package org.example;


import entity.Career;
import entity.City;
import entity.Courses;
import entity.Student;
import repository.helper.EntityManagerHelper;
import repository.implementsRepositories.*;
import repository.interfaceRepository.RepositoryFactory;
import setup.InitializeJPA;

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

        InitializeJPA in = new InitializeJPA(repositoryFactoryJPA);

        // Cargar y llenar base de datos
        //InitializeJPA.loadDataBase();

        // a) Dar de alta un nuevo estudiante
        //City cityStudent = cityRepository.findById(2);
        //Student newStudent = new Student(18529742,52,"juan","Foschino",45,'M',cityStudent);
        //InitializeJPA.addStudent(newStudent);

        // b) Matricular un estudiante nuevo a una carrera
        //Career career = careerRepository.findById(3);
        //InitializeJPA.enrollStudent(newStudent,career);

        // b) Matricular un estudiante a una carrera ya existente
        //Student existentStudent = studentRepository.findById(9653211);
        //coursesRepository.enrollStudent(existentStudent,career);

        // c) Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
        InitializeJPA.studentsOrderedByLastName();

        // d) Recuperar un estudiante, en base a su número de libreta universitaria
        InitializeJPA.studentByRecord(5);

        // e) Recuperar todos los estudiantes, en base a su género
        InitializeJPA.studentsFilterByGender('F');

        // f) Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        InitializeJPA.careerFilterByEnrolledStudent();

        // g) Gecuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
        InitializeJPA.studentsFilterByCity("Tudai","Azul");

        // Generar un reporte de las carreras, que para cada carrera incluya información de los
        //inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        //los años de manera cronológica.
        InitializeJPA.enunciado3();

        EntityManagerHelper.closeEntityManagerFactory();

    }
}
