package persona.moderatore.controller;

import java.util.ArrayList;

import persona.moderatore.ModeratoreManager;
import persona.moderatore.controller.JDBCModeratoreController;
import persona.moderatore.model.Moderatore;
import persona.utente.model.Utente;
import recensione.model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ModeratoreController.
 */
public class ModeratoreController implements ModeratoreManager {

	/**
	 * Instantiates a new moderatore controller.
	 */
	public ModeratoreController() {
		JDBCModeratoreController jdbcModeratore = new JDBCModeratoreController();
	}

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#login(java.lang.String, java.lang.String)
	 */
	public Moderatore login(String username, String password) {
		return null;
	}

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#acceptReview(recensione.model.Recensione, persona.moderatore.model.Moderatore)
	 */
	public boolean acceptReview(Recensione recensione, Moderatore moderatore) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#deleteReview(recensione.model.Recensione, persona.moderatore.model.Moderatore)
	 */
	public boolean deleteReview(Recensione recensione, Moderatore moderatore) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#getMods()
	 */
	public ArrayList<Moderatore> getMods() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#promoteUser(persona.utente.model.Utente)
	 */
	public boolean promoteUser(Utente user) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see persona.moderatore.ModeratoreManager#demoteUser(persona.moderatore.model.Moderatore)
	 */
	public boolean demoteUser(Moderatore moderator) {
		// TODO Auto-generated method stub
		return false;
	}

}
