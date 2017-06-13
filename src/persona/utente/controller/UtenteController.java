package persona.utente.controller;

import java.util.ArrayList;
import java.util.logging.Level;

import gioco.model.Gioco;
import persona.utente.UtenteManager;
import persona.utente.controller.JDBCUtenteController;
import persona.utente.model.Utente;
import recensione.model.Recensione;

public class UtenteController implements UtenteManager {

	public UtenteController() {
		JDBCUtenteController jdbcUtente = new JDBCUtenteController();
	}

	public Utente login(String username, String password) {
		return null;
	}

	public Utente signup(String username, String email, String password, String nome, String cognome) {
		return null;
	}

	public boolean play(Utente utente,Gioco gioco) {
		return true;
	}

	public void getReview() {
	}
	
	public ArrayList<Utente> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean setReview(Recensione recensione) {
		// aggiorno la recensione nel database
		return true;
	}

	public ArrayList<String[]> leveling(Utente utente) {
		return null;
	}

}
