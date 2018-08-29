package edunova;

// domaća zadaća:

import edunova.controller.ObradaNbaTeam;
import edunova.model.NbaTeam;
import edunova.pomocno.HibernateUtil;
import edunova.pomocno.NbaException;

//upogoniti Hibernate prateći https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-maven-example/
public class Start {

    public static void main(String[] args) {
        ObradaNbaTeam obradTeam = new ObradaNbaTeam();
       
        NbaTeam nt = new NbaTeam();
        nt.setName("Tornto");
        
        
        try {
            obradTeam.dodaj(nt);
        } catch (NbaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        obradTeam.getEntiteti().forEach((e)->{System.out.println(e.getName());});        



//HibernateUtil.getSession();
        /*
        Smjer s;
        HibernateUtil.getSession().beginTransaction();
        for (int i = 0; i < 10; i++) {
            s=new Smjer();
            s.setNaziv("Smjer " + i);
            HibernateUtil.getSession().save(s);
        }
        HibernateUtil.getSession().getTransaction().commit();
        */
        
        
    }
    
}
