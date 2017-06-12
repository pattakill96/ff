package persona.utente.controller;

import java.sql.Connection;
import persona.utente.model.Level;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import gioco.model.Gioco;
import persona.utente.UtenteManager;
import persona.utente.model.Utente;
import recensione.model.Recensione;
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

			String sql = "INSERT INTO utente(Username, Email, Password, Nome, Cognome)" + "VALUES(?, ?, ?, ?, ?)";

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
    @Override
	public boolean play(Utente utente, Gioco gioco) {
    	Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

			String sql = "INSERT INTO giocato(Codice, Utente, Gioco, Ore)" + "VALUES(?, ?, ?, ?)";

			ps = con.prepareStatement(sql);
			LocalDateTime data = LocalDateTime.now();
			String cod=data.getYear()+"-"+data.getMonthValue()+"-"+data.getDayOfMonth()+"-"+data.getHour()+"."+data.getMinute()+"."+data.getSecond();
			ps.setString(1, cod);
			ps.setString(2, utente.getUsername());
			ps.setString(3, gioco.getNome());
			ps.setInt(4, 1);
		

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
		
		con = null;
		ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

			String sql = "UPDATE utente SET PE=(?) WHERE utente.Username='"+utente.getUsername()+"' ";

			ps = con.prepareStatement(sql);
			ps.setInt(1, utente.getPe()+100);
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
		if(utente.getPe()/1000!=utente.getLivello()){
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

				String sql = "UPDATE utente SET Livello=(?) WHERE utente.Username='"+utente.getUsername()+"' ";

				ps = con.prepareStatement(sql);
				ps.setInt(1, utente.getPe()/1000);
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
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

				String sql = "INSERT INTO premio(Codice,Livello,Utente) VALUES(?,?,?)";
				ps = con.prepareStatement(sql);
				LocalDate d1= LocalDate.now();
				String data=d1.getYear()+"-"+d1.getMonthValue()+"-"+d1.getDayOfMonth();
				ps.setString(1, data);
				ps.setInt(2, utente.getPe()/1000);
				ps.setString(3, utente.getUsername());
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
			
		}
			
    	return true;
    	
    	
	}

	public void getReview() {
	}
	

	@Override 
		public ArrayList<Utente> getUsers() {
		ArrayList<Utente> lista = new ArrayList<Utente>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			st = con.createStatement();
			rs = st.executeQuery("SELECT * " + "FROM utente ");

			while (rs.next()) {
				String username = rs.getString("Username");
				String email = rs.getString("Email");
				String password = rs.getString("Password");
				String nome = rs.getString("Nome");
				String cognome = rs.getString("Cognome");
				int livello = rs.getInt("Livello");
				int pe = rs.getInt("PE");

				Utente utente = new Utente(username, email, password, nome, cognome, livello, pe);
				lista.add(utente);
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

	public boolean setReview(Recensione recensione) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/gamingplatform", "root", "");

			String sql = "INSERT INTO recensione(Utente, Gioco, Voto, Descrizione,DataPubblicazione,Stato)" + "VALUES(?, ?, ?, ?, ?,0)";

			ps = con.prepareStatement(sql);
			ps.setString(1, recensione.getUtente());
			ps.setString(2, recensione.getGioco());
			ps.setInt(3, recensione.getVoto());
			ps.setString(4, recensione.getDescrizione());
			ps.setString(5, recensione.getData());
			
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


	public void leveling(Utente utente) {
		ArrayList<Level> lista = new ArrayList<Level>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamingplatform", "root", "");

			st = con.createStatement();
			rs = st.executeQuery("SELECT premio.Codice premio.Livello trofeo.Nome " + "FROM premio INNER JOIN trofeo ON premio.Livello=trofeo.Livello WHERE premio.Utente='"+utente.getUsername()+"' ");

			while (rs.next()) {
				String codice = rs.getString("Codice");
				int livello = rs.getInt("Livello");
				String nome = rs.getString("Nome");
				

				Level level = new Level(codice,livello,nome);
				lista.add(level);
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
	
	return null;
	}

}
