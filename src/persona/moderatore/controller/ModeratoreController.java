package persona.moderatore.controller;

import java.util.ArrayList;

import persona.moderatore.ModeratoreManager;
import persona.moderatore.controller.JDBCModeratoreController;
import persona.moderatore.model.Moderatore;
import persona.utente.model.Utente;

public class ModeratoreController implements ModeratoreManager {

	public ModeratoreController() {
		JDBCModeratoreController jdbcModeratore = new JDBCModeratoreController();
	}

	public Moderatore login(String username, String password) {
		return null;
	}


	public boolean acceptReview() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteReview() {
		// TODO Auto-generated method stub
		return false;
	}
	public ArrayList<Utente> showusers() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean promoteUser(Utente user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean demoteUser(Moderatore moderator) {
		// TODO Auto-generated method stub
		return false;
	}

}
