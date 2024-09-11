package entity;

public class City {

    private int idCity;
    private String name;

    public City() {
    }

    public City(int idCity, String name) {
        this.idCity = idCity;
        this.name = name;
    }

    public int getIdCity() {
        return idCity;
    }

    public String getName() {
        return name;
    }
}

