package org.example;


import dto.ReportCareerDTO;
import dto.CareerDTO;
import dto.StudentDTO;
import entity.Career;
import entity.City;
import entity.Courses;
import entity.Student;
import repository.helper.EntityManagerHelper;
import repository.implementsRepositories.*;
import repository.interfaceRepository.RepositoryFactory;
import setup.InitializeJPA;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        //creacion de factory JPA y repositorios de las entidades.
        RepositoryFactory repositoryFactoryJPA = new JPARepositoryFactory();
        StudentRepositoryImp studentRepository = repositoryFactoryJPA.getStudentRepository();
        CityRepositoryImp cityRepository = repositoryFactoryJPA.getCityRepository();
        CareerRepositoryImp careerRepository = repositoryFactoryJPA.getCareerRepository();
        CoursesRepositoryImp coursesRepository = repositoryFactoryJPA.getCoursesRepository();

        InitializeJPA.loadDataBase();

        /* VER SI CORRESPONDE HACER ESTO

        s.addCourses(alumnoCursa1);
        s1.addCourses(alumnoCursa2);
        s2.addCourses(alumnoCursa3);
        s3.addCourses(alumnoCursa4);
        s4.addCourses(alumnoCursa5);
        s5.addCourses(alumnoCursa6);
        s6.addCourses(alumnoCursa7);
        s7.addCourses(alumnoCursa8);

        career2.addCourses(alumnoCursa1);
        career1.addCourses(alumnoCursa4);
        career1.addCourses(alumnoCursa7);
        career2.addCourses(alumnoCursa2);
        career2.addCourses(alumnoCursa5);
        career2.addCourses(alumnoCursa3);
        career2.addCourses(alumnoCursa6);
        career1.addCourses(alumnoCursa7);

        */

        List<StudentDTO>studentsOrderedByLastName = studentRepository.findAllStudentsOrderedByLastName();
        System.out.println("lista ordenada por alfabeto");
        studentsOrderedByLastName.forEach(studentDTO -> System.out.println(studentDTO.toString()));

        StudentDTO studentByRecord =studentRepository.studentByRecord(12);
        System.out.println("Estudiante con libreta numero 12");
        System.out.println(studentByRecord.toString());

        List<StudentDTO>studentsFilterByGender = studentRepository.findStudentsByGender('M');
        System.out.println("lista filtrada por genero");
        studentsFilterByGender.forEach(studentDTO -> System.out.println(studentDTO.toString()));



        //b)matricular un estudiante a una carrera
        //coursesRepositoryImp.enrollStudent(s,career1);

        List<StudentDTO>studentsFilterByCity = studentRepository.getStudentsByCareerFilterByCity("TUDAI","Tandil");
        System.out.println("lista filtrada por ciudad y carrera");
        studentsFilterByCity.forEach(studentDTO -> System.out.println(studentDTO.toString()));


        System.out.println("ejercicio numero 3");//acomodar
        List<ReportCareerDTO> reportCareerDTO = careerRepository.generateCareerReport();
        reportCareerDTO.forEach(reportCareer->System.out.println(reportCareer.toString()));

        List<CareerDTO> careerFilterByEnrolledStudent = careerRepository.findByEnrolledStudentsOrderedByCant();
        System.out.println("lista de carrera por estudiantes ingresados");
        for(CareerDTO cd : careerFilterByEnrolledStudent){
            System.out.println(cd.toString());
        }


        EntityManagerHelper.closeEntityManagerFactory();

    }
}
