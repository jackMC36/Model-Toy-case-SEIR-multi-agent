
/*Pour générer un nombre aléatoire:
 * 
 *  MTRandom random = new MTRandom();
 *  int randomNumber = random.nextInt(); 
 */



public class Main {
    public static void main(String[] args) {
        Humain h1 = new Humain('S', 0, 5, 7, 10);
        Humain h2 = new Humain('I', 0, 5, 7, 10);
        Humain h3 = new Humain('R', 0, 5, 7, 10);
        MTRandom random = new MTRandom();
        double randomNumber = random.negExp(32); 
        System.out.println("Nombre généré: " + randomNumber);
        grilleHumain gh = new grilleHumain(5, 5);
        gh.addHumain(0, 0, h1);
        gh.addHumain(0, 0, h2);
        gh.addHumain(0, 2, h3);
        gh.afficherGrille();
        System.out.println("Nombre d'infectés: " + gh.calculInfected(0, 0));
    }
}
