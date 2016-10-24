package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.parser.prolog.PrologParser;

public class AkteurParser implements PrologParser {

	@Override
	public void create(String[] param) {
		assert param.length == 2: "the Parameter Length for an akteur must be 2, but was " + param.length;
		
		String id = param[0];
		String kontoStand = param[1];
		double kontostand = Double.parseDouble(kontoStand);
		new Akteur(id,kontostand);
		
	}

}

