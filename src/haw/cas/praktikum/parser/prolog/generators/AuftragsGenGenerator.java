package haw.cas.praktikum.parser.prolog.generators;

import haw.cas.praktikum.objects.Auftragsgenerator;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;

import java.util.stream.Stream;

public class AuftragsGenGenerator implements PrologGenerator{

	@Override
	public void generate(ConfigFile cf, Stream<MObjekt> os) {
		os.filter(e -> e instanceof Auftragsgenerator).forEach(
				auftragsGen -> {
					cf.addToSection(
							1,
							"auftragsgen("
									+ auftragsGen.getUID()
									+ ","
									+ ((Auftragsgenerator) auftragsGen)
											.getAktivitaetsrate() + ").");
					for (Ort o : ((Auftragsgenerator) auftragsGen)
							.zuestandigFuer()) {
						cf.addToSection(2, "zustaendig(" + auftragsGen.getUID()
								+ "," + o.getUID() + ").");
					}

				});
	}

}