package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Akteur;
import haw.cas.praktikum.objects.Nachricht;
import haw.cas.praktikum.objects.SchwarzesBrett;
import haw.cas.praktikum.parser.MObjektReposetory;
import haw.cas.praktikum.parser.prolog.PrologParser;
import haw.cas.praktikum.zeittyp.ZeitTyp;

public class NachrichtParser implements PrologParser {
	
	@Override
	public void create(String[] param) {
		assert param.length == 4 : "the Parameter Length for a nachricht must be 4, but was " + param.length;
		String anBrettS = param[0];
		String inhaltS = param[1];
		String erstellerS= param[2];
		String timestampS = param[3];
		
		ZeitTyp zeitPunkt = new ZeitTyp(timestampS);
		SchwarzesBrett sb = (SchwarzesBrett) MObjektReposetory.get(anBrettS);
		Akteur ersteller = (Akteur) MObjektReposetory.get(erstellerS);
				
		
		Nachricht n = new Nachricht(sb,inhaltS,ersteller,zeitPunkt);
		sb.anpinnen(n);
	}

}
