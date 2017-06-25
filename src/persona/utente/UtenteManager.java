package persona.utente;

import persona.utente.model.Utente;
import recensione.model.Recensione;

import java.util.*;

import gioco.model.*;

// TODO: Auto-generated Javadoc
/**
 * The Interface UtenteManager.
 */
public interface UtenteManager {

	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the utente
	 */
	public Utente login(String username, String password);
	
	/**
	 * Signup.
	 *
	 * @param username the username
	 * @param email the email
	 * @param password the password
	 * @param nome the nome
	 * @param cognome the cognome
	 * @return the utente
	 */
	public Utente signup(String username, String email, String password, String nome, String cognome);
	
	/**
	 * Play.
	 *
	 * @param utente the utente
	 * @param gioco the gioco
	 * @return true, if successful
	 */
	public boolean play(Utente utente,Gioco gioco);
	
	/**
	 * Gets the review.
	 *
	 * @return the review
	 */
	public void getReview(); 
	
	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public ArrayList<Utente> getUsers();
	
	/**
	 * Sets the review.
	 *
	 * @param recensione the recensione
	 * @return true, if successful
	 */
	public boolean setReview(Recensione recensione);

	/**
	 * Leveling.
	 *
	 * @param utente the utente
	 * @return the array list
	 */
	public ArrayList<String[]> leveling(Utente utente);

}
