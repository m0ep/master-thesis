/*
 * generated by http://RDFReactor.semweb4j.org ($Id: CodeGenerator.java 1895 2013-02-09 17:39:56Z max.at.xam.de@gmail.com $) on 8/8/13 12:01 PM
 */

package de.m0ep.sioc.services.auth;

import org.ontoware.aifbcommons.collection.ClosableIterator;
import org.ontoware.rdf2go.exception.ModelRuntimeException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.BlankNode;
import org.ontoware.rdf2go.model.node.Node;
import org.ontoware.rdf2go.model.node.Resource;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.ontoware.rdfreactor.runtime.Base;

/**
 * This class manages access to these properties:
 * <ul>
 * <li>ServiceAuthentication</li>
 * </ul>
 * 
 * This class was generated by <a href="http://RDFReactor.semweb4j.org">RDFReactor</a> on 8/8/13
 * 12:01 PM
 */
public class Service extends org.rdfs.sioc.services.Service {

    private static final long serialVersionUID = 7227217886829953218L;

    /** http://rdfs.org/sioc/services#Service */
    public static final URI RDFS_CLASS = new URIImpl( "http://rdfs.org/sioc/services#Service",
            false );

    /** http://www.m0ep.de/sioc/services/auth#serviceAuthentication */
    public static final URI SERVICEAUTHENTICATION = new URIImpl(
            "http://www.m0ep.de/sioc/services/auth#serviceAuthentication", false );

    /**
     * All property-URIs with this class as domain. All properties of all super-classes are also
     * available.
     */
    public static final URI[] MANAGED_URIS = {
            new URIImpl( "http://www.m0ep.de/sioc/services/auth#serviceAuthentication", false )
    };

    // protected constructors needed for inheritance

    /**
     * Returns a Java wrapper over an RDF object, identified by URI. Creating two wrappers for the
     * same instanceURI is legal.
     * 
     * @param model
     *            RDF2GO Model implementation, see http://rdf2go.semweb4j.org
     * @param classURI
     *            URI of RDFS class
     * @param instanceIdentifier
     *            Resource that identifies this instance
     * @param write
     *            if true, the statement (this, rdf:type, TYPE) is written to the model
     * 
     *            [Generated from RDFReactor template rule #c1]
     */
    protected Service( Model model, URI classURI, Resource instanceIdentifier, boolean write ) {
        super( model, classURI, instanceIdentifier, write );
    }

    // public constructors

    /**
     * Returns a Java wrapper over an RDF object, identified by URI. Creating two wrappers for the
     * same instanceURI is legal.
     * 
     * @param model
     *            RDF2GO Model implementation, see http://rdf2go.ontoware.org
     * @param instanceIdentifier
     *            an RDF2Go Resource identifying this instance
     * @param write
     *            if true, the statement (this, rdf:type, TYPE) is written to the model
     * 
     *            [Generated from RDFReactor template rule #c2]
     */
    public Service( Model model, Resource instanceIdentifier, boolean write ) {
        super( model, RDFS_CLASS, instanceIdentifier, write );
    }

    /**
     * Returns a Java wrapper over an RDF object, identified by a URI, given as a String. Creating
     * two wrappers for the same URI is legal.
     * 
     * @param model
     *            RDF2GO Model implementation, see http://rdf2go.ontoware.org
     * @param uriString
     *            a URI given as a String
     * @param write
     *            if true, the statement (this, rdf:type, TYPE) is written to the model
     * @throws ModelRuntimeException
     *             if URI syntax is wrong
     * 
     *             [Generated from RDFReactor template rule #c7]
     */
    public Service( Model model, String uriString, boolean write ) throws ModelRuntimeException {
        super( model, RDFS_CLASS, new URIImpl( uriString, false ), write );
    }

    /**
     * Returns a Java wrapper over an RDF object, identified by a blank node. Creating two wrappers
     * for the same blank node is legal.
     * 
     * @param model
     *            RDF2GO Model implementation, see http://rdf2go.ontoware.org
     * @param bnode
     *            BlankNode of this instance
     * @param write
     *            if true, the statement (this, rdf:type, TYPE) is written to the model
     * 
     *            [Generated from RDFReactor template rule #c8]
     */
    public Service( Model model, BlankNode bnode, boolean write ) {
        super( model, RDFS_CLASS, bnode, write );
    }

