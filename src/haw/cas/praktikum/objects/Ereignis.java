package haw.cas.praktikum.objects;

import java.util.ArrayList;

import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.zeittyp.ZeitTyp;

//TODO:Serialisierung . . .
public class Ereignis extends MObjekt {

	private int kosten;
    private ZeitTyp verfallsZeitpunkt;

    public Ereignis(int kosten, ZeitTyp dauer) {
        this.kosten = kosten;
        this.verfallsZeitpunkt = dauer;
    }

    public int getKosten() {
        return kosten;
    }

    public void setKosten(int value) {
        this.kosten = value;
    }

    public ZeitTyp getEnde() {
        return verfallsZeitpunkt;
        //TODO: Berechnung
    }
}