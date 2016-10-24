package haw.cas.praktikum.objects;

import haw.cas.praktikum.parser.Obj.MObjekt;

import java.util.ArrayList;
import java.util.List;

//TODO:Serialisiuerng . . . 
public class Konsortium extends MObjekt {

	private List<Akteur> teilnehmer = new ArrayList<>();
	private Akteur besitzer;
	private Handelsregister handelsregister;

	public Konsortium(String name, Akteur besitzer) {
		super(name);
		this.besitzer = besitzer;
		// Wäre das nicht sinnvoller? teilnehmer.add(besitzer);
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

	public Akteur getInhaber() {
		return besitzer;
	}

	public void eintragen(Handelsregister hr) {
		this.handelsregister = hr;
	}

	public Handelsregister eingetragenIn() {
		return handelsregister;
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