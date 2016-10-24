package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.objects.Ereignis;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.parser.MObjektReposetory;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.prolog.PrologParser;
import haw.cas.praktikum.zeittyp.ZeitTyp;

public class EreignisParser implements PrologParser {

	@Override
	public void create(String[] param) {
		assert param.length == 4: "the Parameter Length for an ereignis must be 4, but was " + param.length;
		
		String o1S = param[0];
		String o2S = param[1];
		String kostenS = param[2];
		String dauerS = param[3];
		MObjekt o1 =  MObjektReposetory.get(o1S);
		MObjekt o2 =  MObjektReposetory.get(o2S);		
		double kosten = Double.parseDouble(kostenS);
		ZeitTyp dauer = new ZeitTyp(Long.parseLong(dauerS));
		new Ereignis((Ort)o1,(Ort)o2,kosten,dauer);
		
	}

}
