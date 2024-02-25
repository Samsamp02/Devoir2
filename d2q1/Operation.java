/**
 *ITI 1521 - Introduction � l�informatique II
 *@author ZHOR SEBBANI, Universit� d'Ottawa/University of Ottawa
 * 
 */


public class Operation {

    private int x, y;  //nombres aleatoires pour l'operation arithmetique
    private int rand;  //nombre aleatoire = 0 pour l'addition et 1 pour la multiplication

    public Operation() { // constructor
        // G�n�rer deux entiers positifs al�atoires entre 0 et 9 (inclusivement) 
        x = (int)(Math.random() * 10); 
        y = (int)(Math.random() * 10);
        rand = (int)(Math.random() * 2); // G�n�re un entier positif al�atoire entre 0 et 1 (inclusivement) 
    }

    //parametre: rien
    //retourne type string
    public String getQuestion0() {
        return "Quelle est la valeur de " + x + " + " + y + " ?";
    }
  //parametre: rien
    //retourne type string
    public String getQuestion1() {
        return "Quelle est la valeur de " + x + " * " + y + " ?";
    }
      //parametre: rien
    //retourne type int
    public int getAddition() {
        return x + y;
    }
     //parametre: rien
    //retourne type int
    public int getProduct() {
        return x*y;
    }
     //parametre: rien
    //retourne type int
     public int getRand() {
        return rand;
    }
}
