package edunova.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PlayerStats extends Entitet implements Serializable {

    private BigDecimal gamesplayed;
    private BigDecimal fg2ptatt;
    private BigDecimal fg2ptmade;
    private BigDecimal fg3ptatt;
    private BigDecimal fg3ptmade;
    private BigDecimal ftatt;
    private BigDecimal ftmade;
    private BigDecimal player;
//game int not null
    @ManyToOne
    private Player players;
    @ManyToOne
    private Game game;

    public Player getPlayers() {
        return players;
    }

    public void setPlayers(Player players) {
        this.players = players;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    

    public BigDecimal getGamesplayed() {
        return gamesplayed;
    }

    public void setGamesplayed(BigDecimal gamesplayed) {
        this.gamesplayed = gamesplayed;
    }

    public BigDecimal getFg2ptatt() {
        return fg2ptatt;
    }

    public void setFg2ptatt(BigDecimal fg2ptatt) {
        this.fg2ptatt = fg2ptatt;
    }

    public BigDecimal getFg2ptmade() {
        return fg2ptmade;
    }

    public void setFg2ptmade(BigDecimal fg2ptmade) {
        this.fg2ptmade = fg2ptmade;
    }

    public BigDecimal getFg3ptatt() {
        return fg3ptatt;
    }

    public void setFg3ptatt(BigDecimal fg3ptatt) {
        this.fg3ptatt = fg3ptatt;
    }

    public BigDecimal getFg3ptmade() {
        return fg3ptmade;
    }

    public void setFg3ptmade(BigDecimal fg3ptmade) {
        this.fg3ptmade = fg3ptmade;
    }

    public BigDecimal getFtatt() {
        return ftatt;
    }

    public void setFtatt(BigDecimal ftatt) {
        this.ftatt = ftatt;
    }

    public BigDecimal getFtmade() {
        return ftmade;
    }

    public void setFtmade(BigDecimal ftmade) {
        this.ftmade = ftmade;
    }

    public BigDecimal getPlayer() {
        return player;
    }

    public void setPlayer(BigDecimal player) {
        this.player = player;
    }

}
