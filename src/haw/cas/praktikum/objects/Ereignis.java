package haw.cas.praktikum.objects;

import java.util.ArrayList;

import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.zeittyp.ZeitTyp;

//TODO:Serialisierung . . .
public class Ereignis extends MObjekt {

    private Ort ort1;
    private Ort ort2;
    private double kosten;
    private ZeitTyp verfallsZeitpunkt;

    public Ereignis(Ort ort1, Ort ort2, double kosten, ZeitTyp dauer) {
        this.ort1 = ort1;
        this.ort2 = ort2;
        this.kosten = kosten;
        this.verfallsZeitpunkt = dauer;
    }

    public ArrayList<Ort> betrifft() {
        ArrayList<Ort> result = new ArrayList<Ort>();
        result.add(ort1);
        result.add(ort2);
        return result;
    }

    public double getKosten() {
        return kosten;
    }

    public void setKosten(double value) {
        this.kosten = value;
    }

    public ZeitTyp getDauer() {
        return verfallsZeitpunkt;
        //TODO: Berechnung
    }

    public Ort getOrt1() {
        return ort1;
    }

    public void setOrt1(Ort ort1) {
        this.ort1 = ort1;
    }

    public Ort getOrt2() {
        return ort2;
    }

    public void setOrt2(Ort ort2) {
        this.ort2 = ort2;
    }
}