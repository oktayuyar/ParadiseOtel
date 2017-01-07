package otelpackage;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.webapp.FacesServlet;

public class KullaniciManagedBean {

    private Kullanici k=new Kullanici();
    config cg = new config();
    private boolean loginYapildiMi;

    public boolean isLoginYapildiMi() {
        return loginYapildiMi;
    }

    public void setLoginYapildiMi(boolean loginYapildiMi) {
        this.loginYapildiMi = loginYapildiMi;
    }
    
    public Kullanici getK() {
        return k;
    }

    /**
     * @param k the k to set
     */
    public void setK(Kullanici k) {
        this.k = k;
    }
 
   
    
    public KullaniciManagedBean() {
     
    }

    public void giris() throws SQLException{
        Connection c = DB.open();
        int kvarmi = 0;
        int yetki = 0;
        int cinsiyet=0;
        String sif = null;
        try {
            System.out.println(c.isClosed());
            PreparedStatement pr = c.prepareStatement("select * from kullanici where KULLANICIADI=? and SIFRE=?");
            pr.setString(1, k.getKullaniciadi());
            sif = cg.MD5(cg.SHA1(k.getSifre() + "admin").substring(0,30));
            pr.setString(2, sif);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                if (k.getKullaniciadi().equals(rs.getString("KULLANICIADI"))
                        && sif.equals(rs.getString("SIFRE"))) {
                    kvarmi = 1;
                    yetki = rs.getInt("YETKI");
                    k.setAdi(rs.getString("KULLANICIADI"));
                    cinsiyet=rs.getInt("CINSIYETI");
                } else {
                    kvarmi = 0;
                }
            }
        } catch (SQLException ex) {
            k.setKullaniciadi("");
            System.err.println(ex);
        }
        if (yetki==1 && kvarmi==1) {
            k.setYetki(yetki);
            k.setCinsiyeti(cinsiyet);
            
        }
        else if(yetki==2 && kvarmi==1){
            k.setYetki(yetki);
            k.setCinsiyeti(cinsiyet);
        }
        else if(kvarmi!=1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Yanlış Veri Girdiniz"));
            k.setKullaniciadi("");
        
            
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Yanlış Veri Girdiniz"));
            k.setKullaniciadi("");
           
        }
    }

    
    public List<Kullanici> getKullanici() throws SQLException{
        List<Kullanici> liste = new ArrayList<>();
        Connection c = DB.open();
        try {
            PreparedStatement pr = c.prepareStatement("select * from kullanici");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Kullanici k = new Kullanici();
                k.setKid(rs.getInt("KID"));
                k.setKullaniciadi(rs.getString("KULLANICIADI"));
                k.setSifre(rs.getString("SIFRE"));
                k.setAdi(rs.getString("ADI"));
                k.setSoyadi(rs.getString("SOYADI"));
                k.setEmail(rs.getString("EMAIL"));
                k.setCinsiyeti(rs.getInt("CINSIYETI"));
                k.setYetki(rs.getInt("YETKI"));

                liste.add(k);
            }
        } catch (SQLException ex) {
            return liste;
        }
        return liste;
    }
    
    public String cikisyap() {
        setLoginYapildiMi(false);
        k.setKullaniciadi("");
        return "anasayfa.xhtml";
        
    }    
}
