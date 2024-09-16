package org.example;

import entity.City;
import entity.Student;
import repository.helper.EntityManagerHelper;

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
        EntityManager em = EntityManagerHelper.getEntityManager();
        em.getTransaction().begin();
        City c = new City("Tandil");
        City c1 = new City("Olavarria");
        em.persist(c);
        em.persist(c1);
        Student s = new Student(1,"Francisco","Vazquez",33,'M',c);
        Student s1 = new Student(2,"Mauro","Caciato",33,'M',c1);
        em.persist(s);
        em.persist(s1);
        em.getTransaction().commit();
        EntityManagerHelper.closeEntityManagerFactory();
    }
}
