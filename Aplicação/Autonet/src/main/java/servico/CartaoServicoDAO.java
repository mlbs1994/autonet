/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import modelo.Bandeira;
import modelo.Cartao;

/**
 *
 * @author Matheus Levi
 */
public class CartaoServicoDAO implements CartaoDAO
{

    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    
    public CartaoServicoDAO()
    {
        try
        {
            System.out.println("Iniciando UsuarioServicoDAO");
            this.emf = Persistence.createEntityManagerFactory("com.mycompany_Autonet_war_1.0-SNAPSHOTPU");
            System.out.println("Criado o entity manager factory");
            this.em = emf.createEntityManager();
            System.out.println("Criado o entity manager");
            this.et = em.getTransaction();
            System.out.println("Obtido a transacao");
            this.et.begin();
            System.out.println("Iniciando transação");
        }
        catch(Exception e)
        {
            
            //finalizarTransacao();
            System.err.print("Transação abortada - ROLLBACK");
            e.printStackTrace();
        }
    }
    
    @Override
    public void cadastrarCartao(Cartao c) {
        this.em.persist(c);
    }

    @Override
    public Cartao getCartao(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarCartao(Cartao a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerCartao(Cartao a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cartao> getListaCartao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cartao> getListaCartaoBandeira(Bandeira b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commitTransacao() {
        this.et.commit();
    }

    @Override
    public void finalizarTransacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void abortarTransacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
