package edunova.controller;

import edunova.model.Entitet;
import edunova.pomocno.HibernateUtil;
import org.hibernate.Session;

public abstract class Obrada {

   protected Session session;
    
    public  Obrada(){
        session=HibernateUtil.getSession();
    }
   
    
    protected void spremi(Entitet e){
        System.out.println(e.getClass().toString());
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
    }
   
    public void obrisi(Entitet e){
        session.beginTransaction();
        session.delete(e);
        session.getTransaction().commit();
    }
    
}