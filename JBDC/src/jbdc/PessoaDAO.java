package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
	private Connection connection;

	public PessoaDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC";
		String senha = "root";
		String user = "root";
		connection = DriverManager.getConnection(url, senha, user);

	}

	public int maiorId() throws SQLException {
		int id = 0;

		ResultSet rs = connection.prepareStatement("select max(idpessoa) from pessoa").executeQuery();
		while (rs.next()) {
			id = rs.getInt(1) + 1;
		}
		rs.close();

		return id;

	}

	public Boolean inserir(Pessoa pessoa) throws SQLException {

		String sql = "insert into pessoa values(?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, maiorId());
		ps.setString(2, pessoa.getNome());
		return ps.execute();
	}

	public Boolean inserirId(Pessoa pessoa, int id) throws SQLException {

		String sql = "insert into pessoa values(?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, pessoa.getNome());
		return ps.execute();
	}

	public void deletar(int id) throws SQLException {
		String sql = "delete from pessoa where idpessoa = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		connection.close();
	}

	public void deletarTodos() throws SQLException {
		String sql = "delete from pessoa where idpessoa = idpessoa";
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.execute();
		connection.close();
	}

	public void atualizar(Pessoa pessoa) throws SQLException {
		String sql = "update pessoa set nome = ? where idpessoa = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, pessoa.getNome());
		ps.setInt(2, pessoa.getIdPessoa());
		ps.execute();
		connection.close();
	}

	public List<Pessoa> listarTodos() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();

		String sql = "select * from pessoa";
		ResultSet rs = connection.prepareStatement(sql).executeQuery();

		while (rs.next()) {
			pessoas.add(new Pessoa(rs.getInt("idpessoa"), rs.getString("nome")));
		}
		rs.close();
		return pessoas;
	}

	public Pessoa consultarId(int id) throws SQLException {
		Pessoa pessoa = new Pessoa();
		String sql = "select * from pessoa where idpessoa = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pessoa.setIdPessoa(rs.getInt("idpessoa"));
			pessoa.setNome(rs.getString("nome"));

			System.out.println("----------");
			System.out.println(pessoa);
		}
		rs.close();
		connection.close();
		return pessoa;

	}

	public void closeConnection() throws SQLException {
		connection.close();
	}

	
}
