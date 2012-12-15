package sioc;

import java.util.Set;

import org.openrdf.annotations.Iri;

/**
 * A Space is a place where data resides, e.g. on a website, desktop, fileshare,
 * etc.
 */
@Iri( "http://rdfs.org/sioc/ns#Space" )
public interface Space extends Resource {
    /** Points to a Usergroup that has certain access to this Space. */
    @Iri( "http://rdfs.org/sioc/ns#has_usergroup" )
    Set<Usergroup> getSiocHas_usergroups();

    /** Points to a Usergroup that has certain access to this Space. */
    @Iri( "http://rdfs.org/sioc/ns#has_usergroup" )
    void setSiocHas_usergroups( Set<? extends Usergroup> siocHas_usergroups );

    /** A resource which belongs to this data Space. */
    @Iri( "http://rdfs.org/sioc/ns#space_of" )
    Set<Object> getSiocSpace_of();

    /** A resource which belongs to this data Space. */
    @Iri( "http://rdfs.org/sioc/ns#space_of" )
    void setSiocSpace_of( Set<?> siocSpace_of );

}
