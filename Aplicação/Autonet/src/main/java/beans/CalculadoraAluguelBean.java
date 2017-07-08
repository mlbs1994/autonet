/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author Matheus Levi
 */
@ManagedBean(name="calculadoraBean")
@ViewScoped
public class CalculadoraAluguelBean {

    @ManagedProperty(name="aBean", value="#{aluguelBean}")
    private AluguelBean aBean;
    
    @ManagedProperty(name="carBean", value="#{carroBean}")
    private CarroBean carBean;
    
    public CalculadoraAluguelBean() 
    {
    }

    public AluguelBean getaBean() {
        return aBean;
    }

    public void setaBean(AluguelBean aBean) {
        this.aBean = aBean;
    }

    public CarroBean getCarBean() {
        return carBean;
    }

    public void setCarBean(CarroBean carBean) {
        this.carBean = carBean;
    }
    
    public void calcularTotalAluguel() throws Exception
    {
        Date dataAluguel = this.aBean.getDataAluguel();
        Date dataDevolucao = this.aBean.getDataDevolucao();
        float carroValorAluguelDiaria = this.carBean.getCarroValorDiaria();
        
               
        if(dataAluguel.compareTo(dataDevolucao)==0)
        {
            this.aBean.setTotalAluguel(carroValorAluguelDiaria);
        }
        else
        {
            int dias = ((Days.daysBetween(new DateTime(dataAluguel), new DateTime(dataDevolucao)).getDays())+1);
            this.aBean.setTotalAluguel(carroValorAluguelDiaria*dias);
        }
    }
}
