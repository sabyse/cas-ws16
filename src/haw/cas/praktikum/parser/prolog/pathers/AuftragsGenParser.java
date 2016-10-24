package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Auftragsgenerator;
import haw.cas.praktikum.parser.prolog.PrologParser;

public class AuftragsGenParser implements PrologParser {

	@Override
	public void create(String[] param) {
		assert param.length == 2 : "the Parameter Length for an AuftrragsGen must be 2, but was " + param.length;
		String name = param[0];
		String kostenS = param[1];
		int kosten = Integer.parseInt(kostenS);
		new Auftragsgenerator(name,kosten);
	}

}
