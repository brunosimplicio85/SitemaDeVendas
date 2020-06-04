package br.com.sistema.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//http://localhost:8080/Sistema/rest/
@ApplicationPath("rest")
public class SistemaResourceConfig extends ResourceConfig{
	
	public SistemaResourceConfig(){
		packages("br.com.sistema.service");
	}

}
