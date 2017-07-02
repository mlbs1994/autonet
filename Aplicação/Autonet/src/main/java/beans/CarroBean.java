package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import modelo.Carro;
import modelo.Fabricante;
import org.primefaces.event.FileUploadEvent;
import servico.CarroServicoDAO;
import servico.CategoriaServicoDAO;
import servico.FabricanteServicoDAO;
 
@ManagedBean(name = "carroBean")
@ViewScoped
public class CarroBean
{
     
    private Carro c;
    private List<Carro> carros;
    private CarroServicoDAO carroServico;
    
    private String modelo;
    private String cor;
    private String ano;
    private String imagem;
    private String descricao;
    private float valorAluguelDiaria;
    private int fabricante;
    private int categoria;

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
    
    public Carro getCarro()
    {
        return this.carroServico.getCarro(2);
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
    
 
}