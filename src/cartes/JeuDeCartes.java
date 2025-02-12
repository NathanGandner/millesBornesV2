package cartes;

public class JeuDeCartes {
	private Configuration typesDeCartes[];
	
	public JeuDeCartes() {
		typesDeCartes= new Configuration[] {
				new Configuration(new Borne(25), 10),
				new Configuration(new Borne(50), 10),
				new Configuration(new Borne(75), 10),
				new Configuration(new Borne(100), 12),
				new Configuration(new Borne(200), 4),
				new Configuration(new Attaque(Type.FEU), 5),
				new Configuration(new Parade(Type.FEU), 14),
				new Configuration(new Botte(Type.FEU), 1),
				new Configuration(new Attaque(Type.ESSENCE), 3),
				new Configuration(new Parade(Type.ESSENCE), 6),
				new Configuration(new Botte(Type.ESSENCE), 1),
				new Configuration(new Attaque(Type.CREVAISON), 3),
				new Configuration(new Parade(Type.CREVAISON), 6),
				new Configuration(new Botte(Type.CREVAISON), 1),
				new Configuration(new Attaque(Type.ACCIDENT), 3),
		        new Configuration(new Parade(Type.ACCIDENT), 6),
		        new Configuration(new Botte(Type.ACCIDENT), 1),
		        new Configuration(new DebutLimite(), 4),
		        new Configuration(new FinLimite(), 6),
				};
	}
	
	public StringBuilder affichageJeuDeCartes() {
		StringBuilder sortie=new StringBuilder();
		for(Configuration config : typesDeCartes) {
			sortie.append(config);
		}
		return sortie;
	}
	
	public Carte[] donnerCartes()  {
		Carte[] cartes = new Carte[106];
		int cur=0;
		for(int i=0; i<19; i++) 
		{
			for(int j=0; j<typesDeCartes[i].getNbExemplaires(); j++)
			{
				cartes[cur] = typesDeCartes[i].getCarte();
				cur++;
			}
		}
		return cartes;
	}
	
	private static class Configuration{
		private int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte, int nbExemplaire){
			this.nbExemplaires = nbExemplaire;
			this.carte = carte;
		}
			
		public Carte getCarte() {
			return carte;
		}
		
		public int getNbExemplaires() {
			return nbExemplaires;
		}
	}

}
