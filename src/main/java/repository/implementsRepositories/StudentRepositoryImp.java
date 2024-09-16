package repository.implementsRepositories;

import entity.Student;
import repository.helper.EntityManagerHelper;
import repository.interfacesRepositories.StudentRepository;

import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryImp implements StudentRepository {

    @Override
    public void insert(Student student) throws SQLException {
        EntityManagerHelper.getEntityManager();
    }

    @Override
    public boolean delete(Integer integer) throws SQLException {
        EntityManagerHelper.getEntityManager();
        return false;
    }

    @Override
    public List<Student> selectAll() throws SQLException {
        EntityManagerHelper.getEntityManager();
        return null;// List.of();
    }

    @Override
    public boolean update() throws SQLException {
        EntityManagerHelper.getEntityManager();
        return false;
    }

    @Override
    public Student select(Integer integer) throws SQLException {
        EntityManagerHelper.getEntityManager();
        return null;
    }
}
