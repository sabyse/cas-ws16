package haw.cas.praktikum.parser.prolog.generators;

import java.util.stream.Stream;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.objects.Auftrag;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.objects.Strasse;
import haw.cas.praktikum.objects.Tankstelle;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;

public class AuftragsGenerator implements PrologGenerator {

	public void generate(ConfigFile cf, Stream<MObjekt> os) {
		os.filter(s -> s instanceof Auftrag).forEach(
				a -> {
					cf.addToSection(2,"auftrag("+a.getUID()+"," 
												+((Auftrag)a).getStart()+","
												+((Auftrag)a).getZiel()+","
												+((Auftrag)a).getWert()+","
												+((Auftrag)a).getMenge()+").");
					for(Auftrag s : ((Auftrag )a).getAllSubAuftrag()){
						cf.addToSection(3, "sub("+s.getUID()+","+a.getUID()+").");
					}
				});
	}
}
