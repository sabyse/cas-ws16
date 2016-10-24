package haw.cas.praktikum.objects;

import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;
//TODO:Serialisiuerng . . . 
public class Akteur extends MObjekt{

	private List<Auftrag> auftragList;
	private Double kontostand;
	private List<Akteur> bekannte;
	
	public Akteur (String id, Double kontostand){
		super(id);
		this.kontostand = kontostand;
	}
	
	public Akteur (Double kontostand){
		super();
		this.kontostand = kontostand;
	}
	

	public Double getKontostand() {
		return kontostand;
	}

	public void setKontostand(Double kontostand) {
		this.kontostand = kontostand;
	}

	public List<Akteur> getBekannte() {
		return bekannte;
	}

	public void setBekannte(List<Akteur> bekannte) {
		this.bekannte = bekannte;
	}


	public List<Auftrag> getAuftragList() {
		return auftragList;
	}

	public void addAuftragList(Auftrag auftrag) {
		this.auftragList.add(auftrag);
	}

	public void removeAuftragList(Auftrag auftrag) {
		this.auftragList.remove(auftrag);
	}

}