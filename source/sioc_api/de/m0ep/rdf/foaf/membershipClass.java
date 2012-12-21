package de.m0ep.rdf.foaf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openrdf.annotations.Iri;

import de.m0ep.rdf.vs.term_status;

/** Indicates the class of individuals that are a member of a Group */
@Retention( RetentionPolicy.RUNTIME )
@Target( { ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE, ElementType.PACKAGE } )
public @interface membershipClass {
    @term_status( { "unstable" } )
    @Iri( "http://xmlns.com/foaf/0.1/membershipClass" )
    String[] value();

}
