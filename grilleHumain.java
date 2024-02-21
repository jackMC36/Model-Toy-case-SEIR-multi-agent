import java.util.ArrayList;
import java.util.List;


public class grilleHumain {
    private List<Humain>[][] grille;

    // Constructeur

    /* grilleHumain, méthode de contruction de la classe grilleHumain qui créer un tableau à deux dimensions,
     * et qui place un tableau ou peuvent être placer des objets de classe Humain dans chaque case. */

    public grilleHumain(int lignes, int colonnes) {
        grille = new ArrayList[lignes][colonnes];
        for (int i = 0; i < lignes; i++) {
            initialiserLigne(i, colonnes);
        }
    }

    /* InitialiserLigne, méthode utiliser dans le constructeur pour initialiser les lignes du tableau. */

    private void initialiserLigne(int ligne, int colonnes) {
        for (int j = 0; j < colonnes; j++) {
            grille[ligne][j] = new ArrayList<>();
        }
    }

    //Getteurs et Setteurs

    /* addHumain,  méthode qui prend en paramètres un entier ligne, un entier colonne et un humain, et qui
     * l'ajoute à la case donnée.*/

    public void addHumain(int ligne, int colonne, Humain humain) {
        validerPosition(ligne, colonne);
        grille[ligne][colonne].add(humain);
    }

    /* getHumain, méthode qui prend en paramètre une ligne et une colonne et qui renvoie le tableau d'Humain
     * situé dans cette case. */

    public List<Humain> getHumains(int ligne, int colonne) {
        validerPosition(ligne, colonne);
        return grille[ligne][colonne];
    }
    
    /* validerPosition, méthode de validation qui vérifie qu'une position est bien situé dans le tableau. */

    private void validerPosition(int ligne, int colonne) {
        if (ligne < 0 || ligne >= grille.length || colonne < 0 || colonne >= grille[0].length) {
            throw new IllegalArgumentException("Position hors limites");
        }
    }

    /* afficherGrille, méthode d'affichage d'un être humain. Il affiche les statuts des être humains ou 0 si
     * il n'y a aucun être humain dans une case. */

    public void afficherGrille() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print("| ");
                if (grille[i][j].isEmpty()) {
                    System.out.print("0 ");
                } else {
                    for (Humain humain : grille[i][j]) {
                        System.out.print(humain.GetStatut() + " ");
                    }
                }
            }
            System.out.println("|");
            System.out.println(String.format(String.format("%%0%dd", (grille[i].length * 4) + 1), 0).replace("0","-"));
        }
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
}