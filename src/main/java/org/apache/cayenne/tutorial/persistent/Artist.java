package org.apache.cayenne.tutorial.persistent;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.tutorial.persistent.auto._Artist;

import java.time.LocalDate;

public class Artist extends _Artist {

    private static final long serialVersionUID = 1L;

    public void add (ObjectContext context, String name, LocalDate dateOfBirth) {
        // Add Artist
        Artist newArtist = context.newObject(Artist.class);
        newArtist.setName(name);
        newArtist.setDateOfBirth(dateOfBirth);
    }

    public void relateAll (Artist artist, Artistictechniques artistictechniques) {
        artist.setArtistictechniques(artistictechniques);
    }

}
