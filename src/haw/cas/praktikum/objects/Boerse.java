package haw.cas.praktikum.objects;

import haw.cas.praktikum.parser.Obj.MObjekt;

import java.util.ArrayList;
import java.util.List;

//TODO:Serialisiuerng . . . 
public class Boerse extends MObjekt implements LocalServices {

    private List<Auftrag> verfuegbar;

    public Boerse(String name) {
        super(name);
        verfuegbar = new ArrayList<>();
    }

    @Override
    public String getID() {
        return super.getUID();
    }

    public void addAuftrag(Auftrag auftrag) {
        verfuegbar.add(auftrag);
    }

    public void removeAuftrag(Auftrag auftrag) {
        verfuegbar.remove(auftrag);
    }

    public List<Auftrag> bietetAn() {
        return verfuegbar;
    }

}