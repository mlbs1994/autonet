/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;
import servico.UsuarioServicoDAO;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

    private String login;
    private String senha;
    private String nome;
    
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
    
    public String autenticarUsuario()
    {
        Usuario usr = this.usuarioServico.autenticarUsuario(login, senha);
        
        if(usr!=null)
        {
            String[] nomes = usr.getNome().split(" ");
            this.nome = nomes[0];
            System.out.println("Sucesso");
            return "home.xhtml";
        }
        else
        {
            System.out.println("Login e senha incorretos");
            return null;
        }
    }
    
    
    
    
}
