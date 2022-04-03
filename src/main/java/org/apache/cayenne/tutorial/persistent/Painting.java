package org.apache.cayenne.tutorial.persistent;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.tutorial.persistent.auto._Painting;

import java.time.LocalDate;
import java.util.Collection;

public class Painting extends _Painting {

    private static final long serialVersionUID = 1L; 

    public void addNewPainting (
            ObjectContext context,
            String namePainting,
            String descriptionPainting,
            String nameArtist,
            String nameArtisticTechniques,
            String nameGallery,
            LocalDate foundedDateGallery
    ) {

        // Add Gallery
        Gallery newGallery = context.newObject(Gallery.class);
        newGallery.setName(nameGallery);
        newGallery.setFoundedDate(foundedDateGallery);

        context.commitChanges();

        // Add Artistic Techniques
        /*Artistictechniques newArtisticTechniques = context.newObject(Az   rtistictechniques.class);
        newArtisticTechniques.setName(nameArtisticTechniques);*/

        // Add Artist
        Artist newArtist = context.newObject(Artist.class);
        newArtist.setName(nameArtist);
        /*newArtist.setArtistictechniques(newArtisticTechniques);*/

        // Add Painting
        Painting newPainting = context.newObject(Painting.class);
        newPainting.setName(namePainting);
        newPainting.setDescription(descriptionPainting);
        newPainting.setArtist(newArtist);
        newPainting.setGallery(newGallery);
    }

    public Collection<Painting> getPaintingsAll (
            ObjectContext context
    ) {

        Collection<Painting> paintings = ObjectSelect.query(Painting.class).select(context);

        return paintings;
    }
}
