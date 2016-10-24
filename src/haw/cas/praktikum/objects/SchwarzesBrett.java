package haw.cas.praktikum.objects;

import haw.cas.praktikum.parser.Obj.MObjekt;

import java.util.ArrayList;

//TODO:Serialisiuerng . . . 
public class SchwarzesBrett extends MObjekt implements LocalServices {
	private ArrayList<Nachricht> angepinnt = new ArrayList<>();
	
	public SchwarzesBrett(String name){
		super(name);
	}

	@Override
	public String getID() {		
		return super.getUID();
	}
	
	public void anpinnen(Nachricht n){
		angepinnt.add(n);
	}
	
	public ArrayList<Nachricht> getNachrichten(){
		return angepinnt;
	}

}