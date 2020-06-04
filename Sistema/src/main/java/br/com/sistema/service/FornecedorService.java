package br.com.sistema.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.sistema.dao.FornecedorDAO;
import br.com.sistema.domain.Fornecedor;

@Path("fornecedor")
public class FornecedorService {
	//http://localhost:8080/Sistema/rest/fornecedor
	@GET
	public String listar() {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		List<Fornecedor> fornecedores = fornecedorDAO.listar("nome");
		
		Gson gson = new Gson();
		String json = gson.toJson(fornecedores);
		
		return json;
		
	}
	//http://localhost:8080/Sistema/rest/fornecedor/5
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor fornecedore = fornecedorDAO.buscar(codigo);
		
		Gson gson = new Gson();
		String json = gson.toJson(fornecedore);
		
		return json;
		
	}
	
	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		Fornecedor fornecedor = gson.fromJson(json, Fornecedor.class);
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.merge(fornecedor);
		
		
		String jsonSaida = gson.toJson(fornecedor);
		return jsonSaida;
	}
	
	@PUT
	public String editar(String json) {
		Gson gson = new Gson();
		Fornecedor fornecedor = gson.fromJson(json, Fornecedor.class);
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.editar(fornecedor);
		
		
		String jsonSaida = gson.toJson(fornecedor);
		return jsonSaida;
	}


}
