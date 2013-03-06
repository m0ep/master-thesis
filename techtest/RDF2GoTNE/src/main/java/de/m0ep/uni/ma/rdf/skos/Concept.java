/**
 * generated by http://RDFReactor.semweb4j.org ($Id: CodeGenerator.java 1765 2010-02-11 09:51:13Z max.at.xam.de $) on 21.12.12 17:00
 */
package de.m0ep.uni.ma.rdf.skos;

import org.ontoware.aifbcommons.collection.ClosableIterator;
import org.ontoware.rdf2go.exception.ModelRuntimeException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.BlankNode;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.ontoware.rdfreactor.runtime.Base;
import org.ontoware.rdfreactor.runtime.ReactorResult;

import de.m0ep.uni.ma.rdf.owl.Thing;

/**
 * This class manages access to these properties:
 * <ul>
 *   <li> Focus </li>
 * </ul>
 *
 * This class was generated by <a href="http://RDFReactor.semweb4j.org">RDFReactor</a> on 21.12.12 17:00
 */
public class Concept extends Thing {

    /**
     * 
     */
    private static final long serialVersionUID = -189376953308051859L;

    /** http://www.w3.org/2004/02/skos/core#Concept */
	public static final URI RDFS_CLASS = new URIImpl("http://www.w3.org/2004/02/skos/core#Concept", false);

    /** http://xmlns.com/foaf/0.1/focus */
	public static final URI FOCUS = new URIImpl("http://xmlns.com/foaf/0.1/focus",false);

    /** 
     * All property-URIs with this class as domain.
     * All properties of all super-classes are also available. 
     */
    public static final URI[] MANAGED_URIS = {
      new URIImpl("http://xmlns.com/foaf/0.1/focus",false),
    };


	// protected constructors needed for inheritance
	
	/**
	 * Returns a Java wrapper over an RDF object, identified by URI.
	 * Creating two wrappers for the same instanceURI is legal.
	 * @param model RDF2GO Model implementation, see http://rdf2go.semweb4j.org
	 * @param classURI URI of RDFS class
	 * @param instanceIdentifier Resource that identifies this instance
	 * @param write if true, the statement (this, rdf:type, TYPE) is written to the model
	 *
	 * [Generated from RDFReactor template rule #c1] 
	 */
	protected Concept ( Model model, URI classURI, org.ontoware.rdf2go.model.node.Resource instanceIdentifier, boolean write ) {
		super(model, classURI, instanceIdentifier, write);
	}

	// public constructors

	/**
	 * Returns a Java wrapper over an RDF object, identified by URI.
	 * Creating two wrappers for the same instanceURI is legal.
	 * @param model RDF2GO Model implementation, see http://rdf2go.ontoware.org
	 * @param instanceIdentifier an RDF2Go Resource identifying this instance
	 * @param write if true, the statement (this, rdf:type, TYPE) is written to the model
	 *
	 * [Generated from RDFReactor template rule #c2] 
	 */
	public Concept ( Model model, org.ontoware.rdf2go.model.node.Resource instanceIdentifier, boolean write ) {
		super(model, RDFS_CLASS, instanceIdentifier, write);
	}


	/**
	 * Returns a Java wrapper over an RDF object, identified by a URI, given as a String.
	 * Creating two wrappers for the same URI is legal.
	 * @param model RDF2GO Model implementation, see http://rdf2go.ontoware.org
	 * @param uriString a URI given as a String
	 * @param write if true, the statement (this, rdf:type, TYPE) is written to the model
	 * @throws ModelRuntimeException if URI syntax is wrong
	 *
	 * [Generated from RDFReactor template rule #c7] 
	 */
	public Concept ( Model model, String uriString, boolean write) throws ModelRuntimeException {
		super(model, RDFS_CLASS, new URIImpl(uriString,false), write);
	}

	/**
	 * Returns a Java wrapper over an RDF object, identified by a blank node.
	 * Creating two wrappers for the same blank node is legal.
	 * @param model RDF2GO Model implementation, see http://rdf2go.ontoware.org
	 * @param bnode BlankNode of this instance
	 * @param write if true, the statement (this, rdf:type, TYPE) is written to the model
	 *
	 * [Generated from RDFReactor template rule #c8] 
	 */
	public Concept ( Model model, BlankNode bnode, boolean write ) {
		super(model, RDFS_CLASS, bnode, write);
	}

