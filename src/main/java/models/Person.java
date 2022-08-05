package models;

import java.sql.Connection;
import java.util.List;

public class Person {

    public Person(String henry, String s) {

    }

    public void save() {


    }

    public List getApp() {
        return null;
    }

    public List<engineers> getengineers() {
        try(Connection con = DB.sql2o.open()){
            String joinQuery = "SELECT engineers_id FROM engineers_persons WHERE person_id = :person_id";
            List<Integer> engineersIds = con.createQuery(joinQuery)
                    .addParameter("person_id", this.getId())
                    .executeAndFetch(Integer.class);

            List<engineers> engineers = new ArrayList<engineers>();

            for (Integer engineersId : engineersIds) {
                String engineersQuery = "SELECT * FROM engineers WHERE id = :engineersId";
                engineers engineers = con.createQuery(engineersQuery)
                        .addParameter("engineersId", engineersId)
                        .executeAndFetchFirst(engineers.class);
                engineers.add(engineers);
            }
            return engineers;
        }
    }

    public Object getId() {
        return null;
    }
}
