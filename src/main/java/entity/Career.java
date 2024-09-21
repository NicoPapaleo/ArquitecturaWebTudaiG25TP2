package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name= Career.BUSCAR_TODAS, query=" SELECT c FROM  Career c")
@NamedQuery(name= Career.EXIST_CAREER, query=" SELECT c FROM  Career c WHERE idCareer = :idCareer")
public class Career {

    public static final String EXIST_CAREER = "Career.EXIST_CAREER";
    public static final String BUSCAR_TODAS = "Career.BUSCAR_TODAS";

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCareer;

    @Column(name = "Nombre")
    private String name;

    @OneToMany(mappedBy = "career")
    private List<Courses> students;  // Lista de estudiantes cursando

    public Career() {}

    public Career(int idCareer,String name) {
        this.idCareer=idCareer;
        this.name = name;
        this.students=new ArrayList<>();
    }

    public int getId() {
        return idCareer;
    }

    public String getName() {
        return name;
    }

    public List<Courses> getCourses() {
        return students;
    }

    public void addCourses(Courses course){
        students.add(course);
    }

    @Override
    public String toString() {
        return "Career{" +
                "id=" + idCareer +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