	/**
	 * Returns a Java wrapper over an RDF object, identified by 
	 * a randomly generated URI.
	 * Creating two wrappers results in different URIs.
	 * @param model RDF2GO Model implementation, see http://rdf2go.ontoware.org
	 * @param write if true, the statement (this, rdf:type, TYPE) is written to the model
	 *
	 * [Generated from RDFReactor template rule #c9] 
	 */
	public Concept ( Model model, boolean write ) {
		super(model, RDFS_CLASS, model.newRandomUniqueURI(), write);
	}

    ///////////////////////////////////////////////////////////////////
    // typing

	/**
	 * Return an existing instance of this class in the model. No statements are written.
	 * @param model an RDF2Go model
	 * @param instanceResource an RDF2Go resource
	 * @return an instance of Concept  or null if none existst
	 *
	 * [Generated from RDFReactor template rule #class0] 
	 */
	public static Concept  getInstance(Model model, org.ontoware.rdf2go.model.node.Resource instanceResource) {
		return Base.getInstance(model, instanceResource, Concept.class);
	}

	/**
	 * Create a new instance of this class in the model. 
	 * That is, create the statement (instanceResource, RDF.type, http://www.w3.org/2004/02/skos/core#Concept).
	 * @param model an RDF2Go model
	 * @param instanceResource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #class1] 
	 */
	public static void createInstance(Model model, org.ontoware.rdf2go.model.node.Resource instanceResource) {
		Base.createInstance(model, RDFS_CLASS, instanceResource);
	}

	/**
	 * @param model an RDF2Go model
	 * @param instanceResource an RDF2Go resource
	 * @return true if instanceResource is an instance of this class in the model
	 *
	 * [Generated from RDFReactor template rule #class2] 
	 */
	public static boolean hasInstance(Model model, org.ontoware.rdf2go.model.node.Resource instanceResource) {
		return Base.hasInstance(model, RDFS_CLASS, instanceResource);
	}

	/**
	 * @param model an RDF2Go model
	 * @return all instances of this class in Model 'model' as RDF resources
	 *
	 * [Generated from RDFReactor template rule #class3] 
	 */
	public static ClosableIterator<org.ontoware.rdf2go.model.node.Resource> getAllInstances(Model model) {
		return Base.getAllInstances(model, RDFS_CLASS, org.ontoware.rdf2go.model.node.Resource.class);
	}

	/**
	 * @param model an RDF2Go model
	 * @return all instances of this class in Model 'model' as a ReactorResult,
	 * which can conveniently be converted to iterator, list or array.
	 *
	 * [Generated from RDFReactor template rule #class3-as] 
	 */
	public static ReactorResult<? extends Concept> getAllInstances_as(Model model) {
		return Base.getAllInstances_as(model, RDFS_CLASS, Concept.class );
	}

    /**
	 * Remove rdf:type Concept from this instance. Other triples are not affected.
	 * To delete more, use deleteAllProperties
	 * @param model an RDF2Go model
	 * @param instanceResource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #class4] 
	 */
	public static void deleteInstance(Model model, org.ontoware.rdf2go.model.node.Resource instanceResource) {
		Base.deleteInstance(model, RDFS_CLASS, instanceResource);
	}

	/**
	 * Delete all (this, *, *), i.e. including rdf:type
	 * @param model an RDF2Go model
	 * @param resource
	 */
	public static void deleteAllProperties(Model model,	org.ontoware.rdf2go.model.node.Resource instanceResource) {
		Base.deleteAllProperties(model, instanceResource);
	}

