import dao.DB;
import jdk.internal.jimage.BasicImageReader;
import models.Person;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

public class App {
        private String name;
        private String description;
        private int id;

    public App(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO communities (name, description) VALUES (:name, :description)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("description", this.description)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<App> all() {
        String sql = "SELECT * FROM communities";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(App.class);
        }
    }
    public int getId() {
        return id;
    }
    public void addPerson(Person person) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO communities_persons (community_id, person_id) VALUES (:community_id, :person_id)";
            con.createQuery(sql)
                    .addParameter("community_id", this.getId())
                    .addParameter("person_id", person.getId())
                    .executeUpdate();
        }
    }

//    public List<Object> getPersons() {
//        return null;
//
//    }
    public List<Person> getPersons() {
        try(Connection con = (Connection) DB.sql2o.open()){
            String joinQuery = "SELECT person_id FROM communities_persons WHERE community_id = :community_id";
            List<Integer> personIds = con.createQuery(joinQuery)
                    .addParameter("community_id", this.getId())
                    .executeAndFetch(Integer.class);

            List<Person> persons = new ArrayList<Person>();

            for (Integer personId : personIds) {
                String personQuery = "SELECT * FROM persons WHERE id = :personId";
                Person person = con.createQuery(personQuery)
                        .addParameter("personId", personId)
                        .executeAndFetchFirst(Person.class);
                persons.add(person);
            }
            return persons;
        }
    }
}



