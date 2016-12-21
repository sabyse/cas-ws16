package haw.cas.praktikum.parser;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.objects.LKW;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.objects.Ortsnetz;
import haw.cas.praktikum.objects.SpielfeldAktiv;
import haw.cas.praktikum.objects.Strassennetz;
import haw.cas.praktikum.parser.configFile.ConfigFile;
import haw.cas.praktikum.parser.configFile.SimpleConfigFile;
import haw.cas.praktikum.parser.prolog.PrologGenerator;
import haw.cas.praktikum.parser.prolog.PrologParser;
import haw.cas.praktikum.parser.prolog.generators.AkteurGenerator;
import haw.cas.praktikum.parser.prolog.generators.AuftragsGenerator;
import haw.cas.praktikum.parser.prolog.generators.GenGenerator;
import haw.cas.praktikum.parser.prolog.generators.KonsortiumGenerator;
import haw.cas.praktikum.parser.prolog.generators.LKWGenerator;
import haw.cas.praktikum.parser.prolog.generators.LocalServiceGenerator;
import haw.cas.praktikum.parser.prolog.generators.NetGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public final class Parser {
	private Parser() {
	}

	private static HashMap<String, PrologParser> functionMap;
	private static List<PrologGenerator> generatorList;

	static void init() {

		MObjektRepository.clear();

		functionMap = new HashMap<>();
		functionMap.put("ortsNetz", (param)->{
			assert param.length == 0 : "the Parameter Length for an ort must be 0, but was " + param.length;
			(new Strassennetz()).updateKey("__ORTS_NETZ__");
		});
		
		functionMap.put("ort", (param)->{
			assert param.length == 1 : "the Parameter Length for an ort must be 1, but was " + param.length;
			Ortsnetz o = new Ortsnetz(param[0]);
			o.updateKey(param[0]);
			Strassennetz on = (Strassennetz)MObjektRepository.get("__ORTS_NETZ__");
			on.add(o);
		});
		
		functionMap.put("strasse", (param)->{
			assert param.length == 2 : "the Parameter Length for an ort must be 2, but was " + param.length;
			Ortsnetz o1 = (Ortsnetz)MObjektRepository.get(param[0]);
			Ortsnetz o2 = (Ortsnetz)MObjektRepository.get(param[1]);
			Strassennetz on = (Strassennetz)MObjektRepository.get("__ORTS_NETZ__");
			on.connect(o1, o2);
		});
		
		functionMap.put("spielfeld", (param)->{
			assert param.length == 0 : "the Parameter Length for an ort must be 0, but was " + param.length;
			Strassennetz on = (Strassennetz)MObjektRepository.get("__ORTS_NETZ__");
			SpielfeldAktiv sf = new SpielfeldAktiv(on);
			sf.updateKey("__SPIELFELD__");
		});
		
		functionMap.put("akteur", (param)->{
			assert param.length == 2 : "the Parameter Length for an ort must be 2, but was " + param.length;
			Strassennetz on = (Strassennetz)MObjektRepository.get("__ORTS_NETZ__");
			SpielfeldAktiv sf = (SpielfeldAktiv)MObjektRepository.get("__SPIELFELD__");
			Akteur a = new Akteur(param[0], Double.parseDouble(param[1]), sf);
		});
		
		
		
		    
		
		
		
		
		// functionMap.put(Funk.class.getName().toLowerCase(), new
		// StrasseParser());
		// functionMap.put(SchwarzesBrett.class.getName().toLowerCase(), new
		// SchwarzesBrettParser());
		// functionMap.put(Tankstelle.class.getName().toLowerCase(), new
		// TankstelleParser());
		// functionMap.put(Umladebucht.class.getName().toLowerCase(), new
		// UmladebuchtParser());
		
		/*generatorList = new ArrayList<>();

		generatorList.add(new AkteurGenerator());
		generatorList.add(new AuftragsGenerator());
		generatorList.add(new GenGenerator());
		generatorList.add(new KonsortiumGenerator());
		generatorList.add(new LKWGenerator());
		generatorList.add(new LocalServiceGenerator());
		generatorList.add(new NetGenerator());*/
	}

	public static void main(String[] args) {
		init();
		long now = System.currentTimeMillis();
		parse("test.P");
		System.out.println(System.currentTimeMillis() - now);
		
		//now = System.currentTimeMillis();
		//store("out.P");
		//System.out.println(System.currentTimeMillis() - now);
	}

	public static void store(String datei) {
		ConfigFile cf = new SimpleConfigFile(datei);
		for (PrologGenerator pg : generatorList) {
			pg.generate(cf, MObjektRepository.getStream());
		}
		;
		cf.store();

	}

	public static void parse(String datei) {
		try (Stream<String> stream = Files.lines(Paths.get(datei))) {
			stream.forEach(Parser::parseLine);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void parseLine(String line) {

		// Validit�t der Line Pr�fen
		if (line.isEmpty()) {
			// System.out.println("leer");
			return;
		}
		if (line.charAt(0) == '%') {
			// System.out.println("kommentarzeile");
			return;
		}
		int open = line.indexOf('(');
		String fnc = line.substring(0, open);
		String paramsS = line.substring(open + 1, line.length() - 2);
		String[] params = paramsS.split(",");
		functionMap.get(fnc).create(params);
	}

}
