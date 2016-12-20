package haw.cas.praktikum.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;

//TODO:Serialisierung . . .
public class Strassennetz extends Netz{

	public List<Ort> orte;
	public List<Ereignisgenerator> ereignisgenerator;	 //TODO: braucht ne liste von AuftragsGeneratoren
	public List<Akteur> akteurList;
	public List<Auftragsgenerator> auftragsgeneratorList;
	private HashMap<Ort,ArrayList<Akteur>> truckerOrt;

	public HashMap<Ort,ArrayList<Akteur>> getTruckerOrt(){
		return truckerOrt;
	}

}