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
 *   <li> Member </li>
 *   <li> Usergroupof </li>
 *   <li> Comment </li>
 *   <li> Label </li>
 *   <li> Member </li>
 *   <li> Type </li>
 * </ul>
 *
 * This class was generated by <a href="http://RDFReactor.semweb4j.org">RDFReactor</a> on 21.12.12 17:00
 */
public class Usergroup extends SIOCThing {

    /**
     * 
     */
    private static final long serialVersionUID = -6165245536875940846L;

    /** http://rdfs.org/sioc/ns#Usergroup */
	public static final URI RDFS_CLASS = new URIImpl("http://rdfs.org/sioc/ns#Usergroup", false);

    /** http://rdfs.org/sioc/ns#has_member */
	public static final URI MEMBER = new URIImpl("http://rdfs.org/sioc/ns#has_member",false);

    /** http://rdfs.org/sioc/ns#usergroup_of */
	public static final URI USERGROUPOF = new URIImpl("http://rdfs.org/sioc/ns#usergroup_of",false);

    /** 
     * All property-URIs with this class as domain.
     * All properties of all super-classes are also available. 
     */
    public static final URI[] MANAGED_URIS = {
      new URIImpl("http://rdfs.org/sioc/ns#has_member",false),
      new URIImpl("http://rdfs.org/sioc/ns#usergroup_of",false),
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
	protected Usergroup ( Model model, URI classURI, org.ontoware.rdf2go.model.node.Resource instanceIdentifier, boolean write ) {
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
	public Usergroup ( Model model, org.ontoware.rdf2go.model.node.Resource instanceIdentifier, boolean write ) {
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
	public Usergroup ( Model model, String uriString, boolean write) throws ModelRuntimeException {
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
	public Usergroup ( Model model, BlankNode bnode, boolean write ) {
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
	public Usergroup ( Model model, boolean write ) {
		super(model, RDFS_CLASS, model.newRandomUniqueURI(), write);
	}

    ///////////////////////////////////////////////////////////////////
    // typing

	/**
	 * Return an existing instance of this class in the model. No statements are written.
	 * @param model an RDF2Go model
	 * @param instanceResource an RDF2Go resource
	 * @return an instance of Usergroup  or null if none existst
	 *
	 * [Generated from RDFReactor template rule #class0] 
	 */
	public static Usergroup  getInstance(Model model, org.ontoware.rdf2go.model.node.Resource instanceResource) {
		return Base.getInstance(model, instanceResource, Usergroup.class);
	}

	/**
	 * Create a new instance of this class in the model. 
	 * That is, create the statement (instanceResource, RDF.type, http://rdfs.org/sioc/ns#Usergroup).
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
	public static ReactorResult<? extends Usergroup> getAllInstances_as(Model model) {
		return Base.getAllInstances_as(model, RDFS_CLASS, Usergroup.class );
	}

    /**
	 * Remove rdf:type Usergroup from this instance. Other triples are not affected.
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
	 * @return all A's as RDF resources, that have a relation 'Memberof' to this Usergroup instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse1static] 
	 */
    public static ClosableIterator<org.ontoware.rdf2go.model.node.Resource>
            getAllMemberof_Inverse( Model model, Object objectValue ) {
		return Base.getAll_Inverse(model, UserAccount.MEMBEROF, objectValue);
	}

	/**
	 * @return all A's as RDF resources, that have a relation 'Memberof' to this Usergroup instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse1dynamic] 
	 */
    public ClosableIterator<org.ontoware.rdf2go.model.node.Resource>
            getAllMemberof_Inverse() {
		return Base.getAll_Inverse(this.model, UserAccount.MEMBEROF, this.getResource() );
	}

	/**
	 * @param model an RDF2Go model
	 * @param objectValue
	 * @return all A's as a ReactorResult, that have a relation 'Memberof' to this Usergroup instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse-as1static] 
	 */
    public static ReactorResult<org.ontoware.rdf2go.model.node.Resource>
            getAllMemberof_Inverse_as( Model model, Object objectValue ) {
		return Base.getAll_Inverse_as(model, UserAccount.MEMBEROF, objectValue, org.ontoware.rdf2go.model.node.Resource.class);
	}


	/**
	 * @param model an RDF2Go model
	 * @param objectValue
	 * @return all A's as RDF resources, that have a relation 'Usergroup' to this Usergroup instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse1static] 
	 */
    public static ClosableIterator<org.ontoware.rdf2go.model.node.Resource>
            getAllUsergroup_Inverse( Model model, Object objectValue ) {
		return Base.getAll_Inverse(model, Space.USERGROUP, objectValue);
	}

	/**
	 * @return all A's as RDF resources, that have a relation 'Usergroup' to this Usergroup instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse1dynamic] 
	 */
    public ClosableIterator<org.ontoware.rdf2go.model.node.Resource>
            getAllUsergroup_Inverse() {
		return Base.getAll_Inverse(this.model, Space.USERGROUP, this.getResource() );
	}

	/**
	 * @param model an RDF2Go model
	 * @param objectValue
	 * @return all A's as a ReactorResult, that have a relation 'Usergroup' to this Usergroup instance
	 *
	 * [Generated from RDFReactor template rule #getallinverse-as1static] 
	 */
    public static ReactorResult<org.ontoware.rdf2go.model.node.Resource>
            getAllUsergroup_Inverse_as( Model model, Object objectValue ) {
		return Base.getAll_Inverse_as(model, Space.USERGROUP, objectValue, org.ontoware.rdf2go.model.node.Resource.class);
	}



    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@1ba10da6 has at least one value set 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return true if this property has at least one value
	 *
	 * [Generated from RDFReactor template rule #get0has-static] 
     */
    public static boolean hasUsergroupMember( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.has(model, instanceResource, MEMBER);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@1ba10da6 has at least one value set 
     * @return true if this property has at least one value
	 *
	 * [Generated from RDFReactor template rule #get0has-dynamic] 
     */
    public boolean hasUsergroupMember() {
		return Base.has(this.model, this.getResource(), MEMBER);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@1ba10da6 has the given value (maybe among other values).  
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be checked
     * @return true if this property contains (maybe among other) the given value
	 *
	 * [Generated from RDFReactor template rule #get0has-value-static] 
     */
    public static boolean hasUsergroupMember( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		return Base.hasValue(model, instanceResource, MEMBER, value);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@1ba10da6 has the given value (maybe among other values).  
	 * @param value the value to be checked
     * @return true if this property contains (maybe among other) the given value
	 *
	 * [Generated from RDFReactor template rule #get0has-value-dynamic] 
     */
    public boolean
            hasUsergroupMember( org.ontoware.rdf2go.model.node.Node value ) {
		return Base.hasValue(this.model, this.getResource(), MEMBER, value);
	}

     /**
     * Get all values of property Member as an Iterator over RDF2Go nodes 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ClosableIterator of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get7static] 
     */
    public static ClosableIterator<org.ontoware.rdf2go.model.node.Node>
            getAllUsergroupMember_asNode( Model model,
                    org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_asNode(model, instanceResource, MEMBER);
	}
	
    /**
     * Get all values of property Member as a ReactorResult of RDF2Go nodes 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a List of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get7static-reactor-result] 
     */
    public static ReactorResult<org.ontoware.rdf2go.model.node.Node>
            getAllUsergroupMember_asNode_( Model model,
                    org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_as(model, instanceResource, MEMBER, org.ontoware.rdf2go.model.node.Node.class);
	}

    /**
     * Get all values of property Member as an Iterator over RDF2Go nodes 
     * @return a ClosableIterator of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get8dynamic] 
     */
    public ClosableIterator<org.ontoware.rdf2go.model.node.Node>
            getAllUsergroupMember_asNode() {
		return Base.getAll_asNode(this.model, this.getResource(), MEMBER);
	}

    /**
     * Get all values of property Member as a ReactorResult of RDF2Go nodes 
     * @return a List of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get8dynamic-reactor-result] 
     */
    public ReactorResult<org.ontoware.rdf2go.model.node.Node>
            getAllUsergroupMember_asNode_() {
		return Base.getAll_as(this.model, this.getResource(), MEMBER, org.ontoware.rdf2go.model.node.Node.class);
	}
     /**
     * Get all values of property Member     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ClosableIterator of $type
	 *
	 * [Generated from RDFReactor template rule #get11static] 
     */
    public static ClosableIterator<UserAccount> getAllUsergroupMember(
            Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll(model, instanceResource, MEMBER, UserAccount.class);
	}
	
    /**
     * Get all values of property Member as a ReactorResult of UserAccount 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ReactorResult of $type which can conveniently be converted to iterator, list or array
	 *
	 * [Generated from RDFReactor template rule #get11static-reactorresult] 
     */
    public static ReactorResult<UserAccount> getAllUsergroupMember_as(
            Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_as(model, instanceResource, MEMBER, UserAccount.class);
	}

    /**
     * Get all values of property Member     * @return a ClosableIterator of $type
	 *
	 * [Generated from RDFReactor template rule #get12dynamic] 
     */
    public ClosableIterator<UserAccount> getAllUsergroupMember() {
		return Base.getAll(this.model, this.getResource(), MEMBER, UserAccount.class);
	}

    /**
     * Get all values of property Member as a ReactorResult of UserAccount 
     * @return a ReactorResult of $type which can conveniently be converted to iterator, list or array
	 *
	 * [Generated from RDFReactor template rule #get12dynamic-reactorresult] 
     */
    public ReactorResult<UserAccount> getAllUsergroupMember_as() {
		return Base.getAll_as(this.model, this.getResource(), MEMBER, UserAccount.class);
	}
 
    /**
     * Adds a value to property Member as an RDF2Go node 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #add1static] 
     */
    public static void addUsergroupMember( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.add(model, instanceResource, MEMBER, value);
	}
	
    /**
     * Adds a value to property Member as an RDF2Go node 
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #add1dynamic] 
     */
    public void addUsergroupMember( org.ontoware.rdf2go.model.node.Node value ) {
		Base.add(this.model, this.getResource(), MEMBER, value);
	}
    /**
     * Adds a value to property Member from an instance of UserAccount 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #add3static] 
     */
    public static void addUsergroupMember( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            UserAccount value ) {
		Base.add(model, instanceResource, MEMBER, value);
	}
	
    /**
     * Adds a value to property Member from an instance of UserAccount 
	 *
	 * [Generated from RDFReactor template rule #add4dynamic] 
     */
    public void addUsergroupMember( UserAccount value ) {
		Base.add(this.model, this.getResource(), MEMBER, value);
	}
  

    /**
     * Sets a value of property Member from an RDF2Go node.
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be set
	 *
	 * [Generated from RDFReactor template rule #set1static] 
     */
    public static void setUsergroupMember( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.set(model, instanceResource, MEMBER, value);
	}
	
    /**
     * Sets a value of property Member from an RDF2Go node.
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set1dynamic] 
     */
    public void setUsergroupMember( org.ontoware.rdf2go.model.node.Node value ) {
		Base.set(this.model, this.getResource(), MEMBER, value);
	}
    /**
     * Sets a value of property Member from an instance of UserAccount 
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set3static] 
     */
    public static void setUsergroupMember( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            UserAccount value ) {
		Base.set(model, instanceResource, MEMBER, value);
	}
	
    /**
     * Sets a value of property Member from an instance of UserAccount 
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set4dynamic] 
     */
    public void setUsergroupMember( UserAccount value ) {
		Base.set(this.model, this.getResource(), MEMBER, value);
	}
  


    /**
     * Removes a value of property Member as an RDF2Go node 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove1static] 
     */
    public static void removeUsergroupMember( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.remove(model, instanceResource, MEMBER, value);
	}
	
    /**
     * Removes a value of property Member as an RDF2Go node
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove1dynamic] 
     */
    public void
            removeUsergroupMember( org.ontoware.rdf2go.model.node.Node value ) {
		Base.remove(this.model, this.getResource(), MEMBER, value);
	}
    /**
     * Removes a value of property Member given as an instance of UserAccount 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove3static] 
     */
    public static void removeUsergroupMember( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            UserAccount value ) {
		Base.remove(model, instanceResource, MEMBER, value);
	}
	
    /**
     * Removes a value of property Member given as an instance of UserAccount 
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove4dynamic] 
     */
    public void removeUsergroupMember( UserAccount value ) {
		Base.remove(this.model, this.getResource(), MEMBER, value);
	}
  
    /**
     * Removes all values of property Member     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #removeall1static] 
     */
    public static void removeAllUsergroupMember( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		Base.removeAll(model, instanceResource, MEMBER);
	}
	
    /**
     * Removes all values of property Member	 *
	 * [Generated from RDFReactor template rule #removeall1dynamic] 
     */
    public void removeAllUsergroupMember() {
		Base.removeAll(this.model, this.getResource(), MEMBER);
	}
     /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@22aa3904 has at least one value set 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return true if this property has at least one value
	 *
	 * [Generated from RDFReactor template rule #get0has-static] 
     */
    public static boolean hasUsergroupof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.has(model, instanceResource, USERGROUPOF);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@22aa3904 has at least one value set 
     * @return true if this property has at least one value
	 *
	 * [Generated from RDFReactor template rule #get0has-dynamic] 
     */
    public boolean hasUsergroupof() {
		return Base.has(this.model, this.getResource(), USERGROUPOF);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@22aa3904 has the given value (maybe among other values).  
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be checked
     * @return true if this property contains (maybe among other) the given value
	 *
	 * [Generated from RDFReactor template rule #get0has-value-static] 
     */
    public static boolean hasUsergroupof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		return Base.hasValue(model, instanceResource, USERGROUPOF, value);
	}

    /**
     * Check if org.ontoware.rdfreactor.generator.java.JProperty@22aa3904 has the given value (maybe among other values).  
	 * @param value the value to be checked
     * @return true if this property contains (maybe among other) the given value
	 *
	 * [Generated from RDFReactor template rule #get0has-value-dynamic] 
     */
    public boolean hasUsergroupof( org.ontoware.rdf2go.model.node.Node value ) {
		return Base.hasValue(this.model, this.getResource(), USERGROUPOF, value);
	}

     /**
     * Get all values of property Usergroupof as an Iterator over RDF2Go nodes 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ClosableIterator of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get7static] 
     */
    public static ClosableIterator<org.ontoware.rdf2go.model.node.Node>
            getAllUsergroupof_asNode( Model model,
                    org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_asNode(model, instanceResource, USERGROUPOF);
	}
	
    /**
     * Get all values of property Usergroupof as a ReactorResult of RDF2Go nodes 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a List of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get7static-reactor-result] 
     */
    public static ReactorResult<org.ontoware.rdf2go.model.node.Node>
            getAllUsergroupof_asNode_( Model model,
                    org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_as(model, instanceResource, USERGROUPOF, org.ontoware.rdf2go.model.node.Node.class);
	}

    /**
     * Get all values of property Usergroupof as an Iterator over RDF2Go nodes 
     * @return a ClosableIterator of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get8dynamic] 
     */
    public ClosableIterator<org.ontoware.rdf2go.model.node.Node>
            getAllUsergroupof_asNode() {
		return Base.getAll_asNode(this.model, this.getResource(), USERGROUPOF);
	}

    /**
     * Get all values of property Usergroupof as a ReactorResult of RDF2Go nodes 
     * @return a List of RDF2Go Nodes
	 *
	 * [Generated from RDFReactor template rule #get8dynamic-reactor-result] 
     */
    public ReactorResult<org.ontoware.rdf2go.model.node.Node>
            getAllUsergroupof_asNode_() {
		return Base.getAll_as(this.model, this.getResource(), USERGROUPOF, org.ontoware.rdf2go.model.node.Node.class);
	}
     /**
     * Get all values of property Usergroupof     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ClosableIterator of $type
	 *
	 * [Generated from RDFReactor template rule #get11static] 
     */
    public static ClosableIterator<Space> getAllUsergroupof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll(model, instanceResource, USERGROUPOF, Space.class);
	}
	
    /**
     * Get all values of property Usergroupof as a ReactorResult of Space 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
     * @return a ReactorResult of $type which can conveniently be converted to iterator, list or array
	 *
	 * [Generated from RDFReactor template rule #get11static-reactorresult] 
     */
    public static ReactorResult<Space> getAllUsergroupof_as( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		return Base.getAll_as(model, instanceResource, USERGROUPOF, Space.class);
	}

    /**
     * Get all values of property Usergroupof     * @return a ClosableIterator of $type
	 *
	 * [Generated from RDFReactor template rule #get12dynamic] 
     */
    public ClosableIterator<Space> getAllUsergroupof() {
		return Base.getAll(this.model, this.getResource(), USERGROUPOF, Space.class);
	}

    /**
     * Get all values of property Usergroupof as a ReactorResult of Space 
     * @return a ReactorResult of $type which can conveniently be converted to iterator, list or array
	 *
	 * [Generated from RDFReactor template rule #get12dynamic-reactorresult] 
     */
    public ReactorResult<Space> getAllUsergroupof_as() {
		return Base.getAll_as(this.model, this.getResource(), USERGROUPOF, Space.class);
	}
 
    /**
     * Adds a value to property Usergroupof as an RDF2Go node 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #add1static] 
     */
    public static void addUsergroupof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.add(model, instanceResource, USERGROUPOF, value);
	}
	
    /**
     * Adds a value to property Usergroupof as an RDF2Go node 
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #add1dynamic] 
     */
    public void addUsergroupof( org.ontoware.rdf2go.model.node.Node value ) {
		Base.add(this.model, this.getResource(), USERGROUPOF, value);
	}
    /**
     * Adds a value to property Usergroupof from an instance of Space 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #add3static] 
     */
    public static void addUsergroupof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            Space value ) {
		Base.add(model, instanceResource, USERGROUPOF, value);
	}
	
    /**
     * Adds a value to property Usergroupof from an instance of Space 
	 *
	 * [Generated from RDFReactor template rule #add4dynamic] 
     */
    public void addUsergroupof( Space value ) {
		Base.add(this.model, this.getResource(), USERGROUPOF, value);
	}
  

    /**
     * Sets a value of property Usergroupof from an RDF2Go node.
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be set
	 *
	 * [Generated from RDFReactor template rule #set1static] 
     */
    public static void setUsergroupof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.set(model, instanceResource, USERGROUPOF, value);
	}
	
    /**
     * Sets a value of property Usergroupof from an RDF2Go node.
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set1dynamic] 
     */
    public void setUsergroupof( org.ontoware.rdf2go.model.node.Node value ) {
		Base.set(this.model, this.getResource(), USERGROUPOF, value);
	}
    /**
     * Sets a value of property Usergroupof from an instance of Space 
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set3static] 
     */
    public static void setUsergroupof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            Space value ) {
		Base.set(model, instanceResource, USERGROUPOF, value);
	}
	
    /**
     * Sets a value of property Usergroupof from an instance of Space 
     * First, all existing values are removed, then this value is added.
     * Cardinality constraints are not checked, but this method exists only for properties with
     * no minCardinality or minCardinality == 1.
	 * @param value the value to be added
	 *
	 * [Generated from RDFReactor template rule #set4dynamic] 
     */
    public void setUsergroupof( Space value ) {
		Base.set(this.model, this.getResource(), USERGROUPOF, value);
	}
  


    /**
     * Removes a value of property Usergroupof as an RDF2Go node 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove1static] 
     */
    public static void removeUsergroupof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            org.ontoware.rdf2go.model.node.Node value ) {
		Base.remove(model, instanceResource, USERGROUPOF, value);
	}
	
    /**
     * Removes a value of property Usergroupof as an RDF2Go node
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove1dynamic] 
     */
    public void removeUsergroupof( org.ontoware.rdf2go.model.node.Node value ) {
		Base.remove(this.model, this.getResource(), USERGROUPOF, value);
	}
    /**
     * Removes a value of property Usergroupof given as an instance of Space 
     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove3static] 
     */
    public static void removeUsergroupof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource,
            Space value ) {
		Base.remove(model, instanceResource, USERGROUPOF, value);
	}
	
    /**
     * Removes a value of property Usergroupof given as an instance of Space 
	 * @param value the value to be removed
	 *
	 * [Generated from RDFReactor template rule #remove4dynamic] 
     */
    public void removeUsergroupof( Space value ) {
		Base.remove(this.model, this.getResource(), USERGROUPOF, value);
	}
  
    /**
     * Removes all values of property Usergroupof     * @param model an RDF2Go model
     * @param resource an RDF2Go resource
	 *
	 * [Generated from RDFReactor template rule #removeall1static] 
     */
    public static void removeAllUsergroupof( Model model,
            org.ontoware.rdf2go.model.node.Resource instanceResource ) {
		Base.removeAll(model, instanceResource, USERGROUPOF);
	}
	
    /**
     * Removes all values of property Usergroupof	 *
	 * [Generated from RDFReactor template rule #removeall1dynamic] 
     */
    public void removeAllUsergroupof() {
		Base.removeAll(this.model, this.getResource(), USERGROUPOF);
	}
 }