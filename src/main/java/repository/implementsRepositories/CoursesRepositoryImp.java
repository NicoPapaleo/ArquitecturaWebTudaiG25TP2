package repository.implementsRepositories;

import entity.Courses;
import repository.helper.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CoursesRepositoryImp extends BaseJPARepository<Courses, Integer> {

    public CoursesRepositoryImp(Class<Courses> coursesClass, Class<Integer> integerClass) {
        super(coursesClass, integerClass);
    }

    @Override
    public List<Courses> findAll() {
        String jpql = "SELECT c FROM Courses c";
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createQuery(jpql);
        List<Courses> lc = query.getResultList();
        return lc;
    }
}
