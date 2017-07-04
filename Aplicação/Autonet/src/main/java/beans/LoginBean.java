/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;
import servico.UsuarioServicoDAO;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String login;
    private String senha;
    private String nome;
    private int idUsuario;

    private UsuarioServicoDAO usuarioServico;
    
    public LoginBean()
    {
        this.usuarioServico = new UsuarioServicoDAO();
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
    
    
    public String autenticarUsuario(String tipoUsuario)
    {
        Usuario usr = this.usuarioServico.autenticarUsuario(login, senha);
        
        if(usr!=null)
        {
            String[] nomes = usr.getNome().split(" ");
            this.nome = nomes[0];
            this.idUsuario = usr.getIdUsuario();
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
