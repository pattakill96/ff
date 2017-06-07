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

	ArrayList<Utente> list = null;
	public ModeratoreView() {
	}

	public void show() throws IOException {
		System.out.println("\n(1)Promuovi utente\n(2)Retrocedi utente\n(3)Gestisci recensioni\n");
		String line = reader.readLine();
		if(line.equals("1")){
		list = moderatoreController.showusers();
		for (int i=0; i<list.size(); i++)
			System.out.println("Utente "+ i+": "+list.get(i).getUsername());
			System.out.println("\nQuale utente vuoi promuovere?");
			String line1 = reader.readLine();
		    
		}

	}

}
