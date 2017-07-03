/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Aluguel;
import modelo.Usuario;

/**
 *
 * @author Matheus Levi
 */
public interface AluguelDAO 
{
    public void cadastrarAluguel(Aluguel a); //CREATE
    
    public Aluguel getAluguel(Integer id); //READ
    
    public void atualizarAluguel(Aluguel a); //UPDATE
    
    public void removerAluguel(Aluguel a); //DELETE
    
    public List<Aluguel> getListaAlugueis();
    
    public Aluguel getAluguelUsuario(Usuario usr);
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
}
