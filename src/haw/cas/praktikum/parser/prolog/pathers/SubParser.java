package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.objects.Auftrag;
import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.parser.MObjektRepository;
import haw.cas.praktikum.parser.prolog.PrologParser;

public class SubParser implements PrologParser {

	//%auftrag(ID,ID-ort-Start,ID-ort-Ende,double-Gewinn,int-menge)
	@Override
	public void create(String[] param) {
		assert param.length == 2 : "the Parameter Length for an sub must be 2, but was " + param.length;
		String child = param[0];
		String parent = param[1];
		
		Auftrag childO = (Auftrag) MObjektRepository.get(child);
		Auftrag parnetO = (Auftrag) MObjektRepository.get(parent);
		parnetO.addSubAuftrag(childO);
		
	}

}
