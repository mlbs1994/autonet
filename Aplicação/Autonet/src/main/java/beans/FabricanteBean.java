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
import modelo.Fabricante;
import servico.FabricanteServicoDAO;

/**
 *
 * @author Matheus Levi
 */
@ManagedBean(name="fabricanteBean")
@ViewScoped
public class FabricanteBean {

    Fabricante f;
    List<Fabricante> fabricantes;
    
    FabricanteServicoDAO fabricanteServico;
    
    
    public FabricanteBean()
    {
        this.f = new Fabricante();
        this.fabricantes = new ArrayList();
        
        this.fabricanteServico = new FabricanteServicoDAO();
    }
    
    public List<Fabricante> getListaFabricantes()
    {
        this.fabricantes = this.fabricanteServico.getListaFabricantes();
        return this.fabricantes;
    }
    
}
