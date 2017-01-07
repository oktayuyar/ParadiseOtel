package otelpackage;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import javax.faces.context.FacesContext;

/**
 *
 * @author oktay
 */
public class KullaniciDetayManagedBean implements Serializable {

    private Kullanici k1 = new Kullanici();
    config cg = new config();

    public Kullanici getK1() {
        return k1;
    }

    public void setK1(Kullanici k1) {
        this.k1 = k1;
    }

    public KullaniciDetayManagedBean() {

    }

    public String kullaniciGetir() throws SQLException {
        Connection c = DB.open();
        k1.setKullaniciadi("");
        k1.setSifre("");
        k1.setAdi("");
        k1.setSoyadi("");
        k1.setEmail("");
        k1.setCinsiyeti(0);
        k1.setYetki(0);
        try {
            PreparedStatement pr = c.prepareStatement("select * from kullanici where KID=?");
            pr.setInt(1, k1.getKid());

            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                k1.setKullaniciadi(rs.getString("KULLANICIADI"));
                k1.setSifre(rs.getString("SIFRE"));
                k1.setAdi(rs.getString("ADI"));
                k1.setSoyadi(rs.getString("SOYADI"));
                k1.setEmail(rs.getString("EMAIL"));
                k1.setCinsiyeti(rs.getInt("CINSIYETI"));
                k1.setYetki(rs.getInt("YETKI"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "kullanicidetay.xhtml";
    }

    public String kullaniciEkle() throws SQLException {
        Connection c = DB.open();
        if (!"".equals(k1.getKullaniciadi()) && !"".equals(k1.getSifre())&& !"".equals(k1.getAdi())
                && !"".equals(k1.getSoyadi())&& !"".equals(k1.getEmail())) {
            try {
                System.out.println(c.isClosed());
                String sif = cg.MD5(cg.SHA1(k1.getSifre() + "admin").substring(0, 30));
                PreparedStatement ps = c.prepareStatement("insert into kullanici (KULLANICIADI,SIFRE,ADI,SOYADI,EMAIL,CINSIYETI,YETKI) "
                        + "values(?,?,?,?,?,?,?)");
                ps.setString(1, k1.getKullaniciadi());
                ps.setString(2, sif);
                ps.setString(3, k1.getAdi());
                ps.setString(4, k1.getSoyadi());
                ps.setString(5, k1.getEmail());
                ps.setInt(6, k1.getCinsiyeti());
                ps.setInt(7, k1.getYetki());
                ps.executeUpdate();
                ps.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Verileri boş bırakamazsınız!"));
        }

        k1.setKullaniciadi("");
        k1.setSifre("");
        k1.setAdi("");
        k1.setSoyadi("");
        k1.setEmail("");
        k1.setCinsiyeti(0);
        k1.setYetki(0);
        return "anasayfa.xhtml";
    }

    public String kullaniciguncelle() throws SQLException {
        Connection c = DB.open();
        if (!"".equals(k1.getKullaniciadi()) && !"".equals(k1.getAdi())&& !"".equals(k1.getSoyadi()) && !"".equals(k1.getEmail())) {
            try (PreparedStatement pr = c.prepareStatement("update kullanici set KULLANICIADI=?,SIFRE=?,ADI=?,SOYADI=?,EMAIL=?,"
                    + "CINSIYETI=?,YETKI=? where KID=?")) {
                pr.setInt(8, k1.getKid());
                pr.setString(1, k1.getKullaniciadi());
                pr.setString(2, k1.getSifre());
                pr.setString(3, k1.getAdi());
                pr.setString(4, k1.getSoyadi());
                pr.setString(5, k1.getEmail());
                pr.setInt(6, k1.getCinsiyeti());
                pr.setInt(7, k1.getYetki());
                pr.executeUpdate();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Verileri boş bırakamazsınız!"));
        }
        k1.setKullaniciadi("");
        k1.setSifre("");
        k1.setAdi("");
        k1.setSoyadi("");
        k1.setEmail("");
        k1.setCinsiyeti(0);
        k1.setYetki(0);

        return "admin.xhtml";

    }

    public String kullanicisil() throws SQLException {
        Connection c = DB.open();
        try {
            PreparedStatement ps = c.prepareStatement("delete from kullanici where KID=?");
            ps.setInt(1, k1.getKid());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        k1.setKullaniciadi("");
        k1.setSifre("");
        k1.setAdi("");
        k1.setSoyadi("");
        k1.setEmail("");
        k1.setCinsiyeti(0);
        k1.setYetki(0);
        return "admin.xhtml";
    }

    public List<SelectItem> getKadiListesi() throws SQLException {

        List<SelectItem> liste = new ArrayList<SelectItem>();
        Connection c = DB.open();
        try {
            PreparedStatement pr = c.prepareStatement("select * from kullanici");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                liste.add(new SelectItem(rs.getString("KID")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return liste;
        }
        return liste;
    }

}
