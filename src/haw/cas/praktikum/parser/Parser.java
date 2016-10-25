package haw.cas.praktikum.parser;

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
import haw.cas.praktikum.parser.prolog.pathers.AkteurParser;
import haw.cas.praktikum.parser.prolog.pathers.AuftragParser;
import haw.cas.praktikum.parser.prolog.pathers.AuftragsGenParser;
import haw.cas.praktikum.parser.prolog.pathers.BelegtParser;
import haw.cas.praktikum.parser.prolog.pathers.BoerseParser;
import haw.cas.praktikum.parser.prolog.pathers.EingetragenParser;
import haw.cas.praktikum.parser.prolog.pathers.EreignisGenParser;
import haw.cas.praktikum.parser.prolog.pathers.EreignisParser;
import haw.cas.praktikum.parser.prolog.pathers.FunkParser;
import haw.cas.praktikum.parser.prolog.pathers.HandelsregisterParser;
import haw.cas.praktikum.parser.prolog.pathers.KonsortiumParser;
import haw.cas.praktikum.parser.prolog.pathers.LKWParser;
import haw.cas.praktikum.parser.prolog.pathers.LinkLocalServiceParser;
import haw.cas.praktikum.parser.prolog.pathers.NachrichtParser;
import haw.cas.praktikum.parser.prolog.pathers.OrtParser;
import haw.cas.praktikum.parser.prolog.pathers.Printer;
import haw.cas.praktikum.parser.prolog.pathers.SchwarzesBrettParser;
import haw.cas.praktikum.parser.prolog.pathers.StoredInParser;
import haw.cas.praktikum.parser.prolog.pathers.StrasseParser;
import haw.cas.praktikum.parser.prolog.pathers.SubParser;
import haw.cas.praktikum.parser.prolog.pathers.TankstelleParser;
import haw.cas.praktikum.parser.prolog.pathers.TeilnehmerParser;
import haw.cas.praktikum.parser.prolog.pathers.UmladebuchtParser;
import haw.cas.praktikum.parser.prolog.pathers.ZustaendigParser;

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
		functionMap.put("akteur", new AkteurParser());
		functionMap.put("ort", new OrtParser());
		functionMap.put("strasse", new StrasseParser());
		functionMap.put("ereignis", new EreignisParser());
		functionMap.put("ereignisgen", new EreignisGenParser());
		functionMap.put("auftragsgen", new AuftragsGenParser());
		functionMap.put("zustaendig", new ZustaendigParser());
		functionMap.put("tankstelle", new TankstelleParser());
		functionMap.put("belegt", new BelegtParser());
		functionMap.put("handelsregister", new HandelsregisterParser());
		functionMap.put("eingetragen", new EingetragenParser());
		functionMap.put("schwarzesbrett", new SchwarzesBrettParser());
		functionMap.put("sbnachricht", new NachrichtParser());
		functionMap.put("umladebucht", new UmladebuchtParser());
		functionMap.put("boerse", new BoerseParser());
		functionMap.put("funk", new FunkParser());
		functionMap.put("linkLocal", new LinkLocalServiceParser());
		functionMap.put("lkw", new LKWParser());
		functionMap.put("auftrag", new AuftragParser());
		functionMap.put("sub", new SubParser());
		functionMap.put("storedIn", new StoredInParser());
		functionMap.put("konsortium", new KonsortiumParser());
		functionMap.put("teilnehmer", new TeilnehmerParser());
	
		functionMap.put("print", new Printer());
		
		// functionMap.put(Funk.class.getName().toLowerCase(), new
		// StrasseParser());
		// functionMap.put(SchwarzesBrett.class.getName().toLowerCase(), new
		// SchwarzesBrettParser());
		// functionMap.put(Tankstelle.class.getName().toLowerCase(), new
		// TankstelleParser());
		// functionMap.put(Umladebucht.class.getName().toLowerCase(), new
		// UmladebuchtParser());
		
		generatorList = new ArrayList<>();

		generatorList.add(new AkteurGenerator());
		generatorList.add(new AuftragsGenerator());
		generatorList.add(new GenGenerator());
		generatorList.add(new KonsortiumGenerator());
		generatorList.add(new LKWGenerator());
		generatorList.add(new LocalServiceGenerator());
		generatorList.add(new NetGenerator());
	}

	public static void main(String[] args) {
		init();
		long now = System.currentTimeMillis();
		parse("test.P");
		System.out.println(System.currentTimeMillis() - now);
		now = System.currentTimeMillis();
		store("out.P");
		System.out.println(System.currentTimeMillis() - now);
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
