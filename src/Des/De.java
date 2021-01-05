package Des;

import Interfaces.Lancable;

public class De implements Lancable {
	
	private int valeur = 0;
	
	@Override
	public void lancer() {
		// Math.floor -> arrondis inférieur
		// Math.random -> nb aléa entre 0 et 1
		int valeurDe = (int) Math.floor( Math.random() * 6 ) + 1;

		this.setValeur(valeurDe);
	}

	@Override
	public String toString() {
		return "De [ valeur = " + valeur + "]";
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}
