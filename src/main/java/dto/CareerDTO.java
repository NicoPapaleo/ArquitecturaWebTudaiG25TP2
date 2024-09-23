package dto;

import entity.Courses;

import java.util.List;

public class CareerDTO {
    private int idCareer;
    private String name;
    private List<Courses> students;

    public CareerDTO(int id, String name, List<Courses> students) {
        this.idCareer = id;
        this.name = name;
        this.students = students;
    }

    public int getId() {
        return idCareer;
    }

    public void setId(int id) {
        this.idCareer = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Courses> getStudents() {
        return students;
    }

    public void setStudents(List<Courses> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "CareerDTO{" +
                "id=" + idCareer +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
