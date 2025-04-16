package jeu;

import java.util.Iterator;

import cartes.Carte;

public class Joueur extends Carte {
	String nom;
	ZoneDeJeu zone = new ZoneDeJeu();
	MainJoueur main = new MainJoueur();
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Iterator<Carte> itMain() {
		return main.listIterator();
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide())
			return null;
		Carte carte = sabot.piocher();
		donner(carte);
		return carte;
	}
	
	public int donnerKmParcourus() {
		return zone.donnerKmParcourus();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof String string)
		{
			String nom2 = string;
			return nom.equals(nom2);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
