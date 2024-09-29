package dto;

import entity.Student;

import java.util.List;

//clase utilizada para devolver la informacion del registro ejercicio 3
public class ReportCareerDTO {

    private String careerName;  // Nombre de la carrera
    private int year;           // Anio de inscripción o egreso
    private long enrolled;      // Cantidad de estudiantes inscritos
    private long graduated;     // Cantidad de estudiantes graduados
    private String name;
    private String lastName;
    private int dni;

    public ReportCareerDTO(String careerName, int year, long enrolled, long graduated,String name, String lastName, int dni) {
        this.careerName = careerName;
        this.year = year;
        this.enrolled = enrolled;
        this.graduated = graduated;
        this.name=name;
        this.lastName=lastName;
        this.dni=dni;
    }

    public String getCareerName() {
        return careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(long enrolled) {
        this.enrolled = enrolled;
    }

    public long getGraduated() {
        return graduated;
    }

    public void setGraduated(long graduated) {
        this.graduated = graduated;
    }

    @Override
    public String toString() {
        return "ReportCareerDTO{" +
                "careerName='" + careerName + '\'' +
                ", year=" + year +
                ", enrolled=" + enrolled +
                ", graduated=" + graduated +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni=" + dni +
                '}';
    }
}


