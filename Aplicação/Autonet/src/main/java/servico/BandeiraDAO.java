/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Bandeira;

public interface BandeiraDAO
{
    
    public void cadastrarBandeira(Bandeira b); //CREATE
    
    public Bandeira getBandeira(Integer id); //READ
    
    public void atualizarBandeira(Bandeira b); //UPDATE
    
    public void removerBandeira(Bandeira b); //DELETE
    
    public List<Bandeira> getListaBandeiras();
    
    public void commitTransacao();
    
    public void finalizarTransacao();
    
    public void abortarTransacao();
    
}
