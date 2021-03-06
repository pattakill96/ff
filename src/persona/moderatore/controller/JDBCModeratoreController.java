package persona.moderatore.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import persona.moderatore.ModeratoreManager;
import persona.moderatore.model.Moderatore;

import persona.utente.model.Utente;
import recensione.model.Recensione;

// TODO: Auto-generated Javadoc
/**
 * The Class JDBCModeratoreController.
 */
public class JDBCModeratoreController implements ModeratoreManager {

	/**
	 * Instantiates a new JDBC moderatore controller.
	 */
	public JDBCModeratoreController() {
	}

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#login(java.lang.String, java.lang.String)
	 */
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

	public String isAdmin(String u, String p){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String b=null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			st = con.createStatement();
			rs = st.executeQuery("SELECT Admin " + "FROM moderatore " + "WHERE moderatore.Username='" + u
					+ "' AND moderatore.Password='" + p + "'");

			while (rs.next()) {
				b = rs.getString("Admin");

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return b;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					return b;
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

		return b;
		
	}
	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#acceptReview(recensione.model.Recensione, persona.moderatore.model.Moderatore)
	 */
	public boolean acceptReview(Recensione recensione, Moderatore moderatore) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

			String sql = "UPDATE recensione SET Stato=(?), Moderatoda=(?)" + "WHERE recensione.Gioco='"
					+ recensione.getGioco() + "'  AND recensione.Utente='" + recensione.getUtente() + "'";

			ps = con.prepareStatement(sql);
			ps.setString(1, "1");
			ps.setString(2, moderatore.getUsername());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					return false;
					/* Do Nothing */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					return false;
					/* Do Nothing */}
			}
		}

		return true;
	}

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#deleteReview(recensione.model.Recensione, persona.moderatore.model.Moderatore)
	 */
	public boolean deleteReview(Recensione recensione, Moderatore moderatore) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

			String sql = "DELETE FROM recensione WHERE recensione.Gioco='" + recensione.getGioco()
					+ "'  AND recensione.Utente='" + recensione.getUtente() + "'";

			ps = con.prepareStatement(sql);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					return false;
					/* Do Nothing */}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					return false;
					/* Do Nothing */}
			}
		}

		return true;
	}

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#getMods()
	 */
	@Override
	public ArrayList<Moderatore> getMods() {
		ArrayList<Moderatore> lista = new ArrayList<Moderatore>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			st = con.createStatement();
			rs = st.executeQuery("SELECT * " + "FROM moderatore WHERE Admin is null");

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

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#promoteUser(persona.utente.model.Utente)
	 */
	public boolean promoteUser(Utente utente) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			String sql = ("DELETE FROM utente WHERE utente.Username='" + utente.getUsername() + "'");
			String sql1 =("DELETE FROM recensione WHERE recensione.Utente='" + utente.getUsername() + "'");

			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps = con.prepareStatement(sql1);
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

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#demoteUser(persona.moderatore.model.Moderatore)
	 */
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
