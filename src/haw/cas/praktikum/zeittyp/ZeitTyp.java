package haw.cas.praktikum.zeittyp;

public class ZeitTyp {
	long time;
	
	public ZeitTyp(long time) {
		this.time = time;
	}
	
	public ZeitTyp(String time) {
		this(Long.parseLong(time));
	}

	public static ZeitTyp now(){
		return new ZeitTyp(System.currentTimeMillis());
	}
	
	public String toString(){
		return ((Long)time).toString();
	}
}
