/*1
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Bandeira;
import modelo.Cartao;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Usuario;
import servico.BandeiraServicoDAO;
import servico.CartaoServicoDAO;
import servico.UsuarioServicoDAO;

/**
 *
 * @author Matheus Levi
 */
@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean
{

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
    private String numeroCartao;
    private String codigoSeguranca;
    private int bandeira;
    
    private UsuarioServicoDAO usuarioServico;

    public ClienteBean()
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

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public int getBandeira() {
        return bandeira;
    }

    public void setBandeira(int bandeira) {
        this.bandeira = bandeira;
    }
    
    public void cadastrarCliente()
    {
        BandeiraServicoDAO bandeiraServico = new BandeiraServicoDAO();
        CartaoServicoDAO cartaoDAO = new CartaoServicoDAO();
        
        try
        {
           Endereco endereco = new Endereco();
           
           endereco.setLogradouro(logradouro);
           endereco.setNumero(numero);
           endereco.setComplemento(complemento);
           endereco.setBairro(bairro);
           endereco.setCidade(cidade);
           endereco.setEstado(estado);
           
           Cartao cartao = new Cartao();
           
           cartao.setNumero(numeroCartao);
           cartao.setCodigoSeguranca(codigoSeguranca);
           cartao.setIdBandeira(bandeiraServico.getBandeira(bandeira));
           
           Usuario usuario = new Usuario();
           
           usuario.setNome(nome);
           usuario.setLogin(login);
           usuario.setSenha(senha);
           usuario.setTelefone(telefone);
           usuario.setCelular(celular);
           usuario.setIdEndereco(endereco);
           
           int idUsuario = this.usuarioServico.cadastrarUsuario(usuario);
           
           Cliente cliente = new Cliente();
           
           cliente.setIdUsuario(this.usuarioServico.getUsuario(idUsuario));
           
           int idCliente = this.usuarioServico.cadastrarCliente(cliente);
           
           cartao.setIdCliente(this.usuarioServico.getCliente(idCliente));
           
           cartaoDAO.cadastrarCartao(cartao);
           
           this.usuarioServico.commitTransacao();
           cartaoDAO.commitTransacao();
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    
    
    
    
}
