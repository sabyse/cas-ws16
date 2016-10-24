package haw.cas.praktikum.objects;

import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;

//TODO:Serialisierung . . .
public class Strassennetz extends MObjekt{

	public List<Ort> orte;
	public List<Ereignisgenerator> ereignisgenerator;	 //TODO: braucht ne liste von AuftragsGeneratoren
	public List<Akteur> akteurList;
	public List<Auftragsgenerator> auftragsgeneratorList;

}