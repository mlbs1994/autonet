package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import modelo.Aluguel;
import modelo.Carro;
import modelo.Categoria;
import modelo.Fabricante;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.primefaces.event.FileUploadEvent;
import servico.AluguelServicoDAO;
import servico.CarroServicoDAO;
import servico.CategoriaServicoDAO;
import servico.FabricanteServicoDAO;
import servico.UsuarioServicoDAO;
 
@ManagedBean(name = "carroBean")
@SessionScoped
public class CarroBean implements Serializable
{
     
    private Carro c;
    private List<Carro> carros;
    private List<Carro> carrosAlugadosUsuario;
    
    private CarroServicoDAO carroServico;
    private CategoriaServicoDAO categoriaServico;
    
    private String modelo;
    private String cor;
    private String ano;
    private String imagem;
    private String descricao;
    private float valorAluguelDiaria;
    private int fabricante;
    private int categoria;
    private float valorTotal;
    
    private int categoriaSelecionada;
    private int carroSelecionado;

    public CarroBean()
    {
        this.c = new Carro();
        this.carros = new ArrayList();
        this.carrosAlugadosUsuario = new ArrayList();
        this.carroServico = new CarroServicoDAO();
        this.categoriaServico = new CategoriaServicoDAO();
        this.carros = this.carroServico.getListaCarros();
    }
         
    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public int getCarroSelecionado() {
        return carroSelecionado;
    }

    public void setCarroSelecionado(int carroSelecionado) {
        this.carroSelecionado = carroSelecionado;
    }

    public int getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(int categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
    }
    
    public void updateCategoriaSelecionada() {
        this.categoriaSelecionada++;
    }

    public Carro getC() {
        return c;
    }

    public void setC(Carro c) {
        this.c = c;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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

    public float getValorAluguelDiaria() {
        return valorAluguelDiaria;
    }

    public void setValorAluguelDiaria(float valorAluguelDiaria) {
        this.valorAluguelDiaria = valorAluguelDiaria;
    }

    public int getFabricante() {
        return fabricante;
    }

    public void setFabricante(int fabricante) {
        this.fabricante = fabricante;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
      
    public List<Carro> getCarros() 
    {
        if(this.categoriaSelecionada==0)
        {
            this.carros = this.carroServico.getListaCarros();
        }
        else
        {
            Categoria c = this.categoriaServico.getCategoria(this.getCategoriaSelecionada());
            this.carros = this.carroServico.getListaCarrosCategoria(c);
        }
        
        return this.carros;
    }
    
    public List<Carro> getCarrosAlugadosUsuario() 
    {
     
        return this.carrosAlugadosUsuario;
    }

    public void setCarrosAlugadosUsuario(List<Carro> carrosAlugadosUsuario) {
        this.carrosAlugadosUsuario = carrosAlugadosUsuario;
    }
    
    public Carro getCarro()
    {
        return this.carroServico.getCarro(this.carroSelecionado);
    }
    
    public float getCarroValorDiaria()
    {
        return this.carroServico.getCarro(this.carroSelecionado).getValorAluguelDiaria();
    }
    
    public void uploadAction(FileUploadEvent event)
    {
        this.imagem = event.getFile().getFileName();
    }
    
    public void cadastrarCarro()
    {
        try
        {
            FabricanteServicoDAO fabricanteDAO = new FabricanteServicoDAO();
            CategoriaServicoDAO categoriaDAO = new CategoriaServicoDAO();

            this.c.setModelo(modelo);
            this.c.setCor(cor);
            this.c.setAno(ano);
            this.c.setImagem(imagem);
            this.c.setDescricao(descricao);
            this.c.setValorAluguelDiaria(valorAluguelDiaria);
            this.c.setIdFabricante(fabricanteDAO.getFabricante(fabricante));
            this.c.setIdCategoria(categoriaDAO.getCategoria(categoria));

            this.carroServico.cadastrarCarro(this.c);
            this.carroServico.commitTransacao();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public String selecionarCarro(int idCarro)
    {
        this.carroSelecionado = idCarro;
        return "detalheCarro.xhtml";
    }
    

    
 
}