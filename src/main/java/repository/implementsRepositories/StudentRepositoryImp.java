package repository.implementsRepositories;

import entity.Student;
import repository.helper.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    /**
     * @Brief Solicitar lista de todos los estudiantes.
     * @return Lista de estudiantes de tipo List.
     */
    @Override
    public List<Student> findAll() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Student>ls=new ArrayList<>();
        try{
            Query query = em.createQuery(Student.BUSCAR_TODOS);
            ls = query.getResultList();
        }catch(Exception e){
            throw new RuntimeException("Error en la consulta"+e);
        }
        finally{
            em.close();
        }
        return ls;
    }

    /**
     * @brief d) recuperar un estudiante, en base a su número de libreta universitaria.
     * @param idLibreta Numero de libreta del estudiante a solicitar.
     * @return Retorna un DTO de Estudiante.
     */
    public StudentDTO studentByRecord(int idLibreta){
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            Student result = (Student) em.createQuery(Student.BUSCAR_POR_LIBRETA).getSingleResult();
        } catch (NoResultException e){
            System.out.println("No existe la libreta ingresada");
            return null;
        }
        return new StudentDTO();
    }

}
