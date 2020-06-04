package br.com.sistema.Bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.sistema.dao.UsuarioDAO;
import br.com.sistema.domain.Pessoa;
import br.com.sistema.domain.Usuario;


@ManagedBean
@SessionScoped
public class AutenticacaoBean {
 private Usuario usuario;
 
 private Usuario usuarioLogado;
 private Usuario usuarioDeslogado;

 
 
  
 public Usuario getUsuarioLogado() {
	return usuarioLogado;
}
 
 public void setUsuarioLogado(Usuario usuarioLogado) {
	this.usuarioLogado = usuarioLogado;
}
 
 public Usuario getUsuarioDeslogado() {
	return usuarioDeslogado;
}
 
 public void setUsuarioDeslogado(Usuario usuarioDeslogado) {
	this.usuarioDeslogado = usuarioDeslogado;
}
 public Usuario getUsuario() {
	return usuario;
}
 
 public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
 

 @PostConstruct
 public void iniciar(){
	 usuario = new Usuario();
	 usuario.setPessoa(new Pessoa());
	
 }
 
 
 public void autenticar(){
	 try{
		 
		UsuarioDAO usuariodao = new UsuarioDAO();
		usuarioLogado = usuariodao.autenticar(usuario.getPessoa().getCpf(), usuario.getSenha());

		
		if(usuarioLogado == null ){
			Messages.addGlobalError("ERRO DE ACESSO");
			return;
		}
		 
	 Faces.redirect("./pages/principal.xhtml");
	 }catch(IOException erro){
		 
		 erro.printStackTrace();
	 }
 }
 
 public boolean temPermissoes(List<String> permissoes){		
		for(String permissao : permissoes){
			if(usuarioLogado.getTipo() == permissao.charAt(0)){
				return true;
			}
		} 
		
		return false;
	}
 
 
 public void logout() {
		 
	 try{
		 
		 FacesContext fc = FacesContext.getCurrentInstance();
	        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
	        session.invalidate();
			 
		 Faces.redirect("");
		 }catch(IOException erro){
			 erro.printStackTrace();
		 }
	 return;
	}
 
 public void timeout() throws IOException {
	    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	    FacesContext.getCurrentInstance().getExternalContext();
	    Faces.redirect("");

	}
 
}
