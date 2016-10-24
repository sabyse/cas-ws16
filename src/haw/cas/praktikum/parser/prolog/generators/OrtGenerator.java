package haw.cas.praktikum.parser.prolog.generators;

import java.util.stream.Stream;

import haw.cas.praktikum.objects.LocalServices;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.objects.Strasse;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;

public class OrtGenerator implements PrologGenerator {
//TODO: vileicht f�r typen registriern ? (Observer)
//TODO: Reinvol vileicht automatioch durch dependencies managen
	
	@Override
	public void generate(ConfigFile cf, Stream<MObjekt> os) {
		os	.filter( s -> s instanceof Ort)
			.forEach(						//Sektions nummer Auslagern in andere Klasse ?
					ort -> {
						cf.addToSection(1, "ort("+ort.getUID()+").");
						for(Strasse s : ((Ort)ort).getAngebunden()){
							cf.addToSection(2, "strasse("+s.start.getUID()+","+s.ende.getUID()+","+ s.kosten+ ")");
						}
						for(LocalServices l : ((Ort)ort).getLocalServices()){
							cf.addToSection(2, "linkLocal(" + ort.getUID() +"," + l.getID() + ").");
						}
					}
			);
	}
}
