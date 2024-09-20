package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@NamedQuery(name= Student.BUSCAR_POR_LIBRETA, query=" SELECT s FROM  Student s WHERE s.idLibreta = :libreta")
@NamedQuery(name= Student.BUSCAR_TODOS, query=" SELECT s FROM  Student s")
@NamedQuery(name= Student.BUSCAR_POR_GENERO, query="SELECT new dto.StudentDTO(s.dni, s.idLibreta, s.name, s.lastName, s.gender, s.city.name, s.years) FROM Student s WHERE s.gender = :gender")
public class Student {

    public static final String BUSCAR_POR_LIBRETA = "Student.BUSCAR_POR_LIBRETA";
    public static final String BUSCAR_TODOS = "Student.BUSCAR_TODOS";
    public static final String BUSCAR_POR_GENERO = "Student.BUSCAR_POR_GENERO";

    @Id
    @Column(name="DNI")
    private int dni;

    @Column(name="idLibreta")
    private int idLibreta;

    @Column(name="Nombre")
    private String name;

    @Column(name="Apellido")
    private String lastName;

    @Column(name="Edad")
    private int years;

    @Column(name="Genero")
    private char gender;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Courses> courses;  // muestro todas las carreras que cursa el estudiante

    public Student(){}

    public Student(int dni,int idLibreta, String name, String lastName, int years, char gender ,City city) {
        this.dni=dni;
        this.idLibreta=idLibreta;
        this.name = name;
        this.lastName = lastName;
        this.years = years;
        this.gender = gender;
        this.city = city;
        this.courses=new ArrayList<>();
    }

    public int getIdLibreta(){
        return idLibreta;
    }

    public int getDni(){
        return dni;
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

    public void addCourses(Courses courses){
        this.courses.add(courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "dni=" + dni +
                ", idLibreta=" + idLibreta +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", years=" + years +
                ", gender=" + gender +
                ", city=" + city +
                ", courses=" + courses +
                '}';
    }
}
