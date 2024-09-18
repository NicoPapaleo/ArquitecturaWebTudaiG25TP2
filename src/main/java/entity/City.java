package entity;

import javax.persistence.*;

@Entity
public class City {

    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private int idCity;

    @Column
    private String name;

    public City() {
    }

    public City(int idCity, String name) {
        this.idCity=idCity;
        this.name = name;
    }

    public int getIdCity() {
        return idCity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", name='" + name + '\'' +
                '}';
    }
}

