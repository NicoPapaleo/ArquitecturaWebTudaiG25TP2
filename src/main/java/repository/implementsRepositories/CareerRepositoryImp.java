package repository.implementsRepositories;

import entity.Career;
import repository.helper.EntityManagerHelper;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CareerRepositoryImp extends BaseJPARepository<Career, Integer> {

    public CareerRepositoryImp(Class<Career> careerClass, Class<Integer> integerClass) {
        super(careerClass, integerClass);
    }

    @Override
    public List<Career> findAll() {
        String jpql = "SELECT c FROM Career c";
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createQuery(jpql);
        List<Career> lc = query.getResultList();
        return lc;
    }
}
