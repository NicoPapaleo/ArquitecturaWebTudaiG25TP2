package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Courses implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_libreta")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
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
                "student=" + student +
                ", career=" + career +
                ", start_date=" + start_date +
                ", graduated=" + graduated +
                '}';
    }
}
