package haw.cas.praktikum.objects;

import haw.cas.praktikum.parser.Obj.MObjekt;

import java.util.ArrayList;
import java.util.List;
//%lkw(ID,ID-akteur,ID-ort-POS,int-Kapazität)

//TODO:Serialisiuerng . . . 
public class LKW extends MObjekt{

	private Ort pos;		//TODO:Ort oder Straße als POS ?
	private Akteur besitzer;
	private int ladekapazitaet;
	private ArrayList<Auftrag> ladung = new ArrayList<>();

	public LKW(String name, Akteur besitzer, Ort pos, int ladekapazitaet) {
		super(name);
		this.besitzer = besitzer;
		this.pos = pos;
		this.ladekapazitaet = ladekapazitaet;		
	}

	public void addAuftrag(Auftrag auftrag) {
		ladung.add(auftrag);
	}
	
	public Akteur getBesitzer(){
		return besitzer;
	}

	public void removeAuftrag(Auftrag auftrag) {
		ladung.remove(auftrag);
	}

	public Ort getPos() {
		return pos;
	}

	public void setPos(Ort pos) {
		this.pos = pos;
	}

	public int getLadekapazitaet() {
		return ladekapazitaet;
	}

	public void setLadekapazitaet(int ladekapazitaet) {
		this.ladekapazitaet = ladekapazitaet;
	}

	public int getFuellstand() {
		//TODO:errechnen aus aufträgen
		return -1;
	}

	public List<Auftrag> getLadung() {
		return ladung;
	}

	public void setLadung(ArrayList<Auftrag> ladung) {
		this.ladung = ladung;
	}
}