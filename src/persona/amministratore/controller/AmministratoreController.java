package persona.amministratore.controller;



import gioco.model.Gioco;
import persona.amministratore.AmministratoreManager;
import persona.amministratore.model.Amministratore;

import persona.moderatore.model.Moderatore;
import persona.utente.model.Utente;


// TODO: Auto-generated Javadoc
/**
 * The Class ModeratoreController.
 */
public class AmministratoreController implements AmministratoreManager {

	/**
	 * Instantiates a new moderatore controller.
	 */
	public AmministratoreController() {
		JDBCAmministratoreController jdbcAmministratore = new JDBCAmministratoreController();
	}

	/* (non-Javadoc)
	 * @see persona.amministratore.AmministratoreManager#login(java.lang.String, java.lang.String)
	 */
	public Amministratore login(String username, String password) {
		return null;
	}

	/* (non-Javadoc)
	 * @see persona.amministratore.AmministratoreManager#deleteUser(utente.model.Utente);
	 */
	public boolean deleteUser(Utente utente) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see persona.amministratore.AmministratoreManager#deleteModeratore(persona.moderatore.model.Moderatore)
	 */
	public boolean deleteModeratore(Moderatore moderatore) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see persona.amministratore.AmministratoreManager#deleteGame(gioco.model.Gioco)
	 */
	public boolean deleteGame(Gioco gioco) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
