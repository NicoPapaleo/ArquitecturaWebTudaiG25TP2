package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@NamedQuery(name= Courses.BUSCAR_TODO, query=" SELECT c FROM  Courses c")
public class Courses implements Serializable {
    public static final String BUSCAR_TODO = "Courses.BUSCAR_TODO";

    @Id
    @ManyToOne
    @JoinColumn(name = "id_Student")
    private Student student;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_Career")
    private Career career;

    @Temporal(TemporalType.DATE)
    private Date start_date;

    @Column(name="Graduado")
    private boolean graduated;

    public Courses() {}

    public Courses(Student student, Career career, Date startDate, boolean graduated) {
        this.student = student;
        this.career = career;
        this.start_date = startDate;
        this.graduated = graduated;
    }

    public Career getCareer() {
        return career;
    }

    public Date getStart_date() {
        return start_date;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public Student getStudent() {
        return student;
    }


    @Override
    public String toString() {
        return "Courses{" +
                "estudiante=" + student +
                ", carrera=" + career +
                ", inicio=" + start_date +
                ", graduado=" + graduated +
                '}';
    }
}
