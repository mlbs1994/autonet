/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(name = "fabricante", catalog = "autonet", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f"),
    @NamedQuery(name = "Fabricante.findByIdFabricante", query = "SELECT f FROM Fabricante f WHERE f.idFabricante = :idFabricante"),
    @NamedQuery(name = "Fabricante.findByNome", query = "SELECT f FROM Fabricante f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fabricante.findByImgFabricante", query = "SELECT f FROM Fabricante f WHERE f.imgFabricante = :imgFabricante"),
    @NamedQuery(name = "Fabricante.findByHeightImg", query = "SELECT f FROM Fabricante f WHERE f.heightImg = :heightImg"),
    @NamedQuery(name = "Fabricante.findByWidthImg", query = "SELECT f FROM Fabricante f WHERE f.widthImg = :widthImg")})
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFabricante")
    private Integer idFabricante;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 200)
    @Column(name = "imgFabricante")
    private String imgFabricante;
    @Size(max = 45)
    @Column(name = "heightImg")
    private String heightImg;
    @Size(max = 45)
    @Column(name = "widthImg")
    private String widthImg;

    public Fabricante() {
    }

    public Fabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImgFabricante() {
        return imgFabricante;
    }

    public void setImgFabricante(String imgFabricante) {
        this.imgFabricante = imgFabricante;
    }

    public String getHeightImg() {
        return heightImg;
    }

    public void setHeightImg(String heightImg) {
        this.heightImg = heightImg;
    }

    public String getWidthImg() {
        return widthImg;
    }

    public void setWidthImg(String widthImg) {
        this.widthImg = widthImg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFabricante != null ? idFabricante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.idFabricante == null && other.idFabricante != null) || (this.idFabricante != null && !this.idFabricante.equals(other.idFabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Fabricante[ idFabricante=" + idFabricante + " ]";
    }
    
}
