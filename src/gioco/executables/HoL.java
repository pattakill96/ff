package gioco.executables;

// Higher or Lower

import java.util.Random;
import java.util.Scanner;

public class HoL {
    public void show() {

            int terminate = 0;

            	Scanner scan = new Scanner(System.in);
	            int card, cardNext;
	            String userResponse;
	
	            do {
	                    Random randomNumbers = new Random();
	
	                    card = randomNumbers.nextInt(13) + 1;
	                    System.out.println("Il numero casuale secondo te è più alto o più basso di " + card);
	                    System.out.println("Rispondi con '+' se pensi sia più alto, con '-' per il contrario.");
	                    
	                    userResponse = scan.next();
	                    cardNext = randomNumbers.nextInt(13) + 1;
	
	                    if ((String.valueOf(userResponse.charAt(0)).equalsIgnoreCase("+") && cardNext > card) ||
	                        (String.valueOf(userResponse.charAt(0)).equalsIgnoreCase("-") && cardNext < card)) {
	                            System.out.println("Hai vinto! Il numero era: "+ cardNext + "\n");
	                    } else {
	                            System.out.println("Hai perso! Il numero era: "+ cardNext + "\n");
	                            terminate = 1;
	                    }
	            } while (terminate != 1);
            
    }
}
