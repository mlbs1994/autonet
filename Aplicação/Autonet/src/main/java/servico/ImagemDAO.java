/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List ;
import modelo.Carro;
import modelo.Imagem;

/**
 *
 * @author Matheus Levi
 */
public interface ImagemDAO
{
    public void cadastrarImagem(Imagem i); //CREATE
    
    public Imagem getImagem(Integer id); //READ
    
    public void atualizarImagem(Imagem i); //UPDATE
    
    public void removerImagem(Imagem i); //DELETE
    
    public List <Imagem> getListaImagems();
    
    public List <Imagem> getListaImagensCarro(Carro c);
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
}
