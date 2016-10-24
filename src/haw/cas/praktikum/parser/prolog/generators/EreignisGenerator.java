package haw.cas.praktikum.parser.prolog.generators;

import java.util.stream.Stream;

import haw.cas.praktikum.objects.Ereignis;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;

public class EreignisGenerator implements PrologGenerator {

	@Override
	public void generate(ConfigFile cf, Stream<MObjekt> os) {
		os.filter(e -> e instanceof Ereignis).forEach(
				ereignis -> {
					cf.addToSection(1, "ereignis("
							+ ((Ereignis) ereignis).betrifft().get(0).getUID() + ","
							+ ((Ereignis) ereignis).betrifft().get(1).getUID() + ","
							+ ((Ereignis) ereignis).getKosten() + ","
							+ ((Ereignis) ereignis).getDauer().toString() + ").");
				});
	}
}

