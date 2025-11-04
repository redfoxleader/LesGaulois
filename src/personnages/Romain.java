package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	private boolean isInvariantVerified() {
	    return force >= 0 ;
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

	public void recevoirCoup(int dégat) {
		assert dégat>0;
		int avant_réduction_force = force;
		force -= dégat;
		if (force < 1) {
			force = 1;
			parler("J'abandonne !");

		} else {
			parler("Aïe");

		}
		assert avant_réduction_force > force;
	}
 public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	    System.out.println(Equipement.CASQUE);
	    System.out.println(Equipement.BOUCLIER);
}
}
