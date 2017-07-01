/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Carro;
import modelo.Categoria;
import modelo.Fabricante;

/**
 *
 * @author Matheus Levi
 */
public interface CarroDAO
{
    public void cadastrarCarro(Carro a); //CREATE
    
    public Carro getCarro(Integer id); //READ
    
    public void atualizarCarro(Carro a); //UPDATE
    
    public void removerCarro(Carro a); //DELETE
    
    public List<Carro> getListaCarros();
    
    public List<Carro> getListaCarrosCategoria(Categoria ctg);
    
    public List<Carro> getListaCarrosFabricante(Fabricante f);
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
}
