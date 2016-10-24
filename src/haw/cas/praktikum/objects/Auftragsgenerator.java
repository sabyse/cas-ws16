package haw.cas.praktikum.objects;

import java.util.ArrayList;
import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;

//TODO:Serialisierung . . .
public class Auftragsgenerator extends MObjekt {

    // TODO:Zustaendigkeit
    // ist ueber die Boersen geregelt, ein Verweis auf
    // das Strassennetz ist notwendig

    private int aktivitaetsrate;
    private List<Ort> zustaendigFuer;
    private List<Boerse> zustaendigeBoersen;

    public Auftragsgenerator(String name, int aktivitaetsrate) {
        super(name);
        this.aktivitaetsrate = aktivitaetsrate;
        this.zustaendigFuer = new ArrayList<>();
        this.zustaendigeBoersen = new ArrayList<>();
    }

    public Auftragsgenerator(int aktivitaetsrate) {
        super();
        this.aktivitaetsrate = aktivitaetsrate;
        this.zustaendigFuer = new ArrayList<>();
        this.zustaendigeBoersen = new ArrayList<>();
    }

    public int getAktivitaetsrate() {
        return aktivitaetsrate;
    }

    public void setAktivitaetsrate(int aktivitaetsrate) {
        this.aktivitaetsrate = aktivitaetsrate;
    }

    public void bereichErweitern(Ort o) {
        zustaendigFuer.add(o);
    }

    public void bereichVerkleinern(Ort o) {
        zustaendigFuer.remove(o);
    }

    public void addBoerse(Boerse b) {
        zustaendigeBoersen.add(b);
    }

    public void removeBoerse(Boerse b) {
        zustaendigeBoersen.remove(b);
    }

    public List<Ort> zustaendigeOrte() {
        return zustaendigFuer;
    }

}