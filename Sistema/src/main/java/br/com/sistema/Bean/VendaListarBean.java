package br.com.sistema.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;


import br.com.sistema.dao.VendaDAO;
import br.com.sistema.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
@RequestScoped
public class VendaListarBean implements Serializable{
	
	private Venda venda;
	private List<Venda> vendas;
	private ArrayList<Venda> vendasFiltrados;
	
	public ArrayList<Venda> getVendasFiltrados() {
		return vendasFiltrados;
	}
	
	public void setVendasFiltrados(ArrayList<Venda> vendasFiltrados) {
		this.vendasFiltrados = vendasFiltrados;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public List<Venda> getVendas() {
		return vendas;
	}
	
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	
	@PostConstruct
	public void listar() {
		try {
			VendaDAO vendaDAO = new VendaDAO();
			vendas = vendaDAO.listar("codigo");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as Vendas");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			venda = (Venda) evento.getComponent().getAttributes().get("vendaSelecionada");

			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.excluir(venda);

			vendas = vendaDAO.listar();

			Messages.addGlobalInfo("Venda removida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a venda");
			erro.printStackTrace();
		}
	}

}
