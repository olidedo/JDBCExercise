package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

public class Database {
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public EntityManager getConnection(){
        emf = Persistence.createEntityManagerFactory("persistence");
        entityManager = emf.createEntityManager();
        return entityManager;
    }

}
