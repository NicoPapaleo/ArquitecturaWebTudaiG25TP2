package repository.implementsRepositories;

import entity.City;
import entity.Student;
import repository.helper.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CityRepositoryImp extends BaseJPARepository<City, Integer> {

    private static CityRepositoryImp cityRepository;

    public CityRepositoryImp() {
        super(City.class, Integer.class);
    }

    public static CityRepositoryImp getInstance() {
        if (cityRepository == null) {
            cityRepository = new CityRepositoryImp();
        }
        return cityRepository;
    }

    @Override
    public List<City> findAll() {
        String jpql = "SELECT c FROM City c";
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<City>ls=new ArrayList<>();
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
}
