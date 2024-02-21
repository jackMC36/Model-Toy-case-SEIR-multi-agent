import nedragtna.random.MTRandom;

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

    public Humain(int max){
        MTRandom random = new MTRandom();
        random.nextInt(max);
        if (random.nextInt(max) < 20){
            this.statut='I';
        }
        else{
            this.statut='S';
        }
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

    
}

    

