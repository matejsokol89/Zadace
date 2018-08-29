package edunova.controller;

import edunova.model.NbaTeam;
import java.math.BigInteger;
import java.util.List;
import edunova.pomocno.NbaException;

public class ObradaNbaTeam extends Obrada implements ObradaInterface<NbaTeam>{
public List<NbaTeam> getEntiteti(){
        return session.createQuery(" from NbaTeam").list();
    }
    
    /**
     * Metoda vraća sve smjerove prema uvjetu naziva sve %uvjet%
     * @param uvjet uvjet koji se šalje upitu
     * @return lista Smjerova prema rezultatima upita
     */
    public List<NbaTeam> getEntiteti(String uvjet){
        return session.createQuery(" from NbaTeam nt where nt.naziv like :uvjet")
                .setString("uvjet", "%" + uvjet + "%")
                .list();
    }
    
    public NbaTeam dodaj(NbaTeam nt) throws NbaException{
       
        kontrola(nt);
        
        BigInteger postojeci  = (BigInteger)session.createSQLQuery("select count(idNba) from nbateam where name=:name").
                setString("name", nt.getName()).uniqueResult();
        if(postojeci.intValue()==1){
            throw new NbaException("NbaTem nt istim nazivom postoji");
        }
        //ovdje dođu sve ostale kontrole
        
        
        spremi(nt);
        
        return nt;
    }
    
    public NbaTeam promjena(NbaTeam nt) throws NbaException{
        
        kontrola(nt);
        
        BigInteger postojeci  = (BigInteger)session.createSQLQuery("select count(idNba) from nbateam where naziv=:naziv and idNba<>:idNba").
                setString("name", nt.getName()).setInteger("idNba", nt.getIdNba()).uniqueResult();
        if(postojeci.intValue()==1){
            throw new NbaException("Nba team s istim nazivom postoji");
        }
        
        //ovdje dođu sve ostale kontrole
        
        spremi(nt);
        
        return nt;
    }
 

    private void kontrola(NbaTeam nt) throws NbaException{
        kontrolaObaveznoVrijednost(nt);
//može i ovako         
//Kontrola.stringNijePrazan(s.getNaziv(), "Naziv smjera obavezno");
        kontrolaNeViseOd50Znakova(nt); 
        kontrolaBrojeviNeMoguBitiUNazivu(nt);
        
    }

    private void kontrolaObaveznoVrijednost(NbaTeam nt) throws NbaException {
        if(nt.getName()==null || nt.getName().isEmpty()){
            throw new NbaException("Naziv obavezno");
        }
    }

    private void kontrolaBrojeviNeMoguBitiUNazivu(NbaTeam nt) throws NbaException{
         try {
            Integer.parseInt(nt.getName());
            throw new NbaException("Nba team ne smije imati samo brojeve u nazivu");
        } catch (Exception e) {
            
        }
    }

    private void kontrolaNeViseOd50Znakova(NbaTeam nt) throws NbaException{
        if(nt.getName().length()>50){
            throw new NbaException("Naziv ne smije imati više od 50 znakova");
        }
    }
    
}