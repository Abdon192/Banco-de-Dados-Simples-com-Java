package jbdc;

import java.sql.SQLException;
import java.util.Scanner;

public class PrincipalJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		PessoaDAO dao = new PessoaDAO();
		
		

		dao.listarTodos().forEach(p -> {
			System.out.println(p.toString());
		});

		dao.consultarId(5);

		//dao.inserir(new Pessoa("Minato"));

		// dao.inserirId(new Pessoa("Novo"), 4);

		// dao.deletarTodos();

		// dao.deletar(1);
		
		/*Ajustar
		 * Pessoa pessoa = dao.consultarId(1);
		 */
		
		/*Ajustar
		 * pessoa.setNome(pessoa.getNome() + " alterado");
		 dao.atualizar(pessoa);
		 */

		dao.closeConnection();

	}

}
