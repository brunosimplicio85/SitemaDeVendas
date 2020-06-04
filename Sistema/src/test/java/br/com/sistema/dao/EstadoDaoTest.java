package br.com.sistema.dao;


import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistema.domain.Estado;



public class EstadoDaoTest {
	@Test
	
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		Estado estado2 = new Estado();
		estado2.setNome("Santa Catarina");
		estado2.setSigla("SC");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
		estadoDAO.salvar(estado2);
	}
	
	@Test
	@Ignore
	public void merge(){
		Estado estado = new Estado();
		estado.setNome("Amapá");
		estado.setSigla("AP");
		
		Estado estado2 = new Estado();
		estado2.setNome("Piauí");
		estado2.setSigla("PI");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.merge(estado);
		estadoDAO.merge(estado2);
	}
	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Estado estado : resultado) {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 6L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 5L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	@Test
	@Ignore
	public void editar(){
		Long codigo = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro editado - Antes:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
			
			estado.setNome("Santa Catarina");
			estado.setSigla("SC");
			estadoDAO.editar(estado);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	

}
