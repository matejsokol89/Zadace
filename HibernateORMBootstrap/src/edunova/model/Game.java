package edunova.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
@Entity
public class Game extends Entitet implements Serializable{

    public Date getDateofgame() {
        return dateofgame;
    }

    public void setDateofgame(Date dateofgame) {
        this.dateofgame = dateofgame;
    }

    public BigInteger getHometeam() {
        return hometeam;
    }

    public void setHometeam(BigInteger hometeam) {
        this.hometeam = hometeam;
    }

    public BigInteger getAwayteam() {
        return awayteam;
    }

    public void setAwayteam(BigInteger awayteam) {
        this.awayteam = awayteam;
    }

    private Date dateofgame;
    private BigInteger hometeam;
    private BigInteger awayteam;
}
