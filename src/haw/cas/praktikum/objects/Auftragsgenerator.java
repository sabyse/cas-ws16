package haw.cas.praktikum.objects;

import java.util.ArrayList;
import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;

//TODO:Serialisiuerng . . . 
public class Auftragsgenerator extends MObjekt {

	public ArrayList<Ort> zustaendigFuer = new ArrayList<>(); // TODO:Zust�ndigkeit
																// ist �ber die
																// B�rsen
																// geregelt, ein
																// verweis auf
																// das
																// stra�ennetz
																// ist notwendig
	public int aktivitaetsrate;
	public List<Boerse> zustaendigeBoersen;

	public Auftragsgenerator(String name, int aktivitaetsrate) {
		super(name);
		this.aktivitaetsrate = aktivitaetsrate;
	}

	public Auftragsgenerator(int aktivitaetsrate) {
		super();
		this.aktivitaetsrate = aktivitaetsrate;
	}

	public int getAktivitaetsrate() {
		return aktivitaetsrate;
	}

	public void setAktivitaetsrate(int aktivitaetsrate) {
		this.aktivitaetsrate = aktivitaetsrate;
	}

	public void bereichErweitern(Ort o) {
		zustaendigFuer.add(o);
	}

	public ArrayList<Ort> zuestandigFuer() {
		return zustaendigFuer;
	}
}