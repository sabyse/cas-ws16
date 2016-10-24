package haw.cas.praktikum.zeittyp;

public class ZeitTypDiff {
	long time;
	
	public ZeitTypDiff(String time) {
		this(Long.parseLong(time));
	}
	public ZeitTypDiff(long time) {
		this.time = time;
	}
	
}
