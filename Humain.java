
public class Humain {
    private char statut;
    private int temps;
    private final int dE;
    private final int dI;
    private final int dR;

    //Constructeur

    public Humain(char s, int t, int E, int I, int R){
        statutValide(s);
        this.statut=s;
        this.temps=t;
        this.dE=E;
        this.dI=I;
        this.dR=R;

        
    }

    public Humain(int max, char s){
        MTRandom random = new MTRandom();
        random.nextInt(max);
        statutValide(s);
        this.statut=s;
        this.temps=0;
        this.dE=0;
        this.dI=0;
        this.dR=0;
    }

    private void statutValide(char s){
        if ((s!='S')&&(s!='E')&&(s!='I')&&(s!='R')){
            throw new IllegalArgumentException("statut non valide");
        }
    }

    //Getteurs et Setteurs

    public char GetStatut(){
        return this.statut;
    }
    public int GetTemps(){
        return this.temps;
    }
    public int GetdE(){
        return this.dE;
    }
    public int GetdI(){
        return this.dI;
    }
    public int GetdR(){
        return this.dR;
    }

    public void SetStatut(char s){
        statutValide(s);
        this.statut=s;
    }

    public generate_dE(){
        MTRandom random = new MTRandom();
        this.dE = random.negExp(3);
    }

    public generate_dI(){
        MTRandom random = new MTRandom();
        this.dI = random.negExp(7);
    }

    public generate_dR(){
        MTRandom random = new MTRandom();
        this.dR = random.negExp(365);
    }
    
}

    

