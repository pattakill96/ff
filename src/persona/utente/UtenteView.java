package persona.utente;

import persona.utente.model.Utente;
import persona.utente.controller.JDBCUtenteController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class UtenteView {

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
		}
		if(line.equals("2")){}
		
	}

}
