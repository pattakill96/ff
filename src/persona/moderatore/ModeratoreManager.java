package persona.moderatore;

import persona.moderatore.model.Moderatore;
import persona.utente.model.Utente;
import recensione.model.Recensione;

import java.util.*;

public interface ModeratoreManager {

	public Moderatore login(String username, String password);

	public boolean acceptReview(Recensione recensione,Moderatore moderatore); // TODO model di recensioni

	public boolean deleteReview(Recensione recensione,Moderatore moderatore); // TODO model di recensioni
	

	public ArrayList<Moderatore> getMods();
	
	public boolean promoteUser(Utente user);

	public boolean demoteUser(Moderatore moderator);

}
