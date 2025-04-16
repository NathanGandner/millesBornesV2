package jeu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;
import cartes.DebutLimite;
import cartes.FinLimite;

public class ZoneDeJeu extends Carte {
	private List<Carte> lim;
	private List<Carte> bat;
	private List<Carte> borne;
	
	public ZoneDeJeu() {
		lim = new LinkedList<>();
		bat = new LinkedList<>();
		borne = new ArrayList<>();
	}
	
	private void ajouterBorne(Carte carte) {
		borne.add(carte);
	}
	
	private void ajouterLimite(Carte carte) {
		lim.add(0,carte); 
	}
	private void ajouterBataille(Carte carte) {
		bat.add(0,carte);
	}

	
	public int donnerLimitationVitesse() {
		if(lim.isEmpty())
		{
			return 200;
		}
		if (lim.get(0) instanceof DebutLimite)
		{
			return 50;
		}
		return 200;
	}
	
	public int donnerKmParcourus() {
		int km=0;
		for(Carte bor: borne)
		{
			Borne tmp = (Borne) bor;
			km +=tmp.getKm();
		}
		return km;
	}
	
	public void deposer(Carte c) {
		if(c == null)
			return;
		if(c instanceof Borne) {
			ajouterBorne(c);
		}
		if(c instanceof Limite)
			ajouterLimite(c);
		if(c instanceof Bataille)
			ajouterBataille(c);
	}
	
	public boolean peutAvancer() {
		if(bat.isEmpty()) {
			return false;
		}
		Carte carte = bat.get(0);
		if(carte instanceof Parade parade) {
			return parade.getType().equals(Type.FEU);
		}
		return false;
	}
	
	private boolean estDepotFeuVertAutorise() {
		if(bat.isEmpty())
			return true;
		Carte carte = bat.get(0);
		if(carte instanceof Attaque attaque) {
			return !attaque.getType().equals(Type.FEU);
		}
		if(carte instanceof Parade parade) {
			return !parade.getType().equals(Type.FEU);
		}
		return false;
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		if(peutAvancer()) {
			return true;
		}
		if(borne.getKm() > donnerLimitationVitesse()) {
			return false;
		}
		int km = donnerKmParcourus() + borne.getKm();
		return km <=1000;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		if(lim.isEmpty()) {
			return limite instanceof DebutLimite;
		}
		Carte c = lim.get(0);
		if(limite instanceof DebutLimite && (lim.isEmpty() || c instanceof FinLimite)) {
			return true;
		}
		return (limite instanceof FinLimite && c instanceof DebutLimite);
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if(bataille instanceof Attaque) {
			return peutAvancer();
		} else {
			if(bataille.getType().equals(Type.FEU)) {
				return estDepotFeuVertAutorise();
			} else {
				Bataille c = (Bataille) bat.get(0);
				return (!bat.isEmpty() && bataille.getType().equals(c.getType()));
			}
		}
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if(carte == null)
			return false;
		if(carte instanceof Borne bor)
			return estDepotBorneAutorise(bor);
		if(carte instanceof Limite limite)
			return estDepotLimiteAutorise(limite);
		if(carte instanceof Bataille bataille)
			return estDepotBatailleAutorise(bataille);
		return false;
	}
	
}
