package repository.implementsRepositories;

import dto.CareerDTO;
import dto.ReportCareerDTO;
import entity.Career;
import entity.Student;
import repository.helper.EntityManagerHelper;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CareerRepositoryImp extends BaseJPARepository<Career, Integer> {
    
    private static CareerRepositoryImp carrerRepositoryImp;

    public CareerRepositoryImp() {
        super(Career.class, Integer.class);
    }

    public static CareerRepositoryImp getInstance(){
        if(carrerRepositoryImp==null){
            return new CareerRepositoryImp();
        }
        return carrerRepositoryImp;
    }

    @Override
    public List<Career> findAll() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<Career>ls=new ArrayList<>();
        try{
            Query query = em.createQuery(Career.BUSCAR_TODAS);
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
     * @brief busca las carreras con estudiantes inscriptos ordenados por cantidad
     * @return retorna una lista de carreras ordenada por cantidad
     */
    /*public List<CareerDTO> findByEnrolledStudentsOrderedByCant() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<CareerDTO> lc =new ArrayList<>();
        try {
            Query query = em.createNamedQuery(Career.BUSCAR_ESTUDIANTES_ORDENADOS, CareerDTO.class);
            lc = query.getResultList();
        }
        catch(Exception e){
            throw new RuntimeException("Error en la consulta"+e);
        }
        finally{
            em.close();
        }
        return lc;
    }*/


    public List<ReportCareerDTO> generateCareerReport() {

        EntityManager em = EntityManagerHelper.getEntityManager();
        List<ReportCareerDTO> report = new ArrayList<>();

        try {
            TypedQuery<ReportCareerDTO>query = em.createNamedQuery(Career.GENERAR_REPORTE, ReportCareerDTO.class);
            report=query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return report;
    }

}