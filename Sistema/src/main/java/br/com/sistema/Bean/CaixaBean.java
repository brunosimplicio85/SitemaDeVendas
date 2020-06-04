package br.com.sistema.Bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.sistema.dao.CaixaDAO;
import br.com.sistema.dao.FuncionarioDAO;
import br.com.sistema.domain.Caixa;
import br.com.sistema.domain.Funcionario;




@ManagedBean
@ViewScoped
public class CaixaBean {
	private ScheduleModel caixas;
	private Caixa caixa;
	private List<Funcionario>funcionarios;
	
	private List<Caixa> listaEvento;
	
	public List<Caixa> getListaEvento() {
		return listaEvento;
	}
	
	public void setListaEvento(List<Caixa> listaEvento) {
		this.listaEvento = listaEvento;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public Caixa getCaixa() {
		return caixa;
	}
	
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	
	public ScheduleModel getCaixas() {
		return caixas;
	}
	
	public void setCaixas(ScheduleModel caixas) {
		this.caixas = caixas;
	}	
	
	
	@PostConstruct
	public void listar() {
		caixa = new Caixa();
		CaixaDAO caixaDAO = new CaixaDAO();
        caixas = new DefaultScheduleModel();
        //caixa.getDataAbertura();
        
        listaEvento = caixaDAO.listar();
        //caixaDAO.listar(listaEvento);
        
        for(Caixa ca : listaEvento){
        	DefaultScheduleEvent event = new DefaultScheduleEvent();
        	event.setEndDate(ca.getDataAbertura());
        	
        	caixas.addEvent(event);
        	
        }
    }
	
	public void novo(SelectEvent evento ) {	
		caixa = new Caixa();
		caixa.setDataAbertura((Date)evento.getObject());
		FuncionarioDAO funcionariodoa = new FuncionarioDAO();
		funcionarios = funcionariodoa.listar();
		
	}
	
	public void salvar() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(caixa.getDataAbertura());
		calendar.add(Calendar.DATE, 1);
		caixa.setDataAbertura(calendar.getTime());
		
		CaixaDAO caixaDAO = new CaixaDAO();
		caixaDAO.salvar(caixa);
		Messages.addGlobalInfo("Caixa aberto com sucesso");		
	}

}
