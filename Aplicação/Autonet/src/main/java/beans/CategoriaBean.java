/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Categoria;
import servico.CategoriaServicoDAO;

/**
 *
 * @author Matheus Levi
 */
@ManagedBean(name = "ctgBean")
@ViewScoped
public class CategoriaBean {

    private Categoria c;
    private List<Categoria> categorias;
    private CategoriaServicoDAO categoriaServico;
    
    public CategoriaBean()
    {
        this.c = new Categoria();
        this.categorias = new ArrayList();
        this.categoriaServico = new CategoriaServicoDAO();
    }

    public Categoria getC() {
        return c;
    }

    public void setC(Categoria c) {
        this.c = c;
    }
    
     public List<Categoria> getCategorias() {
        this.categorias = this.categoriaServico.getListaCategorias();
        return this.categorias;
    }
    
}
