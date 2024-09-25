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
    private static CoursesRepositoryImp coursesRepositoryImp;
    public CoursesRepositoryImp() {
        super(Courses.class, Integer.class);
    }

    public static CoursesRepositoryImp getInstance(){
        if(coursesRepositoryImp==null){
            return new CoursesRepositoryImp();
        }
        return coursesRepositoryImp;
    }

    @Override
    public List<Courses> findAll() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Courses>ls = new ArrayList<>();
        try{
            Query query = em.createQuery(Courses.BUSCAR_TODO);
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
        int count = (int) em.createQuery(Student.EXIST_STUDENT).setParameter("id",s.getDni()).getSingleResult();
        em.close();
        return count>0;
    }

    private boolean existCareer(Career c) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        int count = (int) em.createQuery(Career.EXIST_CAREER).setParameter("idCareer", c.getId()).getSingleResult();
        em.close();
        return count>0;
    }
}
