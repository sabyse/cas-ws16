package haw.cas.praktikum.parser.prolog.pathers;

import haw.cas.praktikum.parser.prolog.PrologParser;

public class Printer implements PrologParser{

	@Override
	public void create(String[] param) {
		for(String s:param){
			System.out.println(s);
		}
	}

}
