package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(Integer km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return km + " KM";
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && km == ((Borne) obj).km;
	}
}
