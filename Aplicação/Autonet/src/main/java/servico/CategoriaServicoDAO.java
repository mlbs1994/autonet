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
import modelo.Carro;
import modelo.Categoria;

/**
 *
 * @author Matheus Levi
 */
public class CategoriaServicoDAO implements CategoriaDAO {

    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    
    public CategoriaServicoDAO()
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
    public void cadastrarCategoria(Categoria c) {
        this.em.persist(c);
    }

    @Override
    public Categoria getCategoria(Integer id) {
       return this.em.find(Categoria.class, id);
    }

    @Override
    public void atualizarCategoria(Categoria c) {
        this.em.persist(c);
    }

    @Override
    public void removerCategoria(Categoria a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> getListaCategorias() {
        Query q = this.em.createQuery("SELECT c FROM Categoria c ORDER BY c.nome");
        System.out.println("Criado query");
        List<Categoria> categorias =  q.getResultList();
        System.out.println("Pegando o resultList");
        System.out.println("Categoria = "+categorias.get(0).getNome());
        return categorias;
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
