package persona.moderatore;

import persona.moderatore.model.Moderatore;
import persona.utente.model.Utente;
import persona.moderatore.controller.JDBCModeratoreController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class ModeratoreView {

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	JDBCModeratoreController moderatoreController = new JDBCModeratoreController();

	ArrayList<Utente> userList = null;
	ArrayList<Moderatore> modList = null;

	public ModeratoreView() {
	}

	public void show() throws IOException {
		System.out.println("\n(1)Promuovi utente\n(2)Retrocedi utente\n(3)Gestisci recensioni\n");
		String line = reader.readLine();

		if (line.equals("1")) {
			userList = moderatoreController.getUsers();
			System.out.println("--Lista utenti--");
			for (int i = 0; i < userList.size(); i++) {
				int numero = i+1;
				System.out.println("Utente " + numero + ": " + userList.get(i).getUsername());
			}
			System.out.println("\nQuale utente vuoi promuovere?");
			String line1 = reader.readLine();
			int app= Integer.parseInt(line1);
            boolean flag = moderatoreController.promoteUser(userList.get(app-1));
            if(flag)
            	System.out.println("Utente promosso");
		} else if(line.equals("2")) {
			modList = moderatoreController.getMods();
			System.out.println("--Lista moderatori--");
			for (int i = 0; i < modList.size(); i++) {
				int numero = i+1;
				System.out.println("Moderatore" + numero + ": " + modList.get(i).getUsername());
			}
			System.out.println("\nQuale moderatore vuoi retrocedere?");
			String line1 = reader.readLine();
			int app= Integer.parseInt(line1);
            boolean flag = moderatoreController.demoteUser(modList.get(app-1));
            if(flag)
            	System.out.println("Moderatore retrocesso");
		}
			

	}

}