    ///////////////////////////////////////////////////////////////////
    // property access methods


    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@252bb82b has at least one value set 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return true if this property has at least one value
	 *
	 * [Generated from RDFReactor template rule #get0has-static] 
     */
	public static boolean hasFOAFFocus(Model model, org.ontoware.rdf2go.model.node.Resource instanceResource) {
		return Base.has(model, instanceResource, FOCUS);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@252bb82b has at least one value set 
     * @return true if this property has at least one value
	 *
	 * [Generated from RDFReactor template rule #get0has-dynamic] 
     */
	public boolean hasFOAFFocus() {
		return Base.has(this.model, this.getResource(), FOCUS);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@252bb82b has the given value (maybe among other values).  
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be checked
     * @return true if this property contains (maybe among other) the given value
	 *
	 * [Generated from RDFReactor template rule #get0has-value-static] 
     */
	public static boolean hasFOAFFocus(Model model, org.ontoware.rdf2go.model.node.Resource instanceResource, org.ontoware.rdf2go.model.node.Node value ) {
		return Base.hasValue(model, instanceResource, FOCUS, value);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@252bb82b has the given value (maybe among other values).  
	 * @param value the value to be checked
     * @return true if this property contains (maybe among other) the given value
	 *
	 * [Generated from RDFReactor template rule #get0has-value-dynamic] 
     */
	public boolean hasFOAFFocus( org.ontoware.rdf2go.model.node.Node value ) {
		return Base.hasValue(this.model, this.getResource(), FOCUS, value);
	}

     /**
     * Get all values of property Focus as an Iterator over RDF2Go nodes 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ClosableIterator of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get7static] 
     */
	public static ClosableIterator<org.ontoware.rdf2go.model.node.Node> getAllFOAFFocus_asNode(Model model, org.ontoware.rdf2go.model.node.Resource instanceResource) {
		return Base.getAll_asNode(model, instanceResource, FOCUS);
	}
	
    /**
     * Get all values of property Focus as a ReactorResult of RDF2Go nodes 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a List of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get7static-reactor-result] 
     */
	public static ReactorResult<org.ontoware.rdf2go.model.node.Node> getAllFOAFFocus_asNode_(Model model, org.ontoware.rdf2go.model.node.Resource instanceResource) {
		return Base.getAll_as(model, instanceResource, FOCUS, org.ontoware.rdf2go.model.node.Node.class);
	}

    /**
     * Get all values of property Focus as an Iterator over RDF2Go nodes 
     * @return a ClosableIterator of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get8dynamic] 
     */
	public ClosableIterator<org.ontoware.rdf2go.model.node.Node> getAllFOAFFocus_asNode() {
		return Base.getAll_asNode(this.model, this.getResource(), FOCUS);
	}

    /**
     * Get all values of property Focus as a ReactorResult of RDF2Go nodes 
     * @return a List of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get8dynamic-reactor-result] 
     */
	public ReactorResult<org.ontoware.rdf2go.model.node.Node> getAllFOAFFocus_asNode_() {
		return Base.getAll_as(this.model, this.getResource(), FOCUS, org.ontoware.rdf2go.model.node.Node.class);
	}
     /**
     * Get all values of property Focus     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ClosableIterator of $type
	 *
	 * [Generated from RDFReactor template rule #get11static] 
     */
    public static ClosableIterator<org.ontoware.rdfreactor.schema.owl.OwlThing> getAllFOAFFocus(
            Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
        return Base.getAll( model, instanceResource, FOCUS,
                org.ontoware.rdfreactor.schema.owl.OwlThing.class );
	}
	
    /**
     * Get all values of property Focus as a ReactorResult of
     * org.ontoware.rdfreactor.schema.owl.OwlThing
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * @return a ReactorResult of $type which can conveniently be converted to
     *         iterator, list or array
     * 
     *         [Generated from RDFReactor template rule
     *         #get11static-reactorresult]
     */
    public static ReactorResult<org.ontoware.rdfreactor.schema.owl.OwlThing> getAllFOAFFocus_as(
            Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
        return Base.getAll_as( model, instanceResource, FOCUS,
                org.ontoware.rdfreactor.schema.owl.OwlThing.class );
	}

    /**
     * Get all values of property Focus     * @return a ClosableIterator of $type
	 *
	 * [Generated from RDFReactor template rule #get12dynamic] 
     */
    public ClosableIterator<org.ontoware.rdfreactor.schema.owl.OwlThing> getAllFOAFFocus() {
        return Base.getAll( this.model, this.getResource(), FOCUS,
                org.ontoware.rdfreactor.schema.owl.OwlThing.class );
	}

    /**
     * Get all values of property Focus as a ReactorResult of
     * org.ontoware.rdfreactor.schema.owl.OwlThing
     * 
     * @return a ReactorResult of $type which can conveniently be converted to
     *         iterator, list or array
     * 
     *         [Generated from RDFReactor template rule
     *         #get12dynamic-reactorresult]
     */
    public ReactorResult<org.ontoware.rdfreactor.schema.owl.OwlThing> getAllFOAFFocus_as() {
        return Base.getAll_as( this.model, this.getResource(), FOCUS,
                org.ontoware.rdfreactor.schema.owl.OwlThing.class );
	}
 
    /**
     * Adds a value to property Focus as an RDF2Go node 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #add1static] 
     */
	public static void addFOAFFocus( Model model, org.ontoware.rdf2go.model.node.Resource instanceResource, org.ontoware.rdf2go.model.node.Node value) {
		Base.add(model, instanceResource, FOCUS, value);
	}
	
    /**
     * Adds a value to property Focus as an RDF2Go node 
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #add1dynamic] 
     */
	public void addFOAFFocus( org.ontoware.rdf2go.model.node.Node value) {
		Base.add(this.model, this.getResource(), FOCUS, value);
	}
    
    /**
     * Adds a value to property Focus from an instance of
     * org.ontoware.rdfreactor.schema.owl.OwlThing
     * 
     * @param model
     *            an RDF2Go model
     * @param resource
     *            an RDF2Go resource
     * 
     *            [Generated from RDFReactor template rule #add3static]
     */
    public static void addFOAFFocus( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdfreactor.schema.owl.OwlThing value ) {
		Base.add(model, instanceResource, FOCUS, value);
	}
	
    /**
     * Adds a value to property Focus from an instance of
     * org.ontoware.rdfreactor.schema.owl.OwlThing
     * 
     * [Generated from RDFReactor template rule #add4dynamic]
     */
    public void addFOAFFocus( org.ontoware.rdfreactor.schema.owl.OwlThing value ) {
		Base.add(this.model, this.getResource(), FOCUS, value);
	}
  

    /**
     * Sets a value of property Focus from an RDF2Go node.
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be set
	 *
	 * [Generated from RDFReactor template rule #set1static] 
     */
	public static void setFOAFFocus( Model model, org.ontoware.rdf2go.model.node.Resource instanceResource, org.ontoware.rdf2go.model.node.Node value) {
		Base.set(model, instanceResource, FOCUS, value);
	}
	
    /**
     * Sets a value of property Focus from an RDF2Go node.
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set1dynamic] 
     */
	public void setFOAFFocus( org.ontoware.rdf2go.model.node.Node value) {
		Base.set(this.model, this.getResource(), FOCUS, value);
	}
    
    /**
     * Sets a value of property Focus from an instance of
     * org.ontoware.rdfreactor.schema.owl.OwlThing First, all existing values
     * are removed, then this value is added. Cardinality constraints are not
     * checked, but this method exists only for properties with no
     * minCardinality or minCardinality == 1.
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
    public static void setFOAFFocus( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdfreactor.schema.owl.OwlThing value ) {
		Base.set(model, instanceResource, FOCUS, value);
	}
	
    /**
     * Sets a value of property Focus from an instance of
     * org.ontoware.rdfreactor.schema.owl.OwlThing First, all existing values
     * are removed, then this value is added. Cardinality constraints are not
     * checked, but this method exists only for properties with no
     * minCardinality or minCardinality == 1.
     * 
     * @param value
     *            the value to be added
     * 
     *            [Generated from RDFReactor template rule #set4dynamic]
     */
    public void setFOAFFocus( org.ontoware.rdfreactor.schema.owl.OwlThing value ) {
		Base.set(this.model, this.getResource(), FOCUS, value);
	}
  


    /**
     * Removes a value of property Focus as an RDF2Go node 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove1static] 
     */
	public static void removeFOAFFocus( Model model, org.ontoware.rdf2go.model.node.Resource instanceResource, org.ontoware.rdf2go.model.node.Node value) {
		Base.remove(model, instanceResource, FOCUS, value);
	}
	
    /**
     * Removes a value of property Focus as an RDF2Go node
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove1dynamic] 
     */
	public void removeFOAFFocus( org.ontoware.rdf2go.model.node.Node value) {
		Base.remove(this.model, this.getResource(), FOCUS, value);
	}
    
    /**
     * Removes a value of property Focus given as an instance of
     * org.ontoware.rdfreactor.schema.owl.OwlThing
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
    public static void removeFOAFFocus( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdfreactor.schema.owl.OwlThing value ) {
		Base.remove(model, instanceResource, FOCUS, value);
	}
	
    /**
     * Removes a value of property Focus given as an instance of
     * org.ontoware.rdfreactor.schema.owl.OwlThing
     * 
     * @param value
     *            the value to be removed
     * 
     *            [Generated from RDFReactor template rule #remove4dynamic]
     */
    public void removeFOAFFocus(
            org.ontoware.rdfreactor.schema.owl.OwlThing value ) {
		Base.remove(this.model, this.getResource(), FOCUS, value);
	}
  
    /**
     * Removes all values of property Focus     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #removeall1static] 
     */
	public static void removeAllFOAFFocus( Model model, org.ontoware.rdf2go.model.node.Resource instanceResource) {
		Base.removeAll(model, instanceResource, FOCUS);
	}
	
    /**
     * Removes all values of property Focus	 *
	 * [Generated from RDFReactor template rule #removeall1dynamic] 
     */
	public void removeAllFOAFFocus() {
		Base.removeAll(this.model, this.getResource(), FOCUS);
	}
 }