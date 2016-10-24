package main;

import java.util.List;

public class Akteur implements MObjekt{

	private List<Auftrag> auftragList;
	private Double kontostand;
	private List<Akteur> bekannte;

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