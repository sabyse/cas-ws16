package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Ereignisgenerator;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.parser.prolog.PrologParser;

public class EreignisGenParser implements PrologParser{

	
	@Override
	public void create(String[] param) {
		assert param.length == 2 : "the Parameter Length for an EreignisGen must be 2, but was " + param.length;
		String name = param[0];
		String kostenS = param[1];
		int kosten = Integer.parseInt(kostenS);
		new Ereignisgenerator(name,kosten);
	}

}
