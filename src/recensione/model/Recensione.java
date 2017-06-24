package recensione.model;
import java.time.LocalDate;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Recensione.
 */
public class Recensione {

	/** The descrizione. */
	private String descrizione;
	
	/** The voto. */
	private int voto;
	
	/** The utente. */
	private String utente;
	
	/** The gioco. */
	private String gioco;
	
	/** The data. */
	private String data;

	/**
	 * Instantiates a new recensione.
	 *
	 * @param descrizione the descrizione
	 * @param voto the voto
	 * @param utente the utente
	 * @param gioco the gioco
	 * @param data the data
	 */
	public Recensione(String descrizione, int voto, String utente,String gioco,String data) {
		this.descrizione=descrizione;
		this.voto=voto;
		this.utente=utente;
		this.gioco=gioco;
		this.data=data;
	}

	/**
	 * Gets the descrizione.
	 *
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Gets the voto.
	 *
	 * @return the voto
	 */
	public int getVoto() {
		return voto;
	}
	
	/**
	 * Gets the utente.
	 *
	 * @return the utente
	 */
	public String getUtente() {
		return utente;
	}
	
	/**
	 * Gets the gioco.
	 *
	 * @return the gioco
	 */
	public String getGioco() {
		return gioco;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}
}