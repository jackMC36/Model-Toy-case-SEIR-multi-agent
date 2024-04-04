
/*Pour générer un nombre aléatoire:
 * 
 *  MTRandom random = new MTRandom();
 *  int randomNumber = random.nextInt(); 
 */



public class Main {
    public static MTRandom random = new MTRandom();
    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            grilleHumain grille  = new grilleHumain(300, 300);
            grille.simulation(i);
        }
        
        

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
