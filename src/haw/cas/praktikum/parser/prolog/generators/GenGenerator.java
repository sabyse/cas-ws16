package haw.cas.praktikum.parser.prolog.generators;

import haw.cas.praktikum.objects.Auftragsgenerator;
import haw.cas.praktikum.objects.Ereignis;
import haw.cas.praktikum.objects.Ereignisgenerator;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.objects.Strasse;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;

import java.util.stream.Stream;

public class GenGenerator implements PrologGenerator {

	@Override
	public void generate(ConfigFile cf, Stream<MObjekt> os) {
		os.filter(e -> (e instanceof Ereignisgenerator)||(e instanceof Auftragsgenerator)).forEach(
				
				gen -> {
					if(gen instanceof Ereignisgenerator){
						cf.addToSection(1, "ereignisgen("+ gen.getUID()+ ","
										                 + ((Ereignisgenerator) gen).getRate() + ").");
						for (Ort o : ((Ereignisgenerator) gen).zuestandigFuer()) {
							cf.addToSection(2, "zustaendig(" + gen.getUID() + "," 
						                                     + o.getUID() + ").");
						}
					}else if(gen instanceof Auftragsgenerator){
						cf.addToSection(1,"auftragsgen("+ gen.getUID()+ ","
										                + ((Auftragsgenerator) gen).getAktivitaetsrate() + ").");
						for (Ort o : ((Auftragsgenerator) gen).zustaendigeOrte()) {
							cf.addToSection(2, "zustaendig(" + gen.getUID()+ "," 
						                                     + o.getUID() + ").");
						}
					}
				});
				
				
	}

}
