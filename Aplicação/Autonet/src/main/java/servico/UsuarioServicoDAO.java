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
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Usuario;

/**
 *
 * @author Matheus Levi
 */
public class UsuarioServicoDAO implements UsuarioDAO
{
    
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;
    
    public UsuarioServicoDAO()
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
    public Integer cadastrarUsuario(Usuario u) 
    {
        this.em.persist(u);
        this.em.flush();
        return u.getIdUsuario();
    }

    @Override
    public Usuario getUsuario(Integer id)
    {
        return this.em.find(Usuario.class, id);
    }
    
    public Usuario getUsuario(Usuario usuario)
    {
        return this.em.find(Usuario.class, usuario);
    }
    
    public Integer cadastrarCliente(Cliente c)
    {
        this.em.persist(c);
        this.em.flush();
        return c.getIdCliente();
    }
    
    public Integer cadastrarFuncionario(Funcionario f)
    {
        this.em.persist(f);
        this.em.flush();
        return f.getIdFuncionario();
    }
    
    public Cliente getCliente(Integer idCliente)
    {
        return this.em.find(Cliente.class, idCliente);
    }
    
    public Funcionario getFuncionario(Funcionario f)
    {
        return this.em.find(Funcionario.class, f);
    }

    @Override
    public void atualizarUsuario(Usuario u)
    {
        this.em.merge(u);
    }

    @Override
    public void removerUsuario(Usuario a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> getListaUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Usuario autenticarUsuario(String login, String senha)
    {
       Usuario usuario = null; 
       Query q = this.em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha");
       q.setParameter("login", login);
       q.setParameter("senha", senha);
       List<Usuario> usr =  q.getResultList();
       
       if(!(usr.isEmpty()))
       {
           usuario = usr.get(0);
       }
       
       
       if(usuario==null)
       {
           System.out.print("FALSE");
    
       }
       else
       {
           System.out.print("TRUE");
       }
       
       return usuario;
       
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
