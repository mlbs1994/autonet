/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Categoria;
import modelo.Categoria;
import modelo.Fabricante;

/**
 *
 * @author Matheus Levi
 */
public interface CategoriaDAO
{
    public void cadastrarCategoria(Categoria a); //CREATE
    
    public Categoria getCategoria(Integer id); //READ
    
    public void atualizarCategoria(Categoria a); //UPDATE
    
    public void removerCategoria(Categoria a); //DELETE
    
    public List<Categoria> getListaCategorias();
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
}