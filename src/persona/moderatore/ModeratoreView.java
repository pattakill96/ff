package persona.moderatore;

import persona.moderatore.model.Moderatore;
import persona.utente.controller.JDBCUtenteController;
import recensione.model.*;
import recensione.controller.*;
import persona.utente.model.Utente;
import persona.moderatore.controller.JDBCModeratoreController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ModeratoreView.
 */
public class ModeratoreView {

	/** The reader. */
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/** The moderatore controller. */
	JDBCModeratoreController moderatoreController = new JDBCModeratoreController();
	
	/** The utente controller. */
	JDBCUtenteController utenteController = new JDBCUtenteController();
	
	/** The recensione controller. */
	JDBCRecensioneController recensioneController = new JDBCRecensioneController();

	/** The user list. */
	ArrayList<Utente> userList = null;
	
	/** The mod list. */
	ArrayList<Moderatore> modList = null;
	
	/** The rec list. */
	ArrayList<Recensione> recList = null;

	/**
	 * Instantiates a new moderatore view.
	 */
	public ModeratoreView() {
	}

	/**
	 * Show.
	 *
	 * @param moderatore the moderatore
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void show(Moderatore moderatore) throws IOException {
		System.out.println("Pagina del moderatore: " + moderatore.getUsername());
		System.out.println("\n(1)Promuovi utente\n(2)Retrocedi utente\n(3)Gestisci recensioni\n(4)Torna indietro");
		String line = reader.readLine();

		if (line.equals("1")) {
			userList = utenteController.getUsers();
			System.out.println("--Lista utenti--");
			for (int i = 0; i < userList.size(); i++) {
				int numero = i + 1;
				System.out.println("Utente " + numero + ": " + userList.get(i).getUsername());
			}
			System.out.println("\nQuale utente vuoi promuovere?");
			String line1 = reader.readLine();
			int app = Integer.parseInt(line1);
			boolean flag = moderatoreController.promoteUser(userList.get(app - 1));
			if (flag) {
				System.out.println("Utente promosso");
				this.show(moderatore);
			}
		} else if (line.equals("2")) {
			modList = moderatoreController.getMods();
			System.out.println("--Lista moderatori--");
			for (int i = 0; i < modList.size(); i++) {
				int numero = i + 1;
				System.out.println("Moderatore" + numero + ": " + modList.get(i).getUsername());
			}
			System.out.println("\nQuale moderatore vuoi retrocedere?");
			String line1 = reader.readLine();
			int app = Integer.parseInt(line1);
			boolean flag = moderatoreController.demoteUser(modList.get(app - 1));
			if (flag) {
				System.out.println("Moderatore retrocesso");
				this.show(moderatore);
			}
		} else if (line.equals("3")) {
			recList = recensioneController.getAllRec();
			if (recList.size() == 0) {
				System.out.println("Nessuna recensione in attesa di moderazione\n");
				ModeratoreView moderatoreview = new ModeratoreView();
				moderatoreview.show(moderatore);
			}
			System.out.println("--Lista recensioni--");
			for (int i = 0; i < recList.size(); i++) {
				int numero = i + 1;
				System.out.println(
						"Recensone" + numero + ": " + recList.get(i).getGioco() + "/" + recList.get(i).getVoto() + "--"
								+ recList.get(i).getDescrizione() + "[" + recList.get(i).getUtente() + "];\n");
			}
			System.out.println("\nQuale recensione vuoi approvare/respingere?");
			String line1 = reader.readLine();
			int app = Integer.parseInt(line1);
			System.out.println("\nVuoi approvare o respingere questa recensione?(1/0)");
			String line3 = reader.readLine();
			int app1 = Integer.parseInt(line3);
			if (app1 == 1) {
				boolean flag = moderatoreController.acceptReview(recList.get(app - 1), moderatore);
				if (flag)
					System.out.println("Recensione approvata\n");
			} else {
				boolean flag = moderatoreController.deleteReview(recList.get(app - 1), null);
				if (flag) 
					System.out.println("Recensione eliminata");
			}
			this.show(moderatore);

		} else if (line.equals("4")) {
			
		}

	}

}
