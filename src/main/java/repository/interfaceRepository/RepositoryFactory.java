package repository.interfaceRepository;

import repository.implementsRepositories.CareerRepositoryImp;
import repository.implementsRepositories.CityRepositoryImp;
import repository.implementsRepositories.CoursesRepositoryImp;
import repository.implementsRepositories.StudentRepositoryImp;

//devuelve las implementaciones de los repositorios

public interface RepositoryFactory {

    public CareerRepositoryImp getCareerRepository();
    public CityRepositoryImp getCityRepository();
    public CoursesRepositoryImp getCoursesRepository();
    public StudentRepositoryImp getStudentRepository();

}
