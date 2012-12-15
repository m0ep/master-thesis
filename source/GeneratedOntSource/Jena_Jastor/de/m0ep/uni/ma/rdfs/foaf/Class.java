

package de.m0ep.uni.ma.rdfs.foaf;

import com.hp.hpl.jena.rdf.model.*;

/**
 * Interface for Class ontology class<br>
 * Use the de.m0ep.uni.ma.rdfs.foaf.Factory to create instances of this interface.
 * <p>(URI: http://www.w3.org/2000/01/rdf-schema#Class)</p>
 * <br>
 * <br>
 * <br>
 */
public interface Class extends com.ibm.adtech.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final Resource TYPE = ResourceFactory.createResource("http://www.w3.org/2000/01/rdf-schema#Class");
	

	/**
	 * The Jena Property for fundedBy 
	 * <p>(URI: http://xmlns.com/foaf/0.1/fundedBy)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : funded by <br>
	 * 	comment : An organization funding a project or person. <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property fundedByProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/fundedBy");


	/**
	 * The Jena Property for name 
	 * <p>(URI: http://xmlns.com/foaf/0.1/name)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : name <br>
	 * 	comment : A name for some thing. <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property nameProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/name");


	/**
	 * The Jena Property for dnaChecksum 
	 * <p>(URI: http://xmlns.com/foaf/0.1/dnaChecksum)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : DNA checksum <br>
	 * 	comment : A checksum for the DNA of some thing. Joke. <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property dnaChecksumProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/dnaChecksum");


	/**
	 * The Jena Property for phone 
	 * <p>(URI: http://xmlns.com/foaf/0.1/phone)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : phone <br>
	 * 	comment : A phone,  specified using fully qualified tel: URI scheme (refs: http://www.w3.org/Addressing/schemes.html#tel). <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property phoneProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/phone");


	/**
	 * The Jena Property for page 
	 * <p>(URI: http://xmlns.com/foaf/0.1/page)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : page <br>
	 * 	comment : A page or document about this thing. <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property pageProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/page");


	/**
	 * The Jena Property for nick 
	 * <p>(URI: http://xmlns.com/foaf/0.1/nick)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : nickname <br>
	 * 	comment : A short informal nickname characterising an agent (includes login identifiers, IRC and other chat nicknames). <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property nickProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/nick");


	/**
	 * The Jena Property for logo 
	 * <p>(URI: http://xmlns.com/foaf/0.1/logo)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : logo <br>
	 * 	comment : A logo representing some thing. <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property logoProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/logo");


	/**
	 * The Jena Property for maker 
	 * <p>(URI: http://xmlns.com/foaf/0.1/maker)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : maker <br>
	 * 	comment : An agent that  made this thing. <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property makerProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/maker");


	/**
	 * The Jena Property for givenname 
	 * <p>(URI: http://xmlns.com/foaf/0.1/givenname)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : Given name <br>
	 * 	comment : The given name of some person. <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property givennameProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/givenname");


	/**
	 * The Jena Property for title 
	 * <p>(URI: http://xmlns.com/foaf/0.1/title)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : title <br>
	 * 	comment : Title (Mr, Mrs, Ms, Dr. etc) <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property titleProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/title");


	/**
	 * The Jena Property for givenName 
	 * <p>(URI: http://xmlns.com/foaf/0.1/givenName)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : Given name <br>
	 * 	comment : The given name of some person. <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property givenNameProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/givenName");


	/**
	 * The Jena Property for homepage 
	 * <p>(URI: http://xmlns.com/foaf/0.1/homepage)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : homepage <br>
	 * 	comment : A homepage for some thing. <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property homepageProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/homepage");


	/**
	 * The Jena Property for theme 
	 * <p>(URI: http://xmlns.com/foaf/0.1/theme)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : theme <br>
	 * 	comment : A theme. <br>
	 * <br>  
	 */
	public static com.hp.hpl.jena.rdf.model.Property themeProperty = ResourceFactory.createProperty("http://xmlns.com/foaf/0.1/theme");



	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/Project
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Project = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/Project");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/Organization
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Organization = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/Organization");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/OnlineAccount
	 */
	public static com.hp.hpl.jena.rdf.model.Resource OnlineAccount = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/OnlineAccount");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/Document
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Document = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/Document");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/Agent
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Agent = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/Agent");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/Image
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Image = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/Image");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/Person
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Person = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/Person");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/Group
	 */
	public static com.hp.hpl.jena.rdf.model.Resource Group = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/Group");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/OnlineGamingAccount
	 */
	public static com.hp.hpl.jena.rdf.model.Resource OnlineGamingAccount = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/OnlineGamingAccount");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/LabelProperty
	 */
	public static com.hp.hpl.jena.rdf.model.Resource LabelProperty = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/LabelProperty");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/PersonalProfileDocument
	 */
	public static com.hp.hpl.jena.rdf.model.Resource PersonalProfileDocument = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/PersonalProfileDocument");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/OnlineChatAccount
	 */
	public static com.hp.hpl.jena.rdf.model.Resource OnlineChatAccount = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/OnlineChatAccount");


	/**
	 * Individual for URI: http://xmlns.com/foaf/0.1/OnlineEcommerceAccount
	 */
	public static com.hp.hpl.jena.rdf.model.Resource OnlineEcommerceAccount = ResourceFactory.createResource("http://xmlns.com/foaf/0.1/OnlineEcommerceAccount");



	/**
	 * Get an Iterator the 'fundedBy' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.ibm.adtech.jastor.Thing}
	 * @see			#fundedByProperty
	 */
	public java.util.Iterator getFundedBy() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'fundedBy' property
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to add
	 * @see			#fundedByProperty
	 */
	public void addFundedBy(com.ibm.adtech.jastor.Thing fundedBy) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'fundedBy' property
	 * @return		The anoymous {@link com.ibm.adtech.jastor.Thing} created
	 * @see			#fundedByProperty
	 */
	public com.ibm.adtech.jastor.Thing addFundedBy() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * 
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#fundedByProperty
	 */
	public com.ibm.adtech.jastor.Thing addFundedBy(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'fundedBy' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to remove
	 * @see			#fundedByProperty
	 */
	public void removeFundedBy(com.ibm.adtech.jastor.Thing fundedBy) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Iterates through the 'name' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.hp.hpl.jena.rdf.model.Literal}
	 * @see			#nameProperty
	 */
	public java.util.Iterator getName() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Add a 'name' property value
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to add
	 * @see			#nameProperty
	 */
	public void addName(com.hp.hpl.jena.rdf.model.Literal name) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Remove a 'name' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to remove
	 * @see			#nameProperty
	 */
	public void removeName(com.hp.hpl.jena.rdf.model.Literal name) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Iterates through the 'dnaChecksum' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.hp.hpl.jena.rdf.model.Literal}
	 * @see			#dnaChecksumProperty
	 */
	public java.util.Iterator getDnaChecksum() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Add a 'dnaChecksum' property value
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to add
	 * @see			#dnaChecksumProperty
	 */
	public void addDnaChecksum(com.hp.hpl.jena.rdf.model.Literal dnaChecksum) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Remove a 'dnaChecksum' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to remove
	 * @see			#dnaChecksumProperty
	 */
	public void removeDnaChecksum(com.hp.hpl.jena.rdf.model.Literal dnaChecksum) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Get an Iterator the 'phone' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.ibm.adtech.jastor.Thing}
	 * @see			#phoneProperty
	 */
	public java.util.Iterator getPhone() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'phone' property
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to add
	 * @see			#phoneProperty
	 */
	public void addPhone(com.ibm.adtech.jastor.Thing phone) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'phone' property
	 * @return		The anoymous {@link com.ibm.adtech.jastor.Thing} created
	 * @see			#phoneProperty
	 */
	public com.ibm.adtech.jastor.Thing addPhone() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * 
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#phoneProperty
	 */
	public com.ibm.adtech.jastor.Thing addPhone(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'phone' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to remove
	 * @see			#phoneProperty
	 */
	public void removePhone(com.ibm.adtech.jastor.Thing phone) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Get an Iterator the 'page' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link de.m0ep.uni.ma.rdfs.foaf.Document}
	 * @see			#pageProperty
	 */
	public java.util.Iterator getPage() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'page' property
	 * @param		The {@link de.m0ep.uni.ma.rdfs.foaf.Document} to add
	 * @see			#pageProperty
	 */
	public void addPage(de.m0ep.uni.ma.rdfs.foaf.Document page) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'page' property
	 * @return		The anoymous {@link de.m0ep.uni.ma.rdfs.foaf.Document} created
	 * @see			#pageProperty
	 */
	public de.m0ep.uni.ma.rdfs.foaf.Document addPage() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * 
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Document.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#pageProperty
	 */
	public de.m0ep.uni.ma.rdfs.foaf.Document addPage(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'page' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link de.m0ep.uni.ma.rdfs.foaf.Document} to remove
	 * @see			#pageProperty
	 */
	public void removePage(de.m0ep.uni.ma.rdfs.foaf.Document page) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Iterates through the 'nick' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.hp.hpl.jena.rdf.model.Literal}
	 * @see			#nickProperty
	 */
	public java.util.Iterator getNick() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Add a 'nick' property value
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to add
	 * @see			#nickProperty
	 */
	public void addNick(com.hp.hpl.jena.rdf.model.Literal nick) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Remove a 'nick' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to remove
	 * @see			#nickProperty
	 */
	public void removeNick(com.hp.hpl.jena.rdf.model.Literal nick) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Get an Iterator the 'logo' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.ibm.adtech.jastor.Thing}
	 * @see			#logoProperty
	 */
	public java.util.Iterator getLogo() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'logo' property
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to add
	 * @see			#logoProperty
	 */
	public void addLogo(com.ibm.adtech.jastor.Thing logo) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'logo' property
	 * @return		The anoymous {@link com.ibm.adtech.jastor.Thing} created
	 * @see			#logoProperty
	 */
	public com.ibm.adtech.jastor.Thing addLogo() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * 
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#logoProperty
	 */
	public com.ibm.adtech.jastor.Thing addLogo(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'logo' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to remove
	 * @see			#logoProperty
	 */
	public void removeLogo(com.ibm.adtech.jastor.Thing logo) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Get an Iterator the 'maker' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link de.m0ep.uni.ma.rdfs.foaf.Agent}
	 * @see			#makerProperty
	 */
	public java.util.Iterator getMaker() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'maker' property
	 * @param		The {@link de.m0ep.uni.ma.rdfs.foaf.Agent} to add
	 * @see			#makerProperty
	 */
	public void addMaker(de.m0ep.uni.ma.rdfs.foaf.Agent maker) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'maker' property
	 * @return		The anoymous {@link de.m0ep.uni.ma.rdfs.foaf.Agent} created
	 * @see			#makerProperty
	 */
	public de.m0ep.uni.ma.rdfs.foaf.Agent addMaker() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * 
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Agent.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#makerProperty
	 */
	public de.m0ep.uni.ma.rdfs.foaf.Agent addMaker(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'maker' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link de.m0ep.uni.ma.rdfs.foaf.Agent} to remove
	 * @see			#makerProperty
	 */
	public void removeMaker(de.m0ep.uni.ma.rdfs.foaf.Agent maker) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Iterates through the 'givenname' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.hp.hpl.jena.rdf.model.Literal}
	 * @see			#givennameProperty
	 */
	public java.util.Iterator getGivenname() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Add a 'givenname' property value
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to add
	 * @see			#givennameProperty
	 */
	public void addGivenname(com.hp.hpl.jena.rdf.model.Literal givenname) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Remove a 'givenname' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to remove
	 * @see			#givennameProperty
	 */
	public void removeGivenname(com.hp.hpl.jena.rdf.model.Literal givenname) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Iterates through the 'title' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.hp.hpl.jena.rdf.model.Literal}
	 * @see			#titleProperty
	 */
	public java.util.Iterator getTitle() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Add a 'title' property value
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to add
	 * @see			#titleProperty
	 */
	public void addTitle(com.hp.hpl.jena.rdf.model.Literal title) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Remove a 'title' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to remove
	 * @see			#titleProperty
	 */
	public void removeTitle(com.hp.hpl.jena.rdf.model.Literal title) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Iterates through the 'givenName' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.hp.hpl.jena.rdf.model.Literal}
	 * @see			#givenNameProperty
	 */
	public java.util.Iterator getGivenName() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Add a 'givenName' property value
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to add
	 * @see			#givenNameProperty
	 */
	public void addGivenName(com.hp.hpl.jena.rdf.model.Literal givenName) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Remove a 'givenName' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		{@link com.hp.hpl.jena.rdf.model.Literal}, the value to remove
	 * @see			#givenNameProperty
	 */
	public void removeGivenName(com.hp.hpl.jena.rdf.model.Literal givenName) throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Get an Iterator the 'homepage' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link de.m0ep.uni.ma.rdfs.foaf.Document}
	 * @see			#homepageProperty
	 */
	public java.util.Iterator getHomepage() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'homepage' property
	 * @param		The {@link de.m0ep.uni.ma.rdfs.foaf.Document} to add
	 * @see			#homepageProperty
	 */
	public void addHomepage(de.m0ep.uni.ma.rdfs.foaf.Document homepage) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'homepage' property
	 * @return		The anoymous {@link de.m0ep.uni.ma.rdfs.foaf.Document} created
	 * @see			#homepageProperty
	 */
	public de.m0ep.uni.ma.rdfs.foaf.Document addHomepage() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * 
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Document.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#homepageProperty
	 */
	public de.m0ep.uni.ma.rdfs.foaf.Document addHomepage(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'homepage' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link de.m0ep.uni.ma.rdfs.foaf.Document} to remove
	 * @see			#homepageProperty
	 */
	public void removeHomepage(de.m0ep.uni.ma.rdfs.foaf.Document homepage) throws com.ibm.adtech.jastor.JastorException;
		
	/**
	 * Get an Iterator the 'theme' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Iterator} of {@link com.ibm.adtech.jastor.Thing}
	 * @see			#themeProperty
	 */
	public java.util.Iterator getTheme() throws com.ibm.adtech.jastor.JastorException;

	/**
	 * Adds a value for the 'theme' property
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to add
	 * @see			#themeProperty
	 */
	public void addTheme(com.ibm.adtech.jastor.Thing theme) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'theme' property
	 * @return		The anoymous {@link com.ibm.adtech.jastor.Thing} created
	 * @see			#themeProperty
	 */
	public com.ibm.adtech.jastor.Thing addTheme() throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * 
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param		The {@link om.hp.hpl.jena.rdf.model.Resource} to add
	 * @see			#themeProperty
	 */
	public com.ibm.adtech.jastor.Thing addTheme(com.hp.hpl.jena.rdf.model.Resource resource) throws com.ibm.adtech.jastor.JastorException;
	
	/**
	 * Removes a value for the 'theme' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param		The {@link com.ibm.adtech.jastor.Thing} to remove
	 * @see			#themeProperty
	 */
	public void removeTheme(com.ibm.adtech.jastor.Thing theme) throws com.ibm.adtech.jastor.JastorException;
		
}