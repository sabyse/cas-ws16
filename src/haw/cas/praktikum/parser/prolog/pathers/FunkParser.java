package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Funk;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.objects.SchwarzesBrett;
import haw.cas.praktikum.parser.prolog.PrologParser;


/**
 * definiert wie folgt:
 * ort(name,
 * 
 **/
public class FunkParser implements PrologParser{
	@Override
	public void create(String[] param) {
		assert param.length == 1 : "the Parameter Length for a funk must be 1, but was " + param.length;
		String name = param[0];
		new Funk(name);
	}
}
