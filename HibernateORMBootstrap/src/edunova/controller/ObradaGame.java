package edunova.controller;

import edunova.model.Game;
import edunova.pomocno.NbaException;
import java.util.List;

public class ObradaGame extends Obrada implements ObradaInterface<Game>{

public List<Game> getEntiteti(){
        return session.createQuery(" from Game").list();
    }
    
@Override
    public Game dodaj(Game e) throws NbaException {
        
       spremi(e);
        return e;
    }

    public Game promjena(Game e) throws NbaException {
         spremi(e);
        return e;
    }
    
}


    
