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
import modelo.Categoria;
import modelo.Fabricante;

/**
 *
 * @author Matheus Levi
 */
public class FabricanteServicoDAO implements FabricanteDAO
{

    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    
    public FabricanteServicoDAO()
    {
        try
        {
            System.out.println("Iniciando FabricanteServicoDAO");
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
    public void cadastrarFabricante(Fabricante f) {
        this.em.persist(f);
    }

    @Override
    public Fabricante getFabricante(Integer id) {
       return this.em.find(Fabricante.class, id);
    }

    @Override
    public void atualizarFabricante(Fabricante f) {
        this.em.merge(f);
    }

    @Override
    public void removerFabricante(Fabricante f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fabricante> getListaFabricantes() {
        Query q = this.em.createQuery("SELECT f FROM Fabricante f ORDER BY f.nome");
        System.out.println("Criado query");
        List<Fabricante> fabricantes =  q.getResultList();
        System.out.println("Pegando o resultList");
        System.out.println("Fabricante = "+fabricantes.get(0).getNome());
        return fabricantes;
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
