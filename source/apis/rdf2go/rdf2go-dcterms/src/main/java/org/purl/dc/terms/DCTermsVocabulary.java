package org.purl.dc.terms;

import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;

/**
 * Vocabulary File. Created by org.ontoware.rdf2go.util.VocabularyWriter on Sun
 * Dec 23 16:39:21 CET 2012 input file:
 * src/main/resources/ontologies/dcterms.rdf namespace:
 * http://purl.org/dc/terms/
 */
public interface DCTermsVocabulary {
    public static final URI NS_DCTerms = new URIImpl(
	    "http://purl.org/dc/terms/", false);

    /**
     * Label: Agent@en Comment: A resource that acts or has the power to act.@en
     */
    public static final URI Agent = new URIImpl(
	    "http://purl.org/dc/terms/Agent", false);

    /**
     * Label: Agent Class@en Comment: A group of agents.@en
     */
    public static final URI AgentClass = new URIImpl(
	    "http://purl.org/dc/terms/AgentClass", false);

    /**
     * Label: Bibliographic Resource@en Comment: A book, article, or other
     * documentary resource.@en
     */
    public static final URI BibliographicResource = new URIImpl(
	    "http://purl.org/dc/terms/BibliographicResource", false);

    /**
     * Label: File Format@en Comment: A digital resource format.@en
     */
    public static final URI FileFormat = new URIImpl(
	    "http://purl.org/dc/terms/FileFormat", false);

    /**
     * Label: Frequency@en Comment: A rate at which something recurs.@en
     */
    public static final URI Frequency = new URIImpl(
	    "http://purl.org/dc/terms/Frequency", false);

    /**
     * Label: Jurisdiction@en Comment: The extent or range of judicial, law
     * enforcement, or other authority.@en
     */
    public static final URI Jurisdiction = new URIImpl(
	    "http://purl.org/dc/terms/Jurisdiction", false);

    /**
     * Label: License Document@en Comment: A legal document giving official
     * permission to do something with a Resource.@en
     */
    public static final URI LicenseDocument = new URIImpl(
	    "http://purl.org/dc/terms/LicenseDocument", false);

    /**
     * Label: Linguistic System@en Comment: A system of signs, symbols, sounds,
     * gestures, or rules used in communication.@en
     */
    public static final URI LinguisticSystem = new URIImpl(
	    "http://purl.org/dc/terms/LinguisticSystem", false);

    /**
     * Label: Location@en Comment: A spatial region or named place.@en
     */
    public static final URI Location = new URIImpl(
	    "http://purl.org/dc/terms/Location", false);

    /**
     * Label: Location, Period, or Jurisdiction@en Comment: A location, period
     * of time, or jurisdiction.@en
     */
    public static final URI LocationPeriodOrJurisdiction = new URIImpl(
	    "http://purl.org/dc/terms/LocationPeriodOrJurisdiction", false);

    /**
     * Label: Media Type@en Comment: A file format or physical medium.@en
     */
    public static final URI MediaType = new URIImpl(
	    "http://purl.org/dc/terms/MediaType", false);

    /**
     * Label: Media Type or Extent@en Comment: A media type or extent.@en
     */
    public static final URI MediaTypeOrExtent = new URIImpl(
	    "http://purl.org/dc/terms/MediaTypeOrExtent", false);

    /**
     * Label: Method of Instruction@en Comment: A process that is used to
     * engender knowledge, attitudes, and skills.@en
     */
    public static final URI MethodOfInstruction = new URIImpl(
	    "http://purl.org/dc/terms/MethodOfInstruction", false);

    /**
     * Label: Method of Accrual@en Comment: A method by which resources are
     * added to a collection.@en
     */
    public static final URI MethodOfAccrual = new URIImpl(
	    "http://purl.org/dc/terms/MethodOfAccrual", false);

    /**
     * Label: Period of Time@en Comment: An interval of time that is named or
     * defined by its start and end dates.@en
     */
    public static final URI PeriodOfTime = new URIImpl(
	    "http://purl.org/dc/terms/PeriodOfTime", false);

