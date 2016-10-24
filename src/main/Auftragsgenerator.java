package main;

import java.util.List;

public class Auftragsgenerator {

	public List<Ort> zustaendigFuer; //???? Unnötig bzw liste aller Orte?
	public int aktivitaetsrate;
	public List<Boerse> zustaendigeBoersen;

	public int getAktivitaetsrate() {
		return aktivitaetsrate;
	}

	public void setAktivitaetsrate(int aktivitaetsrate) {
		this.aktivitaetsrate = aktivitaetsrate;
	}
}