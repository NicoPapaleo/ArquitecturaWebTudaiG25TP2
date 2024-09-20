package repository.implementsRepositories;

import entity.Career;
import entity.Courses;
import entity.Student;
import repository.helper.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.SQLException;
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


    public void enrollStudent(Student e1, Career c1){
        if(existStudent(e1) && existCareer(c1)){
            Courses newCourses = new Courses(e1,c1,null,false);
            this.persist(newCourses);
        }else{
            System.out.println("Estudiante o Carrera inexistente");
        }
    }

    private boolean existStudent(Student s){
        EntityManager em = EntityManagerHelper.getEntityManager();
        String jpql = "SELECT count(s) FROM Student s WHERE s.dni = :id";
        int count = (int) em.createQuery(jpql).setParameter("id",s.getDni()).getSingleResult();
        return count>0;
    }

    private boolean existCareer(Career c) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        String jpql = "SELECT count(c) FROM Career c WHERE c.idCareer = :idCareer";
        int count = (int) em.createQuery(jpql).setParameter("idCareer", c.getId()).getSingleResult();
        return count>0;
    }
}
