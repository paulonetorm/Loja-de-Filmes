package filmesSpring.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import filmesSpring.models.Clientes;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Clientes cliente) {

		String sql = "insert into clientes (nome, email, endereco, dataNascimento) values (?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());

			stmt.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Clientes> getLista() {
		List<Clientes> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Clientes cliente = new Clientes();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				cliente.setDataNascimento(data);

				// adicionando o objeto � lista
				result.add(cliente);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Clientes cliente) {
		String sql = "update clientes set nome=?, email=?, endereco=?, dataNascimento=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Clientes cliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from clientes where id=?;");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Clientes getById(Long id) {
		Clientes result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Contato
				result = new Clientes();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setEmail(rs.getString("email"));
				result.setEndereco(rs.getString("endereco"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	

}
