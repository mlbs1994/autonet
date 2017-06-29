/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(name = "aluguel", catalog = "autonet", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluguel.findAll", query = "SELECT a FROM Aluguel a"),
    @NamedQuery(name = "Aluguel.findByIdAluguel", query = "SELECT a FROM Aluguel a WHERE a.idAluguel = :idAluguel"),
    @NamedQuery(name = "Aluguel.findByDataAluguel", query = "SELECT a FROM Aluguel a WHERE a.dataAluguel = :dataAluguel"),
    @NamedQuery(name = "Aluguel.findByDataDevolu\u00e7\u00e3o", query = "SELECT a FROM Aluguel a WHERE a.dataDevolu\u00e7\u00e3o = :dataDevolu\u00e7\u00e3o")})
public class Aluguel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAluguel")
    private Integer idAluguel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataAluguel")
    @Temporal(TemporalType.DATE)
    private Date dataAluguel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dataDevolu\u00e7\u00e3o")
    private String dataDevolução;
    @JoinColumn(name = "idCarro", referencedColumnName = "idCarro")
    @ManyToOne(optional = false)
    private Carro idCarro;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Aluguel() {
    }

    public Aluguel(Integer idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Aluguel(Integer idAluguel, Date dataAluguel, String dataDevolução) {
        this.idAluguel = idAluguel;
        this.dataAluguel = dataAluguel;
        this.dataDevolução = dataDevolução;
    }

    public Integer getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(Integer idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public String getDataDevolução() {
        return dataDevolução;
    }

    public void setDataDevolução(String dataDevolução) {
        this.dataDevolução = dataDevolução;
    }

    public Carro getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Carro idCarro) {
        this.idCarro = idCarro;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluguel != null ? idAluguel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluguel)) {
            return false;
        }
        Aluguel other = (Aluguel) object;
        if ((this.idAluguel == null && other.idAluguel != null) || (this.idAluguel != null && !this.idAluguel.equals(other.idAluguel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Aluguel[ idAluguel=" + idAluguel + " ]";
    }
    
}
