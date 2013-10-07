/**
 * generated by http://RDFReactor.semweb4j.org ($Id: CodeGenerator.java 1765 2010-02-11 09:51:13Z max.at.xam.de $) on 21.12.12 17:00
 */
package com.xmlns.foaf;

import org.ontoware.aifbcommons.collection.ClosableIterator;
import org.ontoware.rdf2go.exception.ModelRuntimeException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.BlankNode;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.ontoware.rdfreactor.runtime.Base;

/**
 * This class manages access to these properties:
 * <ul>
 * </ul>
 * 
 * This class was generated by <a
 * href="http://RDFReactor.semweb4j.org">RDFReactor</a> on 21.12.12 17:00
 */
public class ContactPerson extends Thing {

    /**
     * 
     */
    private static final long serialVersionUID = -3129049422023353047L;

    /** http://www.w3.org/2000/10/swap/pim/contact#Person */
    public static final URI RDFS_CLASS = new URIImpl(
	    "http://www.w3.org/2000/10/swap/pim/contact#Person", false);

    /**
     * All property-URIs with this class as domain. All properties of all
     * super-classes are also available.
     */
    public static final URI[] MANAGED_URIS = {};

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
    protected ContactPerson(Model model, URI classURI,
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
    public ContactPerson(Model model,
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
    public ContactPerson(Model model, String uriString, boolean write)
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
    public ContactPerson(Model model, BlankNode bnode, boolean write) {
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
    public ContactPerson(Model model, boolean write) {
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
     * @return an instance of ContactPerson or null if none existst
     * 
     *         [Generated from RDFReactor template rule #class0]
     */
    public static ContactPerson getInstance(Model model,
	    org.ontoware.rdf2go.model.node.Resource instanceResource) {
	return Base.getInstance(model, instanceResource, ContactPerson.class);
    }

    /**
     * Create a new instance of this class in the model. That is, create the
     * statement (instanceResource, RDF.type,
     * http://www.w3.org/2000/10/swap/pim/contact#Person).
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
     * Remove rdf:type ContactPerson from this instance. Other triples are not
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
}