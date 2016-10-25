package haw.cas.praktikum.parser.prolog.generators;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.objects.Auftrag;
import haw.cas.praktikum.objects.LKW;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;

import java.util.stream.Stream;

public class LKWGenerator implements PrologGenerator {

	@Override
	public void generate(ConfigFile cf, Stream<MObjekt> os) {
		os.filter(s -> s instanceof LKW).forEach( // Sektions nummer
													// Auslagern in andere
													// Klasse ?
				lkw -> {
					cf.addToSection(2,
							"lkw(" + lkw.getUID() + ","
									+ ((LKW) lkw).getBesitzer().getUID() + ","
									+ ((LKW) lkw).getPos().getUID() + ","
									+ ((LKW) lkw).getLadekapazitaet() + ").");

					// ArrayList<Auftrag> ladung = ((LKW) lkw)).getLadung();
					if (!((LKW) lkw).getLadung().isEmpty()) {
						for (Auftrag a : ((LKW) lkw).getLadung()) {
							cf.addToSection(3, "storedIn(" + a.getUID() + ","
									+ ((LKW) lkw).getUID() + ").");
						}
					}

				});
	}

}
