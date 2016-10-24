package haw.cas.praktikum.objects;

import java.util.ArrayList;
import java.util.List;

import haw.cas.praktikum.parser.Obj.MObjekt;

//TODO:Serialisiuerng . . . 
public class Ereignisgenerator extends MObjekt {


    private int aktivitaetsrate;
    private List<Ort> zustaendigFuer;
    //TODO:Diagramm anpassen

    public Ereignisgenerator(String name, int aktivitaetsrate) {
        super(name);
        this.aktivitaetsrate = aktivitaetsrate;
        this.zustaendigFuer = new ArrayList<>();
    }

    public Ereignisgenerator(int aktivitaetsrate) {
        super();
        this.aktivitaetsrate = aktivitaetsrate;
        this.zustaendigFuer = new ArrayList<>();
    }

    public int getRate() {
        return aktivitaetsrate;
    }

    public void bereichErweitern(Ort o) {
        zustaendigFuer.add(o);
    }

    public void bereichVerkleinern(Ort o) {
        zuestandigFuer().remove(o);
    }

    public List<Ort> zuestandigFuer() {
        return zustaendigFuer;
    }

}