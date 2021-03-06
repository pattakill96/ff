package gioco.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import gioco.GiocoManager;
import gioco.model.Gioco;

// TODO: Auto-generated Javadoc
/**
 * The Class JDBCGiocoController.
 */
public class JDBCGiocoController implements GiocoManager {

	/**
	 * Instantiates a new JDBC gioco controller.
	 */
	public JDBCGiocoController() {
	}

	/* (non-Javadoc)
	 * @see gioco.GiocoManager#getGames()
	 */
	@Override

	public ArrayList<Gioco> getGames() {
		ArrayList<Gioco> lista = new ArrayList<Gioco>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			st = con.createStatement();
			rs = st.executeQuery("SELECT * " + "FROM gioco ");

			while (rs.next()) {
				String nome = rs.getString("Nome");
				String descrizione = rs.getString("Descrizione");

				Gioco gioco = new Gioco(nome, descrizione);
				lista.add(gioco);
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

}
