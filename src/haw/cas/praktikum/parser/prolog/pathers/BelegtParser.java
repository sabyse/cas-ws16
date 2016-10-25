package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.LKW;
import haw.cas.praktikum.objects.Tankstelle;
import haw.cas.praktikum.parser.MObjektRepository;
import haw.cas.praktikum.parser.prolog.PrologParser;


/**
 * definiert wie folgt:
 * ort(name,
 * 
 **/
public class BelegtParser implements PrologParser{
	@Override
	public void create(String[] param) {
		assert param.length == 2 : "the Parameter Length for an belegt must be 2, but was " + param.length;
		String tanksteleS = param[0];
		String lkwS = param[1];
		
		Tankstelle t = (Tankstelle)MObjektRepository.get(tanksteleS);
		LKW lkw = (LKW)MObjektRepository.get(lkwS);
		t.setBelegt(lkw);
	}
}
