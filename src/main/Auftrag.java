package main;

import java.util.List;

public class Auftrag implements MObjekt{

	private Ort start;
	private Ort ziel;
	private Double wert;
	private int menge;
	private List<Auftrag> subAuftraege;

	public Ort getStart() {
		return start;
	}

	public void setStart(Ort start) {
		this.start = start;
	}

	public Ort getZiel() {
		return ziel;
	}

	public void setZiel(Ort ziel) {
		this.ziel = ziel;
	}

	public Double getWert() {
		return wert;
	}

	public void setWert(Double wert) {
		this.wert = wert;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public void addSubAuftrag(Auftrag auftrag) {
		subAuftraege.add(auftrag);
	}

	public void removeSubAuftrag(Auftrag auftrag) {
		subAuftraege.remove(auftrag);
	}
}