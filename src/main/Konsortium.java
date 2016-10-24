package main;

import java.util.List;

public class Konsortium implements MObjekt{

	private List<Akteur> teilnehmer;

	public Konsortium(List<Akteur> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	/**
	 * 
	 * @param akteur
	 */
	public void addTeilnehmer(Akteur akteur) {
		teilnehmer.add(akteur);
	}

	public List<Akteur> getTeilnehmer() {
		return this.teilnehmer;
	}

	/**
	 * 
	 * @param akteur
	 */
	public void deleteTeilnehmer(Akteur akteur) {
		teilnehmer.remove(akteur);
	}

	public void setTeilnehmer(List<Akteur> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}


}