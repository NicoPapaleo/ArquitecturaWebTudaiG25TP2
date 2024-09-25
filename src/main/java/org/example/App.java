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

        //creacion de registros
        //City c1 = new City(1,"Tandil");
        //City c2 = new City(2, "Olavarria");
        //City c3 = new City(3, "Azul");
        //CityRepositoryImp poscityReitoryImp=new CityRepositoryImp();
        //cityRepositoryImp.persist(c1);cityRepositoryImp.persist(c2);cityRepositoryImp.persist(c3);

        System.out.println("Hello World!");
        //creacion de registros
/*
        City c1 = new City(1,"Tandil");
        City c2 = new City(2, "Olavarria");
        City c3 = new City(3, "Azul");
        CityRepositoryImp cityRepositoryImp=new CityRepositoryImp();
        cityRepositoryImp.persist(c1);cityRepositoryImp.persist(c2);cityRepositoryImp.persist(c3);


        Student s = new Student(35418649,52,"Francisco","Vazquez",33,'M',c1);
        Student s1 = new Student(4952143,63,"Mauro","Caciato",33,'M',c2);
        Student s2 = new Student(9653211,12,"Nicolas","Papaleo",63,'F',c3);
        Student s3 = new Student(9952143,61,"Emanuel","Arispe",30,'F',c1);
        Student s4 = new Student(42424942,69,"Santiago","Gauna",24,'M',c1);
        Student s5 = new Student(43414943,23,"Martin","Sochi",39,'F',c3);
        Student s6 = new Student(42424244,6,"Mariana","Cuervo",26,'F',c2);
        Student s7 = new Student(42424245,9,"Lucia","Perez",39,'F',c3);

        Career career1 = new Career(1,"TUDAI");
        Career career2 = new Career(2,"TUARI");
        Career career3 = new Career(3,"TUPAR");

        Courses alumnoCursa1=new Courses(s,career2,null,false);
        Courses alumnoCursa2=new Courses(s1,career2,null,false);
        Courses alumnoCursa3=new Courses(s2,career2,null,false);
        Courses alumnoCursa4=new Courses(s3,career1,null,false);
        Courses alumnoCursa5=new Courses(s4,career2,null,false);
        Courses alumnoCursa6=new Courses(s5,career2,null,false);
        Courses alumnoCursa7=new Courses(s6,career1,null,false);
        Courses alumnoCursa8=new Courses(s7,career1,null,false);

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


        //StudentRepositoryImp sr = new StudentRepositoryImp();
        //CareerRepositoryImp careerRepositoryImp = new CareerRepositoryImp();
        //CoursesRepositoryImp coursesRepositoryImp = new CoursesRepositoryImp();

*/


/*
        careerRepositoryImp.persist(career1);careerRepositoryImp.persist(career2);careerRepositoryImp.persist(career3);

        sr.persist(s);sr.persist(s1);sr.persist(s2);sr.persist(s3);sr.persist(s4);sr.persist(s5);sr.persist(s6);sr.persist(s7);

        coursesRepositoryImp.persist(alumnoCursa1);
        coursesRepositoryImp.persist(alumnoCursa2);
        coursesRepositoryImp.persist(alumnoCursa3);
        coursesRepositoryImp.persist(alumnoCursa4);
        coursesRepositoryImp.persist(alumnoCursa5);
        coursesRepositoryImp.persist(alumnoCursa6);
        coursesRepositoryImp.persist(alumnoCursa7);
        coursesRepositoryImp.persist(alumnoCursa8);

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
