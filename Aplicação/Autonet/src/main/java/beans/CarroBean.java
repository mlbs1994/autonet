package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import modelo.Carro;
import modelo.Fabricante;
import servico.CarroServicoDAO;
 
@ManagedBean(name = "carroBean")
@ViewScoped
public class CarroBean
{
     
    private Carro c;
    private List<Carro> carros;
    private CarroServicoDAO carroServico;
    
    public CarroBean()
    {
        this.c = new Carro();
        this.carros = new ArrayList();
        this.carroServico = new CarroServicoDAO();
        this.carros = this.carroServico.getListaCarros();
    }
     
    public List<Carro> getCarros() {
        this.carros = this.carroServico.getListaCarros();
        return this.carros;
    }
 
}