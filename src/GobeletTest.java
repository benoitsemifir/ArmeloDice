import Interfaces.Lancable;

public class GobeletTest extends Gobelet {
	
	@Override
	public void lancerDes(boolean estJour, boolean estCorrompu) {
		
		resultats.clear();
		
		for (Lancable de : desList) {
			this.interpreterDe(de, estJour, estCorrompu);
		}
	}
	
}
