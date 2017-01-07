/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author oktay
 */
@ManagedBean
@RequestScoped
public class MesajManagedBean {
    private  Mesaj m=new Mesaj();

    public Mesaj getM() {
        return m;
    }

    public void setM(Mesaj m) {
        this.m = m;
    }
    


    public MesajManagedBean() {
    }
    
    public String mesajYaz() throws SQLException{
        Connection c = DB.open();
        try {
            System.out.println(c.isClosed()); 
            if(!"".equals(m.getAdiSoyadi()) && !"".equals(m.getEMail()) && !"".equals(m.getMesaj())){
                try (PreparedStatement ps = c.prepareStatement("insert into mesaj (adi_soyadi,e_mail,mesaj) "
                    + "values(?,?,?)")) {
                ps.setString(1,m.getAdiSoyadi());
                ps.setString(2, m.getEMail());
                ps.setString(3, m.getMesaj());
                ps.executeUpdate();
            }   
            }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("İsminizi veya mail adresinizi  boş bırakamazsınız."));
            return "contact.xhtml";
        }

        }
        catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        m.setAdiSoyadi("");
        m.setEMail("");
        m.setMesaj("");
        return "contact.xhtml";
    }
    
    public List<Mesaj> getMesajlar() throws SQLException{
        List <Mesaj> list=new ArrayList<>();
        Connection c=DB.open();
        try{
            PreparedStatement pr = c.prepareStatement("select * from mesaj");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Mesaj m1;
                m1 = new Mesaj();
                m1.setMesajId(rs.getInt("mesaj_id"));
                m1.setAdiSoyadi(rs.getString("adi_soyadi"));
                m1.setEMail(rs.getString("e_mail"));
                m1.setMesaj(rs.getString("mesaj"));
                list.add(m1);
            }  
        }
        catch (SQLException ex) {
            return list;
        } 
        return list;
    }
    
    /**
     *
     * @param kid
     * @return
     */
    public String mesajSil(Integer kid) {
        Connection c = DB.open();
         try {
            PreparedStatement ps = c.prepareStatement("delete from mesaj where mesaj_id=?");
            ps.setInt(1,kid);           
            ps.executeUpdate();
         }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        return "mesaj.xhtml";
    }
    
    public String tumunuSil() {
        Connection c = DB.open();
         try {
            PreparedStatement ps = c.prepareStatement("delete from mesaj");          
            ps.executeUpdate();
         }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        return "mesaj.xhtml";
    }
    public Integer topMesaj() throws SQLException {
        Connection c = DB.open();
         
            PreparedStatement ps = c.prepareStatement("select count(mesaj_id) from mesaj");          
            int count;
        try (ResultSet r = ps.executeQuery()) {
            r.next();
            count = r.getInt("count(mesaj_id)");
        }        
            return count;
    }     
    
}
