

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

//Le principe de ce programme est de simuler 
//une calculatrice virtuelle avec les operations de base tel que + - / * 
//et quelques operations speciales tel que ln ! sqrt POW

class GUI extends JFrame implements ActionListener {
  Calculator cal; // le calculateur utilise dans l interface graphique
  JTextField input; // champ de texte pour afficher et saisir les valeurs

  GUI(Calculator p) {
    super("Calculator"); // titre de la fenetre

    setDefaultCloseOperation(this.EXIT_ON_CLOSE); // definit la fermeture de la fenetre

    this.cal = p; // initialise le calculateur

    // creation des panneaux superieur et inferieur
    JPanel panneauSuperieur = new JPanel();
    JPanel panneauInferieur = new JPanel();

    // les labels pour les boutons
    String[] buttonLabels = { "0", "1", "2", "3", "C", "4", "5", "6", "7", "!", "8", "9", "+", "-", "*", "POW", "sqrt",
        "ln", "=", "/" };

    // creation et ajout des boutons au panneau inferieur
    for (int i = 0; i < buttonLabels.length; i++) {
      JButton b = new JButton(buttonLabels[i]);
      b.addActionListener(this); // ajoute un ecouteur d'evenements a chaque bouton
      panneauInferieur.add(b); // ajoute le bouton au panneau
    }

    // configuration du layout pour le panneau superieur
    panneauSuperieur.setLayout(new FlowLayout());

    // ajout d un champ de texte au panneau superieur
    input = new JTextField(25);
    panneauSuperieur.add(input);

    // configuration du layout pour le panneau inferieur
    panneauInferieur.setLayout(new GridLayout(4, 5));

    // ajout des panneaux au cadre avec les positions specifiees
    add(panneauSuperieur, BorderLayout.NORTH);
    add(panneauInferieur, BorderLayout.SOUTH);

    pack(); // ajuste la taille de la fenetre en fonction de son contenu
  }

  //parametre: type string, type string
  //retourne rien
  // methode pour affecter deux nombres en fonction de l'operation
  public void AffecterDeuxNombres(String str, String operande) {

    List<String> listeOperation = cal.getListeOperation();

    // boucle pour extraire le premier nombre
    for (int i = 0; i < listeOperation.size(); i++) {
      if (listeOperation.get(i) == operande) {
        String firstStr = "";
        for (int j = 0; j < i; j++) {
          firstStr += listeOperation.get(j);
        }
        cal.setFirst(Double.parseDouble(firstStr));
      }
    }

    // boucle pour extraire le deuxieme nombre
    for (int i = 0; i < listeOperation.size(); i++) {
      if (listeOperation.get(i) == operande) {
        String secondStr = "";
        for (int j = i; j < listeOperation.size(); j++) {
          if (listeOperation.get(j) == "=") {
            break;
          }
          if (listeOperation.get(j) == operande) {
            continue;
          } else
            secondStr += listeOperation.get(j);
        }
        cal.setSecond(Double.parseDouble(secondStr));
      }
    }
    System.out.println(cal.getFirst()); // affiche le premier nombre
    System.out.println(cal.getSecond()); // affiche le deuxieme nombre
  }

  //parametre: type string, type string
  //retourne rien
  // methode pour affecter un seul nombre en fonction de l operation
  public void AffecterUnNombre(String str, String operande) {
    List<String> listeOperation = cal.getListeOperation();

    String firstStr = "";
    for (int j = listeOperation.indexOf(operande) + 1; j < listeOperation.size(); j++) {
      if (listeOperation.get(j) == "=") {
        break;
      }
      firstStr += listeOperation.get(j);
    }
    cal.setFirst(Double.parseDouble(firstStr));
  }

  //parametre: type ActionEvent
  //retourne rien
  // methode pour gerer les evenements
  public void actionPerformed(ActionEvent e) {
    String str = e.getActionCommand(); // recupere la commande associee a l action produit

    cal.addToListeOperation(str); // ajoute la commande a la liste des operations

    // determine si l utilisateur a appuyé sur "C" 
    if (str.contains("C")) {
      cal.clear(); // efface le contenu du calculateur
    }

    // determine si l utilisateur a appuyé sur "="
    if (str.contains("=")) {
      // si des operations speciales sont presentes, affecte un seul nombre
      if (cal.getListeOperation().contains("!") || cal.getListeOperation().contains("ln")
          || cal.getListeOperation().contains("sqrt")) {
        AffecterUnNombre(str, cal.getOperand());
      } else
        AffecterDeuxNombres(str, cal.getOperand()); // sinon, affecte deux nombres

      // affichage des operations en cours
      System.out.print("operation : ");
      for (String element : cal.getListeOperation()) {
        System.out.print(element);
      }
      System.out.println();
      System.out.println("-------------------------------------------");

      cal.compute(); // effectue le calcul
      System.out.println("response = " + cal.display()); // affiche la reponse du calcul
    }

    // gestion des operations arithmetiques et speciales
    if (str.contains("+")) {
      cal.add();
    } else if (str.contains("-")) {
      cal.subtract();
    } else if (str.contains("*")) {
      cal.multiply();
    } else if (str.contains("/")) {
      cal.divide();
    } else if (str.contains("POW")) {
      cal.pow();
    } else if (str.contains("!")) {
      cal.factorial();
    } else if (str.contains("ln")) {
      cal.nepLog();
    } else if (str.contains("sqrt")) {
      cal.rootSquare();
    }

    String operationAfficher = "";

    // construction de la chaine de caracteres a afficher dans le champ de texte
    for (String membreOperation : cal.getListeOperation()) {
      if (membreOperation != "[" || membreOperation != "]" || membreOperation != "," || membreOperation != "=") {
        operationAfficher += membreOperation;
      }
    }

    // affichage dans le champ de texte l operation en cours ou bien le resultat finale une fois le "=" appuyé ou bien la valeur 0.0 par défaut si l operation est deja fini
    if (!cal.if_result_exists()) {
      if(cal.getListeOperation().isEmpty()){
        this.input.setText("0.0");
      }else
      this.input.setText(operationAfficher);
    } else {
      this.input.setText(String.valueOf(cal.display()));
    }

  }

  public static void main(String arg[]) {
    GUI gui;
    Calculator cal = new Calculator();
    gui = new GUI(cal);
    gui.setVisible(true); // rend la fenetre visible
  }
}
