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

	public void show() throws IOException {
		System.out.println("Visualizza profilo");
		String moderator = reader.readLine();

		System.out.println("Gioca");
		String username = reader.readLine();

		System.out.println("Valuta e/o recensisci un gioco");
		String password = reader.readLine();
		
		
	}

}
