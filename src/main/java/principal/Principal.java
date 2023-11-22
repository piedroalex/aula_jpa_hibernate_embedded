package principal;

import dao.PessoaDAO;
import entities.Endereco;
import entities.Pessoa;

/**
 * @author Pedro Alex
 */
public class Principal {
	
	public static void main(String[] args) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Endereco endereco = new Endereco();
		endereco.setCep("64000-000");
		endereco.setRua("Rua ABC");
		endereco.setBairro("Centro");
		endereco.setCidade("Teresina");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Pedro");
		pessoa.setEndereco(endereco);
		pessoaDAO.salvar(pessoa);
		
		endereco = new Endereco();
		endereco.setCep("65000-000");
		endereco.setRua("Rua 123");
		endereco.setBairro("Centro");
		endereco.setCidade("Timon");
		
		pessoa = new Pessoa();
		pessoa.setNome("Maria");
		pessoa.setEndereco(endereco);
		
		pessoaDAO.salvar(pessoa);
		
		for(Pessoa p: pessoaDAO.listarTodos()) {
			System.out.println(p.toString());
		}
		
	}
}
