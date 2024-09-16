package entity;


import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String lastName;
    private int years;
    private char gender;
    private List<Career>careers;
    private City city;

    public Student(){}

    public Student(String name, String lastName, int years, char gender, City city) {
        this.name = name;
        this.lastName = lastName;
        this.years = years;
        this.gender = gender;
        this.city = city;
        this.careers= new ArrayList<>();
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

    public List<Career> getCareers() {
        return careers;
    }

    public City getCity() {
        return city;
    }
}
