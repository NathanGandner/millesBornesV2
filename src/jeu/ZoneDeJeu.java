package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;
import cartes.FinLimite;
import cartes.DebutLimite;

public class ZoneDeJeu extends Carte {
	private List<Limite> lim;
	private List<Bataille> bat;
	private List<Borne> borne;
	private List<Botte> bottes;

	public ZoneDeJeu() {
		super();
	}

}
