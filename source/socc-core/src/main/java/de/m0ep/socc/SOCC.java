package de.m0ep.socc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;
import java.util.Set;

import org.ontoware.rdf2go.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import de.m0ep.socc.config.SOCCConfigConnectorEntry;
import de.m0ep.socc.config.SOCCConfiguration;
import de.m0ep.socc.exceptions.AlreadyExistsException;
import de.m0ep.socc.exceptions.ConnectorException;

public class SOCC {
    private static final Logger LOG = LoggerFactory.getLogger(SOCC.class);

    private Map<String, IConnectorFactory> factories = new HashMap<String, IConnectorFactory>();
    private Map<String, IConnector> connectorMap = new HashMap<String, IConnector>();
    private Map<String, String> connectorFactoryMapping = new HashMap<String, String>();

    private Model model;

    public SOCC(final Model model) {
	this.model = Preconditions.checkNotNull(model, "Model can not be null");
	Preconditions.checkArgument(model.isOpen(), "Model must be open");

	loadFactories();
    }

    public SOCC(final Model model, final SOCCConfiguration configuration) {
	this(model);
	Preconditions.checkNotNull(configuration,
		"Confiuration can not be null");

	for (SOCCConfigConnectorEntry connectorEntry : configuration
		.getConnectors()) {

	    String factoryId = connectorEntry.getFactoryId();
	    if (factories.containsKey(factoryId)) {
		try {

		    System.err.println(connectorEntry.getId());
		    for (Entry<String, Object> entry : connectorEntry
			    .getParameters().entrySet()) {
			System.err.println(entry.getKey() + " - "
				+ entry.getValue());
		    }
		    System.err.println("-------");

		    IConnectorFactory factory = factories.get(factoryId);
		    IConnector connector = factory.createConnector(
			    connectorEntry.getId(), getModel(),
			    connectorEntry.getParameters());

		    connectorMap.put(connector.getId(), connector);
		    connectorFactoryMapping.put(connector.getId(),
			    factory.getId());
		} catch (ConnectorException e) {
		    LOG.error("Failed to create connector from configuration",
			    e);
		}
	    } else {
		LOG.warn("No ConnectorFactory found with id {}",
			connectorEntry.getFactoryId());
	    }
	}
    }

    public void loadFactories() {
	factories = new HashMap<String, IConnectorFactory>();
	ServiceLoader<IConnectorFactory> loader = ServiceLoader
		.load(IConnectorFactory.class);

	for (IConnectorFactory factory : loader) {
	    factories.put(factory.getId(), factory);
	}
    }

    public IConnector createConnector(final String factoryId, final String id,
	    final Map<String, Object> parameters) throws ConnectorException {

	if (connectorMap.containsKey(id)) {
	    throw new AlreadyExistsException(
		    "There is already a connector with the id = " + id);
	}

	IConnectorFactory factory = getFactory(factoryId);
	IConnector connector = factory.createConnector(id, getModel(),
		parameters);

	connectorMap.put(connector.getId(), connector);
	connectorFactoryMapping.put(connector.getId(), factory.getId());

	return connector;
    }

    public Set<String> getConnectorIds() {
	return this.connectorMap.keySet();
    }

    public IConnector getConnector(final String id) {
	if (connectorMap.containsKey(id)) {
	    return connectorMap.get(id);
	}

	throw new NoSuchElementException("There is no connector with id = "
		+ id);
    }

    public Set<String> getFactoryIds() {
	return this.factories.keySet();
    }

    public IConnectorFactory getFactory(final String id) {
	if (factories.containsKey(id)) {
	    return factories.get(id);
	}

	throw new NoSuchElementException("No factory found with id = " + id);
    }

    public SOCCConfiguration getConfiguration() {
	SOCCConfiguration result = new SOCCConfiguration();
	List<SOCCConfigConnectorEntry> connectorEntries = new ArrayList<SOCCConfigConnectorEntry>();

	for (IConnector connector : connectorMap.values()) {
	    SOCCConfigConnectorEntry entry = new SOCCConfigConnectorEntry();
	    entry.setId(connector.getId());
	    entry.setFactoryId(connectorFactoryMapping.get(connector.getId()));

	    Map<String, Object> parameters = connector.getConfiguration();
	    parameters.remove("class");
	    entry.setParameters(parameters);

	    connectorEntries.add(entry);
	}

	result.setConnectors(connectorEntries);

	return result;
    }

    public Model getModel() {
	return this.model;
    }
}