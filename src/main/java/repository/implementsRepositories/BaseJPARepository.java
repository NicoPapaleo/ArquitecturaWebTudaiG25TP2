package repository.implementsRepositories;

import repository.helper.EntityManagerHelper;
import repository.interfaceRepository.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class BaseJPARepository<Entity,ID extends Serializable> implements Repository<Entity, ID> {
    private EntityManager em;
    private Class<Entity>entityClass;
    //private Class<ID>idClass;

    public BaseJPARepository(Class<Entity>entityClass, Class<ID> idClass){
        this.entityClass=entityClass;
        //this.idClass=idClass;
    }

    @Override
    public Entity findById(ID id) {
         em = EntityManagerHelper.getEntityManager();
         Entity entity = em.find(entityClass,id);
         return entity;
    }

    @Override
    public void persist(Entity entity) {
        em=EntityManagerHelper.getEntityManager();
        try{
            em.persist(entity);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        EntityManagerHelper.getEntityManager().close();
    }

    @Override
    public void delete(Entity entity) {
        em=EntityManagerHelper.getEntityManager();
        try{
            em.remove(entity);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public abstract List<Entity> findAll();

}
