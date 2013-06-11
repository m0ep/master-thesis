/**
 * generated by http://RDFReactor.semweb4j.org ($Id: CodeGenerator.java 1765 2010-02-11 09:51:13Z max.at.xam.de $) on 6/3/13 4:25 PM
 */
package de.m0ep.sioc.service.auth;

import org.ontoware.aifbcommons.collection.ClosableIterator;
import org.ontoware.rdf2go.exception.ModelRuntimeException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.BlankNode;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.ontoware.rdfreactor.runtime.Base;
import org.ontoware.rdfreactor.runtime.ReactorResult;

/**
 * This class manages access to these properties:
 * <ul>
 * <li>Authentication</li>
 * </ul>
 * 
 * This class was generated by <a
 * href="http://RDFReactor.semweb4j.org">RDFReactor</a> on 6/3/13 4:25 PM
 */
public class UserAccount extends org.rdfs.sioc.UserAccount {
    private static final long serialVersionUID = 2475447977759421900L;

    /** http://rdfs.org/sioc/ns#UserAccount */
    public static final URI RDFS_CLASS = new URIImpl(
	    "http://rdfs.org/sioc/ns#UserAccount", false);

    /** http://www.m0ep.de/sioc-service-auth#has_authentication */
    public static final URI AUTHENTICATION = new URIImpl(
	    "http://www.m0ep.de/sioc-service-auth#has_authentication", false);

    /**
     * All property-URIs with this class as domain. All properties of all
     * super-classes are also available.
     */
    public static final URI[] MANAGED_URIS = {
	    new URIImpl(
		    "http://www.m0ep.de/sioc-service-auth#has_authentication",
		    false)
    };

    // protected constructors needed for inheritance

    /**
     * Returns a Java wrapper over an RDF object, identified by URI. Creating
     * two wrappers for the same instanceURI is legal.
     * 
     * @param model
     *            RDF2GO Model implementation, see http://rdf2go.semweb4j.org
     * @param classURI
     *            URI of RDFS class
     * @param instanceIdentifier
     *            Resource that identifies this instance
     * @param write
     *            if true, the statement (this, rdf:type, TYPE) is written to
     *            the model
     * 
     *            [Generated from RDFReactor template rule #c1]
     */
    protected UserAccount(Model model, URI classURI,
	    org.ontoware.rdf2go.model.node.Resource instanceIdentifier,
	    boolean write) {
	super(model, classURI, instanceIdentifier, write);
    }

    // public constructors

    /**
     * Returns a Java wrapper over an RDF object, identified by URI. Creating
     * two wrappers for the same instanceURI is legal.
     * 
     * @param model
     *            RDF2GO Model implementation, see http://rdf2go.ontoware.org
     * @param instanceIdentifier
     *            an RDF2Go Resource identifying this instance
     * @param write
     *            if true, the statement (this, rdf:type, TYPE) is written to
     *            the model
     * 
     *            [Generated from RDFReactor template rule #c2]
     */
    public UserAccount(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceIdentifier,
	    boolean write) {
	super(model, RDFS_CLASS, instanceIdentifier, write);
    }

    /**
     * Returns a Java wrapper over an RDF object, identified by a URI, given as
     * a String. Creating two wrappers for the same URI is legal.
     * 
     * @param model
     *            RDF2GO Model implementation, see http://rdf2go.ontoware.org
     * @param uriString
     *            a URI given as a String
     * @param write
     *            if true, the statement (this, rdf:type, TYPE) is written to
     *            the model
     * @throws ModelRuntimeException
     *             if URI syntax is wrong
     * 
     *             [Generated from RDFReactor template rule #c7]
     */
    public UserAccount(Model model, String uriString, boolean write)
	    throws ModelRuntimeException {
	super(model, RDFS_CLASS, new URIImpl(uriString, false), write);
    }

