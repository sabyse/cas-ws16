package haw.cas.praktikum.objects;

import haw.cas.praktikum.parser.Obj.MObjekt;

import java.util.ArrayList;
import java.util.List;

//TODO:Serialisiuerng . . . 
public class Konsortium extends MObjekt {

	private List<Akteur> teilnehmer;
	private Akteur besitzer;
	private Handelsregister handelsregister;

	public Konsortium(String name, Akteur besitzer) {
		super(name);
		this.besitzer = besitzer;
		this.teilnehmer = new ArrayList<>();
		// Wäre das nicht sinnvoller? teilnehmer.add(besitzer);
	}

	public void addTeilnehmer(Akteur akteur) {
		teilnehmer.add(akteur);
	}

	public void removeTeilnehmer(Akteur akteur) {
		teilnehmer.remove(akteur);
	}

	public List<Akteur> getTeilnehmer() {
		return this.teilnehmer;
	}

	public void setTeilnehmer(List<Akteur> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public Akteur getInhaber() {
		return besitzer;
	}

	// ueberfluessig... Handelsregister hat Liste von Konsortien

	public void eintragen(Handelsregister hr) {
		this.handelsregister = hr;
	}

	public Handelsregister eingetragenIn() {
		return handelsregister;
	}

}