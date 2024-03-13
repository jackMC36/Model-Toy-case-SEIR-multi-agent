
/*Pour générer un nombre aléatoire:
 * 
 *  MTRandom random = new MTRandom();
 *  int randomNumber = random.nextInt(); 
 */



public class Main {
    public static MTRandom random = new MTRandom();
    public static void main(String[] args) {
        grilleHumain grille  = new grilleHumain(30, 30);
        grille.addAllHumains(1000,2);
        grille.afficherGrille();














        /*Humain h1 = new Humain('I', 0, 5, 7, 10);
        Humain h2 = new Humain('I', 0, 5, 7, 10);
        Humain h3 = new Humain('I', 0, 5, 7, 10);
        
        grilleHumain gh = new grilleHumain(30, 30);
        gh.addHumain(0, 0, h1);
        gh.addHumain(0, 0, h2);
        gh.addHumain(4, 0, h3);
        gh.afficherGrille();
        System.out.println("Nombre d'infectés: " + gh.infectedAround(4, 4));*/
    }
}
