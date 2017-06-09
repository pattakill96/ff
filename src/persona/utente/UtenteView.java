package persona.utente;

import gioco.model.Gioco;
import persona.utente.model.Utente;
import persona.moderatore.controller.JDBCModeratoreController;
import persona.utente.controller.JDBCUtenteController;
import gioco.controller.JDBCGiocoController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UtenteView {

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	JDBCUtenteController utenteController = new JDBCUtenteController();

	ArrayList<Gioco> giocoList = null;
	
	public UtenteView() {

	}

	public void show(Utente utente) throws IOException {
		System.out.println("\n(1)Visualizza profilo\n(2)Gioca\n(3)Valuta e recensisci gioco\n");
		String line = reader.readLine();
		
		if(line.equals("1")){
			System.out.println("Username:"+utente.getUsername()+"\n"
					+ "Nome:"+utente.getNome()+"\n"
					+"Cognome:"+utente.getCognome()+"\n"
					+"Email:"+utente.getEmail()+"\n"
					+"Livello:"+utente.getLivello()+"\n"
					+"Punti Esperienza:"+utente.getPe()+"\n");
		} else if(line.equals("2")) {
			giocoList = utenteController.getGames();
			System.out.println("--Lista giochi--");
			for (int i = 0; i < giocoList.size(); i++) {
				int numero = i+1;
				System.out.println("Gioco" + numero + ": " + giocoList.get(i).getNome());
			}
			System.out.println("A quale gioco vuoi giocare ?");
			String line1 = reader.readLine();
	
		}
		
	}
	
}
