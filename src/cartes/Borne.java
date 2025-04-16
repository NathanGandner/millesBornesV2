package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(Integer km) {
		this.km = km;
	}
	
	public int getKm() {
		return km;
	}
	
	@Override
	public int hashCode() {
		return 31*km;
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
