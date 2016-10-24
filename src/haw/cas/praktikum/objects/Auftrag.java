package haw.cas.praktikum.objects;

import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;


//%auftrag(ID,ID-ort-Start,ID-ort-Ende,double-Gewinn,int-menge)
//TODO:Serialisiuerng . . . 
public class Auftrag extends MObjekt{
	private Ort startOrt;
	private Ort endOrt;
	private double gewinn;
	private int menge;
	
	public Auftrag(String name, Ort startOrt, Ort endOrt, double gewinn, int menge){
		super(name);
		this.startOrt = startOrt;
		this.endOrt = endOrt;
		this.gewinn = gewinn;
		this.menge = menge;
	}

	
	private List<Auftrag> subAuftraege;

	public Ort getStart() {
		return startOrt;
	}

	public void setStart(Ort start) {
		this.startOrt = start;
	}

	public Ort getZiel() {
		return endOrt;
	}

	public void setZiel(Ort ziel) {
		this.endOrt = ziel;
	}

	public Double getWert() {
		return gewinn;
	}

	public void setWert(Double wert) {
		this.gewinn = wert;
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

	public List<Auftrag> getAllSubAuftrag() {
		return subAuftraege;
	}
}