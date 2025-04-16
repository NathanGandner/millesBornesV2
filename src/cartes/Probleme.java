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
	public int hashCode() {
		return 31 * type.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		return super.equals(obj) && type == ((Probleme)obj).type;
	}
}
