
package servico;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.Carro;
import modelo.Fabricante;
import modelo.Imagem;


public class ImagemServicoDAO implements ImagemDAO
{
    
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    
    public ImagemServicoDAO()
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
    public void cadastrarImagem(Imagem i) {
        this.em.persist(i);
    }

    @Override
    public Imagem getImagem(Integer id) {
        return this.em.find(Imagem.class, id);
    }

    @Override
    public void atualizarImagem(Imagem i) {
        this.em.merge(i);
    }

    @Override
    public void removerImagem(Imagem i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Imagem> getListaImagems() {
        Query q = this.em.createQuery("SELECT i FROM Imagem i f ORDER BY i.img");
        System.out.println("Criado query");
        List<Imagem> imagens =  q.getResultList();
        System.out.println("Pegando o resultList");
        return imagens;
    }

    @Override
    public List<Imagem> getListaImagensCarro(Carro c) 
    {
        Query q = this.em.createQuery("SELECT i FROM Imagem i WHERE i.idCarro = :idCarro");
        q.setParameter("idCarro", c);

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
    
}
