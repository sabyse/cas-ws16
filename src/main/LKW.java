package main;

import java.util.List;

public class LKW implements MObjekt{

	private Strasse pos;
	private int ladekapazitaet;
	private int fuellstand;
	private List<Auftrag> ladung;

	public LKW(Strasse pos, int ladekapazitaet, int fuellstand, List<Auftrag> ladung) {
		this.pos = pos;
		this.ladekapazitaet = ladekapazitaet;
		this.fuellstand = fuellstand;
		this.ladung = ladung;
	}

	public void addAuftrag(Auftrag auftrag) {
		ladung.add(auftrag);
	}

	public void removeAuftrag(Auftrag auftrag) {
		ladung.remove(auftrag);
	}

	public Strasse getPos() {
		return pos;
	}

	public void setPos(Strasse pos) {
		this.pos = pos;
	}

	public int getLadekapazitaet() {
		return ladekapazitaet;
	}

	public void setLadekapazitaet(int ladekapazitaet) {
		this.ladekapazitaet = ladekapazitaet;
	}

	public int getFuellstand() {
		return fuellstand;
	}

	public void setFuellstand(int fuellstand) {
		this.fuellstand = fuellstand;
	}

	public List<Auftrag> getLadung() {
		return ladung;
	}

	public void setLadung(List<Auftrag> ladung) {
		this.ladung = ladung;
	}
}