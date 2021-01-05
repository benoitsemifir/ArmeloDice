import Des.De;

public class Joueur {
	
	private String nom;
	private Gobelet gobelet;
	private int vie;
	private int force;
	private boolean estCorrompu;
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Gobelet getGobelet() {
		return gobelet;
	}

	public void setGobelet(Gobelet gobelet) {
		this.gobelet = gobelet;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public boolean isEstCorrompu() {
		return estCorrompu;
	}

	public void setEstCorrompu(boolean estCorrompu) {
		this.estCorrompu = estCorrompu;
	}

	
	public Joueur(String nom, int vie, int force, boolean estCorrompu) {
		this.nom = nom;
		this.vie = vie;
		this.force = force;
		this.estCorrompu = estCorrompu;
		this.creerGobelet();
	}

	protected void creerGobelet() {
		Gobelet gobelet = new Gobelet();
		
		for (int i = 0; i < this.force ; i++) {
			De de = new De();
			gobelet.ajouterDe(de);
		}
		this.setGobelet(gobelet);
	}
	
	public void creerGobelet(int nbDe) {
		Gobelet gobelet = new Gobelet();
		
		for (int i = 0; i < nbDe ; i++) {
			De de = new De();
			gobelet.ajouterDe(de);
		}
		this.setGobelet(gobelet);
	}
	
	public void attaquer(Joueur joueurCiblee, boolean estJour) {
		
		Gobelet gobeletJ1 = this.getGobelet();
		Gobelet gobeletJ2 = joueurCiblee.getGobelet();
		
		// Lancer de dés des deux joueurs
		gobeletJ1.lancerDes(estJour, this.estCorrompu);
		gobeletJ2.lancerDes(estJour, joueurCiblee.estCorrompu);
		
		// Joueur1 est tapé par joueur2
		this.subirDegats(gobeletJ2.getEpee() , gobeletJ1.getBouclier());
		
		// Joueur2 est tapé par Joueur1
		joueurCiblee.subirDegats(gobeletJ1.getEpee() , gobeletJ2.getBouclier());
		
	}
	
	/**
	 * Le joueur doit peut-être subir des dégats en fonction des épées et bouclier tirées
	 * Le joueur subit les dégats du tirage de l'autre joueur
	 * 
	 * @param nombreEpee		Représente les dégats générés par le lancé de dés du gobelet
	 * @param nombreBouclier	Représente l'absorption générés par le lancé de dés du gobelet
	 */
	public void subirDegats(int nombreEpee, int nombreBouclier) {
		
		int degats = nombreEpee - nombreBouclier;
		
		// si le nombre d'épée est supérieur au nombre de boucliers
		if(degats > 0) {
			// changer les points de vies du joueur
			this.setVie(this.vie - degats);
		}
	}
	
	public static void combattre(Joueur joueur1, Joueur joueur2, boolean estJour) {
		Gobelet gobeletJ1 = joueur1.getGobelet();
		Gobelet gobeletJ2 = joueur2.getGobelet();
		
		// Lancer de dés des deux joueurs
		gobeletJ1.lancerDes(estJour, joueur1.estCorrompu);
		gobeletJ2.lancerDes(estJour, joueur2.estCorrompu);
		
		// Joueur1 est tapé par joueur2
		joueur1.subirDegats(gobeletJ2.getEpee() , gobeletJ1.getBouclier());
		
		// Joueur2 est tapé par Joueur1
		joueur2.subirDegats(gobeletJ1.getEpee() , gobeletJ2.getBouclier());
	}
	
	public boolean estEnVie() {
		return this.vie > 0;
	}
	

	@Override
	public String toString() {
		
		String str = "Joueur [nom=" + nom; 
		
		if(this.gobelet != null) {			
			str += ", nombre de dés: " + gobelet.getNbDes() + ", gobelet=" + gobelet;
		}
		
		str += ", vie=" + vie + ", force=" + force + ", estCorrompu=" + estCorrompu + "]";

		return str;
	}
	
}
