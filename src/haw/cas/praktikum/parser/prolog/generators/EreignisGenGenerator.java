package haw.cas.praktikum.parser.prolog.generators;

import haw.cas.praktikum.objects.Ereignis;
import haw.cas.praktikum.objects.Ereignisgenerator;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.objects.Strasse;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;

import java.util.stream.Stream;

public class EreignisGenGenerator implements PrologGenerator {

	@Override
	public void generate(ConfigFile cf, Stream<MObjekt> os) {
		os.filter(e -> e instanceof Ereignisgenerator).forEach(
				ereignisGen -> {
					cf.addToSection(
							1,
							"ereignisgen("
									+ ereignisGen.getUID()
									+ ","
									+ ((Ereignisgenerator) ereignisGen)
											.getRate() + ").");
					for (Ort o : ((Ereignisgenerator) ereignisGen)
							.zuestandigFuer()) {
						cf.addToSection(2, "zustaendig(" + ereignisGen.getUID()
								+ "," + o.getUID() + ").");
					}

				});
	}

}
