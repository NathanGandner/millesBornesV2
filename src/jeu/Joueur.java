package jeu;

import cartes.Carte;

public class Joueur extends Carte {
	String nom;
	ZoneDeJeu zone;
	
	public Joueur(String nom, ZoneDeJeu zone) {
		this.nom = nom;
		this.zone = zone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof String)
		{
			String nom2 = (String) obj;
			return nom.equals(nom2);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
