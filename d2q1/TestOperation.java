/**********************Q1-Devoir2 ITI1521....*/
/**
 * TestOperation
 */
public class TestOperation {
    
    private static Operation[] questions;  // questions pour le test

    private static int[] reponses;   // r�ponses de l'utilisateur aux questions
    
      
    /**
     * Cr�e le tableau questions de 10 elements
     */

    //parametre : rien
    //retourne rien
    private static void creezTest() {
      questions = new Operation[10];
      
      for (int i = 0; i<10; i++){
        questions[i] = new Operation();
      }
     
    }//end of creezTest()
    
    
    /**
     * Affiche toutes les questions du test 
     * et obtient les r�ponses de l'utilisateur.
     * Compare la r�ponse de l��l�ve � la bonne r�ponse 
     * (si elles sont diff�rentes, affiche la bonne r�ponse); 
     * les bonnes r�ponses sont compt�es et affich�es � la fin.
     * Les r�ponses sont stock�es dans un tableau, 
     * qui est cr�� dans ce sous-programme.
     *
     * et calcule et affiche une note pour le test. 
     */


       //parametre : rien
    //retourne rien
    private static void effectuezTest()  {
     
    
      reponses = new int[10];
      int rep;
      int correct = 0;
      for (int i = 0; i < 10; i++){
        if (questions[i].getRand() == 0){
          rep = ReadInt.getInt("Question " + (i+1) + ": " + questions[i].getQuestion0());

          if (rep != questions[i].getAddition()){
            System.out.println("INCORRECT. La reponse est: " + questions[i].getAddition());
            
          }else{
            correct++;
            reponses[i] = rep;
          }
          
        } else {
          rep = ReadInt.getInt("Question " + (i+1) + ": " + questions[i].getQuestion1());
          if (rep != questions[i].getProduct()){
            System.out.println("INCORRECT. La reponse est: " + questions[i].getProduct());
            
          }else{
            correct++;
            reponses[i] = rep;
          }
        }
        
      }
      
      System.out.println("Vous avez eu " + correct + " bonnes reponses");  
      System.out.println("Votre note pour ce test est: " + (correct/10.0)*100 +"%");        
    }//end of effectuezTest()
    
   
    /*
     * Programme principal main
     */ 
    public static void main(String[] args) {
        System.out.println();
        System.out.println("SVP répondre aux 10 questions d'operations arithmetiques suivantes :");
        System.out.println();
        creezTest();
        effectuezTest();
   }//end of main()
    

} // end class OperationTest 