    /**
     * Label: Physical Medium@en Comment: A physical material or carrier.@en
     */
    public static final URI PhysicalMedium = new URIImpl(
	    "http://purl.org/dc/terms/PhysicalMedium", false);

    /**
     * Label: Physical Resource@en Comment: A material thing.@en
     */
    public static final URI PhysicalResource = new URIImpl(
	    "http://purl.org/dc/terms/PhysicalResource", false);

    /**
     * Label: Policy@en Comment: A plan or course of action by an authority,
     * intended to influence and determine decisions, actions, and other
     * matters.@en
     */
    public static final URI Policy = new URIImpl(
	    "http://purl.org/dc/terms/Policy", false);

    /**
     * Label: Provenance Statement@en Comment: A statement of any changes in
     * ownership and custody of a resource since its creation that are
     * significant for its authenticity, integrity, and interpretation.@en
     */
    public static final URI ProvenanceStatement = new URIImpl(
	    "http://purl.org/dc/terms/ProvenanceStatement", false);

    /**
     * Label: Rights Statement@en Comment: A statement about the intellectual
     * property rights (IPR) held in or over a Resource, a legal document giving
     * official permission to do something with a resource, or a statement about
     * access rights.@en
     */
    public static final URI RightsStatement = new URIImpl(
	    "http://purl.org/dc/terms/RightsStatement", false);

    /**
     * Label: Size or Duration@en Comment: A dimension or extent, or a time
     * taken to play or execute.@en
     */
    public static final URI SizeOrDuration = new URIImpl(
	    "http://purl.org/dc/terms/SizeOrDuration", false);

    /**
     * Label: Standard@en Comment: A basis for comparison; a reference point
     * against which other things can be evaluated.@en
     */
    public static final URI Standard = new URIImpl(
	    "http://purl.org/dc/terms/Standard", false);

    /**
     * Label: Title@en Comment: A name given to the resource.@en Range:
     * http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI title = new URIImpl(
	    "http://purl.org/dc/terms/title", false);

    /**
     * Label: Creator@en Comment: An entity primarily responsible for making the
     * resource.@en Range: http://purl.org/dc/terms/Agent
     */
    public static final URI creator = new URIImpl(
	    "http://purl.org/dc/terms/creator", false);

    /**
     * Label: Subject@en Comment: The topic of the resource.@en
     */
    public static final URI subject = new URIImpl(
	    "http://purl.org/dc/terms/subject", false);

    /**
     * Label: Description@en Comment: An account of the resource.@en
     */
    public static final URI description = new URIImpl(
	    "http://purl.org/dc/terms/description", false);

    /**
     * Label: Publisher@en Comment: An entity responsible for making the
     * resource available.@en Range: http://purl.org/dc/terms/Agent
     */
    public static final URI publisher = new URIImpl(
	    "http://purl.org/dc/terms/publisher", false);

    /**
     * Label: Contributor@en Comment: An entity responsible for making
     * contributions to the resource.@en Range: http://purl.org/dc/terms/Agent
     */
    public static final URI contributor = new URIImpl(
	    "http://purl.org/dc/terms/contributor", false);

    /**
     * Label: Date@en Comment: A point or period of time associated with an
     * event in the lifecycle of the resource.@en Range:
     * http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI date = new URIImpl("http://purl.org/dc/terms/date",
	    false);

    /**
     * Label: Type@en Comment: The nature or genre of the resource.@en Range:
     * http://www.w3.org/2000/01/rdf-schema#Class
     */
    public static final URI type = new URIImpl("http://purl.org/dc/terms/type",
	    false);

    /**
     * Label: Format@en Comment: The file format, physical medium, or dimensions
     * of the resource.@en Range: http://purl.org/dc/terms/MediaTypeOrExtent
     */
    public static final URI format = new URIImpl(
	    "http://purl.org/dc/terms/format", false);

