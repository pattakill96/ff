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

	public JDBCModeratoreController() { }

  @Override
	public Moderatore login(String u, String p) {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    Moderatore moderatore = null;

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

        moderatore = new Moderatore(username, nome, cognome, email, password);
      }

    } catch (SQLException e) {
      e.printStackTrace();
      return new Moderatore();
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

    return new Moderatore("username", "nome", "cognome", "email", "password");
  }

  public boolean acceptReview() {
    return true;
  }
  public boolean deleteReview() {
    return true;
  }

	public boolean promoteUser(Utente user) {
    return true;
  }
	public boolean demoteUser(Moderatore moderator) {
    return true;
  }

}
