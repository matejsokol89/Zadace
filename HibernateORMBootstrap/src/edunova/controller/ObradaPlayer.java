package edunova.controller;

import edunova.model.Game;
import edunova.model.Player;
import edunova.pomocno.NbaException;
import java.util.List;

public class ObradaPlayer extends Obrada implements ObradaInterface<Player>{
    public List<Player> getEntiteti(){
        return session.createQuery(" from Player").list();
    }
    
@Override
    public Player dodaj(Player e) throws NbaException {
        
       spremi(e);
        return e;
    }

    @Override
    public Player promjena(Player e) throws NbaException {
         spremi(e);
        return e;
    }

   
}