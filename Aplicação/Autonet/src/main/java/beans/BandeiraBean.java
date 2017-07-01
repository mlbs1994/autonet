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
import modelo.Bandeira;
import servico.BandeiraServicoDAO;

/**
 *
 * @author Matheus Levi
 */
@ManagedBean(name="bandeiraBean")
@ViewScoped
public class BandeiraBean
{

    private Bandeira b;
    private List<Bandeira> bandeiras;

    private BandeiraServicoDAO bandeiraServico;
     
    public BandeiraBean()
    {
        this.b = new Bandeira();
        this.bandeiras = new ArrayList();
        this.bandeiraServico = new BandeiraServicoDAO();
    }
    
    public List<Bandeira> getBandeiras()
    {
        this.bandeiras =  this.bandeiraServico.getListaBandeiras();
        
        return this.bandeiras;
    }
    
    public Bandeira getBandeira(){
        return b;
    }

    public void setBandeira(Bandeira b) {
        this.b = b;
    }
    
    
}
