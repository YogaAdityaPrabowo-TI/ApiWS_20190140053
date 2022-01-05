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

/**
 *
 * @author HP
 */
@Entity
@Table(name = "channa")
@NamedQueries({
    @NamedQuery(name = "Channa.findAll", query = "SELECT c FROM Channa c"),
    @NamedQuery(name = "Channa.findByIdIkan", query = "SELECT c FROM Channa c WHERE c.idIkan = :idIkan"),
    @NamedQuery(name = "Channa.findByJenisikan", query = "SELECT c FROM Channa c WHERE c.jenisikan = :jenisikan"),
    @NamedQuery(name = "Channa.findBySize", query = "SELECT c FROM Channa c WHERE c.size = :size"),
    @NamedQuery(name = "Channa.findByKualitas", query = "SELECT c FROM Channa c WHERE c.kualitas = :kualitas"),
    @NamedQuery(name = "Channa.findByHarga", query = "SELECT c FROM Channa c WHERE c.harga = :harga")})
public class Channa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_ikan")
    private Integer idIkan;
    @Column(name = "jenisikan")
    private String jenisikan;
    @Column(name = "size")
    private String size;
    @Column(name = "kualitas")
    private String kualitas;
    @Column(name = "harga")
    private String harga;

    public Channa() {
    }

    public Channa(Integer idIkan) {
        this.idIkan = idIkan;
    }

    public Integer getIdIkan() {
        return idIkan;
    }

    public void setIdIkan(Integer idIkan) {
        this.idIkan = idIkan;
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
        hash += (idIkan != null ? idIkan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Channa)) {
            return false;
        }
        Channa other = (Channa) object;
        if ((this.idIkan == null && other.idIkan != null) || (this.idIkan != null && !this.idIkan.equals(other.idIkan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProjectAkhir.IkanChanna.Channa[ idIkan=" + idIkan + " ]";
    }
    
}
