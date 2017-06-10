package persona.moderatore.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persona.moderatore.ModeratoreManager;
import persona.moderatore.model.Moderatore;

import persona.utente.UtenteManager;
import persona.utente.model.Utente;

public class JDBCModeratoreController implements ModeratoreManager {

	public JDBCModeratoreController() {
	}

	@Override
	public Moderatore login(String u, String p) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Moderatore moderatore = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			st = con.createStatement();
			rs = st.executeQuery("SELECT * " + "FROM moderatore " + "WHERE moderatore.Username='" + u
					+ "' AND moderatore.Password='" + p + "'");

			while (rs.next()) {
				String username = rs.getString("Username");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				String nome = rs.getString("Nome");
				String cognome = rs.getString("Cognome");

				moderatore = new Moderatore(username, nome, cognome, email, password);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return moderatore;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					return moderatore;
				} catch (SQLException e) {
					/* Do Nothing */}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					/* Do Nothing */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* Do Nothing */}
			}
		}

		return moderatore;
	}

	public boolean acceptReview() {
		return true;
	}

	public boolean deleteReview() {
		return true;
	}

	
	@Override public ArrayList<Moderatore> getMods() {
		ArrayList<Moderatore> lista = new ArrayList<Moderatore>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			st = con.createStatement();
			rs = st.executeQuery("SELECT * " + "FROM moderatore ");

			while (rs.next()) {
				String username = rs.getString("Username");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				String nome = rs.getString("Nome");
				String cognome = rs.getString("Cognome");

				Moderatore moderatore = new Moderatore(username, email, password, nome, cognome);
				lista.add(moderatore);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return lista;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					return lista;
				} catch (SQLException e) {
					/* Do Nothing */}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					/* Do Nothing */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					/* Do Nothing */}
			}
		}

		return lista;
	}
	
	public boolean promoteUser(Utente utente) {
		Connection con = null;
		PreparedStatement ps = null;

		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			String sql = ("DELETE FROM utente WHERE utente.Username='" + utente.getUsername() + "'");
			
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			String sql = "INSERT INTO moderatore(Username, Email, Password, Nome, Cognome)" + "VALUES(?, ?, ?, ?, ?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, utente.getUsername());
			ps.setString(2, utente.getEmail());
			ps.setString(3, utente.getPassword());
			ps.setString(4, utente.getNome());
			ps.setString(5, utente.getCognome());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean demoteUser(Moderatore moderatore) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			String sql = ("DELETE FROM moderatore WHERE moderatore.Username='" + moderatore.getUsername() + "'");
						
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			String sql = "INSERT INTO utente(Username, Email, Password, Nome, Cognome)" + "VALUES(?, ?, ?, ?, ?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, moderatore.getUsername());
			ps.setString(2, moderatore.getEmail());
			ps.setString(3, moderatore.getPassword());
			ps.setString(4, moderatore.getNome());
			ps.setString(5, moderatore.getCognome());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
