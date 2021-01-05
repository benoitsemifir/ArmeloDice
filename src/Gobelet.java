import java.util.ArrayList;
import java.util.List;

import Interfaces.Lancable;

public class Gobelet {


	protected List <Lancable> desList = new ArrayList<Lancable>();
	
	protected List <Integer> resultats = new ArrayList<>();
	
	private int epee = 0;
	private int bouclier = 0;
	
	public int getEpee() {
		return epee;
	}

	public void setEpee(int epee) {
		this.epee = epee;
	}

	public int getBouclier() {
		return bouclier;
	}

	public void setBouclier(int bouclier) {
		this.bouclier = bouclier;
	}

	public List <Lancable> getDesList() {

		return desList;
		
	}

	public void setDesList(List <Lancable> desList) {
		this.desList = desList;
	}
	
	
	public void lancerDes(boolean estJour, boolean estCorrompu) {
		resultats.clear();
		
		this.epee = 0;
		this.bouclier = 0;
		
		for (Lancable de : desList) {
			de.lancer();
			interpreterDe(de, estJour, estCorrompu);
		}
	}
	
	public void ajouterDe(Lancable de) {
		desList.add(de);
	}
	
	public void ajouterDes(List<Lancable> des) {
		desList.addAll(des);
	}
	
	protected void interpreterDe(Lancable de, boolean estJour, boolean estCorrompu) {
		
		resultats.add(de.getValeur());
		
		switch(de.getValeur()) {
		// cas épée
		case 1:
			incrementerEpee();
			break;
		// cas bouclier
		case 2:
			incrementerBouclier();
			break;
			
		// cas soleil
		case 3: 
			if(estJour) incrementerEpee();
			break;
		// cas lune
		case 4:
			// if(!estJour) incrementerEpee();
			if(estJour == false) incrementerEpee();
			break;
		// cas bien
		case 5:
			if(estCorrompu == false) exploser(de, estJour, estCorrompu);
			break;
		// cas mal
		case 6:
			if(estCorrompu) exploser(de, estJour, estCorrompu);
			break;
		}
	}

	private void incrementerBouclier() {
		this.bouclier ++;
	}

	private void incrementerEpee() {
		this.epee ++;
	}
	
	private void exploser(Lancable de, boolean estJour, boolean estCorrompu) {
		this.incrementerEpee();
		de.lancer();
		interpreterDe(de, estJour, estCorrompu);
	}

	
	public int getNbDes() {
		return this.desList.size();
	}

	@Override
	public String toString() {
		return "Gobelet [resultats =" + resultats + ", epee=" + epee + ", bouclier=" + bouclier + "]";
	}
}
