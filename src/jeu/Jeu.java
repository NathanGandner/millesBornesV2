package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.GestionCartes;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Jeu extends Carte {
	private Sabot sabot;

	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		Carte[] cartes = jeu.donnerCartes();
		
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, cartes);
		
		GestionCartes.melanger(listeCartes);
		
		Carte[] tabCartes = (Carte[]) listeCartes.toArray();
		Sabot sabotcree = new Sabot(tabCartes);
		this.sabot = sabotcree;
	}

}
