package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name= Career.BUSCAR_TODAS, query=" SELECT c FROM  Career c")
@NamedQuery(name= Career.EXIST_CAREER, query=" SELECT 1 FROM  Career c WHERE idCareer = :idCareer")
@NamedQuery(name=Career.GENERAR_REPORTE, query ="SELECT new dto.ReportCareerDTO(c.name, YEAR(cs.start_date), " +
        "COUNT(cs.student), SUM(CASE WHEN cs.graduated = true THEN 1 ELSE 0 END)) " +
        "FROM Career c JOIN c.students cs " +  // 'students' es el mapeo hacia Courses
        "GROUP BY c.name, YEAR(cs.start_date) " +
        "ORDER BY c.name, YEAR(cs.start_date) desc")
@NamedQuery(name= Career.BUSCAR_CARRERAS_POR_ESTUDIANTES_INSCRIPTOS, query="SELECT new dto.CareerDTO(c.id, c.name,COUNT(s)) FROM Career c JOIN c.students s GROUP BY c.id, c.name HAVING COUNT(s)>0 ORDER BY COUNT(s) DESC")

public class Career {

    public static final String EXIST_CAREER = "Career.EXIST_CAREER";
    public static final String BUSCAR_TODAS = "Career.BUSCAR_TODAS";
    public static final String GENERAR_REPORTE="Career.GENERAR_REPORTE";
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
