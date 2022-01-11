/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectAkhir.IkanChanna;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "channahomestay")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Channahomestay.findAll", query = "SELECT c FROM Channahomestay c"),
    @NamedQuery(name = "Channahomestay.findByIdikan", query = "SELECT c FROM Channahomestay c WHERE c.idikan = :idikan"),
    @NamedQuery(name = "Channahomestay.findByJenisikan", query = "SELECT c FROM Channahomestay c WHERE c.jenisikan = :jenisikan"),
    @NamedQuery(name = "Channahomestay.findBySize", query = "SELECT c FROM Channahomestay c WHERE c.size = :size"),
    @NamedQuery(name = "Channahomestay.findByKualitas", query = "SELECT c FROM Channahomestay c WHERE c.kualitas = :kualitas"),
    @NamedQuery(name = "Channahomestay.findByHarga", query = "SELECT c FROM Channahomestay c WHERE c.harga = :harga")})
public class Channahomestay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idikan")
    private Integer idikan;
    @Column(name = "jenisikan")
    private String jenisikan;
    @Column(name = "size")
    private String size;
    @Column(name = "kualitas")
    private String kualitas;
    @Column(name = "harga")
    private String harga;

    public Channahomestay() {
    }

    public Channahomestay(Integer idikan) {
        this.idikan = idikan;
    }

    public Integer getIdikan() {
        return idikan;
    }

    public void setIdikan(Integer idikan) {
        this.idikan = idikan;
    }

    public String getJenisikan() {
        return jenisikan;
    }

    public void setJenisikan(String jenisikan) {
        this.jenisikan = jenisikan;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getKualitas() {
        return kualitas;
    }

    public void setKualitas(String kualitas) {
        this.kualitas = kualitas;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idikan != null ? idikan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Channahomestay)) {
            return false;
        }
        Channahomestay other = (Channahomestay) object;
        if ((this.idikan == null && other.idikan != null) || (this.idikan != null && !this.idikan.equals(other.idikan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectAkhir.IkanChanna.Channahomestay[ idikan=" + idikan + " ]";
    }
    
}
