package persona.utente;

import persona.utente.model.Utente;
import java.util.*;
import gioco.model.*;

public interface UtenteManager {

	public Utente login(String username, String password);
	
	public Utente signup(String username, String email, String password, String nome, String cognome);
	
	public void play();
	
	public void getReview(); 
	
	public ArrayList<Gioco> getGames();
	
	public boolean setReview(String idG, String recensione);
	
	public boolean setRating(int punteggio);
	
	public void rating();

}
