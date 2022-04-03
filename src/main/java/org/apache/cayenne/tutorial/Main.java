package org.apache.cayenne.tutorial;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.datasource.DataSourceBuilder;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.tutorial.persistent.Artist;
import org.apache.cayenne.tutorial.persistent.Artistictechniques;
import org.apache.cayenne.tutorial.persistent.Gallery;
import org.apache.cayenne.tutorial.persistent.Painting;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ServerRuntime cayenneRuntime = ServerRuntime.builder()
                .dataSource(DataSourceBuilder
                        .url("jdbc:mysql://127.0.0.1:3306/cayenne_demo?useSSL=false&useTimezone=true&serverTimezone=UTC")
                        .driver("com.mysql.cj.jdbc.Driver")
                        .userName("root") // TODO: change to your actual username and password
                        .password("123456").build())
                .addConfig("cayenne/cayenne-project.xml")
                .build();
        ObjectContext context = cayenneRuntime.newContext();

        // Pinturas
        Painting abaporu = context.newObject(Painting.class);

        abaporu.addNewPainting(
            context,
            "Abaporu",
            "Abaporu é uma pintura a óleo da artista brasileira Tarsila do Amaral." +
            "É uma das principais obras do período antropofágico do movimento modernista no Brasil.[1]\n" +
            "É a tela brasileira mais valorizada no mercado mundial das artes, com valor estimado de US$ 40 milhões," +
            " sendo comprada pelo colecionador argentino Eduardo Costantini por US$ 2,5 milhões, em 1995, " +
            "em um leilão realizado na Christies. Criador do Museu de arte latino-americana de " +
            "Buenos Aires (MALBA), Costantini doou sua coleção para o museu, incluindo a Abaporu." +
            " Anteriormente a obra pertencia ao empresário brasileiro Raul Forbes, numa aquisição ocorrida em 1985.",
            "Tarsila do Amaral",
            "Óleo sobre Tela",
            "MALBA",
            LocalDate.parse("2001-09-20")
        );



        List<Painting> paintings = ObjectSelect.query(Painting.class).select(context);

        for (int i = 0; i < paintings.size(); i++) {
            Painting p1 = paintings.get(i);
            System.out.println("Nome da pintura: " + p1.getName());
            System.out.println("Descrição da pintura: " + p1.getDescription());
            System.out.println("Nome do artista: " + p1.getArtist().getName());
        }

        context.commitChanges();
    }
}