package repository.implementsRepositories;

import repository.interfaceRepository.RepositoryFactory;

//Factory JPA devuelve la unica instancia de cada implementacion de repositorios utilizados

public class JPARepositoryFactory implements RepositoryFactory {

    @Override
    public CareerRepositoryImp getCareerRepository() {
        return CareerRepositoryImp.getInstance();
    }

    @Override
    public CityRepositoryImp getCityRepository() {
        return CityRepositoryImp.getInstance();
    }

    @Override
    public CoursesRepositoryImp getCoursesRepository() {
        return CoursesRepositoryImp.getInstance();
    }

    @Override
    public StudentRepositoryImp getStudentRepository() {
        return StudentRepositoryImp.getInstance();
    }
}