    /**
     * Returns a Java wrapper over an RDF object, identified by a randomly generated URI. Creating
     * two wrappers results in different URIs.
     * 
     * @param model
     *            RDF2GO Model implementation, see http://rdf2go.ontoware.org
     * @param write
     *            if true, the statement (this, rdf:type, TYPE) is written to the model
     * 
     *            [Generated from RDFReactor template rule #c9]
     */
    public Service( Model model, boolean write ) {
        super( model, RDFS_CLASS, model.newRandomUniqueURI(), write );
    }

    ///////////////////////////////////////////////////////////////////
    // typing

    /**
     * Return an existing instance of this class in the model. No statements are written.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @return an instance of Service or null if none existst
     * 
     *         [Generated from RDFReactor template rule #class0]
     */
    public static Service getInstance( Model model, Resource instanceResource ) {
        return Base.getInstance( model, instanceResource, Service.class );
    }

    /**
     * Create a new instance of this class in the model. That is, create the statement
     * (instanceResource, RDF.type, http://rdfs.org/sioc/services#Service).
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * 
     *            [Generated from RDFReactor template rule #class1]
     */
    public static void createInstance( Model model, Resource instanceResource ) {
        Base.createInstance( model, RDFS_CLASS, instanceResource );
    }

    /**
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @return true if instanceResource is an instance of this class in the model
     * 
     *         [Generated from RDFReactor template rule #class2]
     */
    public static boolean hasInstance( Model model, Resource instanceResource ) {
        return Base.hasInstance( model, RDFS_CLASS, instanceResource );
    }

    /**
     * @param model
     *            an RDF2Go model
     * @return all instances of this class in Model 'model' as RDF resources
     * 
     *         [Generated from RDFReactor template rule #class3]
     */
    public static ClosableIterator<Resource> getAllInstances( Model model ) {
        return Base.getAllInstances( model, RDFS_CLASS, Resource.class );
    }

    /**
     * Remove triple {@code (this, rdf:type, Service)} from this instance. Other triples are not
     * affected. To delete more, use deleteAllProperties
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * 
     *            [Generated from RDFReactor template rule #class4]
     */
    public static void deleteInstance( Model model, Resource instanceResource ) {
        Base.deleteInstance( model, RDFS_CLASS, instanceResource );
    }

    /**
     * Delete all triples {@code (this, *, *)}, i.e. including {@code rdf:type}.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * 
     *            [Generated from RDFReactor template rule #class5]
     */
    public static void deleteAllProperties( Model model, Resource instanceResource ) {
        Base.deleteAllProperties( model, instanceResource );
    }

    ///////////////////////////////////////////////////////////////////
    // property access methods

    /**
     * Check if {@code ServiceAuthentication} has at least one value set.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @return true if this property has at least one value
     * 
     *         [Generated from RDFReactor template rule #get0has-static]
     */
    public static boolean hasServiceAuthentication( Model model, Resource instanceResource ) {
        return Base.has( model, instanceResource, SERVICEAUTHENTICATION );
    }

    /**
     * Check if {@code ServiceAuthentication} has at least one value set.
     * 
     * @return true if this property has at least one value
     * 
     *         [Generated from RDFReactor template rule #get0has-dynamic]
     */
    public boolean hasServiceAuthentication() {
        return Base.has( this.model, this.getResource(), SERVICEAUTHENTICATION );
    }

    /**
     * Check if {@code ServiceAuthentication} has the given value (maybe among other values).
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @param value
     *            the value to be checked
     * @return true if this property contains (maybe among other) the given value
     * 
     *         [Generated from RDFReactor template rule #get0has-value-static]
     */
    public static boolean hasServiceAuthentication( Model model, Resource instanceResource,
            Node value ) {
        return Base.hasValue( model, instanceResource, SERVICEAUTHENTICATION, value );
    }

    /**
     * Check if {@code ServiceAuthentication} has the given value (maybe among other values).
     * 
     * @param value
     *            the value to be checked
     * @return true if this property contains (maybe among other) the given value
     * 
     *         [Generated from RDFReactor template rule #get0has-value-dynamic]
     */
    public boolean hasServiceAuthentication( Node value ) {
        return Base.hasValue( this.model, this.getResource(), SERVICEAUTHENTICATION, value );
    }

