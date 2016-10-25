package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.objects.Ort;
import haw.cas.praktikum.objects.Strasse;
import haw.cas.praktikum.parser.MObjektRepository;
import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.parser.prolog.PrologParser;


public class StrasseParser implements PrologParser{
	@Override
	public void create(String[] param) {
		assert param.length == 3 : "the Parameter Length for an Street must be 3, but was " + param.length;
		
		String start  = param[0];
		String ende   = param[1];
		String kosten = param[2];
		
		MObjekt startO =  MObjektRepository.get(start);
		MObjekt endeO =  MObjektRepository.get(ende);
		
		//TODO:Null check
		
		assert (startO instanceof Ort) : "Not a valid start Ort for a street";
		assert (endeO instanceof Ort ) : "Not a valid end Ort for a street";;
		Integer k = null;
		try{
			k=Integer.parseInt(kosten);
		}catch (NumberFormatException e) {}
		assert (k!=null) : "not a valid pricing for the street";
		String ID = "STRT_"+startO.getUID()+"_to_"+endeO.getUID();
		
		((Ort) startO).addStrasse(new Strasse(ID,	(Ort) startO,
														(Ort) endeO,
														k 				)); 

		
	}
}
