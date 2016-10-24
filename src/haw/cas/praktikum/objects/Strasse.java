package haw.cas.praktikum.objects;

import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;

//Serialisierbar über ORT, deserialisiert direkt
public class Strasse{

	public Strasse(Ort start,Ort ende,int kosten){
		this.start=start;
		this.ende=ende;
		this.kosten=kosten;
	}

	public Ort start;
	public Ort ende;
	public int kosten;
	public List<Ereignis> ereignisList;

}