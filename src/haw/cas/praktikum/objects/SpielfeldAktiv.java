package haw.cas.praktikum.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Khang on 20.12.16.
 */
public class SpielfeldAktiv {

    private ArrayList<Akteur> trucker = new ArrayList<>();
    private Strassennetz netz;

    public SpielfeldAktiv(Strassennetz netz){
        this.netz = netz;
    }

    public void addTrucker(Akteur t){
        trucker.add(t);
    }

    public void setTruckerOrt(Ort o, Akteur a){
        if(trucker.contains(a)) {
            for (Map.Entry<Ort, ArrayList<Akteur>> e : netz.getTruckerOrt().entrySet()) {
                Ort key = e.getKey();
                ArrayList<Akteur> value = e.getValue();
                if (value.contains(a)) {
                    value.remove(a);
                    break;
                }
            }
            netz.getTruckerOrt().get(o).add(a);
        }
    }

}
