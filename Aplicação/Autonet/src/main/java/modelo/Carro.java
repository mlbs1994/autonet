/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(name = "carro", catalog = "autonet", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c"),
    @NamedQuery(name = "Carro.findByIdCarro", query = "SELECT c FROM Carro c WHERE c.idCarro = :idCarro"),
    @NamedQuery(name = "Carro.findByModelo", query = "SELECT c FROM Carro c WHERE c.modelo = :modelo"),
    @NamedQuery(name = "Carro.findByImagem", query = "SELECT c FROM Carro c WHERE c.imagem = :imagem"),
    @NamedQuery(name = "Carro.findByDescricao", query = "SELECT c FROM Carro c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Carro.findByValorAluguelDiaria", query = "SELECT c FROM Carro c WHERE c.valorAluguelDiaria = :valorAluguelDiaria")})
public class Carro implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarro")
    private List<Imagem> imagemList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarro")
    private Integer idCarro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "modelo")
    private String modelo;
    @Size(min = 1, max = 5)
    @Column(name = "ano")
    private String ano;
    @Size(min = 1, max = 60)
    @Column(name = "cor")
    private String cor;
    @Size(min = 1, max = 60)
    @Column(name = "status")
    private String status;
    
    
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    @Size(max = 150)
    @Column(name = "imagem")
    private String imagem;
    @Size(max = 200)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorAluguelDiaria")
    private Float valorAluguelDiaria;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "idFabricante", referencedColumnName = "idFabricante")
    @ManyToOne(optional = false)
    private Fabricante idFabricante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarro")
    private List<Aluguel> aluguelList;

    public Carro() {
    }

    public Carro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public Carro(Integer idCarro, String modelo) {
        this.idCarro = idCarro;
        this.modelo = modelo;
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValorAluguelDiaria() {
        return valorAluguelDiaria;
    }

    public void setValorAluguelDiaria(Float valorAluguelDiaria) {
        this.valorAluguelDiaria = valorAluguelDiaria;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Fabricante getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Fabricante idFabricante) {
        this.idFabricante = idFabricante;
    }
    
     public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Aluguel> getAluguelList() {
        return aluguelList;
    }

    public void setAluguelList(List<Aluguel> aluguelList) {
        this.aluguelList = aluguelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarro != null ? idCarro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.idCarro == null && other.idCarro != null) || (this.idCarro != null && !this.idCarro.equals(other.idCarro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Carro[ idCarro=" + idCarro + " ]";
    }

    @XmlTransient
    public List<Imagem> getImagemList() {
        return imagemList;
    }

    public void setImagemList(List<Imagem> imagemList) {
        this.imagemList = imagemList;
    }
    
}