    /**
     * Returns a Java wrapper over an RDF object, identified by a blank node.
     * Creating two wrappers for the same blank node is legal.
     * 
     * @param model
     *            RDF2GO Model implementation, see http://rdf2go.ontoware.org
     * @param bnode
     *            BlankNode of this instance
     * @param write
     *            if true, the statement (this, rdf:type, TYPE) is written to
     *            the model
     * 
     *            [Generated from RDFReactor template rule #c8]
     */
    public UserAccount(Model model, BlankNode bnode, boolean write) {
	super(model, RDFS_CLASS, bnode, write);
    }

    /**
     * Returns a Java wrapper over an RDF object, identified by a randomly
     * generated URI. Creating two wrappers results in different URIs.
     * 
     * @param model
     *            RDF2GO Model implementation, see http://rdf2go.ontoware.org
     * @param write
     *            if true, the statement (this, rdf:type, TYPE) is written to
     *            the model
     * 
     *            [Generated from RDFReactor template rule #c9]
     */
    public UserAccount(Model model, boolean write) {
	super(model, RDFS_CLASS, model.newRandomUniqueURI(), write);
    }

    // /////////////////////////////////////////////////////////////////
    // typing

    /**
     * Return an existing instance of this class in the model. No statements are
     * written.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @return an instance of UserAccount or null if none existst
     * 
     *         [Generated from RDFReactor template rule #class0]
     */
    public static UserAccount getInstance(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource) {
	return Base.getInstance(model, instanceResource, UserAccount.class);
    }

    /**
     * Create a new instance of this class in the model. That is, create the
     * statement (instanceResource, RDF.type,
     * http://rdfs.org/sioc/ns#UserAccount).
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * 
     *            [Generated from RDFReactor template rule #class1]
     */
    public static void createInstance(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource) {
	Base.createInstance(model, RDFS_CLASS, instanceResource);
    }

    /**
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @return true if instanceResource is an instance of this class in the
     *         model
     * 
     *         [Generated from RDFReactor template rule #class2]
     */
    public static boolean hasInstance(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource) {
	return Base.hasInstance(model, RDFS_CLASS, instanceResource);
    }

    /**
     * @param model
     *            an RDF2Go model
     * @return all instances of this class in Model 'model' as RDF resources
     * 
     *         [Generated from RDFReactor template rule #class3]
     */
    public static ClosableIterator<org.ontoware.rdf2go.model.node.Resource> getAllInstances(
	    Model model) {
	return Base.getAllInstances(model, RDFS_CLASS,
		org.ontoware.rdf2go.model.node.Resource.class);
    }

    /**
     * @param model
     *            an RDF2Go model
     * @return all instances of this class in Model 'model' as a ReactorResult,
     *         which can conveniently be converted to iterator, list or array.
     * 
     *         [Generated from RDFReactor template rule #class3-as]
     */
    public static ReactorResult<? extends UserAccount> getAllInstances_as(
	    Model model) {
	return Base.getAllInstances_as(model, RDFS_CLASS, UserAccount.class);
    }

    /**
     * Remove rdf:type UserAccount from this instance. Other triples are not
     * affected. To delete more, use deleteAllProperties
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * 
     *            [Generated from RDFReactor template rule #class4]
     */
    public static void deleteInstance(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource) {
	Base.deleteInstance(model, RDFS_CLASS, instanceResource);
    }

    /**
     * Delete all (this, *, *), i.e. including rdf:type
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     */
    public static void deleteAllProperties(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource) {
	Base.deleteAllProperties(model, instanceResource);
    }

