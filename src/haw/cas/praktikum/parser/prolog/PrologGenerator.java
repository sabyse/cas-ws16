package haw.cas.praktikum.parser.prolog;

import java.util.stream.Stream;

import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.configFile.ConfigFile;

public interface PrologGenerator {
	void generate(ConfigFile cf,Stream<MObjekt> objectStream);
}
