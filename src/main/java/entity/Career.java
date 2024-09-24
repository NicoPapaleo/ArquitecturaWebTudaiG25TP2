package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name= Career.BUSCAR_TODAS, query=" SELECT c FROM  Career c")
@NamedQuery(name= Career.EXIST_CAREER, query=" SELECT c FROM  Career c WHERE idCareer = :idCareer")
//@NamedQuery(name= Career.BUSCAR_ESTUDIANTES_ORDENADOS, query="SELECT c.name, COUNT(e) AS cant_insctiptos FROM Career c JOIN Courses.student e GROUP BY c.name HAVING COUNT(e)>0 ORDER BY cant_insctiptos DESC")
@NamedQuery(name= Career.BUSCAR_CARRERAS_POR_ESTUDIANTES_INSCRIPTOS, query="SELECT new dto.CareerDTO(c.id, c.name) FROM Career c JOIN Courses cu ON c.idCareer = cu.career.id JOIN Student s ON s.id = cu.student.id GROUP BY c.id, c.name HAVING COUNT(cu)>0 ORDER BY COUNT(cu) DESC")
public class Career {

    public static final String EXIST_CAREER = "Career.EXIST_CAREER";
    public static final String BUSCAR_TODAS = "Career.BUSCAR_TODAS";
    //public static final String BUSCAR_ESTUDIANTES_ORDENADOS = "Career.BUSCAR_ESTUDIANTES_ORDENADOS";
    public static final String BUSCAR_CARRERAS_POR_ESTUDIANTES_INSCRIPTOS = "Career.BUSCAR_CARRERAS_POR_ESTUDIANTES_INSCRIPTOS";

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
