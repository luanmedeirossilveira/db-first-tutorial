package org.apache.cayenne.tutorial.persistent;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.tutorial.persistent.auto._Artistictechniques;

import java.util.List;

public class Artistictechniques extends _Artistictechniques {

    private static final long serialVersionUID = 1L;

    public void add (ObjectContext context, String name) {
        // Add Artistic Techniques
        Artistictechniques newArtisticTechniques = context.newObject(Artistictechniques.class);
        newArtisticTechniques.setName(name);
    }

    public void getAll(ObjectContext context) {
        List<Artistictechniques> artisticTechniques = ObjectSelect.query(Artistictechniques.class).select(context);

        for (int i = 0; i < artisticTechniques.size(); i++) {
            Artistictechniques at1 = artisticTechniques.get(i);
            System.out.println("Nome da Técnica Artística: " + at1.getName());
        }
    }

    public void getListByName(ObjectContext context, String name) {
        List<Artistictechniques> at1 = ObjectSelect
                .query(Artistictechniques.class)
                .where(Artistictechniques.NAME.like(name + "%"))
                .select(context);

        for (int i = 0; i < at1.size(); i++) {
            Artistictechniques atLocal = at1.get(i);
            System.out.println("[" + i + "] Nome da técnica artística: " + atLocal.getName());
        }
    }

}
