package repository.interfaceRepository;

import java.io.Serializable;
import java.util.List;

public interface Repository<Entity, ID extends Serializable> {

    public Entity findById(ID id);
    public void persist(Entity entity);
    public void delete(Entity entity);
    public List<Entity> findAll();

}
