package haw.cas.praktikum.parser.Obj;

import java.util.UUID;

import haw.cas.praktikum.parser.MObjektReposetory;

public class MObjekt {
	String key;
	
	protected MObjekt(){
		this.key = UUID.randomUUID().toString();
		MObjektReposetory.add(key, this);
	}
	protected MObjekt(String key){
		this.key = key;	//TODO: prüfen ob key bereits vorhanden
		MObjektReposetory.add(key, this);
	}
	public void updateKey(String key){
		MObjektReposetory.remove(this.key);
		this.key=key;
		MObjektReposetory.add(this.key, this);
	}
	public String getUID(){
		return key;
	}
}
