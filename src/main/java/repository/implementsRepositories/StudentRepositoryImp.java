package repository.implementsRepositories;

import dto.StudentDTO;
import entity.Student;
import repository.helper.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

//Clase singleton

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
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Student>ls=new ArrayList<>();
        try{
            Query query = em.createNamedQuery(Student.BUSCAR_TODOS);
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
        try {
            Query query = em.createNamedQuery(Student.BUSCAR_TODOS_ORDENADOS, StudentDTO.class);
            studentDTOlist = query.getResultList();
        }catch(Exception e){
            System.out.print("error"+e);
        }finally{
        em.close();
        }
        return studentDTOlist;
    }

    public List<StudentDTO> findStudentsByGender(char gender) {
        EntityManager em = EntityManagerHelper.getEntityManager();

        List<StudentDTO>ls=new ArrayList<>();
        try{
            Query query = em.createNamedQuery(Student.BUSCAR_POR_GENERO);
            query.setParameter("gender", gender);
            ls = query.getResultList();
        } catch(Exception e){
            throw new RuntimeException("Error en la consulta"+e);
        } finally {
            em.close();
        }
        return ls;
    }

    public StudentDTO studentByRecord(int idLibreta){
        EntityManager em = EntityManagerHelper.getEntityManager();
        Student result = null;
        try {
            result = (Student) em.createNamedQuery(Student.BUSCAR_POR_LIBRETA)
                                         .setParameter("libreta", idLibreta).getSingleResult();
        } catch (NoResultException e){
            System.out.println("No existe la libreta ingresada");
            return null;
        } finally{
            em.close();
        }
        return new StudentDTO(result.getDni(),result.getIdLibreta(),result.getName(),
                              result.getLastName(),result.getGender(),result.getCity().getName(),result.getYears());
    }

    public List<StudentDTO> getStudentsByCareerFilterByCity(String careerName ,String cityName){
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Student>listResult = new ArrayList<>();
        List<StudentDTO>studentDTOlist=new ArrayList<>();
        try{
            listResult=(List<Student>) em.createNamedQuery(Student.BUSCAR_POR_CARRERA)
                                         .setParameter("careerName",careerName)
                                         .setParameter("cityName",cityName)
                                         .getResultList();
        }catch (NoResultException e){
            System.out.println("No existen en la ciudad ingresada");
        }
        finally{
            em.close();
        }
       listResult.forEach(s -> { studentDTOlist.add(new StudentDTO(s.getDni(),s.getIdLibreta(),s.getName(),
                                                                   s.getLastName(),s.getGender(),s.getCity().getName(),
                                                                   s.getYears()));});
        return studentDTOlist;
    }

}

