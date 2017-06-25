package gioco;

import persona.utente.model.Utente;
import recensione.controller.JDBCRecensioneController;
import recensione.model.Recensione;
import persona.utente.UtenteView;
import persona.utente.controller.JDBCUtenteController;
import gioco.model.Gioco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class GiocoView.
 */
public class GiocoView {

	/** The reader. */
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/** The utentecontroller. */
	JDBCUtenteController utentecontroller = new JDBCUtenteController();
	
	/** The recensione controller. */
	JDBCRecensioneController recensioneController = new JDBCRecensioneController();

	/** The rec list. */
	ArrayList<Recensione> recList = null;

	/**
	 * Instantiates a new gioco view.
	 */
	public GiocoView() {

	}

	/**
	 * Show.
	 *
	 * @param utente the utente
	 * @param gioco the gioco
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void show(Utente utente, Gioco gioco) throws IOException {
		System.out.println(gioco.getNome() + " " + gioco.getDescrizione());
		System.out.println("\n(1)Gioca\n(2)Visualizza Recensione\n");
		String line = reader.readLine();
		if (line.equals("1")) {
			boolean flag = utentecontroller.play(utente, gioco);
			if (flag) {
				System.out.println("Complimenti!!Bella partita\nAdesso tornerai sulla tua pagina profilo!");
				UtenteView utenteview = new UtenteView();
				utenteview.show(utente);
			}
		} else if (line.equals("2")) {
			recList = recensioneController.getRec(gioco);
			if (recList.size() == 0) {
				System.out.println("Non è presente nessuna recensione di questo gioco!\n");
				UtenteView utenteView = new UtenteView();
				utenteView.show(utente);
			}
			System.out.println("--Lista recensioni--");
			for (int i = 0; i < recList.size(); i++) {
				int numero = i + 1;
				System.out.println("Recensone" + numero + ": " + recList.get(i).getVoto() + "--"
						+ recList.get(i).getDescrizione() + "--[Utente:" + recList.get(i).getUtente() + "]" + "(Data :"
						+ recList.get(i).getData() + ")" + ";\n");
			}
			UtenteView utenteView = new UtenteView();
			utenteView.show(utente);
		}
	}

}