    /**
     * Get all values of property {@code ServiceAuthentication} as an Iterator over RDF2Go nodes.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @return a ClosableIterator of RDF2Go Nodes
     * 
     *         [Generated from RDFReactor template rule #get7static]
     */
    public static ClosableIterator<Node> getAllServiceAuthentication_asNode( Model model,
            Resource instanceResource ) {
        return Base.getAll_asNode( model, instanceResource, SERVICEAUTHENTICATION );
    }

    /**
     * Get all values of property {@code ServiceAuthentication} as an Iterator over RDF2Go nodes
     * 
     * @return a ClosableIterator of RDF2Go Nodes
     * 
     *         [Generated from RDFReactor template rule #get8dynamic]
     */
    public ClosableIterator<Node> getAllServiceAuthentication_asNode() {
        return Base.getAll_asNode( this.model, this.getResource(), SERVICEAUTHENTICATION );
    }

    /**
     * Get all values of property {@code ServiceAuthentication}.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @return a ClosableIterator of $type
     * 
     *         [Generated from RDFReactor template rule #get11static]
     */
    public static ClosableIterator<AuthenticationMechanism> getAllServiceAuthentication(
            Model model, Resource instanceResource ) {
        return Base.getAll( model, instanceResource, SERVICEAUTHENTICATION,
                AuthenticationMechanism.class );
    }

    /**
     * Get all values of property {@code ServiceAuthentication}.
     * 
     * @return a ClosableIterator of $type
     * 
     *         [Generated from RDFReactor template rule #get12dynamic]
     */
    public ClosableIterator<AuthenticationMechanism> getAllServiceAuthentication() {
        return Base.getAll( this.model, this.getResource(), SERVICEAUTHENTICATION,
                AuthenticationMechanism.class );
    }

    /**
     * Get all values of property {@code ServiceAuthentication}.
     * 
     * @return a ClosableIterator of $type
     * 
     *         [Generated from RDFReactor template rule #get12dynamic]
     */
    public AuthenticationMechanism getServiceAuthentication() {
        return Base.getAll_as( this.model, this.getResource(), SERVICEAUTHENTICATION,
                AuthenticationMechanism.class ).firstValue();
    }

    /**
     * Get all values of property {@code ServiceAuthentication}.
     * 
     * @return a ClosableIterator of $type
     * 
     *         [Generated from RDFReactor template rule #get12dynamic]
     */
    public AuthenticationMechanism getServiceAuthentication( Model model, Resource instanceResource ) {
        return Base.getAll_as( model, instanceResource, SERVICEAUTHENTICATION,
                AuthenticationMechanism.class ).firstValue();
    }

    /**
     * Adds a value to property {@code ServiceAuthentication} as an RDF2Go {@linkplain Node}.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #add1static]
     */
    public static void addServiceAuthentication( Model model, Resource instanceResource, Node value ) {
        Base.add( model, instanceResource, SERVICEAUTHENTICATION, value );
    }

    /**
     * Adds a value to property {@code ServiceAuthentication} as an RDF2Go {@linkplain Node}.
     * 
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #add1dynamic]
     */
    public void addServiceAuthentication( Node value ) {
        Base.add( this.model, this.getResource(), SERVICEAUTHENTICATION, value );
    }

    /**
     * Adds a value to property {@code ServiceAuthentication} from an instance of
     * {@linkplain AuthenticationMechanism}.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @param value
     * 
     *            [Generated from RDFReactor template rule #add3static]
     */
    public static void addServiceAuthentication( Model model, Resource instanceResource,
            AuthenticationMechanism value ) {
        Base.add( model, instanceResource, SERVICEAUTHENTICATION, value );
    }

    /**
     * Adds a value to property {@code ServiceAuthentication} from an instance of
     * {@linkplain AuthenticationMechanism}.
     * 
     * [Generated from RDFReactor template rule #add4dynamic]
     */
    public void addServiceAuthentication( AuthenticationMechanism value ) {
        Base.add( this.model, this.getResource(), SERVICEAUTHENTICATION, value );
    }

