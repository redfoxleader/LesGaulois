package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	private void parlerEquipement(String texte) {
		System.out.println("Le soldat " + nom + " " + texte);
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equipements[0] = equipement;
			nbEquipement = 1;
			parlerEquipement("s'équipe avec un " + equipement + ".");
			break;
		case 1:
			if (equipements[0] == equipement) {
				parlerEquipement("possède déjà un " + equipement + "!");
			} else {
				equipements[1] = equipement;
				nbEquipement = 2;
				parlerEquipement("s'équipe avec un " + equipement + ".");
			}
			break;
		case 2:
			parlerEquipement("est déjà bien protégé !");
			break;
		}
	}

//	public void recevoirCoup(int dégat) {
//		assert dégat>0;
//		int avant_réduction_force = force;
//		force -= dégat;
//		if (force < 1) {
//			force = 1;
//			parler("J'abandonne !");
//
//		} else {
//			parler("Aïe");
//
//		}
//		assert avant_réduction_force > force;
//	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if(force==0) {
			parler("Aïe");}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force estdiminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sousla force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	public int getForce() {
		return force;
	}
}
