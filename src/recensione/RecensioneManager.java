package recensione;

import recensione.model.*;
import gioco.model.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Interface RecensioneManager.
 */
public interface RecensioneManager {

	/**
	 * Gets the all rec.
	 *
	 * @return the all rec
	 */
	public ArrayList<Recensione> getAllRec();
	
	/**
	 * Gets the rec.
	 *
	 * @param gioco the gioco
	 * @return the rec
	 */
	public ArrayList<Recensione> getRec(Gioco gioco);

}
