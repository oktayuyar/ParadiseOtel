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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oktay
 */
@Entity
@Table(name = "mesaj")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesaj.findAll", query = "SELECT m FROM Mesaj m"),
    @NamedQuery(name = "Mesaj.findByMesajId", query = "SELECT m FROM Mesaj m WHERE m.mesajId = :mesajId"),
    @NamedQuery(name = "Mesaj.findByAdiSoyadi", query = "SELECT m FROM Mesaj m WHERE m.adiSoyadi = :adiSoyadi"),
    @NamedQuery(name = "Mesaj.findByEMail", query = "SELECT m FROM Mesaj m WHERE m.eMail = :eMail")})
public class Mesaj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mesaj_id")
    private Integer mesajId;
    @Basic(optional = false)
    @Column(name = "adi_soyadi")
    private String adiSoyadi;
    @Basic(optional = false)
    @Column(name = "e_mail")
    private String eMail;
    @Basic(optional = false)
    @Lob
    @Column(name = "mesaj")
    private String mesaj;

    public Mesaj() {
    }

    public Mesaj(Integer mesajId) {
        this.mesajId = mesajId;
    }

    public Integer getMesajId() {
        return mesajId;
    }

    public void setMesajId(Integer mesajId) {
        this.mesajId = mesajId;
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

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mesajId != null ? mesajId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesaj)) {
            return false;
        }
        Mesaj other = (Mesaj) object;
        if ((this.mesajId == null && other.mesajId != null) || (this.mesajId != null && !this.mesajId.equals(other.mesajId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "otelpackage.Mesaj[ mesajId=" + mesajId + " ]";
    }
    
}
