package filmesSpring.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import filmesSpring.models.Clientes;
import filmesSpring.models.Vendas;
import filmesSpring.models.Filmes;

public class VendaDAO {
	private Connection connection;

	public VendaDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Vendas venda) {

		String sql = "insert into vendas (clienteID, filmeID, dataVenda, status) values ( ?, ?, ?, ?);";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			Calendar calen = Calendar.getInstance();
			Long calendario = calen.getTimeInMillis();

			stmt.setLong(1, venda.getCliente().getId());
			stmt.setLong(2, venda.getFilme().getId());
			stmt.setDate(3, new java.sql.Date(calendario));
			stmt.setString(4, venda.getStatus());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Vendas> getAcessiveis() {
		List<Vendas> vendas = new ArrayList<Vendas>();

		try {

			PreparedStatement stmt = this.connection.prepareStatement("select * from vendas;");
			ResultSet rs = stmt.executeQuery();

			Calendar dataVenda = Calendar.getInstance();
			stmt.setDate(1, new Date(dataVenda.getTimeInMillis() - 14 * 24 * 60 * 60 * 1000));

			while (rs.next()) {
				Vendas venda1 = new Vendas();

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataVenda"));
				venda1.setDataVenda(data);
				Clientes cliente = new ClienteDAO().getById(rs.getLong("clienteID"));
				Filmes filme = new FilmeDAO().getById(rs.getLong("filmeID"));
				venda1.setCliente(cliente);
				venda1.setFilme(filme);
				venda1.setId(rs.getLong("id"));

				vendas.add(venda1);

			}
			rs.close();

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendas;
	}

	public List<Vendas> getLista() {
		try {

			List<Vendas> venda = new ArrayList<Vendas>();
			PreparedStatement stmt = connection.prepareStatement("select * from vendas;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				venda.add(formacaoVenda(rs));

			}
			rs.close();
			stmt.close();
			return venda;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Vendas getVendasByID(Long id) {
		try {

			Vendas venda = null;
			ClienteDAO cDAO = new ClienteDAO();
			FilmeDAO fDAO = new FilmeDAO();
			PreparedStatement stmt = this.connection.prepareStatement("select * from vendas where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				venda = new Vendas();
				venda.setId(rs.getLong("id"));
				venda.setCliente(cDAO.getById(rs.getLong("clienteID")));
				venda.setFilme(fDAO.getById(rs.getLong("filmeID")));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataVenda"));
				venda.setDataVenda(data);
			}

			rs.close();
			stmt.close();
			return venda;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public boolean alterarStatus(Vendas venda) {
		String sql = "update vendas set status=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, venda.getStatus());
			stmt.setLong(2, venda.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private Vendas formacaoVenda(ResultSet rs) throws SQLException {
		Vendas venda = new Vendas();

		Clientes cliente = new ClienteDAO().getById(rs.getLong("clienteID"));
		venda.setCliente(cliente);
		Filmes filme = new FilmeDAO().getById(rs.getLong("filmeID"));
		venda.setFilme(filme);

		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataVenda"));
		venda.setDataVenda(data);

		venda.setStatus(rs.getString("status"));
		venda.setId(rs.getLong("id"));
		return venda;
	}

}