    /**
     * Label: Identifier@en Comment: An unambiguous reference to the resource
     * within a given context.@en Range:
     * http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI identifier = new URIImpl(
	    "http://purl.org/dc/terms/identifier", false);

    /**
     * Label: Source@en Comment: A related resource from which the described
     * resource is derived.@en
     */
    public static final URI source = new URIImpl(
	    "http://purl.org/dc/terms/source", false);

    /**
     * Label: Language@en Comment: A language of the resource.@en Range:
     * http://purl.org/dc/terms/LinguisticSystem
     */
    public static final URI language = new URIImpl(
	    "http://purl.org/dc/terms/language", false);

    /**
     * Label: Relation@en Comment: A related resource.@en
     */
    public static final URI relation = new URIImpl(
	    "http://purl.org/dc/terms/relation", false);

    /**
     * Label: Coverage@en Comment: The spatial or temporal topic of the
     * resource, the spatial applicability of the resource, or the jurisdiction
     * under which the resource is relevant.@en Range:
     * http://purl.org/dc/terms/LocationPeriodOrJurisdiction
     */
    public static final URI coverage = new URIImpl(
	    "http://purl.org/dc/terms/coverage", false);

    /**
     * Label: Rights@en Comment: Information about rights held in and over the
     * resource.@en Range: http://purl.org/dc/terms/RightsStatement
     */
    public static final URI rights = new URIImpl(
	    "http://purl.org/dc/terms/rights", false);

    /**
     * Label: Audience@en Comment: A class of entity for whom the resource is
     * intended or useful.@en Range: http://purl.org/dc/terms/AgentClass
     */
    public static final URI audience = new URIImpl(
	    "http://purl.org/dc/terms/audience", false);

    /**
     * Label: Alternative Title@en Comment: An alternative name for the
     * resource.@en Range: http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI alternative = new URIImpl(
	    "http://purl.org/dc/terms/alternative", false);

    /**
     * Label: Table Of Contents@en Comment: A list of subunits of the resource.@en
     */
    public static final URI tableOfContents = new URIImpl(
	    "http://purl.org/dc/terms/tableOfContents", false);

    /**
     * Label: Abstract@en Comment: A summary of the resource.@en
     */
    public static final URI abstract_ = new URIImpl(
	    "http://purl.org/dc/terms/abstract", false);

    /**
     * Label: Date Created@en Comment: Date of creation of the resource.@en
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI created = new URIImpl(
	    "http://purl.org/dc/terms/created", false);

    /**
     * Label: Date Valid@en Comment: Date (often a range) of validity of a
     * resource.@en Range: http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI valid = new URIImpl(
	    "http://purl.org/dc/terms/valid", false);

    /**
     * Label: Date Available@en Comment: Date (often a range) that the resource
     * became or will become available.@en Range:
     * http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI available = new URIImpl(
	    "http://purl.org/dc/terms/available", false);

    /**
     * Label: Date Issued@en Comment: Date of formal issuance (e.g.,
     * publication) of the resource.@en Range:
     * http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI issued = new URIImpl(
	    "http://purl.org/dc/terms/issued", false);

    /**
     * Label: Date Modified@en Comment: Date on which the resource was changed.@en
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI modified = new URIImpl(
	    "http://purl.org/dc/terms/modified", false);

    /**
     * Label: Extent@en Comment: The size or duration of the resource.@en Range:
     * http://purl.org/dc/terms/SizeOrDuration
     */
    public static final URI extent = new URIImpl(
	    "http://purl.org/dc/terms/extent", false);

    /**
     * Label: Medium@en Comment: The material or physical carrier of the
     * resource.@en Comment: http://purl.org/dc/terms/PhysicalResource Range:
     * http://purl.org/dc/terms/PhysicalMedium
     */
    public static final URI medium = new URIImpl(
	    "http://purl.org/dc/terms/medium", false);

