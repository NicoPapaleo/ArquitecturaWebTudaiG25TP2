package dto;

public class CareerDTO {

    private int idCareer;
    private String name;
    private long cantEstudiantes;

    public CareerDTO(int id, String name, long cantEstudiantes) {
        this.idCareer = id;
        this.name = name;
        this.cantEstudiantes=cantEstudiantes;
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

    public long getCantEstudiantes(){
        return cantEstudiantes;
    }

    @Override
    public String toString() {
        return "CareerDTO{" +
                "idCareer=" + idCareer +
                ", name='" + name + '\'' +
                ", cantEstudiantes=" + cantEstudiantes +
                '}';
    }
}
