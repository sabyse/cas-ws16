package haw.cas.praktikum.objects;

import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;

//TODO:Serialisiuerng . . . 
public class Funk extends MObjekt implements LocalServices {
	
	private List<Ort> verfuegbar;
	//TODO : Fehlt hier nicht was?
	
	public Funk(String name){
		super(name);
	}

	@Override
	public String getID() {		
		return super.getUID();
	}
	
}