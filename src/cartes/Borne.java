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
		if(obj == null)
			return false;
		if(getClass() == obj.getClass()) {
			Borne borne = (Borne) obj;
			return km == borne.km;
		}
		return false;
	}
}
