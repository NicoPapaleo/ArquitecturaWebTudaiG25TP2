package repository.implementsRepositories;

import entity.Student;
import repository.helper.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentRepositoryImp extends BaseJPARepository<Student, Integer> {

    private static StudentRepositoryImp studentRepositoryImp;

    public StudentRepositoryImp() {
        super(Student.class, Integer.class);
    }

    public static StudentRepositoryImp getInstance() {
        if (studentRepositoryImp == null) {
            studentRepositoryImp = new StudentRepositoryImp();
        }
        return studentRepositoryImp;
    }

    @Override
    public List<Student> findAll() {
        String jpql = "SELECT s FROM Student s";
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createQuery(jpql);
        List<Student> ls = query.getResultList();
        return ls;
    }
}
