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

	public JDBCUtenteController() { }

  @Override
	public Utente login(String u, String p) {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    Utente utente = null;

    try {
      con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/gamingplatform", "root", "root" );

      st = con.createStatement();
      rs = st.executeQuery("SELECT t.*, "
            + "tk.name AS title_kind_name  "
          + "FROM title t INNER JOIN title_kind tk "
          + "WHERE t.title_kind_id = tk.title_kind_id "
          + "ORDER BY t.name");

      while (rs.next()){
        String username = rs.getString("Username");
        String email = rs.getString("Email");
        String password = rs.getString("Password");
        String nome = rs.getString("Nome");
        String cognome = rs.getString("Cognome");
        int livello = rs.getInt("Livello");
        int pe = rs.getInt("PE");

        utente = new Utente(username, nome, cognome, email, password, livello, pe);
      }

    } catch (SQLException e) {
      e.printStackTrace();
      return new Utente();
    } finally {
            if (rs!=null) {
                try {
                   rs.close();
                } catch (SQLException e) {/*Do Nothing*/}
            }
            if (st!=null) {
                try {
                   st.close();
                } catch (SQLException e) {/*Do Nothing*/}
            }
            if (con!=null) {
                try {
                   con.close();
                } catch (SQLException e) {/*Do Nothing*/}
            }
         }

    return utente;
  }

  @Override
	public boolean signup(String username, String email, String password) {
    Connection con = null;
    PreparedStatement ps = null;

    try {
      con = DriverManager.getConnection( "jdbc:mysql://localhost/gamingplatform", "root", "root" );

      String sql = "INSERT INTO utente(title_id, name, title_kind_id, "
            + "description, author, isbn, publication_year, editor)"
            + "VALUES(NULL,?,?,?,?,?,?,?)";

      ps = con.prepareStatement(sql);
      ps.setString( 1, username);
      ps.setString( 2, email);
      ps.setString( 3, password);

      ps.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    } finally {
      if (ps!=null) {
          try {
             ps.close();
          } catch (SQLException e) {/*Do Nothing*/}
      }
      if (con!=null) {
          try {
             con.close();
          } catch (SQLException e) {/*Do Nothing*/}
      }
   }

		return true;
	}

	public void play() {
	}

	public void getReview() {
	}

  public boolean setReview(String idG, String recensione) {
    //aggiorno la recensione nel database
    return true;
  }

  public boolean setRating(int punteggio) {
    return true;
  }

	public void rating() {
	}

}
