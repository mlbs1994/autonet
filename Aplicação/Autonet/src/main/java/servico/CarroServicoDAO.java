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
import modelo.Fabricante;
import servico.CarroDAO;

/**
 *
 * @author Matheus Levi
 */
public class CarroServicoDAO implements CarroDAO
{
    
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    
    public CarroServicoDAO()
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
    public void cadastrarCarro(Carro c)
    {
        this.em.persist(c);
    }

    @Override
    public Carro getCarro(Integer id)
    {
        Carro c = em.find(Carro.class, id);
        System.out.println("obtendo carro = "+c.getModelo());
        return c;
    }

    @Override
    public void atualizarCarro(Carro c)
    {
        this.em.merge(c);
    }

    @Override
    public void removerCarro(Carro a)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carro> getListaCarros()
    {
        Query q = this.em.createQuery("SELECT c FROM Carro c ORDER BY c.modelo");
        System.out.println("Criado query");
        List<Carro> carros =  q.getResultList();
        System.out.println("Pegando o resultList");
        System.out.println("Carro1 = "+carros.get(0).getModelo());
        return carros;
    }
    
    @Override
    public List<Carro> getListaCarrosCategoria(Categoria ctg) {
       
        Query q = this.em.createQuery("SELECT c FROM Carro c WHERE c.idCategoria = :idCategoria");
        q.setParameter("idCategoria", ctg);

        return q.getResultList();
        
    }

    @Override
    public List<Carro> getListaCarrosFabricante(Fabricante f) {
        
      Query q = this.em.createQuery("SELECT c FROM Carro c WHERE c.idFabricante = :idFabricante");
      q.setParameter("idFabricante", f);

      return q.getResultList();
        
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

    @Override
    public List<Carro> getListaCarrosStatus(String status) {
      Query q = this.em.createQuery("SELECT c FROM Carro c WHERE c.status = :status");
      q.setParameter("status", status);

      return q.getResultList();
    }

    @Override
    public List<Carro> getListaCarrosPalavraChave(String palavraChave) {
      Query q = this.em.createQuery("SELECT c FROM Carro c WHERE c.modelo LIKE :palavraChave");
      q.setParameter("palavraChave", palavraChave);

      return q.getResultList();
    }

    
}
