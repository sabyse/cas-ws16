package main;

import java.util.List;

public class Ort implements MObjekt{

	public String name;
	public List<Strasse> angebunden;
	public Funk erreichbar;
	public List<LocalServices> localServices;

	public Ort(String name, List<Strasse> angebunden, Funk erreichbar, List<LocalServices> localServices) {
		this.name = name;
		this.angebunden = angebunden;
		this.erreichbar = erreichbar;
		this.localServices = localServices;
	}

	public void addLocalService(LocalServices localService) {
		localServices.add(localService);
	}

	public void removeLocalService(LocalServices localService) {
		localServices.remove(localService);
	}

	public void addStrasse(Strasse strasse) {
		angebunden.add(strasse);
	}

	public void removeStrasse(Strasse strasse) {
		angebunden.remove(strasse);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Strasse> getAngebunden() {
		return angebunden;
	}

	public void setAngebunden(List<Strasse> angebunden) {
		this.angebunden = angebunden;
	}

	public Funk getErreichbar() {
		return erreichbar;
	}

	public void setErreichbar(Funk erreichbar) {
		this.erreichbar = erreichbar;
	}

	public List<LocalServices> getLocalServices() {
		return localServices;
	}

	public void setLocalServices(List<LocalServices> localServices) {
		this.localServices = localServices;
	}
}