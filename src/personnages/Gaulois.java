package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(predreParole() + "\"" + texte + "\"");
	}

	private String predreParole() {

		return "Le gaulois " + nom + " : ";
	}
	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + nomRomain);
		romain.recevoirCoup(force / 3);
	}
public static void main(String[] args) {
	Gaulois asterix = new Gaulois("Astérix",8);
	System.out.println(asterix);
	
}

@Override
public String toString() {
	return nom;
}
}
