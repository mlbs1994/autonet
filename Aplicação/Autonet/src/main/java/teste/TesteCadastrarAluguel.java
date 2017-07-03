package teste;

import java.util.Date;
import modelo.Aluguel;
import modelo.Carro;
import modelo.Usuario;
import servico.AluguelServicoDAO;
import servico.CarroServicoDAO;
import servico.CategoriaServicoDAO;
import servico.FabricanteServicoDAO;
import servico.UsuarioServicoDAO;


public class TesteCadastrarAluguel
{
     
    
    
    
    public static void main(String args[])
    {
        try
        {
            AluguelServicoDAO aluguelServicoDAO = new AluguelServicoDAO();
            UsuarioServicoDAO usuarioServico = new UsuarioServicoDAO();
            CategoriaServicoDAO categoriaServico = new CategoriaServicoDAO();
            FabricanteServicoDAO fabricanteServico = new FabricanteServicoDAO();
            CarroServicoDAO carroServico = new CarroServicoDAO();
            
            Aluguel a = new Aluguel();
            Date dataAluguel = new Date();
            Date dataDevolucao = new Date();
            float totalAluguel = 200.00f;
            
            Carro carro = carroServico.getCarro(1);  
            Usuario usuario = usuarioServico.getUsuario(5);
            
        
            a.setDataAluguel(dataAluguel);
            a.setDataDevolução(dataDevolucao);
            a.setTotalAluguel(totalAluguel);
            a.setIdCarro(carro);
            a.setIdUsuario(usuario);
            
            aluguelServicoDAO.cadastrarAluguel(a);
            aluguelServicoDAO.commitTransacao();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        
    }

}


