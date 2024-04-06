
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
    }
}
