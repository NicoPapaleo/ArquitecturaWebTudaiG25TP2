package repository.implementsRepositories;

import entity.City;
import repository.helper.EntityManagerHelper;
import repository.interfacesRepositories.CityRepository;

import java.sql.SQLException;
import java.util.List;

public class CityRepositoryImp implements CityRepository {

    @Override
    public void insert(City city) throws SQLException {
        EntityManagerHelper.getEntityManager();
    }

    @Override
    public boolean delete(Integer integer) throws SQLException {
        EntityManagerHelper.getEntityManager();
        return false;
    }

    @Override
    public List<City> selectAll() throws SQLException {
        EntityManagerHelper.getEntityManager();
        return List.of();
    }

    @Override
    public boolean update() throws SQLException {
        EntityManagerHelper.getEntityManager();
        return false;
    }

    @Override
    public City select(Integer integer) throws SQLException {
        EntityManagerHelper.getEntityManager();
        return null;
    }
}
