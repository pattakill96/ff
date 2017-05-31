package persona.utente;

import persona.utente.model.Utente;
import persona.utente.model.Utente;
import persona.utente.controller.UtenteController;
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
		System.out.println("This is the user view");
		String moderator = reader.readLine();
	}

}
