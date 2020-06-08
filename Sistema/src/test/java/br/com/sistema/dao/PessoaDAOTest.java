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
		pessoa.setRg("11111111");
		pessoa.setRua("Das Nissoes");
		pessoa.setNumero(new Short("1307"));
		pessoa.setCidade(cidade);
		pessoa.setBairro("Ponta Aguda");
		pessoa.setCep("89.051-000");
		pessoa.setComplemento("Casa");
		pessoa.setTelefone("(47)3333-3333);
		pessoa.setCelular("(47)99999-9999");
		pessoa.setEmail("bruno@email.com");
		
		
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
		
		System.out.println("Pessoa salvo com sucesso.");
	}

}
