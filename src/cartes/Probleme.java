package cartes;

public abstract class Probleme extends Carte {
	 
	private Type type;

	protected Probleme(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(getClass() == obj.getClass()) {
			Probleme pb = (Probleme) obj;
			return type == pb.type;
		}
		return false;
	}
}
