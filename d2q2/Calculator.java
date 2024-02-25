
/**********************Q2-Devoir2 ITI1521*********/

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

class Calculator {
  private double first, second; // two calculator operands
  private String oP; // symbole operation
  private List<String> listeOperation; // operation liste
  private boolean existsResult; // variable qui va changer son état selon "si l operation mathematique est fini"

  Calculator() {
    // j initialise la liste d operation vide et le resultat de l operation qui n
    // existe pas encore
    this.listeOperation = new ArrayList<>();
    existsResult = false;
  };

  // parametre: type string
  // retourne rien
  void operation(String str) {
    first = second; // keep first operand
    second = 0; // initialize and get ready for second operand
    oP = str;
  }

  // parametre: rien
  // retourne rien
  // ajoute loperation daddition a la liste des operations
  void add() {
    operation("+");
  }

  // parametre: rien
  // retourne rien
  // ajoute loperation de soustraction a la liste des operations
  void subtract() {
    operation("-");
  }

  // parametre: rien
  // retourne rien
  // ajoute loperation de multiplication a la liste des operations
  void multiply() {
    operation("*");
  }

  // parametre: rien
  // retourne rien
  // ajoute loperation de division a la liste des operations
  void divide() {
    operation("/");
  }

  // parametre: rien
  // retourne rien
  // ajoute loperation de factorielle a la liste des operations
  void factorial() {
    operation("!");
  }

  // parametre: rien
  // retourne rien
  // ajoute loperation de puissance a la liste des operations
  void pow() {
    operation("POW");
  }

  // parametre: rien
  // retourne rien
  // ajoute loperation de racine carree a la liste des operations
  void rootSquare() {
    operation("sqrt");
  }

  // parametre: rien
  // retourne rien
  // ajoute loperation de logarithme neprien a la liste des operations
  void nepLog() {
    operation("ln");
  }


  //parametre: rien
  //retourne rien
  // calcule le resultat en fonction de loperation en cours
  void compute() {
    if (oP.equals("+")) {
      second = first + second;
      this.existsResult = true;
    } else if (oP.equals("-")) {
      second = first - second;
      this.existsResult = true;
    } else if (oP.equals("*")) {
      second = first * second;
      this.existsResult = true;
    } else if (oP.equals("/")) {
      second = first / second;
      this.existsResult = true;
    } else if (oP.equals("POW")) {
      double multiple = 1;

      for (int i = 0; i < second; i++) {
        multiple = multiple * first;
      }
      second = multiple;
      this.existsResult = true;
    } else if (oP.equals("sqrt")) {
      second = Math.sqrt(first);
      this.existsResult = true;
    } else if (oP.equals("!")) {
      second = Math
          .round(Math.sqrt(2 * first * Math.PI) * Math.pow((first / Math.E), first) * (1 + (1 / (12 * first))));
      this.existsResult = true;
    } else if (oP.equals("ln")) {
      second = Math.log(first);
      this.existsResult = true;
    }
  }

  //parametre: rien
  //retourne rien
  // reinitialise la calculatrice
  void clear() {
    second = 0;
    first = 0;
    oP = "";
    this.listeOperation.clear();
    this.existsResult = false;
  }

  //parametre: rien
  //retourne type double
  // affiche le resultat
  double display() {
    return second;
  }

   //parametre: rien
  //retourne type double
  // recupere le premier nombre
  double getFirst() {
    return first;
  }
 //parametre: rien
  //retourne type double
  // recupere le deuxieme nombre
  double getSecond() {
    return second;
  }
 //parametre: rien
  //retourne type string
  // recupere loperateur
  String getOperand() {
    return oP;
  }
 //parametre: type double
  //retourne rien
  // definit le premier nombre
  void setFirst(double first) {
    this.first = first;
  }
 //parametre: type double
  //retourne rien
  // definit le deuxieme nombre
  void setSecond(double second) {
    this.second = second;
  }

   //parametre: rien
  //retourne boolean
  // verifie si le resultat existe
  boolean if_result_exists() {
    return this.existsResult;
  }

   //parametre: rien
  //retourne type List<String>
  // recupere la liste des operations
  List<String> getListeOperation() {
    return this.listeOperation;
  }

  //parametre: string
  //retourne rien
  // ajoute une operation a la liste des operations
  void addToListeOperation(String memberOperation) {
    this.listeOperation.add(memberOperation);
  }

}
