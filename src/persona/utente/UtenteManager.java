package persona.utente;

import persona.utente.model.Utente;
import recensione.model.Recensione;

import java.util.*;
import java.util.logging.Level;

import gioco.model.*;

public interface UtenteManager {

	public Utente login(String username, String password);
	
	public Utente signup(String username, String email, String password, String nome, String cognome);
	
	public boolean play(Utente utente,Gioco gioco);
	
	public void getReview(); 
	
	public ArrayList<Utente> getUsers();
	
	public boolean setReview(Recensione recensione);
	

	public void leveling(Utente utente);

}
