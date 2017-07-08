package beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Aluguel;
import modelo.Carro;
import modelo.Usuario;
import org.joda.time.DateTime;
import servico.AluguelServicoDAO;
import org.joda.time.Days;
import servico.CarroServicoDAO;
import servico.UsuarioServicoDAO;

@ManagedBean(name="aluguelBean")
@SessionScoped
public class AluguelBean 
{
 
    private Aluguel a;
    
    private Date dataAluguel;
    private Date dataDevolucao;
    private float valorDiaria;
    private float totalAluguel;
    
    @ManagedProperty(name="cBean", value = "#{carroBean}")
    private CarroBean cBean;

    @ManagedProperty(name="uBean", value="#{loginBean}")
    private LoginBean uBean;

    public AluguelBean()
    {
        this.aluguelServico = new AluguelServicoDAO();
        this.a = new Aluguel();
    }
    
    public LoginBean getuBean() {
        return uBean;
    }

    public void setuBean(LoginBean uBean) {
        this.uBean = uBean;
    }
    
    public CarroBean getcBean() {
        return cBean;
    }

    public void setcBean(CarroBean cBean) {
        this.cBean = cBean;
    }
  
    
    private AluguelServicoDAO aluguelServico; 

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getTotalAluguel() {
        return totalAluguel;
    }

    public void setTotalAluguel(float totalAluguel) {
        this.totalAluguel = totalAluguel;
    }
    private Usuario usuario;
    private Carro carro;

    public Date getDataAluguel() throws Exception{
        return this.dataAluguel;
    }
    
    public String getDataAluguelFormatado()
    {
        String formato = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String dataFormato = sdf.format(this.dataAluguel);
        return dataFormato;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
   
    public String fazerAluguel()
    {
        try
        {
            UsuarioServicoDAO usuarioServico = new UsuarioServicoDAO();
            CarroServicoDAO carroDAO = new CarroServicoDAO();
        
            Carro c = this.cBean.getCarro();
            
            this.a.setDataAluguel(dataAluguel);
            this.a.setDataDevolução(dataDevolucao);
            this.a.setTotalAluguel(totalAluguel);
            this.a.setIdCarro(c);
            this.a.setIdUsuario(usuarioServico.getUsuario(this.uBean.getIdUsuario()));
            
            this.aluguelServico.cadastrarAluguel(this.a);
            this.aluguelServico.commitTransacao();
            
            //Marcando o carro como alugado
            c.setStatus("Alugado");
            carroDAO.atualizarCarro(c);
            carroDAO.commitTransacao();
            
            return "AluguelSucesso.xhtml";
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "home.xhtml";
        }
        
    }
    
    public String voltar()
    {
        this.dataAluguel = null;
        this.dataDevolucao = null;
        this.totalAluguel = 0.0f;
        return "home.xhtml";
    }
}
