package repository.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//crea/cierra el entity manager factory(singleton) y devuelve las entity managers

public class EntityManagerHelper {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        }
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory(){
        if(emf!=null){
            emf.close();
        }
    }
}
