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

	public Chaudron() {

	}

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion += quantite;
		this.forcePotion = forcePotion;

	}

	public int prendreLouche() {
		quantitePotion -= 1;
		return forcePotion;

	}
}
