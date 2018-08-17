package sample.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NbaTeam {

    private StringProperty name;
    private StringProperty city;
    private IntegerProperty id_team;

    public NbaTeam() {
        this(null, null, 0);
    }

    public NbaTeam(String name, String city, int id) {
        this.name = new SimpleStringProperty(name);
        this.city = new SimpleStringProperty(city);
        this.id_team = new SimpleIntegerProperty(id);
    }

    @Override
    public String toString() {
        return "NbaTeam{" +
                "name=" + name +
                ", city=" + city +
                ", id_team=" + id_team +
                '}';
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public int getId_team() {
        return id_team.get();
    }

    public IntegerProperty id_teamProperty() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team.set(id_team);
    }
}
