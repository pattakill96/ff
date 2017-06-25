package persona.amministratore;

import persona.moderatore.model.Moderatore;
import persona.utente.controller.JDBCUtenteController;
import recensione.model.*;
import recensione.controller.*;
import persona.utente.model.Utente;
import persona.amministratore.controller.JDBCAmministratoreController;
import persona.amministratore.model.Amministratore;
import persona.moderatore.controller.JDBCModeratoreController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import gioco.controller.JDBCGiocoController;
import gioco.model.Gioco;

// TODO: Auto-generated Javadoc
/**
 * The Class ModeratoreView.
 */
public class AmministratoreView {

	/** The reader. */
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/** The moderatore controller. */
	JDBCModeratoreController moderatoreController = new JDBCModeratoreController();
	
	/** The utente controller. */
	JDBCUtenteController utenteController = new JDBCUtenteController();
	
	/** The recensione controller. */
	JDBCRecensioneController recensioneController = new JDBCRecensioneController();
	
	/** The amministratore controller. */
	JDBCAmministratoreController amministratoreController = new JDBCAmministratoreController();
	
	/** The gioco controller. */
	JDBCGiocoController giocoController = new JDBCGiocoController();

	/** The user list. */
	ArrayList<Utente> userList = null;
	
	/** The mod list. */
	ArrayList<Moderatore> modList = null;
	
	/** The rec list. */
	ArrayList<Recensione> recList = null;
	
	/** The gioco list. */
	ArrayList<Gioco> giocoList = null;

	/**
	 * Instantiates a new moderatore view.
	 */
	public AmministratoreView() {
	}

	/**
	 * Show.
	 *
	 * @param amministratore the moderatore
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void show(Amministratore amministratore) throws IOException {
		System.out.println("Pagina dell'amministratore: " + amministratore.getUsername());
		System.out.println("\n(1)Rimuovi utente\n(2)Rimuovi moderatore\n(3)Rimuovi gioco\n");
		String line = reader.readLine();

		if (line.equals("1")) {
			userList = utenteController.getUsers();
			System.out.println("--Lista utenti--");
			for (int i = 0; i < userList.size(); i++) {
				int numero = i + 1;
				System.out.println("Utente " + numero + ": " + userList.get(i).getUsername());
			}
			System.out.println("\nQuale utente vuoi rimuovere?");
			String line1 = reader.readLine();
			int app = Integer.parseInt(line1);
			boolean flag = amministratoreController.deleteUser(userList.get(app - 1));
			if (flag)
				System.out.println("Utente rimosso");
			AmministratoreView amministratoreview = new AmministratoreView();
			amministratoreview.show(amministratore);
		} else if (line.equals("2")) {
			modList = moderatoreController.getMods();
			System.out.println("--Lista moderatori--");
			for (int i = 0; i < modList.size(); i++) {
				int numero = i + 1;
				System.out.println("Moderatore" + numero + ": " + modList.get(i).getUsername());
			}
			System.out.println("\nQuale moderatore vuoi rimuovere?");
			String line1 = reader.readLine();
			int app = Integer.parseInt(line1);
			boolean flag = amministratoreController.deleteModeratore(modList.get(app - 1));
			if (flag)
				System.out.println("Moderatore rimosso");
			AmministratoreView amministratoreview = new AmministratoreView();
			amministratoreview.show(amministratore);
		} else if (line.equals("3")) {
			giocoList = giocoController.getGames();
			System.out.println("--Lista giochi--");
			for (int i = 0; i < giocoList.size(); i++) {
				int numero = i + 1;
				System.out.println("Gioco" + numero + ": " + giocoList.get(i).getNome());
			}
			System.out.println("\nQuale gioco vuoi rimuovere?");
			String line1 = reader.readLine();
			int app = Integer.parseInt(line1);
			boolean flag = amministratoreController.deleteGame(giocoList.get(app - 1));
			if (flag)
				System.out.println("Gioco rimosso");
			AmministratoreView amministratoreview = new AmministratoreView();
			amministratoreview.show(amministratore);
		} else if (line.equals("4")) {

		}

	}

}
