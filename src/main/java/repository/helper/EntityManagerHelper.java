package repository.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
    private static EntityManager entityManager;
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if(entityManager == null){
            emf = Persistence.createEntityManagerFactory("my_persistence_unit");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public static void closeEntityManagerFactory(){
        if(entityManager!= null){
            emf.close();
        }
    }
}
