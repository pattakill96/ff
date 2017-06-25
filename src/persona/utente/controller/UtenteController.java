package persona.utente.controller;

import java.util.ArrayList;

import gioco.model.Gioco;
import persona.utente.UtenteManager;
import persona.utente.controller.JDBCUtenteController;
import persona.utente.model.Utente;
import recensione.model.Recensione;

// TODO: Auto-generated Javadoc
/**
 * The Class UtenteController.
 */
public class UtenteController implements UtenteManager {

	/**
	 * Instantiates a new utente controller.
	 */
	public UtenteController() {
		JDBCUtenteController jdbcUtente = new JDBCUtenteController();
	}

	/* (non-Javadoc)
	 * @see persona.utente.UtenteManager#login(java.lang.String, java.lang.String)
	 */
	public Utente login(String username, String password) {
		return null;
	}

	/* (non-Javadoc)
	 * @see persona.utente.UtenteManager#signup(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Utente signup(String username, String email, String password, String nome, String cognome) {
		return null;
	}

	/* (non-Javadoc)
	 * @see persona.utente.UtenteManager#play(persona.utente.model.Utente, gioco.model.Gioco)
	 */
	public boolean play(Utente utente, Gioco gioco) {
		return true;
	}

	/* (non-Javadoc)
	 * @see persona.utente.UtenteManager#getReview()
	 */
	public void getReview() {
	}

	/* (non-Javadoc)
	 * @see persona.utente.UtenteManager#getUsers()
	 */
	public ArrayList<Utente> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persona.utente.UtenteManager#setReview(recensione.model.Recensione)
	 */
	public boolean setReview(Recensione recensione) {
		// aggiorno la recensione nel database
		return true;
	}

	/* (non-Javadoc)
	 * @see persona.utente.UtenteManager#leveling(persona.utente.model.Utente)
	 */
	public ArrayList<String[]> leveling(Utente utente) {
		return null;
	}

}
