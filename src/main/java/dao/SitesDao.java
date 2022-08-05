package dao;
import db.sitesDao;
import models.Sites;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//import org.sql2o.Sql2oException;


import java.sql.Connection;
import java.util.List;

public abstract class SitesDao {


    public abstract List<SitesDao> getAll();

    public class Sql2oSitesDao<Sql2o> extends SitesDao {
        private Sql2o sql2o;

        public void Sql2oSitesDaoDao(Sql2o sql2o) {
            this.sql2o = sql2o;
        }


        @Override
        public List<SitesDao> getAll() {
            try (Class<?> con = sql2o.getClass()) {
                return con.createQuery("SELECT * FROM sites")
                        .executeAndFetch(sitesDao.class);
            }
        }


        @Override
        public void add(Sites Sites) {
            String sql = "INSERT INTO sites (name) VALUES (:name)";
            try (Connection con = sql2o.open()) {
                int id = (int) con.createQuery(sql, true)
                        .bind(sites)
                        .executeUpdate()
                        .getKey();
                sites.setId(id);
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
        }


        @Override
        public SitesDao findById(int id) {
            try (Connection con = sql2o.open()) {
                return con.createQuery("SELECT * FROM Sites WHERE id = :id")
                        .addParameter("id", id)
                        .executeAndFetchFirst(SitesDao.class);
            }
        }


    }
}
