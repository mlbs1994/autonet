/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;
import servico.UsuarioServicoDAO;

/**
 *
 * @author Matheus Levi
 */

@ManagedBean(name="funcBean")
@RequestScoped
public class FuncionarioBean {

    private String nome;
    private String login;
    private String senha;
    private String telefone;
    private String celular;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
 
    private UsuarioServicoDAO usuarioServico;
    
    public FuncionarioBean()
    {
        this.usuarioServico = new UsuarioServicoDAO();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioServicoDAO getUsuarioServico() {
        return usuarioServico;
    }

    public void setUsuarioServico(UsuarioServicoDAO usuarioServico) {
        this.usuarioServico = usuarioServico;
    }
    
    public void cadastrarFuncionario()
    {
        try
        {
           Endereco endereco = new Endereco();
           
           endereco.setLogradouro(logradouro);
           endereco.setNumero(numero);
           endereco.setComplemento(complemento);
           endereco.setBairro(bairro);
           endereco.setCidade(cidade);
           endereco.setEstado(estado);
           
           Usuario usuario = new Usuario();
           
           usuario.setNome(nome);
           usuario.setLogin(login);
           usuario.setSenha(senha);
           usuario.setTelefone(telefone);
           usuario.setCelular(celular);
           usuario.setIdEndereco(endereco);
           
           int idUsuario = this.usuarioServico.cadastrarUsuario(usuario);
           
           Funcionario funcionario = new Funcionario();
           
           funcionario.setIdUsuario(this.usuarioServico.getUsuario(idUsuario));
           
           int idFuncionario = this.usuarioServico.cadastrarFuncionario(funcionario);
        
           this.usuarioServico.commitTransacao();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
