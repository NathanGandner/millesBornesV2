package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import cartes.Carte;

public class MainJoueur extends Carte {
	private List<Carte> main = gnew ArrayList<>();

	public void prendre(Carte carte) {
		main.add(carte);
	}
	
	public void jouer(Carte carte) {
		assert(main.contains(carte));
		main.remove(carte);
	}
	
	@Override
	public String toString() {
		StringBuilder sortie = new StringBuilder();
		for(Carte carte: main) {
			sortie.append("-");
			sortie.append(carte);
			sortie.append("\n");
		}
		return sortie.toString();
	}
	
	public ListIterator<Carte> listIterator() {
		return main.listIterator();
	}

}
