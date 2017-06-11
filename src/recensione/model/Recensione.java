package recensione.model;
import java.time.LocalDate;
import java.util.Date;

public class Recensione {

	private String descrizione;
	private int voto;
	private String utente;
	private String gioco;
	private String data;

	public Recensione(String descrizione, int voto, String utente,String gioco,String data) {
		this.descrizione=descrizione;
		this.voto=voto;
		this.utente=utente;
		this.gioco=gioco;
		this.data=data;
	}

	public String getDescrizione() {
		return descrizione;
	}
	public int getVoto() {
		return voto;
	}
	public String getUtente() {
		return utente;
	}
	public String getGioco() {
		return gioco;
	}
	public String getData() {
		return data;
	}
}