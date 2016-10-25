package haw.cas.praktikum.objects;

import java.util.ArrayList;
import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;

//Serialisierbar ueber ORT, deserialisiert direkt
public class Strasse extends MObjekt{

	private Ort start;
	private Ort ende;
	private int kosten;
	private List<Ereignis> ereignisList;

	
	public Strasse(String id,Ort start,Ort ende,int kosten){
		super(id);
		this.start=start;
		this.ende=ende;
		this.kosten=kosten;
		this.ereignisList = new ArrayList<>();
	}
	
	public Strasse(Ort start,Ort ende,int kosten){
		this.start=start;
		this.ende=ende;
		this.kosten=kosten;
		this.ereignisList = new ArrayList<>();
	}
	

	public Ort getStart() {
		return start;
	}

	public void setStart(Ort start) {
		this.start = start;
	}

	public Ort getEnde() {
		return ende;
	}

	public void setEnde(Ort ende) {
		this.ende = ende;
	}

	public int getKosten() {
		return kosten;
	}

	public void setKosten(int kosten) {
		this.kosten = kosten;
	}

	public void addEreignis(Ereignis e) {
		ereignisList.add(e);
	}

	public void removeEreignis(Ereignis e) {
		ereignisList.remove(e);
	}
	
	public List<Ereignis> getEreignise() {
		return ereignisList;
	}
}