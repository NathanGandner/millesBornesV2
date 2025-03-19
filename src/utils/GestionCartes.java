package utils;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import cartes.Carte;

public abstract class GestionCartes extends Carte {

	private static Random random = new Random();

	public static <T> T extraire(List<T> liste) {
		return liste.remove(random.nextInt(liste.size()));
	}

	public static <T> T extraireIt(List<T> liste) {
		int indice = random.nextInt(liste.size());
		ListIterator<T> iterateur = liste.listIterator(indice);
		T elem = iterateur.next();
		iterateur.remove();
		return elem;
	}

	public static <T> List<T> melanger(List<T> liste) {
		List<T> melange = new ArrayList<>();
		int taille = liste.size();
		for (int i = 0; i < taille; i++) {
			melange.add(extraire(liste));
		}
		return melange;
	}

	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		if (liste1.size() != liste2.size()) {
			return false;
		}
		for (T elem : liste1) {
			if (Collections.frequency(liste1, elem) != Collections.frequency(liste2, elem))
				return false;
		}
		for (T elem : liste2) {
			if (Collections.frequency(liste2, elem) != Collections.frequency(liste1, elem))
				return false;
		}
		return true;
	}

	public static <T> List<T> rassembler(List<T> liste) {
		List<T> rassemble = new ArrayList<>();
		ListIterator<T> iterateur = liste.listIterator();
		while (iterateur.hasNext()) {
			T elt = iterateur.next();
			if (!rassemble.contains(elt)) {
				int nbOcc = Collections.frequency(liste, elt);
				for (int j = 0; j < nbOcc; j++) {
					rassemble.add(elt);
				}
			}
		}
		return rassemble;
	}

	private static <T> boolean presence(T elem, ListIterator<T> it) {
		while (it.hasNext()) {
			T elemTest = it.next();
			System.out.println("elem2 = " + elemTest);
			if (elem.equals(elemTest))
				return true;
		}
		return false;
	}
	

	public static <T> boolean verifierRassemblement(List<T> liste) {
		T elemPrec = liste.get(0);
		boolean verifie = false;
		for(ListIterator<T> it = liste.listIterator(1); it.hasNext(); ) {
			T elem = it.next();
			System.out.println("elem1 = " + elem);
			if(!elem.equals(elemPrec)) {
				if(!verifie) {
					if(presence(elem, liste.listIterator(it.previousIndex())))
							return false;
				}
				verifie = !verifie;
			}
			elemPrec = elem;
		}
		return true;
	}
}