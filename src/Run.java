
public class Run {

	public static void main(String[] args) {
		
		Joueur j1 = new Joueur("Michel", 20, 5, false);
		Joueur j2 = new Joueur("Jean", 20, 5, true);
		
		int nbTours = 0;
		
		while (j1.estEnVie() && j2.estEnVie()) {
			nbTours++;
			boolean estJour = true;
			
			if(nbTours % 2 == 0) {
				estJour = false;
				System.out.println("Il fait jour");
			}else {
				estJour = true;
				System.out.println("Il fait nuit");
			}
			Joueur.combattre(j1, j2, estJour);
			
			System.out.println(j1);
			System.out.println(j2);
		}
		
		System.out.println("La partie a durée "+ nbTours + " tours");
		
	}

}
