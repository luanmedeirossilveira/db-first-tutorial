package org.apache.cayenne.tutorial;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.datasource.DataSourceBuilder;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.tutorial.persistent.Artist;

import java.time.LocalDate;
import java.util.Collection;
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


        /* Collection<Artist> artists = ObjectSelect.query(Artist.class)
                .select(context);
        context.deleteObjects(artists); */
        context.commitChanges();
    }
}