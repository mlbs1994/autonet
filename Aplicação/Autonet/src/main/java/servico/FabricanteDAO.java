/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Fabricante;

/**
 *
 * @author Matheus Levi
 */
public interface FabricanteDAO 
{
    public void cadastrarFabricante(Fabricante f); //CREATE
    
    public Fabricante getFabricante(Integer id); //READ
    
    public void atualizarFabricante(Fabricante f); //UPDATE
    
    public void removerFabricante(Fabricante f); //DELETE
    
    public List<Fabricante> getListaFabricantes();
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
}
