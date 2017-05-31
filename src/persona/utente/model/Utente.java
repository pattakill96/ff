package persona.utente.model;

public class Utente {

	private String username;
	private int livello;
	private int pe;
	private String nome;
	private String cognome;
	private String email;
	private String password;

	public Utente(String username, String nome, String cognome, String email, String password, int livello, int pe) {
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.livello = livello;
		this.pe = pe;
	}

	public String getUsername() {
		return username;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getLivello() {
		return livello;
	}

	public int getPe() {
		return pe;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

	public void setPe(int pe) {
		this.pe = pe;
	}

}
