
public class Humain {
    private char statut;
    private int temps;
    private int dE;
    private int dI;
    private int dR;
    private MTRandom random = new MTRandom();

    //Constructeur

    public Humain(char s){
        statutValide(s);
        this.statut=s;
        this.temps=0;
        this.generate_dE();
        this.generate_dI();
        this.generate_dR();
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

    public void SetTemps(int n){
        this.temps = n;
    }

    public void generate_dE(){
        this.dE = (int) random.negExp(3);
        
    }

    public void generate_dI(){
        this.dI = (int) random.negExp(7);
        
    }

    public void generate_dR(){
        this.dR = (int) random.negExp(365);
    }
    
}

    

