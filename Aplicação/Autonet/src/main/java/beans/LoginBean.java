package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Aluguel;
import modelo.Carro;
import modelo.Usuario;
import servico.AluguelServicoDAO;
import servico.UsuarioServicoDAO;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String login;
    private String senha;
    private String nome;
    private int idUsuario;
    private Usuario usuarioLogado;
    private List<Carro> carrosAlugados;

 
    private UsuarioServicoDAO usuarioServico;
    
    public LoginBean()
    {
        this.usuarioServico = new UsuarioServicoDAO();
        this.carrosAlugados = new ArrayList();
    }
    
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdUsuario() {
        System.out.println("Usuario = "+this.idUsuario);
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public List<Carro> getCarrosAlugados() {
        
        AluguelServicoDAO alDAO = new AluguelServicoDAO() ;
        UsuarioServicoDAO usrDAO = new UsuarioServicoDAO();
        
        List<Aluguel> listaAlugueisUsuario = alDAO.getAlugueisUsuario(this.usuarioLogado);
        
        for(int i=0;i<listaAlugueisUsuario.size();i++)
        {
            this.carrosAlugados.add(listaAlugueisUsuario.get(i).getIdCarro());
        }
        
        return this.carrosAlugados;
    }

    public void setCarrosAlugados(List<Carro> carrosAlugados) {
        this.carrosAlugados = carrosAlugados;
    }
    
    
    public String autenticarUsuario(String tipoUsuario)
    {
        this.usuarioLogado = this.usuarioServico.autenticarUsuario(login, senha);
        
        if(this.usuarioLogado!=null)
        {
            String[] nomes = this.usuarioLogado.getNome().split(" ");
            this.nome = nomes[0];
            this.idUsuario = this.usuarioLogado.getIdUsuario();
            System.out.println("Sucesso");
            if(tipoUsuario.equals("C"))
            {
                return "home.xhtml";
            }
            else
            {
                return "cadastrarCarro.xhtml";
            }
        }
        else
        {
            System.out.println("Login e senha incorretos");
            return null;
        }
    }
    
    
}
