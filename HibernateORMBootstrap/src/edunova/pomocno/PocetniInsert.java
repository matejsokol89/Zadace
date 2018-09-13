/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.pomocno;

import edunova.model.NbaTeam;
import edunova.model.Operater;
import edunova.model.Player;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Profesor
 */
public class PocetniInsert {

    public static void izvedi() {


        Session session = HibernateUtil.getSession();

        session.beginTransaction();

        kreirajOperatera(session);
        NbaTeam nbaTeam = kreirajNbaTeam(session);
        Player player = kreirajPlayera(session,nbaTeam);
        session.getTransaction().commit();
    }

    private static void kreirajOperatera(Session session) {
        Operater o = new Operater();
        o.setIme("Matej");
        o.setPrezime("Sokol");
        o.setEmail("sokolvm@gmail.com");
        o.setLozinka(Autorizacija.getHash("t"));
        session.save(o);
    }

    private static NbaTeam kreirajNbaTeam(Session session) {
        NbaTeam newTeam = new NbaTeam();
        newTeam.setName("Pacers");
        newTeam.setCity("Indiana");
        session.save(newTeam);
        return  newTeam;
    }

    private static Player kreirajPlayera(Session session, NbaTeam nbaTeam) {
        Player newPlayer = new Player();
        newPlayer.setFirstname("Victor");
        newPlayer.setLastname("Oladipo");
        newPlayer.setNbaTeam( nbaTeam);
        newPlayer.setJerseynumber("40");
        newPlayer.setPosition("SG");
        session.save(newPlayer);
        return newPlayer;
         


    }
    

}
