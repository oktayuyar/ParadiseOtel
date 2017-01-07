/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelpackage;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oktay
 */
@Entity
@Table(name = "rezervasyon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rezervasyon.findAll", query = "SELECT r FROM Rezervasyon r"),
    @NamedQuery(name = "Rezervasyon.findByRezId", query = "SELECT r FROM Rezervasyon r WHERE r.rezId = :rezId"),
    @NamedQuery(name = "Rezervasyon.findByAdiSoyadi", query = "SELECT r FROM Rezervasyon r WHERE r.adiSoyadi = :adiSoyadi"),
    @NamedQuery(name = "Rezervasyon.findByEMail", query = "SELECT r FROM Rezervasyon r WHERE r.eMail = :eMail"),
    @NamedQuery(name = "Rezervasyon.findByCepTel", query = "SELECT r FROM Rezervasyon r WHERE r.cepTel = :cepTel"),
    @NamedQuery(name = "Rezervasyon.findByYetSayisi", query = "SELECT r FROM Rezervasyon r WHERE r.yetSayisi = :yetSayisi"),
    @NamedQuery(name = "Rezervasyon.findByCSayisi", query = "SELECT r FROM Rezervasyon r WHERE r.cSayisi = :cSayisi"),
    @NamedQuery(name = "Rezervasyon.findByRezCinsi", query = "SELECT r FROM Rezervasyon r WHERE r.rezCinsi = :rezCinsi"),
    @NamedQuery(name = "Rezervasyon.findByRezZamani", query = "SELECT r FROM Rezervasyon r WHERE r.rezZamani = :rezZamani"),
    @NamedQuery(name = "Rezervasyon.findByBasTarihi", query = "SELECT r FROM Rezervasyon r WHERE r.basTarihi = :basTarihi"),
    @NamedQuery(name = "Rezervasyon.findByBitisTarihi", query = "SELECT r FROM Rezervasyon r WHERE r.bitisTarihi = :bitisTarihi"),
    @NamedQuery(name = "Rezervasyon.findByFiyat", query = "SELECT r FROM Rezervasyon r WHERE r.fiyat = :fiyat")})
public class Rezervasyon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rez_id")
    private Integer rezId;
    @Basic(optional = false)
    @Column(name = "adi_soyadi")
    private String adiSoyadi;
    @Basic(optional = false)
    @Column(name = "e_mail")
    private String eMail;
    @Basic(optional = false)
    @Column(name = "cep_tel")
    private long cepTel;
    @Basic(optional = false)
    @Lob
    @Column(name = "adres")
    private String adres;
    @Basic(optional = false)
    @Column(name = "yet_sayisi")
    private int yetSayisi;
    @Basic(optional = false)
    @Column(name = "c_sayisi")
    private int cSayisi;
    @Basic(optional = false)
    @Column(name = "rez_cinsi")
    private int rezCinsi;
    @Basic(optional = false)
    @Column(name = "rez_zamani")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rezZamani;
    @Basic(optional = false)
    @Column(name = "bas_tarihi")
    private String basTarihi;
    @Basic(optional = false)
    @Column(name = "bitis_tarihi")
    private String bitisTarihi;
    @Basic(optional = false)
    @Column(name = "fiyat")
    private int fiyat;

    public Rezervasyon() {
    }

    public Rezervasyon(Integer rezId) {
        this.rezId = rezId;
    }

    public Rezervasyon(Integer rezId, String adiSoyadi, String eMail, long cepTel, String adres, int yetSayisi, int cSayisi, int rezCinsi, Date rezZamani, String basTarihi, String bitisTarihi, int fiyat) {
        this.rezId = rezId;
        this.adiSoyadi = adiSoyadi;
        this.eMail = eMail;
        this.cepTel = cepTel;
        this.adres = adres;
        this.yetSayisi = yetSayisi;
        this.cSayisi = cSayisi;
        this.rezCinsi = rezCinsi;
        this.rezZamani = rezZamani;
        this.basTarihi = basTarihi;
        this.bitisTarihi = bitisTarihi;
        this.fiyat = fiyat;
    }

    public Integer getRezId() {
        return rezId;
    }

    public void setRezId(Integer rezId) {
        this.rezId = rezId;
    }

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public long getCepTel() {
        return cepTel;
    }

    public void setCepTel(long cepTel) {
        this.cepTel = cepTel;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getYetSayisi() {
        return yetSayisi;
    }

    public void setYetSayisi(int yetSayisi) {
        this.yetSayisi = yetSayisi;
    }

    public int getCSayisi() {
        return cSayisi;
    }

    public void setCSayisi(int cSayisi) {
        this.cSayisi = cSayisi;
    }

    public int getRezCinsi() {
        return rezCinsi;
    }

    public void setRezCinsi(int rezCinsi) {
        this.rezCinsi = rezCinsi;
    }

    public Date getRezZamani() {
        return rezZamani;
    }

    public void setRezZamani(Date rezZamani) {
        this.rezZamani = rezZamani;
    }

    public String getBasTarihi() {
        return basTarihi;
    }

    public void setBasTarihi(String basTarihi) {
        this.basTarihi = basTarihi;
    }

    public String getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(String bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rezId != null ? rezId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervasyon)) {
            return false;
        }
        Rezervasyon other = (Rezervasyon) object;
        if ((this.rezId == null && other.rezId != null) || (this.rezId != null && !this.rezId.equals(other.rezId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "otelpackage.Rezervasyon[ rezId=" + rezId + " ]";
    }
    
}
