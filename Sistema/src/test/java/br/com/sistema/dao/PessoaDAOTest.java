package br.com.sistema.dao;


import org.junit.Ignore;
import org.junit.Test;

import br.com.sistema.domain.Cidade;
import br.com.sistema.domain.Pessoa;


public class PessoaDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Long codigoCidade = 1L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Bruno Silveira Simplicio");
		pessoa.setCpf("111.111.11-11");
		pessoa.setRg("001139204");
		pessoa.setRua("Das Nissoes");
		pessoa.setNumero(new Short("1307"));
		pessoa.setCidade(cidade);
		pessoa.setBairro("Ponta Aguda");
		pessoa.setCep("89.051-000");
		pessoa.setComplemento("Casa");
		pessoa.setTelefone("(47)3234-4770");
		pessoa.setCelular("(47)99719-3315");
		pessoa.setEmail("bruno.simplicio@outlook.com.com");
		
		
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
		
		System.out.println("Pessoa salvo com sucesso.");
	}

}
