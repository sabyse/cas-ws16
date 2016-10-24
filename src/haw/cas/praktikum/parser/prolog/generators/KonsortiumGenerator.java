package haw.cas.praktikum.parser.prolog.generators;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.objects.Konsortium;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;

import java.util.stream.Stream;

public class KonsortiumGenerator implements PrologGenerator {

	@Override
	public void generate(ConfigFile cf, Stream<MObjekt> os) {
		os.filter(s -> s instanceof Konsortium).forEach( // Sektions nummer
				// Auslagern in andere
				// Klasse ?
				k -> {
					cf.addToSection(1, "konsortium(" + k.getUID() + ","
							+ ((Konsortium) k).getInhaber().getUID() + ").");

					if (((Konsortium) k).eingetragenIn() != null) {
						cf.addToSection(2, "eingetragen(" + k.getUID() + ","
								+ ((Konsortium) k).eingetragenIn().getUID()
								+ ").");
					}

					if (!((Konsortium) k).getTeilnehmer().isEmpty()) {
						for (Akteur a : ((Konsortium) k).getTeilnehmer()) {
							cf.addToSection(2, "teilnehmer(" + a.getUID() + ","
									+ k.getUID() + ").");
						}
					}
				});
	}

}
