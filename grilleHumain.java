import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class grilleHumain {
    // Attributs
    private ArrayList<Humain>[][] grille;
    public static MTRandom random = new MTRandom();

    // Constructeur

    /* grilleHumain, méthode de contruction de la classe grilleHumain qui créer un tableau à deux dimensions,
     * et qui place un tableau ou peuvent être placer des objets de classe Humain dans chaque case. */

    @SuppressWarnings("unchecked")
    public grilleHumain(int lignes, int colonnes) {
        this.grille = new ArrayList[lignes][colonnes];
        for (int i = 0; i < lignes; i++) {
            initialiserLigne(i, colonnes);
        }
    }

    /* InitialiserLigne, méthode utiliser dans le constructeur pour initialiser les lignes du tableau. */

    private void initialiserLigne(int ligne, int colonnes) {
        for (int j = 0; j < colonnes; j++) {
            grille[ligne][j] = new ArrayList<Humain>();
        }
    }

    //Getteurs et Setteurs

    /* addHumain,  méthode qui prend en paramètres un entier ligne, un entier colonne et un humain, et qui
     * l'ajoute à la case donnée.*/

    public void addHumain(Humain humain) {
        int ligne = (int) random.negExp(grille.length);
        int colonne = (int) random.negExp(grille.length);
        grille[this.HorsTab(ligne,grille.length)][this.HorsTab(colonne, grille.length)].add(humain);
    }

    public void addAllHumains(int n, int infected){
        for(int i = 0 ; i < infected ; i++){
            Humain infect = new Humain('I');
            this.addHumain(infect);
        }
        for(int i = 0 ; i < (n - infected) ; i++){
            Humain h = new Humain('S');
            this.addHumain(h);
        }
    }

    /* validerPosition, méthode de validation qui vérifie qu'une position est bien situé dans le tableau. */

    private void validerPosition(int ligne, int colonne) {
        if (ligne < 0 || ligne >= grille.length || colonne < 0 || colonne >= grille.length) {
            throw new IllegalArgumentException("Position hors limites");
        }
    }

    private int HorsTab (int index, int tailleTab){
        if (index<0){
            return index + tailleTab;
        }
        else if (index>=tailleTab){
            return index % tailleTab;
        }
        return index;
    }

    /* getHumain, méthode qui prend en paramètre une ligne et une colonne et qui renvoie le tableau d'Humain
     * situé dans cette case. */

    public List<Humain> getHumains(int ligne, int colonne) {
        validerPosition(ligne, colonne);
        return grille[ligne][colonne];
    }

    /* calculInfected, méthode qui prend en paramètre un entier ligne et un entier colonne, et qui renvoie le nombre
     * d'humain infectés à cette case.*/
    public int calculInfected(int ligne, int colonne){
        List<Humain> list = getHumains(ligne,colonne);
        int infected = 0;
        for (int i = 0; i < list.size(); i++){
            Humain humain = list.get(i);
            if (humain.GetStatut() == 'I'){
                infected+=1;
            }
        }
        return infected;
    }
    
    /* infectedAround, méthode qui prend en paramètre un entier ligne et un entier colonne, et qui renvoie le nombre
     * d'humain infectés à cette case, et les 8 cases autour.*/
    public int infectedAround(int ligne, int colonne){
        int infected = 0;
        
        for (int i = ligne-1; i <= ligne+1; i++){
            for (int j = colonne-1; j <= colonne+1; j++){
                infected += calculInfected(HorsTab(i, grille.length),HorsTab(j, grille.length));
            }
        }
        return infected;
    }

    public double probability(Humain h, int ligne, int colonne){
        return 1-Math.exp(-0.5*infectedAround(ligne, colonne));
    }

    public void checkEtat(Humain h, int ligne, int colonne){
        switch (h.GetStatut()) {
            case 'S':
                if(random.negExp(1)<this.probability(h, ligne, colonne)){
                    h.SetStatut('E');
                    h.SetTemps(0);
                }
                break;
            case 'E':
                if(h.GetTemps()>h.GetdE()){
                    h.SetStatut('I');
                    h.SetTemps(0);
                }
                else{
                    h.SetTemps(h.GetTemps()+1);
                }
                break;
            case 'I':
                if(h.GetTemps()>h.GetdI()){
                    h.SetStatut('R');
                    h.SetTemps(0);
                }
                else{
                    h.SetTemps(h.GetTemps()+1);
                }
                break;
            case 'R':
                if(h.GetTemps()>h.GetdR()){
                    h.SetStatut('S');
                    h.SetTemps(0);
                }
                else{
                    h.SetTemps(h.GetTemps()+1);
                }
                break;
        }
    }

    private void deplacementHumains(){
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                List<Humain> humains = new ArrayList<>(getHumains(i, j));
                for (Humain h : humains) {
                    int newLigne = HorsTab((int) random.negExp(300), grille.length);
                    int newColonne = HorsTab((int) random.negExp(300), grille.length);
                    grille[HorsTab(newLigne, grille.length)][HorsTab(newColonne, grille.length)].add(h);
                    grille[i][j].remove(h);
                }
            }
        }
    }

    public void simulation(int simu){
        /* Initialisation */
        for (int i = 0; i < 19980; i++) {
            Humain h = new Humain('S');
            addHumain(h);
        }

        for (int i = 0; i < 20; i++) {
            Humain infect = new Humain('I');
            addHumain(infect);
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("simulation_results_" + simu + ".csv", true))) {
            writer.println(20 + "," + 19980 + "," + 0 + "," + 0);
        }
        catch (IOException e) {
            System.out.println("Il y a une erreur, aucune écriture dans le fichier n'a été effectuée.");
            e.printStackTrace();
        }


        for(int k=0;k<730;k++){
            System.out.println("Jour "+k);
            int nombre_infected = 0;
            int nombre_sain = 0;
            int nombre_exposed = 0;
            int nombre_recovered = 0;
        
            for (int i = 0; i < 300; i++) {
                for (int j = 0; j < 300; j++) {
                    List<Humain> humains = new ArrayList<>(getHumains(i, j));
                    for (Humain h : humains) {
                        checkEtat(h, i, j);
                        if(h.GetStatut()== 'I'){
                            nombre_infected+=1;
                        }
                        else if(h.GetStatut()== 'S'){
                            nombre_sain+=1;
                        }
                        else if(h.GetStatut()== 'E'){
                            nombre_exposed+=1;
                        }
                        else if(h.GetStatut()== 'R'){
                            nombre_recovered+=1;
                        }
                    }
                }
            }
            this.deplacementHumains();
            try (PrintWriter writer = new PrintWriter(new FileWriter("simulation_results_" + simu + ".csv", true))) {
                writer.println(nombre_infected + "," + nombre_sain + "," + nombre_exposed + "," + nombre_recovered);
            }
            catch (IOException e) {
                System.out.println("Il y a une erreur, aucune écriture dans le fichier n'a été effectuée.");
                e.printStackTrace();
            }
        }   
    }
}

