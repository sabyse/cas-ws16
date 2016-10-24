package main;

import java.time.LocalDateTime;

public class Nachricht implements MObjekt{

	private String content;
	private Akteur ersteller;
	private LocalDateTime erstellungsZeitpunkt;

	public Nachricht(String content, Akteur ersteller) {
		this.content = content;
		this.ersteller = ersteller;
		LocalDateTime erstellungsZeitpunkt = LocalDateTime.now();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Akteur getErsteller() {
		return ersteller;
	}

	public void setErsteller(Akteur ersteller) {
		this.ersteller = ersteller;
	}

	public LocalDateTime getErstellungsZeitpunkt() {
		return erstellungsZeitpunkt;
	}

	public void setErstellungsZeitpunkt(LocalDateTime erstellungsZeitpunkt) {
		this.erstellungsZeitpunkt = erstellungsZeitpunkt;
	}
}