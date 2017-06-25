package persona.amministratore.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gioco.model.Gioco;
import persona.amministratore.model.Amministratore;
import persona.amministratore.AmministratoreManager;
import persona.moderatore.model.Moderatore;

import persona.utente.model.Utente;


// TODO: Auto-generated Javadoc
/**
 * The Class JDBCAmministratoreController.
 */
public class JDBCAmministratoreController implements AmministratoreManager {

	/**
	 * Instantiates a new JDBC amministratore controller.
	 */
	public JDBCAmministratoreController() {
	}

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Amministratore login(String u, String p) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Amministratore amministratore = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			st = con.createStatement();
			rs = st.executeQuery("SELECT * " + "FROM moderatore " + "WHERE moderatore.Username='" + u
					+ "' AND moderatore.Password='" + p + "' AND Admin is not NULL");

			while (rs.next()) {
				String username = rs.getString("Username");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				String nome = rs.getString("Nome");
				String cognome = rs.getString("Cognome");

				amministratore = new Amministratore(username, nome, cognome, email, password);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return amministratore;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					return amministratore;
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

		return amministratore;
	}
	/* (non-Javadoc)
	 * @see persona.amministratore.AmministratoreManager#deleteUser(utente.model.Utente);
	 */
	@Override
	public boolean deleteUser(Utente utente) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

			String sql = "DELETE FROM utente WHERE utente.Username='" + utente.getUsername()+"'";
			String sql1="DELETE FROM recensione WHERE recensione.Utente='"+utente.getUsername()+"'";
			String sql2= "DELETE FROM premio WHERE premio.Utente='" + utente.getUsername()+"'";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps = con.prepareStatement(sql1);
			ps.executeUpdate();
			ps = con.prepareStatement(sql2);
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
	 * @see persona.amministratore.AmministratoreManager#deleteModeratore(persona.moderatore.model.Moderatore)
	 */
	@Override
	public boolean deleteModeratore(Moderatore moderatore) {
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

			String sql = "DELETE FROM moderatore WHERE moderatore.Username='" + moderatore.getUsername()+ "'";

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
	 * @see persona.amministratore.AmministratoreManager#deleteGame(gioco.model.Gioco)
	 */
	@Override
	public boolean deleteGame(Gioco gioco) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

			String sql = "DELETE  FROM gioco WHERE gioco.Nome='" + gioco.getNome() + "'";
			String sql1 = "DELETE  FROM recensione WHERE recensione.Gioco='" + gioco.getNome() + "'";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps = con.prepareStatement(sql1);
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

	
}
