package persona.utente;

import gioco.model.Gioco;
import persona.utente.model.Utente;
import recensione.model.Recensione;
import persona.utente.controller.JDBCUtenteController;
import gioco.GiocoView;
import gioco.controller.JDBCGiocoController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.time.*;

// TODO: Auto-generated Javadoc
/**
 * The Class UtenteView.
 */
public class UtenteView {

	/** The reader. */
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/** The gioco controller. */
	JDBCGiocoController giocoController = new JDBCGiocoController();

	/** The utente controller. */
	JDBCUtenteController utenteController = new JDBCUtenteController();

	/** The gioco list. */
	ArrayList<Gioco> giocoList = null;

	/** The trofeo list. */
	ArrayList<String[]> trofeoList = null;

	/**
	 * Instantiates a new utente view.
	 */
	public UtenteView() {

	}

	/**
	 * Show.
	 *
	 * @param utente
	 *            the utente
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void show(Utente utente) throws IOException {
		System.out.println("Pagina dell'utente: " + utente.getUsername());
		System.out.println("\n(1)Visualizza profilo\n(2)Cerca Gioco\n(3)Valuta e recensisci gioco\n(4)Visualizza scala livelli\n(5)Torna indietro");
		String line = reader.readLine();

		if (line.equals("1")) {
			System.out.println("Username:" + utente.getUsername() + "\n" + "Nome:" + utente.getNome() + "\n"
					+ "Cognome:" + utente.getCognome() + "\n" + "Email:" + utente.getEmail() + "\n" + "Livello:"
					+ utente.getLivello() + "\n" + "Punti Esperienza:" + utente.getPe() + "\n\n");
			this.show(utente);
		} else if (line.equals("2")) {
			giocoList = giocoController.getGames();
			System.out.println("--Lista giochi--");
			for (int i = 0; i < giocoList.size(); i++) {
				int numero = i + 1;
				System.out.println("Gioco" + numero + ": " + giocoList.get(i).getNome());
			}
			System.out.println("Quale gioco vuoi visualizzare?");
			String line1 = reader.readLine();
			int app = Integer.parseInt(line1);
			GiocoView giocoview = new GiocoView();
			giocoview.show(utente, giocoList.get(app - 1));
		} else if (line.equals("3")) {
			giocoList = giocoController.getGames();
			System.out.println("--Lista giochi--");
			for (int i = 0; i < giocoList.size(); i++) {
				int numero = i + 1;
				System.out.println("Gioco" + numero + ": " + giocoList.get(i).getNome());
			}
			System.out.println("Quale gioco vuoi recensire?");
			String line1 = reader.readLine();
			int app = Integer.parseInt(line1);

			System.out.println("Inserisci una recensione per il gioco " + giocoList.get(app - 1).getNome());
			String rec = reader.readLine();
			System.out.println("Inserisci una valutazione per il gioco (1-10) " + giocoList.get(app - 1).getNome());
			String val = reader.readLine();
			int val1 = Integer.parseInt(val);
			LocalDate d1 = LocalDate.now();
			String data = d1.getYear() + "-" + d1.getMonthValue() + "-" + d1.getDayOfMonth();
			Recensione recensione = new Recensione(rec, val1, utente.getUsername(), giocoList.get(app - 1).getNome(),
					data);
			boolean flag = utenteController.setReview(recensione);
			if (flag) {
				System.out.println("La tua recensione è stata inserita nel database è necessario che un moderatore la approvi\n\n");
			}
			this.show(utente);
		} else if (line.equals("4")) {
			trofeoList = utenteController.leveling(utente);
			for (int i = 0; i < trofeoList.size(); i++) {
				int numero = i + 1;
				System.out.println(trofeoList.get(i)[1] + " " + trofeoList.get(i)[2] + " " + trofeoList.get(i)[0]);
			}
		} else if (line.equals("5")) {
			// Automatically returns to main menu
		}

	}

}
