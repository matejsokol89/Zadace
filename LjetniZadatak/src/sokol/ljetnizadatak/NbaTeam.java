package sokol.ljetnizadatak;

public class NbaTeam {

    private String name;
    private String city;
    private int id_team;

    public String getName() {
        return name;
    }

    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
   
    public String toString() {
    return getName();
   
}
}
    