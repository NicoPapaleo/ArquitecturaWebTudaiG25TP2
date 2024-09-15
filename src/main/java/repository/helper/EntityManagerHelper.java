package repository.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if(entityManager == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
}
