/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Matheus Levi
 */
public interface UsuarioDAO
{
    public Integer cadastrarUsuario(Usuario a); //CREATE
    
    public Usuario getUsuario(Integer id); //READ
    
    public void atualizarUsuario(Usuario a); //UPDATE
    
    public void removerUsuario(Usuario a); //DELETE
    
    public List<Usuario> getListaUsuarios();
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
}
