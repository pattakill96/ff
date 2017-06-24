package gioco.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Gioco.
 */
public class Gioco {

	/** The nome. */
	private String nome;
	
	/** The descrizione. */
	String descrizione;

	/**
	 * Instantiates a new gioco.
	 *
	 * @param nome the nome
	 * @param descrizione the descrizione
	 */
	public Gioco(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Gets the descrizione.
	 *
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
}
