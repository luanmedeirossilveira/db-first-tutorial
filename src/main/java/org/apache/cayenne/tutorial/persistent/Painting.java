package org.apache.cayenne.tutorial.persistent;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.tutorial.persistent.auto._Painting;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class Painting extends _Painting {

    private static final long serialVersionUID = 1L; 

    public void add (
            ObjectContext context,
            String name,
            String description
    ) {

        // Add Painting
        Painting newPainting = context.newObject(Painting.class);
        newPainting.setName(name);
        newPainting.setDescription(description);
    }

    public void relateAll(
        Painting painting,
        Artist artist,
        Gallery gallery
    ) {
        painting.setArtist(artist);
        painting.setGallery(gallery);
    }

    public void getAll (
            ObjectContext context
    ) {
        List<Painting> paintings = ObjectSelect.query(Painting.class).select(context);

        for (int i = 0; i < paintings.size(); i++) {
            Painting p1 = paintings.get(i);
            System.out.println("Nome da pintura: " + p1.getName());
            System.out.println("Descrição da pintura: " + p1.getDescription());
            System.out.println("Nome do artista: " + p1.getArtist().getName());
            System.out.println("Nome da galeria: " + p1.getGallery().getName());
            System.out.println("Data da fundação da galeria: " + p1.getGallery().getFoundedDate().toString());
        }
    }

    public void getByName(
            ObjectContext context,
            String name
    ) {
        Painting p1 = ObjectSelect
                        .query(Painting.class)
                        .where(Painting.NAME.like(name + "%"))
                        .selectOne(context);

        System.out.println("Nome da pintura: " + p1.getName());
        System.out.println("Descrição da pintura: " + p1.getDescription());
        System.out.println("Nome do artista: " + p1.getArtist().getName());
        System.out.println("Nome da galeria: " + p1.getGallery().getName());
        System.out.println("Data da fundação da galeria: " + p1.getGallery().getFoundedDate().toString());
    }
}
