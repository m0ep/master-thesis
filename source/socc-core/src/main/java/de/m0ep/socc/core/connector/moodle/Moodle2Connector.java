package de.m0ep.socc.core.connector.moodle;

import java.io.IOException;

import org.ontoware.rdf2go.model.node.URI;
import org.rdfs.sioc.UserAccount;
import org.rdfs.sioc.services.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import de.m0ep.socc.config.ConnectorConfig;
import de.m0ep.socc.core.ISoccContext;
import de.m0ep.socc.core.connector.DefaultConnector;
import de.m0ep.socc.core.exceptions.AuthenticationException;

public class Moodle2Connector extends DefaultConnector {
	private static final Logger LOG = LoggerFactory
	        .getLogger( Moodle2Connector.class );

	private URI serviceEndpointUri;

	private Moodle2ClientManager serviceClientManager;
	private Moodle2StructureReader serviceStructureReader;
	private Moodle2PostReader postReader;
	private Moodle2PostWriter postWriter;

	public Moodle2Connector( ISoccContext context, ConnectorConfig config ) {
		super( context, config );
	}

	public Moodle2Connector( String id, ISoccContext context,
	        UserAccount defaultUserAccount,
	        Service service ) {
		super( id, context, defaultUserAccount, service );
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public Moodle2ClientManager getServiceClientManager() {
		return serviceClientManager;
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public Moodle2StructureReader getStructureReader() {
		Preconditions.checkState( isInitialized(),
		        "Connector was not initialized" );

		if ( null == serviceStructureReader ) {
			serviceStructureReader = new Moodle2StructureReader( this );
		}

		return serviceStructureReader;
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public Moodle2PostReader getPostReader() {
		Preconditions.checkState( isInitialized(),
		        "Connector was not initialized" );

		if ( null == postReader ) {
			postReader = new Moodle2PostReader( this );
		}

		return postReader;
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public Moodle2PostWriter getPostWriter() {
		Preconditions.checkState( isInitialized(),
		        "Connector was not initialized" );

		if ( null == postWriter ) {
			postWriter = new Moodle2PostWriter( this );
		}

		return postWriter;
	}

	@Override
	public void initialize() throws AuthenticationException, IOException {
		Preconditions.checkArgument(
		        service.hasServiceEndpoint(),
		        "The service contains no required serviceEndpoint." );
		serviceEndpointUri = getService().getServiceEndpoint().asURI();

		LOG.info( "Create Moodle connector with endpoint at {}.",
		        serviceEndpointUri );

		try {
			serviceClientManager = new Moodle2ClientManager( getService(),
			        getDefaultUserAccount() );
		} catch ( Exception e ) {
			throw new AuthenticationException(
			        "Failed to create and login default client.", e );
		}

		serviceStructureReader = new Moodle2StructureReader( this );
		setInitialized( true );
	}

	@Override
	public void shutdown() {
		for ( Object obj : serviceClientManager.getAll() ) {
			Moodle2ClientWrapper client = (Moodle2ClientWrapper) obj;
			client.getBindingStub().logout(
			        client.getAuthClient(),
			        client.getSessionKey() );
		}
		serviceClientManager.clear();

		Moodle2ClientWrapper client = serviceClientManager
		        .getDefaultClient();
		client.getBindingStub().logout(
		        client.getAuthClient(),
		        client.getSessionKey() );

		setInitialized( false );
	}
}