    /**
     * Label: Is Version Of@en Comment: A related resource of which the
     * described resource is a version, edition, or adaptation.@en
     */
    public static final URI isVersionOf = new URIImpl(
	    "http://purl.org/dc/terms/isVersionOf", false);

    /**
     * Label: Has Version@en Comment: A related resource that is a version,
     * edition, or adaptation of the described resource.@en
     */
    public static final URI hasVersion = new URIImpl(
	    "http://purl.org/dc/terms/hasVersion", false);

    /**
     * Label: Is Replaced By@en Comment: A related resource that supplants,
     * displaces, or supersedes the described resource.@en
     */
    public static final URI isReplacedBy = new URIImpl(
	    "http://purl.org/dc/terms/isReplacedBy", false);

    /**
     * Label: Replaces@en Comment: A related resource that is supplanted,
     * displaced, or superseded by the described resource.@en
     */
    public static final URI replaces = new URIImpl(
	    "http://purl.org/dc/terms/replaces", false);

    /**
     * Label: Is Required By@en Comment: A related resource that requires the
     * described resource to support its function, delivery, or coherence.@en
     */
    public static final URI isRequiredBy = new URIImpl(
	    "http://purl.org/dc/terms/isRequiredBy", false);

    /**
     * Label: Requires@en Comment: A related resource that is required by the
     * described resource to support its function, delivery, or coherence.@en
     */
    public static final URI requires = new URIImpl(
	    "http://purl.org/dc/terms/requires", false);

    /**
     * Label: Is Part Of@en Comment: A related resource in which the described
     * resource is physically or logically included.@en
     */
    public static final URI isPartOf = new URIImpl(
	    "http://purl.org/dc/terms/isPartOf", false);

    /**
     * Label: Has Part@en Comment: A related resource that is included either
     * physically or logically in the described resource.@en
     */
    public static final URI hasPart = new URIImpl(
	    "http://purl.org/dc/terms/hasPart", false);

    /**
     * Label: Is Referenced By@en Comment: A related resource that references,
     * cites, or otherwise points to the described resource.@en
     */
    public static final URI isReferencedBy = new URIImpl(
	    "http://purl.org/dc/terms/isReferencedBy", false);

    /**
     * Label: References@en Comment: A related resource that is referenced,
     * cited, or otherwise pointed to by the described resource.@en
     */
    public static final URI references = new URIImpl(
	    "http://purl.org/dc/terms/references", false);

    /**
     * Label: Is Format Of@en Comment: A related resource that is substantially
     * the same as the described resource, but in another format.@en
     */
    public static final URI isFormatOf = new URIImpl(
	    "http://purl.org/dc/terms/isFormatOf", false);

    /**
     * Label: Has Format@en Comment: A related resource that is substantially
     * the same as the pre-existing described resource, but in another format.@en
     */
    public static final URI hasFormat = new URIImpl(
	    "http://purl.org/dc/terms/hasFormat", false);

    /**
     * Label: Conforms To@en Comment: An established standard to which the
     * described resource conforms.@en Range: http://purl.org/dc/terms/Standard
     */
    public static final URI conformsTo = new URIImpl(
	    "http://purl.org/dc/terms/conformsTo", false);

    /**
     * Label: Spatial Coverage@en Comment: Spatial characteristics of the
     * resource.@en Range: http://purl.org/dc/terms/Location
     */
    public static final URI spatial = new URIImpl(
	    "http://purl.org/dc/terms/spatial", false);

    /**
     * Label: Temporal Coverage@en Comment: Temporal characteristics of the
     * resource.@en Range: http://purl.org/dc/terms/PeriodOfTime
     */
    public static final URI temporal = new URIImpl(
	    "http://purl.org/dc/terms/temporal", false);

    /**
     * Label: Mediator@en Comment: An entity that mediates access to the
     * resource and for whom the resource is intended or useful.@en Range:
     * http://purl.org/dc/terms/AgentClass
     */
    public static final URI mediator = new URIImpl(
	    "http://purl.org/dc/terms/mediator", false);

