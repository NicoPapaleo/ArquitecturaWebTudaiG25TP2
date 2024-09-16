package repository.implementsRepositories;

import entity.Career;
import repository.helper.EntityManagerHelper;

import java.sql.SQLException;
import java.util.List;

public class CareerRepositoryImp implements CrudRepository<Career, Integer> {

    @Override
    public void insert(Career career) throws SQLException {
        EntityManagerHelper.getEntityManager();
    }

    @Override
    public boolean delete(Integer integer) throws SQLException {
        EntityManagerHelper.getEntityManager();
        return false;
    }

    @Override
    public List<Career> selectAll() throws SQLException {
        EntityManagerHelper.getEntityManager();
        return null;//List.of();
    }

    @Override
    public boolean update() throws SQLException {
        EntityManagerHelper.getEntityManager();
        return false;
    }

    @Override
    public Career select(Integer integer) throws SQLException {
        return null;
    }
}
