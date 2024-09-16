package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nombre")
    private String name;

    @OneToMany(mappedBy = "career")
    private List<Courses> students;  // Lista de estudiantes cursando

    public Career() {}

    public Career(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Courses> getCourses() {
        return students;
    }

    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
