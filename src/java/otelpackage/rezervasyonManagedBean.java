/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelpackage;

import java.sql.Connection;
import java.sql.Date;
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
public class rezervasyonManagedBean {

    private Rezervasyon r = new Rezervasyon();
    int fiyat;
    int tekSayisi = 2;
    int suitSayisi = 5;
    int ciftSayisi = 3;

    public int getTekSayisi() {
        return tekSayisi;
    }

    public void setTekSayisi(int tekSayisi) {
        this.tekSayisi = tekSayisi;
    }

    public int getSuitSayisi() {
        return suitSayisi;
    }

    public void setSuitSayisi(int suitSayisi) {
        this.suitSayisi = suitSayisi;
    }

    public int getCiftSayisi() {
        return ciftSayisi;
    }

    public void setCiftSayisi(int ciftSayisi) {
        this.ciftSayisi = ciftSayisi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public Rezervasyon getR() {
        return r;
    }

    public void setR(Rezervasyon r) {
        this.r = r;
    }

    public rezervasyonManagedBean() {
    }

    public void kontrolEtme() throws SQLException {
        if (tekSayisi > 0 && r.getRezCinsi() == 1) {
            tekSayisi = tekSayisi - 1;
            System.out.println("tek " + tekSayisi);
            rezervasyonYapma();
        } else if (suitSayisi > 0 && r.getRezCinsi() == 2) {
            suitSayisi = suitSayisi - 1;
            System.out.println("suit " + suitSayisi);
            rezervasyonYapma();
        } else if (ciftSayisi > 0 && r.getRezCinsi() == 3) {
            ciftSayisi = ciftSayisi - 1;
            System.out.println("cift " + ciftSayisi);
            rezervasyonYapma();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Seçtiğiniz türde boş odamız yoktur."));
        }
    }

    public String kontrolEtmeAnasayfa() throws SQLException {
        if (tekSayisi > 0 && r.getRezCinsi() == 1) {
            System.out.println("tek " + tekSayisi);
            return "reservation.xhtml";
        } else if (suitSayisi > 0 && r.getRezCinsi() == 2) {
            System.out.println("suit " + suitSayisi);
            return "reservation.xhtml";
        } else if (ciftSayisi > 0 && r.getRezCinsi() == 3) {
            System.out.println("cift " + ciftSayisi);
            return "reservation.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Seçtiğiniz türde boş odamız yoktur."));
        }
        return "anasayfa.xhtml";
    }

    public String rezervasyonYapma() throws SQLException {
        Connection c = DB.open();
        System.out.println(c.isClosed());
        if (r.getAdiSoyadi() != "" && r.getAdres() != "" && r.getEMail() != "" && r.getBasTarihi() != ""
                && r.getBitisTarihi() != "" && r.getYetSayisi() != 0) {
            try {
                try (PreparedStatement ps = c.prepareStatement("insert into rezervasyon (adi_soyadi,e_mail,"
                        + "cep_tel,adres,yet_sayisi,c_sayisi,rez_cinsi,rez_zamani,bas_tarihi,bitis_tarihi,fiyat) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?)")) {
                    ps.setString(1, r.getAdiSoyadi());
                    ps.setString(2, r.getEMail());
                    ps.setLong(3, r.getCepTel());
                    ps.setString(4, r.getAdres());
                    ps.setInt(5, r.getYetSayisi());
                    ps.setInt(6, r.getCSayisi());
                    ps.setInt(7, r.getRezCinsi());
                    ps.setDate(8, (Date) r.getRezZamani());
                    ps.setString(9, r.getBasTarihi());
                    ps.setString(10, r.getBitisTarihi());
                    ps.setInt(11, fiyat);
                    ps.executeUpdate();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Verileri Boş Bırakamazsınız!"));
            r.setAdiSoyadi("");
            r.setAdres("");
            r.setCSayisi(0);
            r.setCepTel(0);
            r.setEMail("");
            r.setFiyat(0);
            r.setRezCinsi(0);
            r.setYetSayisi(0);
            r.setBasTarihi("");
            r.setBitisTarihi("");
            setFiyat(0);;
            return "reservation.xhtml";
        }

        r.setAdiSoyadi("");
        r.setAdres("");
        r.setCSayisi(0);
        r.setCepTel(0);
        r.setEMail("");
        r.setFiyat(0);
        r.setRezCinsi(0);
        r.setYetSayisi(0);
        r.setBasTarihi("");
        r.setBitisTarihi("");
        setFiyat(0);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rezervasyonunuz Başarılı Bir Şekilde Yapıldı.!"));
        return "anasayfa.xhtml";
    }

    public List<Rezervasyon> getRezervasyonlar() throws SQLException {
        List<Rezervasyon> rezList = new ArrayList<>();
        Connection c = DB.open();
        try {
            PreparedStatement pr = c.prepareStatement("SELECT * from rezervasyon");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Rezervasyon r1;
                r1 = new Rezervasyon();
                r1.setRezId(rs.getInt("rez_id"));
                r1.setAdiSoyadi(rs.getString("adi_soyadi"));
                r1.setEMail(rs.getString("e_mail"));
                r1.setCepTel(rs.getLong("cep_tel"));
                r1.setBasTarihi(rs.getString("bas_tarihi"));
                r1.setBitisTarihi(rs.getString("bitis_tarihi"));
                r1.setFiyat(rs.getInt("fiyat"));
                rezList.add(r1);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            return rezList;
        }
        return rezList;
    }

    public String rezervasyonGetir() throws SQLException {
        Connection c = DB.open();
        try {
            PreparedStatement pr = c.prepareStatement("select * from rezervasyon where rez_id=?");
            pr.setInt(1, r.getRezId());

            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                r.setAdiSoyadi(rs.getString("adi_soyadi"));
                r.setEMail(rs.getString("e_mail"));
                r.setCepTel(rs.getLong("cep_tel"));
                r.setAdres(rs.getString("adres"));
                r.setYetSayisi(rs.getInt("yet_sayisi"));
                r.setCSayisi(rs.getInt("c_sayisi"));
                r.setRezCinsi(rs.getInt("rez_cinsi"));
                r.setBasTarihi(rs.getString("bas_tarihi"));
                r.setBitisTarihi(rs.getString("bitis_tarihi"));
                r.setFiyat(rs.getInt("fiyat"));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return "rezDetay.xhtml";
    }

    public String rezervasyonGuncelle() throws SQLException {
        Connection c = DB.open();
        if (r.getAdiSoyadi() != "" && r.getAdres() != "" && r.getEMail() != "" && r.getBasTarihi() != ""
                && r.getBitisTarihi() != "" && r.getYetSayisi() != 0) {
            try {
                PreparedStatement pr;
                pr = c.prepareStatement("update rezervasyon set adi_soyadi=? , e_mail=? , cep_tel=? , adres=? , yet_sayisi=?"
                        + ",c_sayisi=? , rez_cinsi=? ,bas_tarihi=? , bitis_tarihi=? , fiyat=?  where rez_id=?");
                pr.setString(1, r.getAdiSoyadi());
                pr.setString(2, r.getEMail());
                pr.setLong(3, r.getCepTel());
                pr.setString(4, r.getAdres());
                pr.setInt(5, r.getYetSayisi());
                pr.setInt(6, r.getCSayisi());
                pr.setInt(7, r.getRezCinsi());
                pr.setString(8, r.getBasTarihi());
                pr.setString(9, r.getBitisTarihi());
                pr.setInt(10, r.getFiyat());
                pr.setInt(11, r.getRezId());
                pr.executeUpdate();

            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Verileri Boş Bırakamazsınız!"));
            return "rezDetay.xhtml";
        }
        r.setAdiSoyadi("");
        r.setAdres("");
        r.setCSayisi(0);
        r.setCepTel(0);
        r.setEMail("");
        r.setRezCinsi(0);
        r.setYetSayisi(0);
        r.setBasTarihi("");
        r.setBitisTarihi("");
        setFiyat(0);
        return "rezListeleme.xhtml";
    }

    public String rezSil() throws SQLException {
        Connection c = DB.open();
        try {
            PreparedStatement ps = c.prepareStatement("delete from rezervasyon where rez_id=?");
            ps.setInt(1, r.getRezId());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        r.setAdiSoyadi("");
        r.setAdres("");
        r.setCSayisi(0);
        r.setCepTel(0);
        r.setEMail("");
        r.setFiyat(0);
        r.setRezCinsi(0);
        r.setYetSayisi(0);
        r.setBasTarihi("");
        r.setBitisTarihi("");
        return "rezListeleme.xhtml";
    }
}
