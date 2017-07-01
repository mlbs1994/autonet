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
import modelo.Bandeira;


public class BandeiraServicoDAO implements BandeiraDAO
{

    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    
    public BandeiraServicoDAO()
    {
        try
        {
            System.out.println("Iniciando CarroServicoDAO");
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
    public void cadastrarBandeira(Bandeira b)
    {
        this.em.persist(b);
    }

    @Override
    public Bandeira getBandeira(Integer id)
    {
        return this.em.find(Bandeira.class, id);
    }

    @Override
    public void atualizarBandeira(Bandeira b)
    {
        this.em.merge(b);
    }

    @Override
    public void removerBandeira(Bandeira b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bandeira> getListaBandeiras()
    {
        Query q = this.em.createQuery("SELECT b FROM Bandeira b ORDER BY b.nome");
        System.out.println("Criado query");
        List<Bandeira> bandeiras =  q.getResultList();
        System.out.println("Pegando o resultList");
        System.out.println("Bandeira1 = "+bandeiras.get(0).getNome());
        return bandeiras;
    }

    @Override
    public void commitTransacao()
    {
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
