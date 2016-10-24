package haw.cas.praktikum.objects;

import haw.cas.praktikum.parser.Obj.MObjekt;

import java.util.ArrayList;

//TODO:Serialisiuerng . . . 
public class Boerse extends MObjekt implements LocalServices {
	private ArrayList<Auftrag> verfuegbar = new ArrayList<>();
	
	public Boerse(String name){
		super(name);
	}

	@Override
	public String getID() {
		return super.getUID();
	}
	
	public void addAuftrag(Auftrag auftrag){
		verfuegbar.add(auftrag);
	}
	
	public void removeAuftrag(Auftrag auftrag){
		verfuegbar.remove(auftrag);
	}
	
	public ArrayList<Auftrag> bietetAn(){
		return verfuegbar;
	}

}