package gioco.model;

public class Gioco {

	private String nome;
	String descrizione;

	public Gioco(String nome,String descrizione) {
		this.nome = nome;
		this.descrizione=descrizione;
	}

	public String getNome() {
		return nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
}
