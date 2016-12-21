package haw.cas.praktikum.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import haw.cas.praktikum.parser.Obj.MObjekt;

/**
 * Created by Khang on 20.12.16.
 */
public class SpielfeldAktiv extends MObjekt implements Runnable{

    private ArrayList<Akteur> trucker = new ArrayList<>();
    private Strassennetz netz;

    public SpielfeldAktiv(Strassennetz netz){
        this.netz = netz;
    }

    public void addTrucker(Ort o, Akteur a){
        trucker.add(a);
        netz.getTruckerOrt().get(o).add(a);
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}
