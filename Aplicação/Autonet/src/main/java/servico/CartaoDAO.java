/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Bandeira;
import modelo.Cartao;

/**
 *
 * @author Matheus Levi
 */
public interface CartaoDAO
{
    
    public void cadastrarCartao(Cartao a); //CREATE
    
    public Cartao getCartao(Integer id); //READ
    
    public void atualizarCartao(Cartao a); //UPDATE
    
    public void removerCartao(Cartao a); //DELETE
    
    public List<Cartao> getListaCartao();
    
    public List<Cartao> getListaCartaoBandeira(Bandeira b);
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
    
}
