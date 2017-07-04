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
import javax.persistence.Query;
import modelo.Aluguel;
import modelo.Usuario;

/**
 *
 * @author Matheus Levi
 */
public class AluguelServicoDAO implements AluguelDAO
{
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;

    public AluguelServicoDAO()
    {
        try
        {
            System.out.println("Iniciando AluguelServicoDAO");
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
    public void cadastrarAluguel(Aluguel a) {
        try
        {
            System.out.println("Persistindo aluguel...");
            this.em.persist(a);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Aluguel getAluguel(Integer id) {
        return this.em.find(Aluguel.class, id);
    }

    @Override
    public void atualizarAluguel(Aluguel a) {
        this.em.merge(a);
    }

    @Override
    public void removerAluguel(Aluguel a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluguel> getListaAlugueis() {
        Query q = this.em.createQuery("SELECT a FROM Aluguel a ORDER BY a.dataAluguel");
        System.out.println("Criado query");
        List<Aluguel> alugueis =  q.getResultList();
        System.out.println("Pegando o resultList");
        return alugueis;
    }

    @Override
    public Aluguel getAluguelUsuario(Usuario usr) {
        Query q = this.em.createQuery("SELECT a FROM Aluguel a WHERE a.idUsuario = :idUsuario");
        q.setParameter("idUsuario", usr);
        Aluguel aluguelUsuario = (Aluguel) q.getSingleResult();
        return aluguelUsuario;
    }

    @Override
    public void commitTransacao() 
    {
        try
        {
            System.out.println("Commitando transação");
            this.et.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public List<Aluguel> getAlugueisUsuario(Usuario usr) 
    {    
        Query q = this.em.createQuery("SELECT a FROM Aluguel a WHERE a.idUsuario = :idUsuario");
        q.setParameter("idUsuario", usr);
        List<Aluguel> alugueisUsuario = q.getResultList();
        return alugueisUsuario;
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
