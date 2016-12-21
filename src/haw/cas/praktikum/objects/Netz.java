package haw.cas.praktikum.objects;

import haw.cas.praktikum.parser.Obj.MObjekt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Khang on 29.11.16.
 */
public abstract class Netz extends MObjekt implements NetzFaehig{

    private HashMap<NetzFaehig,HashMap<NetzFaehig,Integer>> verbindungsMatrix = new HashMap<NetzFaehig,HashMap<NetzFaehig,Integer>>();

    public Netz(){
        super();
    }

    public void add(NetzFaehig v){
        if(!verbindungsMatrix.containsKey(v)) {
            verbindungsMatrix.put(v, new HashMap<NetzFaehig, Integer>());
        }
    }

    public void delete(NetzFaehig v){
        verbindungsMatrix.remove(v);
    }

    public void connect(NetzFaehig source, NetzFaehig target){
        if(!verbindungsMatrix.containsKey(source)){
            add(source);
        }
        verbindungsMatrix.get(source).put(target,0);
        //mehrfachkanten gehen nicht da datenstruktur
    }

    public void disconnect(NetzFaehig source, NetzFaehig target){
        if(!verbindungsMatrix.containsKey(source)){
            //Wie soll mit Fehlern umgegangen werden?
            throw new Error("Es gibt keine Strasse von source nach target");
        }
        verbindungsMatrix.get(source).remove(target);
    }

    public List<NetzFaehig> getAdjacent(NetzFaehig vertex){
        List<NetzFaehig> result = getTarget(vertex);
        result.addAll(getSource(vertex));
        return result;
    }

    public List<NetzFaehig> getTarget(NetzFaehig vertex){
        if(!verbindungsMatrix.containsKey(vertex)){
            throw new Error("Es gibt keinen Ort " + vertex);
        }
        return verbindungsMatrix.get(vertex).keySet().stream().collect(Collectors.toList());
    }

    public List<NetzFaehig> getSource(NetzFaehig vertex){
        List<NetzFaehig> result = new ArrayList<NetzFaehig>();
        for(NetzFaehig n : verbindungsMatrix.keySet()){
            if(verbindungsMatrix.get(n).keySet().contains(vertex)) {
                result.add(n);
            }
        }
        return result;
    }
}
