package persona.amministratore;

import persona.amministratore.model.Amministratore;
import persona.moderatore.model.Moderatore;
import persona.utente.model.Utente;

import gioco.model.Gioco;

// TODO: Auto-generated Javadoc
/**
 * The Interface ModeratoreManager.
 */
public interface AmministratoreManager {

	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the moderatore
	 */
	public Amministratore login(String username, String password);
	/**
	 * deleteUser.
	 *
	 * @param user the user
	 * @return true or false
	 */
	public boolean deleteUser(Utente utente);
	/**
	 * deleteModeratore.
	 *
	 * @param moderatore the moderatore
	 * @return true or false
	 */
	public boolean deleteModeratore(Moderatore moderatore);
	/**
	 * deleteGame.
	 *
	 * @param game the game
	 * @return true or false
	 */
	public boolean deleteGame(Gioco gioco);
	
	

}
