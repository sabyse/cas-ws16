package haw.cas.praktikum.objects;

import java.util.ArrayList;

import haw.cas.praktikum.parser.Obj.MObjekt;

//TODO:Serialisiuerng . . . 
public class Ereignisgenerator extends MObjekt {
	

	private int aktivitaetsrate;
	private ArrayList<Ort> zustaendigFuer = new ArrayList<>();
	//TODO:Diagramm anpassen
	
	public Ereignisgenerator(String name, int aktivitaetsrate){
		super(name);
		this.aktivitaetsrate = aktivitaetsrate;
	}
	
	public Ereignisgenerator(int aktivitaetsrate){
		super();
		this.aktivitaetsrate = aktivitaetsrate;
	}
	
	public int getRate(){
		return aktivitaetsrate;
	}
	
	public void bereichErweitern(Ort o){
		zustaendigFuer.add(o);
	}
	
	public ArrayList<Ort> zuestandigFuer(){
		return zustaendigFuer;
	}

}