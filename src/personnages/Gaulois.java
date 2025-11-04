package personnages;

import objets.Equipement;

public class Gaulois {
	private String nom;
//	private int force;
	private int effetPotion;
	private Village village;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	private String prendreParole() {
//
//		return "Le gaulois " + nom + " : ";
//	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
}

//	public void frapper(Romain romain) {
//		String nomRomain = romain.getNom();
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + nomRomain);
//		romain.recevoirCoup(force * effetPotion / 3);
//		effetPotion -= 1;
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " +
		romain.getNom());
		Equipement[] equipementEjecte = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; equipementEjecte != null && i < equipementEjecte.length; i++,
				nbTrophees++) {
		this.trophees[nbTrophees] = equipementEjecte[i];
		}
		}


	public void sePresenter() {
		if (village == null) {
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		} else if (village.getChef() == this) {
			parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village " + village.getNom() + ".");
		} else {
			parler("Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".");
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);

	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}

	@Override
	public String toString() {
		return nom;
	}
}
