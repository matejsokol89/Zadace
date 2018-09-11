/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.pomocno;

import edunova.model.NbaTeam;
import edunova.model.Operater;
import edunova.model.Player;
import org.hibernate.Session;

/**
 *
 * @author Profesor
 */
public class PocetniInsert {
    
    public static void izvedi(){
        
        Session session = HibernateUtil.getSession();
        
        session.beginTransaction();
        
        Operater o = new Operater();
        o.setIme("Matej");
        o.setPrezime("Sokol");
        o.setEmail("sokolvm@gmail.com");
        o.setLozinka(Autorizacija.getHash("t"));
        
        session.save(o);
        
        NbaTeam newTeam = new NbaTeam();
        newTeam.setName("Pacers");
        newTeam.setCity("Indiana");
        
        session.save(newTeam);
        
      Player newPlayer = new Player();
      newPlayer.setFirstname("Bojan");
      newPlayer.setLastname("Bogdanović");
      newPlayer.setPosition("SG");
      newPlayer.setJerseynumber("41");
      
        
        session.save(newPlayer);
        
       session.getTransaction().commit();
        
        
    }
    
}
