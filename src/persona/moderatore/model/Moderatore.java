package persona.moderatore.model;

public class Moderatore {

  private String username;
  private String nome;
  private String cognome;
  private String email;
  private String password;

  public Moderatore() {
    this.username = "";
  }

	public Moderatore(String username, String nome, String cognome, String email, String password) {
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
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

}
