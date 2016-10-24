package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.objects.Konsortium;
import haw.cas.praktikum.parser.MObjektReposetory;
import haw.cas.praktikum.parser.prolog.PrologParser;

public class KonsortiumParser implements PrologParser {

	@Override
	public void create(String[] param) {
		assert param.length == 2 : "the Parameter Length for a konsortium must be 1, but was " + param.length;
		String name = param[0];
		String besitzerS = param[1];
		
		Akteur besitzer = (Akteur) MObjektReposetory.get(besitzerS);
		new Konsortium(name, besitzer);
	}

}
