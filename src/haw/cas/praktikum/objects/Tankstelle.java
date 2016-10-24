package haw.cas.praktikum.objects;

import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.zeittyp.ZeitTyp;


//TODO:Serialisierung . . .
public class Tankstelle extends MObjekt implements LocalServices {

	private Double preis; 
	private ZeitTyp kostenZeit;
	private Akteur belegtDurch;
	
	
	
	public Tankstelle(String name, ZeitTyp tankdauer ,double preis) {
		super(name);
		this.preis = preis;
		this.kostenZeit = tankdauer;
	}

	public double getKosten(){
		return preis;
	}
	
	public ZeitTyp getDauer(){
		return kostenZeit;
	}
	
	public Akteur belegtDurch(){
		return belegtDurch;
	}

	@Override
	public String getID() {
		return super.getUID();
	}

}