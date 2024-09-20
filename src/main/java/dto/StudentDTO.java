package dto;

public class StudentDTO {

    private int dni;
    private int idLibreta;
    private String name;
    private String lastName;
    private char gender;
    private String city;
    private int years;

    public StudentDTO(int dni, int idLibreta, String name, String lastName, char gender, String city, int years) {
        this.dni = dni;
        this.idLibreta = idLibreta;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.city = city;
        this.years = years;
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

    public int getYears() {
        return years;
    }

    public void setYears(int edad) {
        this.years = edad;
    }
}
