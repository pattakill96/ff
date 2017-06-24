package persona.moderatore.model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Moderatore.
 */
public class Moderatore {

	/** The username. */
	private String username;
	
	/** The nome. */
	private String nome;
	
	/** The cognome. */
	private String cognome;
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;

	/**
	 * Instantiates a new moderatore.
	 *
	 * @param username the username
	 * @param email the email
	 * @param password the password
	 * @param nome the nome
	 * @param cognome the cognome
	 */
	public Moderatore(String username, String email, String password, String nome, String cognome) {
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
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

}