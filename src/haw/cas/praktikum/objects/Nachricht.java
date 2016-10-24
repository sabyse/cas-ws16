package haw.cas.praktikum.objects;

import haw.cas.praktikum.parser.Obj.MObjekt;
import haw.cas.praktikum.zeittyp.ZeitTyp;

//TODO:Serialisiuerng . . . 
public class Nachricht extends MObjekt{

	private String content;
	private Akteur ersteller;
	private ZeitTyp erstellungsZeitpunkt;
	private SchwarzesBrett sb;

	public Nachricht(String content, Akteur ersteller, SchwarzesBrett sb) {
		this(sb, content, ersteller,ZeitTyp.now());
	}
	
	public Nachricht(SchwarzesBrett sb, String content, Akteur ersteller,ZeitTyp zeitpung) {
		this.sb = sb;
		this.content = content;
		this.ersteller = ersteller;
		erstellungsZeitpunkt = zeitpung ;
	}

	public String getContent() {
		return content;
	}
	
	public SchwarzesBrett getSB(){
		return sb;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Akteur getErsteller() {
		return ersteller;
	}

	public void setErsteller(Akteur ersteller) {
		this.ersteller = ersteller;
	}

	public ZeitTyp getErstellungsZeitpunkt() {
		return erstellungsZeitpunkt;
	}

	public void setErstellungsZeitpunkt(ZeitTyp erstellungsZeitpunkt) {
		this.erstellungsZeitpunkt = erstellungsZeitpunkt;
	}
	
	public void anBrettPinnen(){
		sb.anpinnen(this);
	}
}