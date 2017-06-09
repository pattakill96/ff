import persona.utente.model.Utente;
import persona.utente.UtenteView;
//import persona.utente.controller.UtenteController;
import persona.utente.controller.JDBCUtenteController;

import persona.moderatore.model.Moderatore;
import persona.moderatore.ModeratoreView;
// import persona.moderatore.controller.ModeratoreController;
import persona.moderatore.controller.JDBCModeratoreController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.io.Console;


public class GamingPlatform {

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		// Instantiating user and moderator controllers
	    
		Console cnsl = null;
		Utente utente = null;
		Moderatore moderatore = null;
		// UtenteController utenteController = new UtenteController();
		JDBCUtenteController utenteController = new JDBCUtenteController();
		// ModeratoreController moderatoreController = new ModeratoreController();
		JDBCModeratoreController moderatoreController = new JDBCModeratoreController();

		System.out.print("(1) Login\n(2) Sign Up\n(3) Esci\n\n");
		String line = reader.readLine();

		if (line.equals("1")) {
			while(utente == null || moderatore == null) {
				System.out.println("Sei un moderatore? y/n");
				String moderator = reader.readLine();
	
				System.out.println("Inserisci l'username");
				String username = reader.readLine();
	
				String password = "";
				
				try {
					cnsl = System.console();
					password = cnsl.readPassword("Inserisci la password per il tuo account: ").toString();
				} catch(Exception ex) {
					System.out.println("Inserisci la password per il tuo account");
					password = reader.readLine();
				}
				
				if (moderator.equals("n")) {
					utente = utenteController.login(username, password);
					if (utente == null) {
						System.out.println("Utente non trovato\n");
					} else {
						UtenteView utenteview = new UtenteView();
						utenteview.show(utente);
					}
				} else {
					moderatore = moderatoreController.login(username, password);
					if (moderatore == null) {
						System.out.println("Moderatore non trovato\n");
					} else {
						ModeratoreView moderatoreview = new ModeratoreView();
						moderatoreview.show();
					}
				}	
			}

		} else if (line.equals("2")) {

			System.out.println("Inserisci il tuo username");
			String username = reader.readLine();

			System.out.println("Inserisci la tua email");
			String email = reader.readLine();
			
			String password = "";
			try {
				cnsl = System.console();
				password = cnsl.readPassword("Inserisci la password per il tuo account: ").toString();
			} catch(Exception ex) {
				System.out.println("Inserisci la password per il tuo account");
				password = reader.readLine();
			}
				
			System.out.println("Inserisci il tuo nome");
			String nome = reader.readLine();		
			
			System.out.println("Inserisci il tuo cognome");
			String cognome = reader.readLine();
			
			utente = utenteController.signup(username, email, password, nome, cognome);
			if (utente == null) {
				System.out.println("Problemi nella registrazione");
			} else {
				UtenteView utenteview = new UtenteView();
				utenteview.show(utente);
			}

		} else if (line.equals("3")) {
			System.exit(0);
		}
	}

}
