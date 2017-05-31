package persona.moderatore;

import persona.moderatore.model.Moderatore;
import persona.utente.model.Utente;

public interface ModeratoreManager {

	public Moderatore login(String email, String password);

  public boolean acceptReview(); //TODO model di recensioni
  public boolean deleteReview(); //TODO model di recensioni

	public boolean promoteUser(Utente user);
	public boolean demoteUser(Moderatore moderator);

}
