package persona.utente;

import persona.utente.model.Utente;

public interface UtenteManager {

	public Utente login(String email, String password);
	
	public Utente signup(String username, String email, String password, String nome, String cognome);
	
	public void play();
	
	public void getReview();
	
	public boolean setReview(String idG, String recensione);
	
	public boolean setRating(int punteggio);
	
	public void rating();

}
