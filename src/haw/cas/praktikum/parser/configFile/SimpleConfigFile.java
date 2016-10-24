package haw.cas.praktikum.parser.configFile;

import java.util.ArrayList;

public class SimpleConfigFile implements ConfigFile {

	ArrayList<String> list;
	
	public SimpleConfigFile(String datei) {
		list = new ArrayList<>();
		for(int i = 0;i<10;i++)list.add("");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addToSection(int section, String textToAdd) {
		String l;
		if((l = list.get(section))==null){
			list.set(section, textToAdd+"\n");
		}else{
			list.set(section,l+textToAdd+"\n");
		}
	}

	@Override
	public void store() {
		for(String s: list){
			System.out.print(s);
		}
	}

}
