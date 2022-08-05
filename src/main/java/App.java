import dao.DB;
//import jdk.internal.jimage.BasicImageReader;
import models.Person;
//import org.sql2o.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import static dao.DB.*;
import static dao.DB.sql2o;

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
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO engineers (name, description) VALUES (:name, :description)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("description", this.description)
                    .executeUpdate()
                    .getKey();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<App> all() {
        String sql = "SELECT * FROM engineers";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(App.class);
        }
    }
    public int getId() {
        return id;
    }
    public void addPerson(Person person) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO engineers_persons (engineers_id, person_id) VALUES (:engineers_id, :person_id)";
            con.createQuery(sql)
                    .addParameter("engineers_id", this.getId())
                    .addParameter("person_id", person.getId())
                    .executeUpdate();
        }
    }

    public List<Object> getPersons() {
        return null;

    }

    public void delete() {
        try(Connection con = sql2o.open()) {
            String sql = "DELETE FROM engineers WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
}



