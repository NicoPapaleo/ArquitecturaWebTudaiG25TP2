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

    }

    @Override
    public Entity findById(ID id) {
        Entity entity=null;
        em = EntityManagerHelper.getEntityManager();
        try{
            entity=em.find(entityClass,id);
        }
        catch(Exception e){
            throw new RuntimeException("Error al buscar el id "+id+e);
        }
        finally{
            em.close();
        }
        return entity;
    }

    @Override
    public void persist(Entity entity) {
        em = EntityManagerHelper.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }catch (Exception e) {
            throw new RuntimeException("Error al insertar "+entity.toString()+e);
        }finally {
            em.close();
        }
    }

    @Override
    public void delete(Entity entity) {
        em = EntityManagerHelper.getEntityManager();
        if (!em.contains(entity)) {
            entity = em.merge(entity);  // Reanexar la entidad si está detach
        }
        try{
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new RuntimeException("No se puede eliminar "+entity.toString()+e);
        }
        finally {
            em.close();
        }
    }

    @Override
    public abstract List<Entity> findAll();


}
