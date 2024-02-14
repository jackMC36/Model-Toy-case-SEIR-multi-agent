package L2.S4.ProjetInfos;


public class Humain {
    private char statut;
    private int temps;
    private final int dE;
    private final int dI;
    private final int dR;

    public Humain(char s, int t, int E, int I, int R){
        statutValide(s);
        this.statut=s;
        this.temps=t;
        this.dE=E;
        this.dI=I;
        this.dR=R;

        
    }

    private void statutValide(char s){
        if ((s!='S')||(s!='E')||(s!='I')||(s!='R')){
            throw new IllegalArgumentException("statut non valide");
        }
    }
}

    //GET

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
    

