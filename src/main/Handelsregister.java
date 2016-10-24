package main;

import java.util.List;

public class Handelsregister implements LocalServices, MObjekt {

    private List<Konsortium> eingetragen;

    public Handelsregister(List<Konsortium> eingetragen) {
        this.eingetragen = eingetragen;
    }

    public List<Konsortium> getEintraege() {
        return eingetragen;
    }

    public void setEintraege(List<Konsortium> eingetragen) {
        this.eingetragen = eingetragen;
    }

    public void addEintrag(Konsortium konsortium) {
        eingetragen.add(konsortium);
    }

    public void removeEintrag(Konsortium konsortium) {
        eingetragen.remove(konsortium);
    }

}