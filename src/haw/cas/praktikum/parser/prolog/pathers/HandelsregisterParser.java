package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Handelsregister;
import haw.cas.praktikum.parser.prolog.PrologParser;

public class HandelsregisterParser implements PrologParser {

	@Override
	public void create(String[] param) {
		assert param.length == 1 : "the Parameter Length for a handelsregister must be 1, but was " + param.length;
		String name = param[0];
		new Handelsregister(name);
	}

}
