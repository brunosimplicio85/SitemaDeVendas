package br.com.sistema.Bean;



import java.io.Serializable;
import java.util.Date;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;


import br.com.sistema.dao.VendaDAO;
import br.com.sistema.domain.Historico;
import br.com.sistema.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaPesquisaBean implements Serializable {
	
	private Venda venda;
	private Boolean exibir;
	private Historico historico;
	
		
	public Historico getHistorico() {
		return historico;
	}
	
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}
	
	public Boolean getExibir() {
		return exibir;
	}
	
	public void setExibir(Boolean exibir) {
		this.exibir = exibir;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	@PostConstruct
	public void novo(){
		historico = new Historico();
		venda = new Venda();
		exibir = false;
	}
	
	public void buscar(){
		try{
		venda.setHorario(new Date());
		VendaDAO vendadao = new VendaDAO();
		Venda resultado = vendadao.buscar(venda.getCodigo());
		
		if(resultado == null){
			Messages.addGlobalWarn("Não existe este Produto Cadastrado");
			exibir = false;
		} else{
			exibir = true;
			venda = resultado;
		}
		
		}catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar buscar o Produto");
			erro.printStackTrace();
		}
		
	}

	
}
