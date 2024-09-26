package dto;

public class ReportCareerDTO {

    private String careerName;  // Nombre de la carrera
    private int year;           // Año de inscripción o egreso
    private long enrolled;      // Cantidad de estudiantes inscritos
    private long graduated;     // Cantidad de estudiantes graduados

    // Constructor
    public ReportCareerDTO(String careerName, int year, long enrolled, long graduated) {
        this.careerName = careerName;
        this.year = year;
        this.enrolled = enrolled;
        this.graduated = graduated;
    }

    // Getters y Setters
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
                "Carrera='" + careerName + '\'' +
                ", Anio=" + year +
                ", Estudiantes inscriptos=" + enrolled +
                ", Graduado=" + graduated +
                '}';
    }
}


