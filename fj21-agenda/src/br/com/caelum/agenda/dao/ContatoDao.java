package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.agenda.model.Contato;

public class ContatoDao {

	private static final String INSERT = "insert into CONTATOS (NOME, EMAIL, ENDERECO, DATANASCIMENTO) values (?, ?, ?, ?)";
	private static final String UPDATE = "update CONTATOS set NOME=?, EMAIL=?, ENDERECO=?, DATANASCIMENTO=? where ID=?";
	private static final String REMOVE = "delete from CONTATOS where ID=?";
	private static final String SEARCH = "select ID, EMAIL, NOME, ENDERECO, DATANASCIMENTO from CONTATOS where ID = ?";
	private static final String FIND_ALL = "select * from CONTATOS";
	private static Connection connection;

	public ContatoDao(Connection connection){
		this.connection = connection;
	}
	
	public ContatoDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adiciona(Contato contato) {
		try (PreparedStatement stmt = this.connection.prepareStatement(INSERT)) {

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato) {

		try (PreparedStatement stmt = connection.prepareStatement(UPDATE)) {

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		try (PreparedStatement stmt = connection.prepareStatement(REMOVE)) {

			stmt.setLong(1, contato.getId());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Contato pesquisa(long id) {

		Contato contato = new Contato();
		contato.setId(id);

		try (PreparedStatement stmt = connection.prepareStatement(SEARCH)) {

			stmt.setLong(1, id);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					contato.setId(rs.getLong("ID"));
					contato.setNome(rs.getString("NOME"));
					contato.setEmail(rs.getString("EMAIL"));
					contato.setEndereco(rs.getString("ENDERECO"));

					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("DATANASCIMENTO"));
					contato.setDataNascimento(data);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return contato;
	}

	public List<Contato> getLista() {

		try (PreparedStatement stmt = this.connection.prepareStatement(FIND_ALL); ResultSet rs = stmt.executeQuery()) {

			List<Contato> contatos = new ArrayList<Contato>();

			while (rs.next()) {

				// criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("ID"));
				contato.setNome(rs.getString("NOME"));
				contato.setEmail(rs.getString("EMAIL"));
				contato.setEndereco(rs.getString("ENDERECO"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("DATANASCIMENTO"));
				contato.setDataNascimento(data);

				// adicionando objeto a lista
				contatos.add(contato);
			}
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
