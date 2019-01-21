package filmesSpring.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import filmesSpring.models.Filmes;

public class FilmeDAO {

	private Connection connection;

	public FilmeDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Filmes filme) {

		String sql = "insert into filmes (titulo, genero, diretor, dataLancamento) values (?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, filme.getTitulo());
			stmt.setString(2, filme.getGenero());
			stmt.setString(3, filme.getDiretor());

			stmt.setDate(4, new java.sql.Date(filme.getDataLancamento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Filmes> getLista() {
		List<Filmes> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from filmes;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Filmes filme = new Filmes();
				filme.setId(rs.getLong("id"));
				filme.setTitulo(rs.getString("titulo"));
				filme.setGenero(rs.getString("genero"));
				filme.setDiretor(rs.getString("diretor"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataLancamento"));
				filme.setDataLancamento(data);

				// adicionando o objeto � lista
				result.add(filme);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

//	public boolean alterar(Contato contato) {
//		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?;";
//		try {
//			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setString(1, contato.getNome());
//			stmt.setString(2, contato.getEmail());
//			stmt.setString(3, contato.getEndereco());
//			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
//			stmt.setLong(5, contato.getId());
//			stmt.execute();
//			stmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}

	public boolean remover(Filmes filme) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from filmes where id=?;");
			stmt.setLong(1, filme.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Filmes getById(Long id) {
		Filmes result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from filmes where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Contato
				result = new Filmes();
				result.setId(rs.getLong("id"));
				result.setTitulo(rs.getString("titulo"));
				result.setGenero(rs.getString("genero"));
				result.setDiretor(rs.getString("diretor"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataLancamento"));
				result.setDataLancamento(data);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	

}