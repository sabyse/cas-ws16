package haw.cas.praktikum.objects;

/**
 * Created by Khang on 06.12.2016.
 */
public class Funknetz extends Netz {

    public boolean sendeNachricht(Akteur other, Nachricht n){
        return other.addNachricht(n);
    }

}
