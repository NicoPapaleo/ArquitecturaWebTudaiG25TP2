package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Student {

    @Id
    private int id;

    @Column(name = "Nombre")
    private String name;

    @Column(name="Apellido")
    private String lastName;

    @Column(name="Edad")
    private int years;

    @Column(name="Genero")
    private char gender;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "student")
    private List<Courses> courses;  // muestro todas las carreras que cursa el estudiante

    public Student(){}

    public Student(int id, String name, String lastName, int years, char gender, City city) {
        this.id=id;
        this.name = name;
        this.lastName = lastName;
        this.years = years;
        this.gender = gender;
        this.city = city;
    }

    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYears() {
        return years;
    }

    public char getGender() {
        return gender;
    }

    public City getCity() {
        return city;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", years=" + years +
                ", gender=" + gender +
                ", city=" + city +
                ", cursa=" + courses +
                '}';
    }
}
