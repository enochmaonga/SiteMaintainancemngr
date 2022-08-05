package models;

import java.util.List;

public class Person {

    public Person(String henry, String s) {

    }

    public void save() {


    }

    public List getApp() {
        return null;
    }

    public List<Community> getCommunities() {
        try(Connection con = DB.sql2o.open()){
            String joinQuery = "SELECT community_id FROM communities_persons WHERE person_id = :person_id";
            List<Integer> communityIds = con.createQuery(joinQuery)
                    .addParameter("person_id", this.getId())
                    .executeAndFetch(Integer.class);

            List<Community> communities = new ArrayList<Community>();

            for (Integer communityId : communityIds) {
                String communityQuery = "SELECT * FROM communities WHERE id = :communityId";
                Community community = con.createQuery(communityQuery)
                        .addParameter("communityId", communityId)
                        .executeAndFetchFirst(Community.class);
                communities.add(community);
            }
            return communities;
        }
    }
}
