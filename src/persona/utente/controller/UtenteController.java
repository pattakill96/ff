package persona.utente.controller;

import persona.utente.UtenteManager;
import persona.utente.controller.JDBCUtenteController;
import persona.utente.model.Utente;

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
