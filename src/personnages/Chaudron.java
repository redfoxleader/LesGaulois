package personnages;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;

	public boolean resterPotion() {
		if (quantitePotion == 0) {
			return false;
		}
		return true;
	}

	private void remplirChaudron(int quantite, int forcePotion) {
		quantitePotion += quantite;
		this.forcePotion = forcePotion;
		
		

		
		
	}
}
