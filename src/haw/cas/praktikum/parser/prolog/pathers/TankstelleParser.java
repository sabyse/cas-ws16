package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Funk;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.objects.SchwarzesBrett;
import haw.cas.praktikum.objects.Tankstelle;
import haw.cas.praktikum.parser.prolog.PrologParser;
import haw.cas.praktikum.zeittyp.ZeitTyp;
import haw.cas.praktikum.zeittyp.ZeitTypDiff;


/**
 * definiert wie folgt:
 * ort(name,
 * 
 **/
public class TankstelleParser implements PrologParser{
	@Override
	public void create(String[] param) {
		assert param.length == 3 : "the Parameter Length for an ort must be 3, but was " + param.length;
		String name = param[0];
		String kostenS = param[1];
		String dauerS = param[2];
		
		ZeitTyp dauer = new ZeitTyp(dauerS);
		double kosten = Double.parseDouble(kostenS);
		
		new Tankstelle(name, dauer,kosten);
	}
}
