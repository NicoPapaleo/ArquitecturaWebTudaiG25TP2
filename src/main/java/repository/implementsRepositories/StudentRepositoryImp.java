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

    public List<StudentDTO> findAllStudentsOrderedByLastName() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<StudentDTO>studentDTOlist=new ArrayList<>();
        String jpql = "SELECT new dto.StudentDTO(s.name,s.lastName,s.years,s.gender,s.city.name) FROM Student s ORDER BY s.lastName";
        try {
            Query query = em.createQuery(jpql, StudentDTO.class);
            studentDTOlist = query.getResultList();
        }catch(Exception e){
            System.out.print("error"+e);
        }finally{
        em.close();
        }
        return studentDTOlist;
    }


}