    /**
     * Sets a value of property {@code ServiceAuthentication} from an RDF2Go {@linkplain Node}.
     * First, all existing values are removed, then this value is added. Cardinality constraints are
     * not checked, but this method exists only for properties with no {@code minCardinality} or
     * {@code minCardinality == 1}.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @param value
     *            the value to be set
     * 
     *            [Generated from RDFReactor template rule #set1static]
     */
    public static void setServiceAuthentication( Model model, Resource instanceResource, Node value ) {
        Base.set( model, instanceResource, SERVICEAUTHENTICATION, value );
    }

    /**
     * Sets a value of property {@code ServiceAuthentication} from an RDF2Go {@linkplain Node}.
     * First, all existing values are removed, then this value is added. Cardinality constraints are
     * not checked, but this method exists only for properties with no {@code minCardinality} or
     * {@code minCardinality == 1}.
     * 
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #set1dynamic]
     */
    public void setServiceAuthentication( Node value ) {
        Base.set( this.model, this.getResource(), SERVICEAUTHENTICATION, value );
    }

    /**
     * Sets a value of property {@code ServiceAuthentication} from an instance of
     * {@linkplain AuthenticationMechanism}. First, all existing values are removed, then this value
     * is added. Cardinality constraints are not checked, but this method exists only for properties
     * with no {@code minCardinality} or {@code minCardinality == 1}.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #set3static]
     */
    public static void setServiceAuthentication( Model model, Resource instanceResource,
            AuthenticationMechanism value ) {
        Base.set( model, instanceResource, SERVICEAUTHENTICATION, value );
    }

    /**
     * Sets a value of property {@code ServiceAuthentication} from an instance of
     * {@linkplain AuthenticationMechanism}. First, all existing values are removed, then this value
     * is added. Cardinality constraints are not checked, but this method exists only for properties
     * with no {@code minCardinality} or {@code minCardinality == 1}.
     * 
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #set4dynamic]
     */
    public void setServiceAuthentication( AuthenticationMechanism value ) {
        Base.set( this.model, this.getResource(), SERVICEAUTHENTICATION, value );
    }

    /**
     * Removes a value of property {@code ServiceAuthentication} as an RDF2Go {@linkplain Node}.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @param value
     *            the value to be removed
     * 
     *            [Generated from RDFReactor template rule #remove1static]
     */
    public static void removeServiceAuthentication( Model model, Resource instanceResource,
            Node value ) {
        Base.remove( model, instanceResource, SERVICEAUTHENTICATION, value );
    }

    /**
     * Removes a value of property {@code ServiceAuthentication} as an RDF2Go {@linkplain Node}.
     * 
     * @param value
     *            the value to be removed
     * 
     *            [Generated from RDFReactor template rule #remove1dynamic]
     */
    public void removeServiceAuthentication( Node value ) {
        Base.remove( this.model, this.getResource(), SERVICEAUTHENTICATION, value );
    }

    /**
     * Removes a value of property {@code ServiceAuthentication} given as an instance of
     * {@linkplain AuthenticationMechanism}.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * @param value
     *            the value to be removed
     * 
     *            [Generated from RDFReactor template rule #remove3static]
     */
    public static void removeServiceAuthentication( Model model, Resource instanceResource,
            AuthenticationMechanism value ) {
        Base.remove( model, instanceResource, SERVICEAUTHENTICATION, value );
    }

    /**
     * Removes a value of property {@code ServiceAuthentication} given as an instance of
     * {@linkplain AuthenticationMechanism}.
     * 
     * @param value
     *            the value to be removed
     * 
     *            [Generated from RDFReactor template rule #remove4dynamic]
     */
    public void removeServiceAuthentication( AuthenticationMechanism value ) {
        Base.remove( this.model, this.getResource(), SERVICEAUTHENTICATION, value );
    }

    /**
     * Removes all values of property {@code ServiceAuthentication}.
     * 
     * @param model
     *            an RDF2Go model
     * @param instanceResource
     *            an RDF2Go resource
     * 
     *            [Generated from RDFReactor template rule #removeall1static]
     */
    public static void removeAllServiceAuthentication( Model model, Resource instanceResource ) {
        Base.removeAll( model, instanceResource, SERVICEAUTHENTICATION );
    }

    /**
     * Removes all values of property {@code ServiceAuthentication}.
     * 
     * [Generated from RDFReactor template rule #removeall1dynamic]
     */
    public void removeAllServiceAuthentication() {
        Base.removeAll( this.model, this.getResource(), SERVICEAUTHENTICATION );
    }
}
