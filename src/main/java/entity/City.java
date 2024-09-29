package entity;

import javax.persistence.*;


@Entity
@NamedQuery(name= City.BUSCAR_TODAS, query=" SELECT c FROM  City c")
public class City {

    public static final String BUSCAR_TODAS = "City.BUSCAR_TODAS";

    @Id
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

