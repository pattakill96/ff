package gioco.controller;

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
import gioco.GiocoManager;
import gioco.model.Gioco;

public class JDBCGiocoController implements GiocoManager {

	public JDBCGiocoController() {
	}

	@Override
	
		public ArrayList<Gioco> getGames(){
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

					Gioco gioco = new Gioco(nome);
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


