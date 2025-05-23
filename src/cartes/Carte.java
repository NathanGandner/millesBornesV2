package cartes;

public abstract class Carte {

	@Override
	public int hashCode() {
		return 31*getClass().hashCode();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if((getClass() == obj.getClass()))
		{
			Carte carte = (Carte) obj;
			return toString().equals(carte.toString());
		}
		
		return false;
	}
	
}
