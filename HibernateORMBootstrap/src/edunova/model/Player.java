package edunova.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sokol
 */
@Entity

public class Player extends Entitet implements Serializable {

    
    private String firstname;
    private String lastname;
    
    @ManyToOne
    private NbaTeam nbaTeam;

    public NbaTeam getNbaTeam() {
        return nbaTeam;
    }

    public void setNbaTeam(NbaTeam nbaTeam) {
        this.nbaTeam = nbaTeam;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getYersnumber() {
        return yersnumber;
    }

    public void setYersnumber(String yersnumber) {
        this.yersnumber = yersnumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    private String yersnumber;
    private String position;
//private nbateam int not null;
}
