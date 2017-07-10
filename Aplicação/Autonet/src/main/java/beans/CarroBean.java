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
import modelo.Imagem;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.primefaces.event.FileUploadEvent;
import servico.AluguelServicoDAO;
import servico.CarroServicoDAO;
import servico.CategoriaServicoDAO;
import servico.FabricanteServicoDAO;
import servico.ImagemServicoDAO;
import servico.UsuarioServicoDAO;
 
@ManagedBean(name = "carroBean")
@SessionScoped
public class CarroBean implements Serializable
{
     
    private Carro c;
    private List<Carro> carros;
    private List<Imagem> imagensCarroSelecionado; 
    
    private CarroServicoDAO carroServico;
    private CategoriaServicoDAO categoriaServico;
    private FabricanteServicoDAO fabricanteServico;
    private ImagemServicoDAO imagemServico;
    
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
    private int fabricanteSelecionado;
    private int carroSelecionado;
  
    private String keyword;
 
    
    @ManagedProperty(name="carrosAlugadosBean", value="#{loginBean}")
    private LoginBean carrosAlugadosBean;
  
    public CarroBean()
    {
        this.c = new Carro();
        this.carros = new ArrayList();
        this.carroServico = new CarroServicoDAO();
        this.categoriaServico = new CategoriaServicoDAO();
        this.fabricanteServico = new FabricanteServicoDAO();
        this.imagemServico = new ImagemServicoDAO();
        this.carros = this.carroServico.getListaCarros();
    }

    public LoginBean getCarrosAlugadosBean() {
        return carrosAlugadosBean;
    }

    public void setCarrosAlugadosBean(LoginBean carrosAlugadosBean) {
        this.carrosAlugadosBean = carrosAlugadosBean;
    }
    
    

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public int getFabricanteSelecionado() {
        return fabricanteSelecionado;
    }

    public void setFabricanteSelecionado(int fabricanteSelecionado) {
        this.fabricanteSelecionado = fabricanteSelecionado;
        this.categoriaSelecionada = -3;
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
        if(this.categoriaSelecionada==-4) //Por palavra chave
        {
            this.carros = this.carroServico.getListaCarrosPalavraChave("%"+this.keyword+"%");
        }
        else if(this.categoriaSelecionada==-3) //Por Fabricante selecionado
        {
            Fabricante f = this.fabricanteServico.getFabricante(this.fabricanteSelecionado);
            this.carros = this.carroServico.getListaCarrosFabricante(f);
        }
        else if(this.categoriaSelecionada==-2) //Carros alugados pelo usuario
        {
            this.carros = this.carrosAlugadosBean.getCarrosAlugados();
        }
        else if(this.categoriaSelecionada==-1) // Carros disponíveis
        {
            this.carros = this.carroServico.getListaCarrosStatus("Disponível");
        }
        else if(this.categoriaSelecionada==0) // Todos os carros
        {
            this.carros = this.carroServico.getListaCarros();
        }
        else // Por Categoria especificada
        {
            Categoria c = this.categoriaServico.getCategoria(this.getCategoriaSelecionada());
            this.carros = this.carroServico.getListaCarrosCategoria(c);
        }
        
        return this.carros;
    }
    
    
  
    public Carro getCarro()
    {
         return this.carroServico.getCarro(this.carroSelecionado);
    }
    
    public float getCarroValorDiaria()
    {
        return this.carroServico.getCarro(this.carroSelecionado).getValorAluguelDiaria();
    }

    public List<Imagem> getImagensCarroSelecionado() {
        this.imagensCarroSelecionado = this.imagemServico.
                getListaImagensCarro(this.getCarro());
        return this.imagensCarroSelecionado;
    }

    public void setImagensCarroSelecionado(List<Imagem> imagensCarroSelecionado) {
        this.imagensCarroSelecionado = imagensCarroSelecionado;
    }
    
    
    public void uploadAction(FileUploadEvent event)
    {
        this.imagem = event.getFile().getFileName();
    }

    public ImagemServicoDAO getImagensCarro() {
        return this.imagemServico;
    }
 
    public String corStatus(String status)
    {
        if(status.equals("Disponivel"))
        {
            return "green";
        }
        else
        {
            return "red";
        }
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
    
    public String voltarHome(int categoriaSelecionada)
    {
        this.setCategoriaSelecionada(categoriaSelecionada);
        
        return "home.xhtml";
        
    }
    

    
}