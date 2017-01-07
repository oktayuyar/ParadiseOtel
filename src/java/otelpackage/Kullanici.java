/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelpackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oktay
 */
@Entity
@Table(name = "kullanici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanici.findAll", query = "SELECT k FROM Kullanici k"),
    @NamedQuery(name = "Kullanici.findByKid", query = "SELECT k FROM Kullanici k WHERE k.kid = :kid"),
    @NamedQuery(name = "Kullanici.findByKullaniciadi", query = "SELECT k FROM Kullanici k WHERE k.kullaniciadi = :kullaniciadi"),
    @NamedQuery(name = "Kullanici.findBySifre", query = "SELECT k FROM Kullanici k WHERE k.sifre = :sifre"),
    @NamedQuery(name = "Kullanici.findByAdi", query = "SELECT k FROM Kullanici k WHERE k.adi = :adi"),
    @NamedQuery(name = "Kullanici.findBySoyadi", query = "SELECT k FROM Kullanici k WHERE k.soyadi = :soyadi"),
    @NamedQuery(name = "Kullanici.findByEmail", query = "SELECT k FROM Kullanici k WHERE k.email = :email"),
    @NamedQuery(name = "Kullanici.findByCinsiyeti", query = "SELECT k FROM Kullanici k WHERE k.cinsiyeti = :cinsiyeti"),
    @NamedQuery(name = "Kullanici.findByYetki", query = "SELECT k FROM Kullanici k WHERE k.yetki = :yetki")})
public class Kullanici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kid")
    private Integer kid;
    @Column(name = "kullaniciadi")
    private String kullaniciadi;
    @Column(name = "sifre")
    private String sifre;
    @Column(name = "adi")
    private String adi;
    @Column(name = "soyadi")
    private String soyadi;
    @Column(name = "email")
    private String email;
    @Column(name = "cinsiyeti")
    private Integer cinsiyeti;
    @Column(name = "yetki")
    private Integer yetki;


    public Kullanici() {
    }

    public Kullanici(Integer kid) {
        this.kid = kid;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCinsiyeti() {
        return cinsiyeti;
    }

    public void setCinsiyeti(Integer cinsiyeti) {
        this.cinsiyeti = cinsiyeti;
    }

    public Integer getYetki() {
        return yetki;
    }

    public void setYetki(Integer yetki) {
        this.yetki = yetki;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kid != null ? kid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanici)) {
            return false;
        }
        Kullanici other = (Kullanici) object;
        if ((this.kid == null && other.kid != null) || (this.kid != null && !this.kid.equals(other.kid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "otelpackage.Kullanici[ kid=" + kid + " ]";
    }
    
}
