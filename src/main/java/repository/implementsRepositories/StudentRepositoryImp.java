package repository.implementsRepositories;

import dto.StudentDTO;
import entity.Student;
import repository.helper.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
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
        List<Student>ls=new ArrayList<>();
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

    public List<StudentDTO> findStudentsByGender(char gender) {
        String jpql = "SELECT new dto.StudentDTO(s.dni, s.idLibreta, s.name, s.lastName, s.gender, s.city.name, s.years) " +
                        "FROM Student s WHERE s.gender = :gender";
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<StudentDTO>ls=new ArrayList<>();
        try{
            Query query = em.createQuery(jpql);
            query.setParameter("gender", gender);
            ls = query.getResultList();
        } catch(Exception e){
            throw new RuntimeException("Error en la consulta"+e);
        } finally {
            em.close();
        }
        return ls;
    }


}
