package org.apache.cayenne.tutorial.persistent;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.tutorial.persistent.auto._Gallery;

import java.time.LocalDate;

public class Gallery extends _Gallery {

    private static final long serialVersionUID = 1L; 

    public void add (ObjectContext context, String name, LocalDate foundedDate) {
        // Add Gallery
        Gallery newGallery = context.newObject(Gallery.class);
        newGallery.setName(name);
        newGallery.setFoundedDate(foundedDate);
    }
}
