package haw.cas.praktikum.objects;

import java.util.ArrayList;
import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;

//TODO:Serialisierung . . .
public class Akteur extends MObjekt {

    private List<Auftrag> auftragList;
    private double kontostand;
    private List<Akteur> bekannte;
    private SpielfeldAktiv saktiv;
    private ArrayList<Nachricht> nachrichten;

    public Akteur(String id, double kontostand, SpielfeldAktiv saktiv) {
        super(id);
        this.kontostand = kontostand;
        this.auftragList = new ArrayList<>();
        this.bekannte = new ArrayList<>();
        this.saktiv = saktiv;
        this.nachrichten = new ArrayList<>();
    }

    public Akteur(double kontostand, SpielfeldAktiv saktiv) {
        super();
        this.kontostand = kontostand;
        this.auftragList = new ArrayList<>();
        this.bekannte = new ArrayList<>();
        this.saktiv = saktiv;
        this.nachrichten = new ArrayList<>();
    }

    public Double getKontostand() {
        return kontostand;
    }

    public void setKontostand(Double kontostand) {
        this.kontostand = kontostand;
    }

    public void addBekannte(Akteur bekannte) { this.bekannte.add(bekannte); }

    public void removeBekannte(Akteur bekannte) { this.bekannte.remove(bekannte); }

    public void addAuftrag(Auftrag auftrag) { this.auftragList.add(auftrag); }

    public void removeAuftragList(Auftrag auftrag) {
        this.auftragList.remove(auftrag);
    }

    public boolean addNachricht(Nachricht n){
        return nachrichten.add(n);
    }

}