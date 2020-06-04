package br.com.sistema.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


//http://localhost:8080/Sistema/rest/sistema
@Path("sistema")
public class SistemaService {
	
	@GET
	public String exibir(){
		return "Bruno S. Simplicio";
	}

}
