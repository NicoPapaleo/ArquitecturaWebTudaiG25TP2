package dto;

import java.util.List;

public class StudentDTO {

    private int dni;
    private int idLibreta;
    private String name;
    private String lastName;
    private char gender;
    private String city;
    private int edad;

    public StudentDTO(int dni, int idLibreta, String name, String lastName, char gender, String city, int edad) {
        this.dni = dni;
        this.idLibreta = idLibreta;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.city = city;
        this.edad = edad;
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getIdLibreta() {
        return idLibreta;
    }

    public void setIdLibreta(int idLibreta) {
        this.idLibreta = idLibreta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
