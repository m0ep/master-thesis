/**
 * generated by http://RDFReactor.semweb4j.org ($Id: CodeGenerator.java 1765 2010-02-11 09:51:13Z max.at.xam.de $) on 21.12.12 17:00
 */
package org.rdfs.sioc;

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
 *   <li> Functionof </li>
 *   <li> Scope </li>
 * </ul>
 *
 * This class was generated by <a href="http://RDFReactor.semweb4j.org">RDFReactor</a> on 21.12.12 17:00
 */
public class Role extends SIOCThing {

    /**
     * 
     */
    private static final long serialVersionUID = 5410197850078981271L;

    /** http://rdfs.org/sioc/ns#Role */
	public static final URI RDFS_CLASS = new URIImpl("http://rdfs.org/sioc/ns#Role", false);

    /** http://rdfs.org/sioc/ns#function_of */
	public static final URI FUNCTIONOF = new URIImpl("http://rdfs.org/sioc/ns#function_of",false);

    /** http://rdfs.org/sioc/ns#has_scope */
	public static final URI SCOPE = new URIImpl("http://rdfs.org/sioc/ns#has_scope",false);


    /** 
     * All property-URIs with this class as domain.
     * All properties of all super-classes are also available. 
     */
    public static final URI[] MANAGED_URIS = {
      new URIImpl("http://rdfs.org/sioc/ns#function_of",false),
      new URIImpl("http://rdfs.org/sioc/ns#has_scope",false),
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
	protected Role ( Model model, URI classURI, org.ontoware.rdf2go.model.node.Resource instanceIdentifier, boolean write ) {
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
	public Role ( Model model, org.ontoware.rdf2go.model.node.Resource instanceIdentifier, boolean write ) {
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
	public Role ( Model model, String uriString, boolean write) throws ModelRuntimeException {
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
	public Role ( Model model, BlankNode bnode, boolean write ) {
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
	public Role ( Model model, boolean write ) {
		super(model, RDFS_CLASS, model.newRandomUniqueURI(), write);
	}

    ///////////////////////////////////////////////////////////////////
    // typing

	/**
	 * Return an existing instance of this class in the model. No statements are written.
	 * @param model an RDF2Go model
	 * @param instanceResource an RDF2Go resource
	 * @return an instance of Role  or null if none existst
	 *
	 * [Generated from RDFReactor template rule #class0] 
	 */
	public static Role  getInstance(Model model, org.ontoware.rdf2go.model.node.Resource instanceResource) {
		return Base.getInstance(model, instanceResource, Role.class);
	}

	/**
	 * Create a new instance of this class in the model. 
	 * That is, create the statement (instanceResource, RDF.type, http://rdfs.org/sioc/ns#Role).
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
	public static ReactorResult<? extends Role> getAllInstances_as(Model model) {
		return Base.getAllInstances_as(model, RDFS_CLASS, Role.class );
	}

    /**
	 * Remove rdf:type Role from this instance. Other triples are not affected.
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
	 * @param model an RDF2Go model
	 * @param objectValue
	 * @return all A's as RDF resources, that have a relation 'Function' to this Role instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse1static] 
	 */
    public static ClosableIterator<org.ontoware.rdf2go.model.node.Resource>
            getAllFunction_Inverse( Model model, Object objectValue ) {
		return Base.getAll_Inverse(model, SIOCThing.FUNCTION, objectValue);
	}

	/**
	 * @return all A's as RDF resources, that have a relation 'Function' to this Role instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse1dynamic] 
	 */
    public ClosableIterator<org.ontoware.rdf2go.model.node.Resource>
            getAllFunction_Inverse() {
		return Base.getAll_Inverse(this.model, SIOCThing.FUNCTION, this.getResource() );
	}

	/**
	 * @param model an RDF2Go model
	 * @param objectValue
	 * @return all A's as a ReactorResult, that have a relation 'Function' to this Role instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse-as1static] 
	 */
    public static ReactorResult<org.ontoware.rdf2go.model.node.Resource>
            getAllFunction_Inverse_as( Model model, Object objectValue ) {
		return Base.getAll_Inverse_as(model, SIOCThing.FUNCTION, objectValue, org.ontoware.rdf2go.model.node.Resource.class);
	}


	/**
	 * @param model an RDF2Go model
	 * @param objectValue
	 * @return all A's as RDF resources, that have a relation 'Scopeof' to this Role instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse1static] 
	 */
    public static ClosableIterator<org.ontoware.rdf2go.model.node.Resource>
            getAllScopeof_Inverse( Model model, Object objectValue ) {
		return Base.getAll_Inverse(model, SIOCThing.SCOPEOF, objectValue);
	}

	/**
	 * @return all A's as RDF resources, that have a relation 'Scopeof' to this Role instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse1dynamic] 
	 */
    public ClosableIterator<org.ontoware.rdf2go.model.node.Resource>
            getAllScopeof_Inverse() {
		return Base.getAll_Inverse(this.model, SIOCThing.SCOPEOF, this.getResource() );
	}

	/**
	 * @param model an RDF2Go model
	 * @param objectValue
	 * @return all A's as a ReactorResult, that have a relation 'Scopeof' to this Role instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse-as1static] 
	 */
    public static ReactorResult<org.ontoware.rdf2go.model.node.Resource>
            getAllScopeof_Inverse_as( Model model, Object objectValue ) {
		return Base.getAll_Inverse_as(model, SIOCThing.SCOPEOF, objectValue, org.ontoware.rdf2go.model.node.Resource.class);
	}



    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@61e076f3 has at least one value set 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return true if this property has at least one value
	 *
	 * [Generated from RDFReactor template rule #get0has-static] 
     */
    public static boolean hasFunctionof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.has(model, instanceResource, FUNCTIONOF);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@61e076f3 has at least one value set 
     * @return true if this property has at least one value
	 *
	 * [Generated from RDFReactor template rule #get0has-dynamic] 
     */
    public boolean hasFunctionof() {
		return Base.has(this.model, this.getResource(), FUNCTIONOF);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@61e076f3 has the given value (maybe among other values).  
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be checked
     * @return true if this property contains (maybe among other) the given value
	 *
	 * [Generated from RDFReactor template rule #get0has-value-static] 
     */
    public static boolean hasFunctionof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		return Base.hasValue(model, instanceResource, FUNCTIONOF, value);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@61e076f3 has the given value (maybe among other values).  
	 * @param value the value to be checked
     * @return true if this property contains (maybe among other) the given value
	 *
	 * [Generated from RDFReactor template rule #get0has-value-dynamic] 
     */
    public boolean hasFunctionof( org.ontoware.rdf2go.model.node.Node value ) {
		return Base.hasValue(this.model, this.getResource(), FUNCTIONOF, value);
	}

     /**
     * Get all values of property Functionof as an Iterator over RDF2Go nodes 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ClosableIterator of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get7static] 
     */
    public static ClosableIterator<org.ontoware.rdf2go.model.node.Node>
            getAllFunctionof_asNode( Model model,
                    org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_asNode(model, instanceResource, FUNCTIONOF);
	}
	
    /**
     * Get all values of property Functionof as a ReactorResult of RDF2Go nodes 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a List of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get7static-reactor-result] 
     */
    public static ReactorResult<org.ontoware.rdf2go.model.node.Node>
            getAllFunctionof_asNode_( Model model,
                    org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_as(model, instanceResource, FUNCTIONOF, org.ontoware.rdf2go.model.node.Node.class);
	}

    /**
     * Get all values of property Functionof as an Iterator over RDF2Go nodes 
     * @return a ClosableIterator of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get8dynamic] 
     */
    public ClosableIterator<org.ontoware.rdf2go.model.node.Node>
            getAllFunctionof_asNode() {
		return Base.getAll_asNode(this.model, this.getResource(), FUNCTIONOF);
	}

    /**
     * Get all values of property Functionof as a ReactorResult of RDF2Go nodes 
     * @return a List of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get8dynamic-reactor-result] 
     */
    public ReactorResult<org.ontoware.rdf2go.model.node.Node>
            getAllFunctionof_asNode_() {
		return Base.getAll_as(this.model, this.getResource(), FUNCTIONOF, org.ontoware.rdf2go.model.node.Node.class);
	}
     /**
     * Get all values of property Functionof     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ClosableIterator of $type
	 *
	 * [Generated from RDFReactor template rule #get11static] 
     */
    public static ClosableIterator<SIOCThing> getAllFunctionof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll(model, instanceResource, FUNCTIONOF, SIOCThing.class);
	}
	
    /**
     * Get all values of property Functionof as a ReactorResult of Thing 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ReactorResult of $type which can conveniently be converted to iterator, list or array
	 *
	 * [Generated from RDFReactor template rule #get11static-reactorresult] 
     */
    public static ReactorResult<SIOCThing> getAllFunctionof_as( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_as(model, instanceResource, FUNCTIONOF, SIOCThing.class);
	}

    /**
     * Get all values of property Functionof     * @return a ClosableIterator of $type
	 *
	 * [Generated from RDFReactor template rule #get12dynamic] 
     */
    public ClosableIterator<SIOCThing> getAllFunctionof() {
		return Base.getAll(this.model, this.getResource(), FUNCTIONOF, SIOCThing.class);
	}

    /**
     * Get all values of property Functionof as a ReactorResult of Thing 
     * @return a ReactorResult of $type which can conveniently be converted to iterator, list or array
	 *
	 * [Generated from RDFReactor template rule #get12dynamic-reactorresult] 
     */
    public ReactorResult<SIOCThing> getAllFunctionof_as() {
		return Base.getAll_as(this.model, this.getResource(), FUNCTIONOF, SIOCThing.class);
	}
 
    /**
     * Adds a value to property Functionof as an RDF2Go node 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #add1static] 
     */
    public static void addFunctionof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.add(model, instanceResource, FUNCTIONOF, value);
	}
	
    /**
     * Adds a value to property Functionof as an RDF2Go node 
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #add1dynamic] 
     */
    public void addFunctionof( org.ontoware.rdf2go.model.node.Node value ) {
		Base.add(this.model, this.getResource(), FUNCTIONOF, value);
	}
    /**
     * Adds a value to property Functionof from an instance of Thing 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #add3static] 
     */
    public static void addFunctionof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            SIOCThing value ) {
		Base.add(model, instanceResource, FUNCTIONOF, value);
	}
	
    /**
     * Adds a value to property Functionof from an instance of Thing 
	 *
	 * [Generated from RDFReactor template rule #add4dynamic] 
     */
    public void addFunctionof( SIOCThing value ) {
		Base.add(this.model, this.getResource(), FUNCTIONOF, value);
	}
  

    /**
     * Sets a value of property Functionof from an RDF2Go node.
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be set
	 *
	 * [Generated from RDFReactor template rule #set1static] 
     */
    public static void setFunctionof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.set(model, instanceResource, FUNCTIONOF, value);
	}
	
    /**
     * Sets a value of property Functionof from an RDF2Go node.
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set1dynamic] 
     */
    public void setFunctionof( org.ontoware.rdf2go.model.node.Node value ) {
		Base.set(this.model, this.getResource(), FUNCTIONOF, value);
	}
    /**
     * Sets a value of property Functionof from an instance of Thing 
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set3static] 
     */
    public static void setFunctionof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            SIOCThing value ) {
		Base.set(model, instanceResource, FUNCTIONOF, value);
	}
	
    /**
     * Sets a value of property Functionof from an instance of Thing 
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set4dynamic] 
     */
    public void setFunctionof( SIOCThing value ) {
		Base.set(this.model, this.getResource(), FUNCTIONOF, value);
	}
  


    /**
     * Removes a value of property Functionof as an RDF2Go node 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove1static] 
     */
    public static void removeFunctionof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.remove(model, instanceResource, FUNCTIONOF, value);
	}
	
    /**
     * Removes a value of property Functionof as an RDF2Go node
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove1dynamic] 
     */
    public void removeFunctionof( org.ontoware.rdf2go.model.node.Node value ) {
		Base.remove(this.model, this.getResource(), FUNCTIONOF, value);
	}
    /**
     * Removes a value of property Functionof given as an instance of Thing 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove3static] 
     */
    public static void removeFunctionof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            SIOCThing value ) {
		Base.remove(model, instanceResource, FUNCTIONOF, value);
	}
	
    /**
     * Removes a value of property Functionof given as an instance of Thing 
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove4dynamic] 
     */
    public void removeFunctionof( SIOCThing value ) {
		Base.remove(this.model, this.getResource(), FUNCTIONOF, value);
	}
  
    /**
     * Removes all values of property Functionof     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #removeall1static] 
     */
    public static void removeAllFunctionof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		Base.removeAll(model, instanceResource, FUNCTIONOF);
	}
	
    /**
     * Removes all values of property Functionof	 *
	 * [Generated from RDFReactor template rule #removeall1dynamic] 
     */
    public void removeAllFunctionof() {
		Base.removeAll(this.model, this.getResource(), FUNCTIONOF);
	}
     /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@5f015823 has at least one value set 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return true if this property has at least one value
	 *
	 * [Generated from RDFReactor template rule #get0has-static] 
     */
    public static boolean hasScope( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.has(model, instanceResource, SCOPE);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@5f015823 has at least one value set 
     * @return true if this property has at least one value
	 *
	 * [Generated from RDFReactor template rule #get0has-dynamic] 
     */
    public boolean hasScope() {
		return Base.has(this.model, this.getResource(), SCOPE);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@5f015823 has the given value (maybe among other values).  
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be checked
     * @return true if this property contains (maybe among other) the given value
	 *
	 * [Generated from RDFReactor template rule #get0has-value-static] 
     */
    public static boolean hasScope( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		return Base.hasValue(model, instanceResource, SCOPE, value);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@5f015823 has the given value (maybe among other values).  
	 * @param value the value to be checked
     * @return true if this property contains (maybe among other) the given value
	 *
	 * [Generated from RDFReactor template rule #get0has-value-dynamic] 
     */
    public boolean hasScope( org.ontoware.rdf2go.model.node.Node value ) {
		return Base.hasValue(this.model, this.getResource(), SCOPE, value);
	}

     /**
     * Get all values of property Scope as an Iterator over RDF2Go nodes 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ClosableIterator of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get7static] 
     */
    public static ClosableIterator<org.ontoware.rdf2go.model.node.Node>
            getAllScope_asNode( Model model,
                    org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_asNode(model, instanceResource, SCOPE);
	}
	
    /**
     * Get all values of property Scope as a ReactorResult of RDF2Go nodes 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a List of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get7static-reactor-result] 
     */
    public static ReactorResult<org.ontoware.rdf2go.model.node.Node>
            getAllScope_asNode_( Model model,
                    org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_as(model, instanceResource, SCOPE, org.ontoware.rdf2go.model.node.Node.class);
	}

    /**
     * Get all values of property Scope as an Iterator over RDF2Go nodes 
     * @return a ClosableIterator of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get8dynamic] 
     */
    public ClosableIterator<org.ontoware.rdf2go.model.node.Node>
            getAllScope_asNode() {
		return Base.getAll_asNode(this.model, this.getResource(), SCOPE);
	}

    /**
     * Get all values of property Scope as a ReactorResult of RDF2Go nodes 
     * @return a List of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get8dynamic-reactor-result] 
     */
    public ReactorResult<org.ontoware.rdf2go.model.node.Node>
            getAllScope_asNode_() {
		return Base.getAll_as(this.model, this.getResource(), SCOPE, org.ontoware.rdf2go.model.node.Node.class);
	}
     /**
     * Get all values of property Scope     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ClosableIterator of $type
	 *
	 * [Generated from RDFReactor template rule #get11static] 
     */
    public static ClosableIterator<SIOCThing> getAllScope( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll(model, instanceResource, SCOPE, SIOCThing.class);
	}
	
    /**
     * Get all values of property Scope as a ReactorResult of Thing 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ReactorResult of $type which can conveniently be converted to iterator, list or array
	 *
	 * [Generated from RDFReactor template rule #get11static-reactorresult] 
     */
    public static ReactorResult<SIOCThing> getAllScope_as( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_as(model, instanceResource, SCOPE, SIOCThing.class);
	}

    /**
     * Get all values of property Scope     * @return a ClosableIterator of $type
	 *
	 * [Generated from RDFReactor template rule #get12dynamic] 
     */
    public ClosableIterator<SIOCThing> getAllScope() {
		return Base.getAll(this.model, this.getResource(), SCOPE, SIOCThing.class);
	}

    /**
     * Get all values of property Scope as a ReactorResult of Thing 
     * @return a ReactorResult of $type which can conveniently be converted to iterator, list or array
	 *
	 * [Generated from RDFReactor template rule #get12dynamic-reactorresult] 
     */
    public ReactorResult<SIOCThing> getAllScope_as() {
		return Base.getAll_as(this.model, this.getResource(), SCOPE, SIOCThing.class);
	}
 
    /**
     * Adds a value to property Scope as an RDF2Go node 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #add1static] 
     */
    public static void addScope( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.add(model, instanceResource, SCOPE, value);
	}
	
    /**
     * Adds a value to property Scope as an RDF2Go node 
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #add1dynamic] 
     */
    public void addScope( org.ontoware.rdf2go.model.node.Node value ) {
		Base.add(this.model, this.getResource(), SCOPE, value);
	}
    /**
     * Adds a value to property Scope from an instance of Thing 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #add3static] 
     */
    public static void addScope( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            SIOCThing value ) {
		Base.add(model, instanceResource, SCOPE, value);
	}
	
    /**
     * Adds a value to property Scope from an instance of Thing 
	 *
	 * [Generated from RDFReactor template rule #add4dynamic] 
     */
    public void addScope( SIOCThing value ) {
		Base.add(this.model, this.getResource(), SCOPE, value);
	}
  

    /**
     * Sets a value of property Scope from an RDF2Go node.
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be set
	 *
	 * [Generated from RDFReactor template rule #set1static] 
     */
    public static void setScope( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.set(model, instanceResource, SCOPE, value);
	}
	
    /**
     * Sets a value of property Scope from an RDF2Go node.
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set1dynamic] 
     */
    public void setScope( org.ontoware.rdf2go.model.node.Node value ) {
		Base.set(this.model, this.getResource(), SCOPE, value);
	}
    /**
     * Sets a value of property Scope from an instance of Thing 
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set3static] 
     */
    public static void setScope( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            SIOCThing value ) {
		Base.set(model, instanceResource, SCOPE, value);
	}
	
    /**
     * Sets a value of property Scope from an instance of Thing 
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set4dynamic] 
     */
    public void setScope( SIOCThing value ) {
		Base.set(this.model, this.getResource(), SCOPE, value);
	}
  


    /**
     * Removes a value of property Scope as an RDF2Go node 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove1static] 
     */
    public static void removeScope( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.remove(model, instanceResource, SCOPE, value);
	}
	
    /**
     * Removes a value of property Scope as an RDF2Go node
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove1dynamic] 
     */
    public void removeScope( org.ontoware.rdf2go.model.node.Node value ) {
		Base.remove(this.model, this.getResource(), SCOPE, value);
	}
    /**
     * Removes a value of property Scope given as an instance of Thing 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove3static] 
     */
    public static void removeScope( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            SIOCThing value ) {
		Base.remove(model, instanceResource, SCOPE, value);
	}
	
    /**
     * Removes a value of property Scope given as an instance of Thing 
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove4dynamic] 
     */
    public void removeScope( SIOCThing value ) {
		Base.remove(this.model, this.getResource(), SCOPE, value);
	}
  
    /**
     * Removes all values of property Scope     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #removeall1static] 
     */
    public static void removeAllScope( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		Base.removeAll(model, instanceResource, SCOPE);
	}
	
    /**
     * Removes all values of property Scope	 *
	 * [Generated from RDFReactor template rule #removeall1dynamic] 
     */
    public void removeAllScope() {
		Base.removeAll(this.model, this.getResource(), SCOPE);
	}
 }