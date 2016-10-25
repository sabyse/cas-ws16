package haw.cas.praktikum.parser.Obj;

import java.util.UUID;

import haw.cas.praktikum.parser.MObjektRepository;

public class MObjekt {
	String key;
	
	protected MObjekt(){
		this.key = UUID.randomUUID().toString();
		MObjektRepository.add(key, this);
	}
	protected MObjekt(String key){
		this.key = key;	//TODO: prüfen ob key bereits vorhanden
		MObjektRepository.add(key, this);
	}
	public void updateKey(String key){
		MObjektRepository.remove(this.key);
		this.key=key;
		MObjektRepository.add(this.key, this);
	}
	public String getUID(){
		return key;
	}
}
