package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Auftragsgenerator;
import haw.cas.praktikum.objects.Ereignisgenerator;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.objects.Strasse;
import haw.cas.praktikum.parser.MObjektReposetory;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.prolog.PrologParser;

public class ZustaendigParser implements PrologParser {

	@Override
	public void create(String[] param) {
		assert param.length == 2 : "the Parameter Length for zuestandig must be 2, but was "
				+ param.length;

		String genS = param[0];
		String ortS = param[1];

		MObjekt gen = MObjektReposetory.get(genS);
		MObjekt ort = MObjektReposetory.get(ortS);

		// TODO:Null check

		assert (ort instanceof Ort) : "Not a valid  Ort";

		if (gen instanceof Ereignisgenerator) {
			((Ereignisgenerator) gen).bereichErweitern((Ort) ort);
		}
		if (gen instanceof Auftragsgenerator) {
			((Auftragsgenerator) gen).bereichErweitern((Ort) ort);
		}
	}

}
