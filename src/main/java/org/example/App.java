package org.example;

import entity.City;
import entity.Student;
import repository.helper.EntityManagerHelper;
import repository.implementsRepositories.CityRepositoryImp;
import repository.implementsRepositories.StudentRepositoryImp;

import javax.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //EntityManager em = EntityManagerHelper.getEntityManager();
        //em.getTransaction().begin();
        //City c = new City("Tandil");
        //City c1 = new City("Olavarria");
        //Student s = new Student(4,35418649,"Francisco","Vazquez",33,'M',c);
        //Student s1 = new Student(5, 4952143,"Mauro","Caciato",33,'M',c1);
        CityRepositoryImp cr = new CityRepositoryImp();
        //cr.persist(c);
        //cr.persist(c1);

        StudentRepositoryImp sr = new StudentRepositoryImp();

        Student sss = sr.findById(5);
        sr.delete(sss);
        //City ccc = cr.findById(11);
        //cr.delete(ccc);
        //sr.persist(s);
        //sr.persist(s1);
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
