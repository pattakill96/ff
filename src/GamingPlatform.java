import persona.utente.model.Utente;
import persona.utente.UtenteView;
import persona.utente.controller.UtenteController;
import persona.utente.controller.JDBCUtenteController;

import persona.moderatore.model.Moderatore;
import persona.moderatore.ModeratoreView;
// import persona.moderatore.controller.ModeratoreController;
import persona.moderatore.controller.JDBCModeratoreController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class GamingPlatform {

		public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		public static void main(String[] args) throws IOException {

			System.out.print("(1) Login\n(2) Sign Up\n(3) Esci\n\n");

      // TODO Nel login verrà chiesto se si è un moderatore e quindi switchera controller e model

			String line = reader.readLine();

			if( line.equals("1") ) {
        System.out.println("Sei un moderatore? y/n");
        String moderator = reader.readLine();

        System.out.println("Inserisci l'username");
    		String username = reader.readLine();

        System.out.println("Inserisci la password");
        String password = reader.readLine();

        if (moderator.equals("n")) {
          // UtenteController utenteController = new UtenteController();
          JDBCUtenteController utenteController = new JDBCUtenteController();
          Utente utente = utenteController.login(username, password);
          if(utente.getUsername().equals("")) {
            System.out.println("Utente non trovato");
          } else {
            UtenteView utenteview = new UtenteView();
            utenteview.show();
          }
        } else {
          // ModeratoreController moderatoreController = new ModeratoreController();
          JDBCModeratoreController moderatoreController = new JDBCModeratoreController();
          Moderatore moderatore = moderatoreController.login(username, password);
          if(moderatore.getUsername().equals("")) {
            System.out.println("Moderatore non trovato");
          } else {
            ModeratoreView moderatoreview = new ModeratoreView();
            moderatoreview.show();
          }
        }

			} else if( line.equals("2") ) {

			} else if( line.equals("3") ) {
        System.exit(0);
      }
		}

}
