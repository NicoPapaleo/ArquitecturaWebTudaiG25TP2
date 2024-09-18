package repository.implementsRepositories;

import entity.Career;
import entity.Student;
import repository.helper.EntityManagerHelper;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CareerRepositoryImp extends BaseJPARepository<Career, Integer> {

    public CareerRepositoryImp() {
        super(Career.class, Integer.class);
    }

    @Override
    public List<Career> findAll() {
        String jpql = "SELECT c FROM Career c";
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Career>ls=new ArrayList<>();
        try{
            Query query = em.createQuery(jpql);
            ls = query.getResultList();
        }catch(Exception e){
            throw new RuntimeException("Error en la consulta"+e);
        }
        finally{
            em.close();
        }
        return ls;
    }
}
