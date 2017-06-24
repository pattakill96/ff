package persona.utente.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Utente.
 */
public class Utente {

	/** The username. */
	private String username;
	
	/** The livello. */
	private int livello;
	
	/** The pe. */
	private int pe;
	
	/** The nome. */
	private String nome;
	
	/** The cognome. */
	private String cognome;
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;

	/**
	 * Instantiates a new utente.
	 *
	 * @param username the username
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param email the email
	 * @param password the password
	 * @param livello the livello
	 * @param pe the pe
	 */
	public Utente(String username, String nome, String cognome, String email, String password, int livello, int pe) {
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.livello = livello;
		this.pe = pe;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
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
	 * Gets the cognome.
	 *
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the livello.
	 *
	 * @return the livello
	 */
	public int getLivello() {
		return livello;
	}

	/**
	 * Gets the pe.
	 *
	 * @return the pe
	 */
	public int getPe() {
		return pe;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Sets the cognome.
	 *
	 * @param cognome the new cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the livello.
	 *
	 * @param livello the new livello
	 */
	public void setLivello(int livello) {
		this.livello = livello;
	}

	/**
	 * Sets the pe.
	 *
	 * @param pe the new pe
	 */
	public void setPe(int pe) {
		this.pe = pe;
	}

}
