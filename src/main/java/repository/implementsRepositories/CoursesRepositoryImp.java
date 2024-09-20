package repository.implementsRepositories;

import entity.Career;
import entity.Courses;
import entity.Student;
import repository.helper.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CoursesRepositoryImp extends BaseJPARepository<Courses, Integer> {

    public CoursesRepositoryImp() {
        super(Courses.class, Integer.class);
    }

    @Override
    public List<Courses> findAll() {
        String jpql = "SELECT c FROM Courses c";
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Courses>ls = new ArrayList<>();
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

    public void persistCourses(Student e1, Career c1){
        String jpql1 = "SELECT s FROM Student s WHERE s.dni = :id";
        String jpql2 = "SELECT c FROM Career c WHERE c.idCareer = :idCareer";
        EntityManager em = EntityManagerHelper.getEntityManager();
        Student student = (Student) em.createQuery(jpql1).setParameter("id",e1.getDni());
        Career career = (Career) em.createQuery(jpql2).setParameter("idCareer", c1.getId());
        if(student != null && career != null){
            Courses newCourses = new Courses(e1,c1,null,false);
            this.persist(newCourses);
        }else{
            System.out.println("Estudiante o carrera inexistente");
        }

    }

}
