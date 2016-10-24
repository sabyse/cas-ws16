package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Auftrag;
import haw.cas.praktikum.objects.Boerse;
import haw.cas.praktikum.objects.LKW;
import haw.cas.praktikum.parser.MObjektReposetory;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.prolog.PrologParser;

public class StoredInParser implements PrologParser {

	@Override
	public void create(String[] param) {
		assert param.length == 2 : "the Parameter Length for an auftrag must be 2, but was "
				+ param.length;

		String auftragS = param[0];
		String besitzerS = param[1];
		
		Auftrag auftrag = (Auftrag) MObjektReposetory.get(auftragS);
		MObjekt besitzer = MObjektReposetory.get(besitzerS);
		if(besitzer instanceof LKW){
			((LKW) besitzer).addAuftrag(auftrag);
		}else if(besitzer instanceof Boerse){
			((Boerse) besitzer).addAuftrag(auftrag);
		}
		else{
			System.err.println("Ein Auftrag kann der Instanz " + besitzerS + " nicht zugewiesen werden.");
		}
	}
}
