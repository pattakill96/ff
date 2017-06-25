package recensione.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import recensione.model.*;
import recensione.RecensioneManager;
import gioco.model.Gioco;

// TODO: Auto-generated Javadoc
/**
 * The Class JDBCRecensioneController.
 */
public class JDBCRecensioneController implements RecensioneManager {

	/**
	 * Instantiates a new JDBC recensione controller.
	 */
	public JDBCRecensioneController() {
	}

	/* (non-Javadoc)
	 * @see recensione.RecensioneManager#getAllRec()
	 */
	@Override
	
		public ArrayList<Recensione> getAllRec(){
			ArrayList<Recensione> lista = new ArrayList<Recensione>();
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

				st = con.createStatement();
				rs = st.executeQuery("SELECT * " + "FROM recensione " +"WHERE recensione.Moderatoda is null ORDER BY recensione.DataPubblicazione ASC");

				while (rs.next()) {
					String descrizione = rs.getString("Descrizione");
					int voto = rs.getInt("Voto");
					String utente = rs.getString("Utente");
					String gioco = rs.getString("Gioco");
					Recensione recensione = new Recensione(descrizione,voto,utente,gioco,null);
					lista.add(recensione);
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
	 * @see recensione.RecensioneManager#getRec(gioco.model.Gioco)
	 */
	public ArrayList<Recensione> getRec(Gioco gioco){
		ArrayList<Recensione> lista = new ArrayList<Recensione>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			st = con.createStatement();
			rs = st.executeQuery("SELECT * " + "FROM recensione " +"WHERE recensione.Moderatoda is not null AND recensione.Gioco='"+gioco.getNome() +"' ORDER BY recensione.DataPubblicazione ASC");

			while (rs.next()) {
				String descrizione = rs.getString("Descrizione");
				int voto = rs.getInt("Voto");
				String utente = rs.getString("Utente");
				String gioco1 = rs.getString("Gioco");
				String data =rs.getString("DataPubblicazione");
				Recensione recensione = new Recensione(descrizione,voto,utente,gioco1,data);
				lista.add(recensione);
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

