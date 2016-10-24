package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Handelsregister;
import haw.cas.praktikum.objects.Konsortium;
import haw.cas.praktikum.parser.MObjektReposetory;
import haw.cas.praktikum.parser.prolog.PrologParser;

public class EingetragenParser implements PrologParser {

	@Override
	public void create(String[] param) {
		assert param.length == 2 : "the Parameter Length for an ort must be 3, but was "
				+ param.length;
		String nameK = param[0];
		String nameH = param[1];

		Konsortium k = (Konsortium) MObjektReposetory.get(nameK);
		Handelsregister h = (Handelsregister) MObjektReposetory.get(nameH);
		k.eintragen(h);

	}

}
