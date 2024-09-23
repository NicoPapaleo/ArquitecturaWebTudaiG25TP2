package org.example;

import dto.StudentDTO;
import entity.Career;
import entity.City;
import entity.Courses;
import entity.Student;
import repository.helper.EntityManagerHelper;
import repository.implementsRepositories.CareerRepositoryImp;
import repository.implementsRepositories.CityRepositoryImp;
import repository.implementsRepositories.CoursesRepositoryImp;
import repository.implementsRepositories.StudentRepositoryImp;

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
        //System.out.println("Hello World!");
        //creacion de registros
        //City c1 = new City(1,"Tandil");
        //City c2 = new City(2, "Olavarria");
        //City c3 = new City(3, "Azul");
        CityRepositoryImp cityRepositoryImp=new CityRepositoryImp();
        //cityRepositoryImp.persist(c1);cityRepositoryImp.persist(c2);cityRepositoryImp.persist(c3);

        //Student s = new Student(35418649,52,"Francisco","Vazquez",33,'M',c1);
        //Student s1 = new Student(4952143,63,"Mauro","Caciato",33,'M',c2);
        //Student s2 = new Student(9653211,12,"Nicolas","Papaleo",63,'F',c3);
        //Student s3 = new Student(9952143,61,"Emanuel","Arispe",30,'F',c1);
        //Student s4 = new Student(42424942,69,"Santiago","Gauna",24,'M',c1);
        //Student s5 = new Student(43414943,23,"Martin","Sochi",39,'F',c3);
        //Student s6 = new Student(42424244,6,"Mariana","Cuervo",26,'F',c2);
        //Student s7 = new Student(42424245,9,"Lucia","Perez",39,'F',c3);

        //Career career1 = new Career(1,"TUDAI");
        //Career career2 = new Career(2,"TUARI");
        //Career career3 = new Career(3,"TUPAR");

        //Courses alumnoCursa1=new Courses(s,career1,null,false);
        //Courses alumnoCursa2=new Courses(s1,career2,null,false);
        //Courses alumnoCursa3=new Courses(s2,career3,null,false);
        //Courses alumnoCursa4=new Courses(s3,career1,null,false);
        //Courses alumnoCursa5=new Courses(s4,career2,null,false);
        //Courses alumnoCursa6=new Courses(s5,career3,null,false);
        //Courses alumnoCursa7=new Courses(s6,career1,null,false);
        //Courses alumnoCursa8=new Courses(s7,career1,null,false);

        //s.addCourses(alumnoCursa1);
        //s1.addCourses(alumnoCursa2);
        //s2.addCourses(alumnoCursa3);
        //s3.addCourses(alumnoCursa4);
        //s4.addCourses(alumnoCursa5);
        //s5.addCourses(alumnoCursa6);
        //s6.addCourses(alumnoCursa7);
        //s7.addCourses(alumnoCursa8);

        //career1.addCourses(alumnoCursa1);
        //career1.addCourses(alumnoCursa4);
        //career1.addCourses(alumnoCursa7);
        //career2.addCourses(alumnoCursa2);
        //career2.addCourses(alumnoCursa5);
        //career3.addCourses(alumnoCursa3);
        //career3.addCourses(alumnoCursa6);
        //career1.addCourses(alumnoCursa7);

        StudentRepositoryImp sr = new StudentRepositoryImp();
        CareerRepositoryImp careerRepositoryImp = new CareerRepositoryImp();
        CoursesRepositoryImp coursesRepositoryImp = new CoursesRepositoryImp();

        //careerRepositoryImp.persist(career1);careerRepositoryImp.persist(career2);careerRepositoryImp.persist(career3);

        //sr.persist(s);sr.persist(s1);sr.persist(s2);sr.persist(s3);sr.persist(s4);sr.persist(s5);sr.persist(s6);sr.persist(s7);

        //coursesRepositoryImp.persist(alumnoCursa1);
        //coursesRepositoryImp.persist(alumnoCursa2);
        //coursesRepositoryImp.persist(alumnoCursa3);
        //coursesRepositoryImp.persist(alumnoCursa4);
        //coursesRepositoryImp.persist(alumnoCursa5);
        //coursesRepositoryImp.persist(alumnoCursa6);
        //coursesRepositoryImp.persist(alumnoCursa7);
        //coursesRepositoryImp.persist(alumnoCursa8);

        //List<StudentDTO>studentsOrderedByLastName = sr.findAllStudentsOrderedByLastName();
        //System.out.println("lista ordenada por alfabeto");
        //studentsOrderedByLastName.forEach(studentDTO -> System.out.println(studentDTO.toString()));

        //StudentDTO studentByRecord =sr.studentByRecord(12);
        //System.out.println("Estudiante con libreta numero 12");
        //System.out.println(studentByRecord.toString());

        //List<StudentDTO>studentsFilterByGender = sr.findStudentsByGender('M');
        //System.out.println("lista filtrada por genero");
        //studentsFilterByGender.forEach(studentDTO -> System.out.println(studentDTO.toString()));



        //b)matricular un estudiante a una carrera
        //coursesRepositoryImp.enrollStudent(s,career1);


        EntityManagerHelper.closeEntityManagerFactory();

    }
}
