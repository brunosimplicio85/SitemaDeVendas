package br.com.sistema.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.sistema.dao.ItemVendaDAO;
import br.com.sistema.domain.ItemVenda;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
@RequestScoped
public class ItemVendaBean implements Serializable{
	
	private ItemVenda ivenda;
	private List<ItemVenda> ivendas;
	private ArrayList<ItemVenda> ivendasFiltrados;
	
	public ArrayList<ItemVenda> getIvendasFiltrados() {
		return ivendasFiltrados;
	}
	
	public void setIvendasFiltrados(ArrayList<ItemVenda> ivendasFiltrados) {
		this.ivendasFiltrados = ivendasFiltrados;
	}
	
	public ItemVenda getIvenda() {
		return ivenda;
	}
	
	public void setIvenda(ItemVenda ivenda) {
		this.ivenda = ivenda;
	}
	
	public List<ItemVenda> getIvendas() {
		return ivendas;
	}
	public void setIvendas(List<ItemVenda> ivendas) {
		this.ivendas = ivendas;
	}
	
	@PostConstruct
	public void listar() {
		try {
			ItemVendaDAO ivendaDAO = new ItemVendaDAO();
			ivendas = ivendaDAO.listar("codigo");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as Vendas");
			erro.printStackTrace();
		}
	}
	
	
	

}
