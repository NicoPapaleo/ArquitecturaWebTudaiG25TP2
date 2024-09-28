package repository.implementsRepositories;

import repository.interfaceRepository.RepositoryFactory;

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
