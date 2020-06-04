package br.com.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistema.domain.Fornecedor;

public class FornecedorDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Fornecedor B");

		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.salvar(fornecedor);
	}

	@Test
	@Ignore
	public void listar() {
		FornecedorDAO FornecedorDAO = new FornecedorDAO();
		List<Fornecedor> resultado = FornecedorDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Fornecedor fornecedor : resultado) {
			System.out.println(fornecedor.getCodigo() + " - " + fornecedor.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 3L;
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDAO.buscar(codigo);
		
		if(fornecedor == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado:");
			System.out.println(fornecedor.getCodigo() + " - " + fornecedor.getNome());
		}
	}
}

