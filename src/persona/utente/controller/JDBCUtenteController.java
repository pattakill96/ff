package persona.utente.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persona.utente.UtenteManager;
import persona.utente.model.Utente;

public class JDBCUtenteController implements UtenteManager {

	public JDBCUtenteController() {
	}

	@Override
	public Utente login(String u, String p) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Utente utente = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			st = con.createStatement();
			rs = st.executeQuery(
					"SELECT * FROM utente WHERE utente.Username='" + u + "' AND utente.Password='" + p + "'");

			while (rs.next()) {
				String username = rs.getString("Username");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				String nome = rs.getString("Nome");
				String cognome = rs.getString("Cognome");
				int livello = rs.getInt("Livello");
				int pe = rs.getInt("PE");

				utente = new Utente(username, email, password, nome, cognome, livello, pe);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					return null;
					/* Do Nothing */}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					return null;
					/* Do Nothing */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					return null;
					/* Do Nothing */}
			}
		}

		return utente;
	}

	@Override
	public Utente signup(String username, String email, String password, String nome, String cognome) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

			String sql = "INSERT INTO utente(Username, Password, Email, Nome, Cognome)" + "VALUES(?, ?, ?, ?, ?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, nome);
			ps.setString(5, cognome);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					return null;
					/* Do Nothing */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					return null;
					/* Do Nothing */}
			}
		}
		return new Utente(username, email, password, nome, cognome, 0, 0);
	}

	public void play() {
	}

	public void getReview() {
	}

	public boolean setReview(String idG, String recensione) {
		// aggiorno la recensione nel database
		return true;
	}

	public boolean setRating(int punteggio) {
		return true;
	}

	public void rating() {
	}

}
