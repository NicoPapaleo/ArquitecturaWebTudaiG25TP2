package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    private int id;
    @Column(name="Nombre")
    private String name;
    @Column(name="Apellido")
    private String lastName;
    @Column
    private int years;
    @Column
    private char gender;

    //private List<Career>careers;
    @ManyToOne
    private City city;

    public Student(){}

    public Student(int id, String name, String lastName, int years, char gender, City city) {
        this.id=id;
        this.name = name;
        this.lastName = lastName;
        this.years = years;
        this.gender = gender;
        this.city = city;
        //this.careers= new ArrayList<>();
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

    //public List<Career> getCareers() {
    //    return careers;
    //}

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", years=" + years +
                ", gender=" + gender +
                //", careers=" + careers +
                ", city=" + city +
                '}';
    }
}