    // /////////////////////////////////////////////////////////////////
    // property access methods

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@53785fd3 has at
     * least one value set
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * @return true if this property has at least one value
     * 
     *         [Generated from RDFReactor template rule #get0has-static]
     */
    public static boolean hasAuthentication(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource) {
	return Base.has(model, instanceResource, AUTHENTICATION);
    }

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@53785fd3 has at
     * least one value set
     * 
     * @return true if this property has at least one value
     * 
     *         [Generated from RDFReactor template rule #get0has-dynamic]
     */
    public boolean hasAuthentication() {
	return Base.has(this.model, this.getResource(), AUTHENTICATION);
    }

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@53785fd3 has
     * the given value (maybe among other values).
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * @param value
     *            the value to be checked
     * @return true if this property contains (maybe among other) the given
     *         value
     * 
     *         [Generated from RDFReactor template rule #get0has-value-static]
     */
    public static boolean hasAuthentication(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource,
	    org.ontoware.rdf2go.model.node.Node value) {
	return Base.hasValue(model, instanceResource, AUTHENTICATION, value);
    }

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@53785fd3 has
     * the given value (maybe among other values).
     * 
     * @param value
     *            the value to be checked
     * @return true if this property contains (maybe among other) the given
     *         value
     * 
     *         [Generated from RDFReactor template rule #get0has-value-dynamic]
     */
    public boolean hasAuthentication(org.ontoware.rdf2go.model.node.Node value) {
	return Base.hasValue(this.model, this.getResource(), AUTHENTICATION,
		value);
    }

    /**
     * Get all values of property Authentication as an Iterator over RDF2Go
     * nodes
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * @return a ClosableIterator of RDF2Go Nodes
     * 
     *         [Generated from RDFReactor template rule #get7static]
     */
    public static ClosableIterator<org.ontoware.rdf2go.model.node.Node> getAllAuthentication_asNode(
	    Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource) {
	return Base.getAll_asNode(model, instanceResource, AUTHENTICATION);
    }

    /**
     * Get all values of property Authentication as an Iterator over RDF2Go
     * nodes
     * 
     * @return a ClosableIterator of RDF2Go Nodes
     * 
     *         [Generated from RDFReactor template rule #get8dynamic]
     */
    public ClosableIterator<org.ontoware.rdf2go.model.node.Node> getAllAuthentication_asNode() {
	return Base.getAll_asNode(this.model, this.getResource(),
		AUTHENTICATION);
    }

    /**
     * Get all values of property Authentication * @param model an RDF2Go model
     * 
     * @param resource
     *            an RDF2Go resource
     * @return a ClosableIterator of $type
     * 
     *         [Generated from RDFReactor template rule #get11static]
     */
    public static ClosableIterator<Authentication> getAllAuthentication(
	    Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource) {
	return Base.getAll(model, instanceResource, AUTHENTICATION,
		Authentication.class);
    }

    /**
     * Get all values of property Authentication * @return a ClosableIterator of
     * $type
     * 
     * [Generated from RDFReactor template rule #get12dynamic]
     */
    public ClosableIterator<Authentication> getAllAuthentication() {
	return Base.getAll(this.model, this.getResource(), AUTHENTICATION,
		Authentication.class);
    }

    /**
     * Get all values of property Authentication as a ReactorResult of
     * Authentication
     * 
     * @return a ReactorResult of $type which can conveniently be converted to
     *         iterator, list or array
     * 
     *         [Generated from RDFReactor template rule
     *         #get12dynamic-reactorresult]
     */
    public Authentication getAuthentication() {
	return Base.getAll_as(this.model, this.getResource(), AUTHENTICATION,
		Authentication.class).firstValue();
    }

    /**
     * Adds a value to property Authentication as an RDF2Go node
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #add1static]
     */
    public static void addAuthentication(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource,
	    org.ontoware.rdf2go.model.node.Node value) {
	Base.add(model, instanceResource, AUTHENTICATION, value);
    }

    /**
     * Adds a value to property Authentication as an RDF2Go node
     * 
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #add1dynamic]
     */
    public void addAuthentication(org.ontoware.rdf2go.model.node.Node value) {
	Base.add(this.model, this.getResource(), AUTHENTICATION, value);
    }

    /**
     * Adds a value to property Authentication from an instance of
     * Authentication
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * 
     *            [Generated from RDFReactor template rule #add3static]
     */
    public static void addAuthentication(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource,
	    Authentication value) {
	Base.add(model, instanceResource, AUTHENTICATION, value);
    }

    /**
     * Adds a value to property Authentication from an instance of
     * Authentication
     * 
     * [Generated from RDFReactor template rule #add4dynamic]
     */
    public void addAuthentication(Authentication value) {
	Base.add(this.model, this.getResource(), AUTHENTICATION, value);
    }

    /**
     * Sets a value of property Authentication from an RDF2Go node. First, all
     * existing values are removed, then this value is added. Cardinality
     * constraints are not checked, but this method exists only for properties
     * with no minCardinality or minCardinality == 1.
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * @param value
     *            the value to be set
     * 
     *            [Generated from RDFReactor template rule #set1static]
     */
    public static void setAuthentication(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource,
	    org.ontoware.rdf2go.model.node.Node value) {
	Base.set(model, instanceResource, AUTHENTICATION, value);
    }

    /**
     * Sets a value of property Authentication from an RDF2Go node. First, all
     * existing values are removed, then this value is added. Cardinality
     * constraints are not checked, but this method exists only for properties
     * with no minCardinality or minCardinality == 1.
     * 
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #set1dynamic]
     */
    public void setAuthentication(org.ontoware.rdf2go.model.node.Node value) {
	Base.set(this.model, this.getResource(), AUTHENTICATION, value);
    }

    /**
     * Sets a value of property Authentication from an instance of
     * Authentication First, all existing values are removed, then this value is
     * added. Cardinality constraints are not checked, but this method exists
     * only for properties with no minCardinality or minCardinality == 1.
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #set3static]
     */
    public static void setAuthentication(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource,
	    Authentication value) {
	Base.set(model, instanceResource, AUTHENTICATION, value);
    }

    /**
     * Sets a value of property Authentication from an instance of
     * Authentication First, all existing values are removed, then this value is
     * added. Cardinality constraints are not checked, but this method exists
     * only for properties with no minCardinality or minCardinality == 1.
     * 
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #set4dynamic]
     */
    public void setAuthentication(Authentication value) {
	Base.set(this.model, this.getResource(), AUTHENTICATION, value);
    }

    /**
     * Removes a value of property Authentication as an RDF2Go node
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * @param value
     *            the value to be removed
     * 
     *            [Generated from RDFReactor template rule #remove1static]
     */
    public static void removeAuthentication(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource,
	    org.ontoware.rdf2go.model.node.Node value) {
	Base.remove(model, instanceResource, AUTHENTICATION, value);
    }

    /**
     * Removes a value of property Authentication as an RDF2Go node
     * 
     * @param value
     *            the value to be removed
     * 
     *            [Generated from RDFReactor template rule #remove1dynamic]
     */
    public void removeAuthentication(org.ontoware.rdf2go.model.node.Node value) {
	Base.remove(this.model, this.getResource(), AUTHENTICATION, value);
    }

    /**
     * Removes a value of property Authentication given as an instance of
     * Authentication
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * @param value
     *            the value to be removed
     * 
     *            [Generated from RDFReactor template rule #remove3static]
     */
    public static void removeAuthentication(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource,
	    Authentication value) {
	Base.remove(model, instanceResource, AUTHENTICATION, value);
    }

    /**
     * Removes a value of property Authentication given as an instance of
     * Authentication
     * 
     * @param value
     *            the value to be removed
     * 
     *            [Generated from RDFReactor template rule #remove4dynamic]
     */
    public void removeAuthentication(Authentication value) {
	Base.remove(this.model, this.getResource(), AUTHENTICATION, value);
    }

    /**
     * Removes all values of property Authentication * @param model an RDF2Go
     * model
     * 
     * @param resource
     *            an RDF2Go resource
     * 
     *            [Generated from RDFReactor template rule #removeall1static]
     */
    public static void removeAllAuthentication(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource) {
	Base.removeAll(model, instanceResource, AUTHENTICATION);
    }

    /**
     * Removes all values of property Authentication * [Generated from
     * RDFReactor template rule #removeall1dynamic]
     */
    public void removeAllAuthentication() {
	Base.removeAll(this.model, this.getResource(), AUTHENTICATION);
    }
}