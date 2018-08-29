package edunova.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public  class NbaTeam extends Entitet implements Serializable {

   
    private String name;
    private String city;


    public String getName() {
        return name;
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

}
