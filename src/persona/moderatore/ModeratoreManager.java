package persona.moderatore;

import persona.moderatore.model.Moderatore;
import persona.utente.model.Utente;
import java.util.*;

public interface ModeratoreManager {

	public Moderatore login(String username, String password);

	public boolean acceptReview(); // TODO model di recensioni

	public boolean deleteReview(); // TODO model di recensioni
	
	public ArrayList<Utente> showusers();

	public boolean promoteUser(Utente user);

	public boolean demoteUser(Moderatore moderator);

}
