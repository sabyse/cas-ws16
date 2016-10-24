package haw.cas.praktikum.parser.prolog.generators;

import java.util.stream.Stream;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.objects.Strasse;
import haw.cas.praktikum.objects.Tankstelle;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;

public class AkteurGenerator implements PrologGenerator {

	public void generate(ConfigFile cf, Stream<MObjekt> os) {
		os.filter(s -> s instanceof Akteur).forEach( // Sektions nummer
														// Auslagern in andere
														// Klasse ?
				akteur -> {
					cf.addToSection(1, "akteur(" + akteur.getUID() + ","
							+ ((Akteur) akteur).getKontostand().toString()
							+ ").");

				});
	}
}
