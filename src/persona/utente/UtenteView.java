package persona.utente;

import gioco.model.Gioco;
import persona.utente.model.Utente;
import recensione.model.Recensione;
import persona.moderatore.controller.JDBCModeratoreController;
import persona.utente.controller.JDBCUtenteController;
import gioco.controller.JDBCGiocoController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.time.*;

public class UtenteView {

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	JDBCGiocoController giocoController = new JDBCGiocoController();
	JDBCUtenteController utentecontroller = new JDBCUtenteController();

	ArrayList<Gioco> giocoList = null;
	
	public UtenteView() {

	}

	public void show(Utente utente) throws IOException {
		System.out.println("Pagina dell'utente :"+utente.getUsername());
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
			giocoList = giocoController.getGames();
			System.out.println("--Lista giochi--");
			for (int i = 0; i < giocoList.size(); i++) {
				int numero = i+1;
				System.out.println("Gioco" + numero + ": " + giocoList.get(i).getNome());
			}
			System.out.println("A quale gioco vuoi giocare ?");
			String line1 = reader.readLine();
	
		}
		else if(line.equals("3")) {
			giocoList = giocoController.getGames();
			System.out.println("--Lista giochi--");
			for (int i = 0; i < giocoList.size(); i++) {
				int numero = i+1;
				System.out.println("Gioco" + numero + ": " + giocoList.get(i).getNome());
			}
			System.out.println("Quale gioco vuoi recensire?");
			String line1 = reader.readLine();
			int app= Integer.parseInt(line1);
			
			System.out.println("Inserisci una recensione per il gioco "+giocoList.get(app-1).getNome());
			String rec=reader.readLine();
			System.out.println("Inserisci una valutazione per il gioco "+giocoList.get(app-1).getNome());
			String val = reader.readLine();
			int val1= Integer.parseInt(val);
			LocalDate d1= LocalDate.now();
			String data=d1.getYear()+"-"+d1.getMonthValue()+"-"+d1.getDayOfMonth();
			Recensione recensione = new Recensione(rec,val1,utente.getUsername(),giocoList.get(app-1).getNome(),data);
			boolean flag = utentecontroller.setReview(recensione);
			if(flag){
				System.out.println("La tua recensione è stata inserita nel database\n è necessario che un moderatore la approvi");
			}
			
	
		}
		
	}
	
}
