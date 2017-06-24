package persona.moderatore;

import persona.moderatore.model.Moderatore;
import persona.utente.model.Utente;
import recensione.model.Recensione;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Interface ModeratoreManager.
 */
public interface ModeratoreManager {

	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the moderatore
	 */
	public Moderatore login(String username, String password);

	/**
	 * Accept review.
	 *
	 * @param recensione the recensione
	 * @param moderatore the moderatore
	 * @return true, if successful
	 */
	public boolean acceptReview(Recensione recensione,Moderatore moderatore); // TODO model di recensioni

	/**
	 * Delete review.
	 *
	 * @param recensione the recensione
	 * @param moderatore the moderatore
	 * @return true, if successful
	 */
	public boolean deleteReview(Recensione recensione,Moderatore moderatore); // TODO model di recensioni
	
	/**
	 * Gets the mods.
	 *
	 * @return the mods
	 */
	public ArrayList<Moderatore> getMods();
	
	/**
	 * Promote user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean promoteUser(Utente user);

	/**
	 * Demote user.
	 *
	 * @param moderator the moderator
	 * @return true, if successful
	 */
	public boolean demoteUser(Moderatore moderator);

}
