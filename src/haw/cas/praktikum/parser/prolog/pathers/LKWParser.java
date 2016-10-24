package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.objects.LKW;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.parser.MObjektRepository;
import haw.cas.praktikum.parser.prolog.PrologParser;

public class LKWParser implements PrologParser{

	@Override
	public void create(String[] param) {
		assert param.length == 4 : "the Parameter Length for an ort must be 3, but was " + param.length;
		String name = param[0];
		String akteurS = param[1];
		String posS = param[2];
		String kapazitaetS = param[3];
		
		Akteur akteur = (Akteur) MObjektRepository.get(akteurS);
		Ort pos = (Ort) MObjektRepository.get(posS);
		int kapazitaet = Integer.parseInt(kapazitaetS);
		
		new LKW(name, akteur, pos, kapazitaet);
	}
}
