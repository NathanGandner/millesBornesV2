package cartes;

public enum Type {
	FEU("Feu Rouge", "Feu Vert", "Vehicule Prioritaire"), ESSENCE("Panne d'Essence", "Bidon d'Essence", "Citerne"), CREVAISON("Crevaison", "Roue De Secours", "Increvable"), ACCIDENT("Accident", "Reparation", "As Du Volant");
	private String attaque;
	private String parade;
	private String botte;

	private Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}


	public String getAttaque() {
		return attaque;
	}


	public String getParade() {
		return parade;
	}
	
	public String getBotte() {
		return botte;
	}

}