    /**
     * Label: Date Accepted@en Comment: Date of acceptance of the resource.@en
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI dateAccepted = new URIImpl(
	    "http://purl.org/dc/terms/dateAccepted", false);

    /**
     * Label: Date Copyrighted@en Comment: Date of copyright.@en Range:
     * http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI dateCopyrighted = new URIImpl(
	    "http://purl.org/dc/terms/dateCopyrighted", false);

    /**
     * Label: Date Submitted@en Comment: Date of submission of the resource.@en
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI dateSubmitted = new URIImpl(
	    "http://purl.org/dc/terms/dateSubmitted", false);

    /**
     * Label: Audience Education Level@en Comment: A class of entity, defined in
     * terms of progression through an educational or training context, for
     * which the described resource is intended.@en Range:
     * http://purl.org/dc/terms/AgentClass
     */
    public static final URI educationLevel = new URIImpl(
	    "http://purl.org/dc/terms/educationLevel", false);

    /**
     * Label: Access Rights@en Comment: Information about who can access the
     * resource or an indication of its security status.@en Range:
     * http://purl.org/dc/terms/RightsStatement
     */
    public static final URI accessRights = new URIImpl(
	    "http://purl.org/dc/terms/accessRights", false);

    /**
     * Label: Bibliographic Citation@en Comment: A bibliographic reference for
     * the resource.@en Comment: http://purl.org/dc/terms/BibliographicResource
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal
     */
    public static final URI bibliographicCitation = new URIImpl(
	    "http://purl.org/dc/terms/bibliographicCitation", false);

    /**
     * Label: License@en Comment: A legal document giving official permission to
     * do something with the resource.@en Range:
     * http://purl.org/dc/terms/LicenseDocument
     */
    public static final URI license = new URIImpl(
	    "http://purl.org/dc/terms/license", false);

    /**
     * Label: Rights Holder@en Comment: A person or organization owning or
     * managing rights over the resource.@en Range:
     * http://purl.org/dc/terms/Agent
     */
    public static final URI rightsHolder = new URIImpl(
	    "http://purl.org/dc/terms/rightsHolder", false);

    /**
     * Label: Provenance@en Comment: A statement of any changes in ownership and
     * custody of the resource since its creation that are significant for its
     * authenticity, integrity, and interpretation.@en Range:
     * http://purl.org/dc/terms/ProvenanceStatement
     */
    public static final URI provenance = new URIImpl(
	    "http://purl.org/dc/terms/provenance", false);

    /**
     * Label: Instructional Method@en Comment: A process, used to engender
     * knowledge, attitudes and skills, that the described resource is designed
     * to support.@en Range: http://purl.org/dc/terms/MethodOfInstruction
     */
    public static final URI instructionalMethod = new URIImpl(
	    "http://purl.org/dc/terms/instructionalMethod", false);

    /**
     * Label: Accrual Method@en Comment: The method by which items are added to
     * a collection.@en Comment: http://purl.org/dc/dcmitype/Collection Range:
     * http://purl.org/dc/terms/MethodOfAccrual
     */
    public static final URI accrualMethod = new URIImpl(
	    "http://purl.org/dc/terms/accrualMethod", false);

    /**
     * Label: Accrual Periodicity@en Comment: The frequency with which items are
     * added to a collection.@en Comment: http://purl.org/dc/dcmitype/Collection
     * Range: http://purl.org/dc/terms/Frequency
     */
    public static final URI accrualPeriodicity = new URIImpl(
	    "http://purl.org/dc/terms/accrualPeriodicity", false);

    /**
     * Label: Accrual Policy@en Comment: The policy governing the addition of
     * items to a collection.@en Comment: http://purl.org/dc/dcmitype/Collection
     * Range: http://purl.org/dc/terms/Policy
     */
    public static final URI accrualPolicy = new URIImpl(
	    "http://purl.org/dc/terms/accrualPolicy", false);

}
