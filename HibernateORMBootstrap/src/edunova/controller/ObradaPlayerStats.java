package edunova.controller;

import edunova.model.PlayerStats;
import edunova.pomocno.NbaException;
import java.util.List;

public class ObradaPlayerStats extends Obrada implements ObradaInterface<PlayerStats> {
    
    public List<PlayerStats> getEntiteti() {
        return session.createQuery(" from PlayerStats").list();
    }
    
    @Override
    public PlayerStats dodaj(PlayerStats e) throws NbaException {
        
        spremi(e);
        return e;
    }
    
    public PlayerStats promjena(PlayerStats e) throws NbaException {
        spremi(e);
        return e;
    }
}
