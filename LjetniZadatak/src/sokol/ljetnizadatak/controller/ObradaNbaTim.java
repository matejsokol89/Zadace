package sokol.ljetnizadatak.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sokol.ljetnizadatak.model.NbaTeam;

public class ObradaNbaTim {

    Connection veza;
    PreparedStatement izraz;
    ResultSet rs;

    public ObradaNbaTim() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            veza = DriverManager.getConnection("jdbc:mysql://localhost/NBA_STATS?"
                    + "user=edunova&password=edunova&serverTimezone=CET&useUnicode=true&characterEncoding=utf-8");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<NbaTeam> getNbaTimovi() {
        try {
            izraz = veza.prepareStatement("select * from nbateam");
            ResultSet rs = izraz.executeQuery();
            List<NbaTeam> lista = new ArrayList<>();
            NbaTeam nt;
            while (rs.next()) {
                nt = new NbaTeam();
                nt.setId_team(rs.getInt("id_team"));
                nt.setCity(rs.getString("city"));
                nt.setName(rs.getString("name"));
                lista.add(nt);
            }
            rs.close();
            izraz.close();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private void postaviParametre(NbaTeam nt) throws SQLException {
        izraz.setString(1, nt.getName());
        izraz.setString(2, nt.getCity());
    }

    public boolean dodajNovi(NbaTeam nt) {
        try {
            izraz = veza.prepareStatement("insert into nbateam (name,city) "
                    + " value (?,?)");
            postaviParametre(nt);
            int brojPromjenaUBazi = izraz.executeUpdate();
            izraz.close();
            return brojPromjenaUBazi == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
        public boolean promjeniPostojeci(NbaTeam nt) {
        try {
            izraz = veza.prepareStatement("update nbateam set name=?,city=? "
                    + " where id_team=?");
            postaviParametre(nt);
            izraz.setInt(3, nt.getId_team());
            int brojPromjenaUBazi = izraz.executeUpdate();
            izraz.close(); 
            return brojPromjenaUBazi == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
        
     public boolean obrisiPostojeci(NbaTeam nt) throws SQLException{
            izraz = veza.prepareStatement("delete from nbateam  "
                    + " where id_team=?");
            izraz.setInt(1, nt.getId_team());
            int brojPromjenaUBazi = izraz.executeUpdate();
            izraz.close();
            return brojPromjenaUBazi == 1;
    }   

    
}
