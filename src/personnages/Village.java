package personnages;

public class Village {
	private String nom;
	private int nbVillageois=0;
	private Gaulois[] villageois;
	private Gaulois chef;
	
	public Village(String nom, Gaulois chef, int nbVillageoisMax) {
	    this.nom = nom;
	    this.chef = chef;
	    this.villageois = new Gaulois[nbVillageoisMax];
	    this.nbVillageois = 0;
		chef.setVillage(this);
	}
	public String getNom() {
		return nom;
	}
	public Gaulois getChef() {
		return chef;
	}
	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		gaulois.setVillage(this);
		
		nbVillageois +=1;
	}
	public Gaulois trouverVillageois(int recherche) {
		if (recherche<=nbVillageois) {
			recherche -=1;
			return villageois[recherche];
		} else {
			System.out.print("Il n'y a pas autant d'habitants dans notre village ! \n");
			return null;
		}
	}
	public void affichervillageois(){
		System.out.print("Dans le village " + nom + " du chef " + chef + " vivent les légendaires gaulois :\n" );
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- "+villageois[i] + " ");
			}

	}
		
		
		
		
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("abraracourcix",6);
		Village village = new Village("Village des Irréductibles",abraracourcix,30);
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		 System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		 System.out.println(gaulois);
		 village.affichervillageois();
		 Gaulois obelix = new Gaulois("Obélix",25);
		 village.ajouterVillageois(obelix);
		 village.affichervillageois();
		 Gaulois doublepolemix = new Gaulois("DoublePolémix",4);
		 asterix.sePresenter();
		 abraracourcix.sePresenter();
		 doublepolemix.sePresenter();
		 
		 
		 
		
	}
	
	
}
