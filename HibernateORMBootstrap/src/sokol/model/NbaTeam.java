package sokol.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public  class NbaTeam extends Entitet implements Serializable {

   
    private String name;
    private String city;
    
    @Temporal(TemporalType.DATE)
    private Date datumPocetka;
    
    @OneToMany(mappedBy = "nbaTeam")
    private List<Player> playeri;


    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public List<Player> getPlayeri() {
        return playeri;
    }

    public void setPlayeri(List<Player> playeri) {
        this.playeri = playeri;
    }


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
   
    @Override
    public String toString() {
        return getName();
    }
    @Override
    public String getCSV(){
        return getName() + "\t" + getCity() + "\t" + getDatumPocetka();
    }
}
