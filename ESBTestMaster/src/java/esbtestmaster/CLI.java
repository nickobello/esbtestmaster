/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esbtestmaster;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.naturalcli.*;
import org.naturalcli.InvalidSyntaxException;

/**
 *
 * @author matthieu
 */
public class CLI {

     private Set<Command> cs = new HashSet<Command>();
     private Scanner input = new Scanner(System.in);
     private ArrayList<String> historic = new ArrayList<String>();

     public CLI(){
         super();
         init();
     }

     /*
      *  Lance le CLI
      */
     public void launch(){
         String cmd = "";
          while(true){
            try {
                // Execute
                System.out.print("ESB# ");
                cmd = input.nextLine();
                historic.add(cmd);
                new NaturalCLI(cs).execute(cmd);
            } catch (ExecutionException ex) {

                System.out.println("Commande inconnue");    
            }
          }
     }


     /*
      * Initialise le CLI en ajoutant les commandes run, process
      */
     private void init(){
        try {

            Command helloWorldCommand = new Command("hello world <name:string>", "Says hello to the world and especially to some one.", new ICommandExecutor() {
                public void execute(ParseResult pr) {
                    System.out.println("Hello world! And hello especially to " + pr.getParameterValue(0));
                }
            });

            Command run = new Command("run <scenario:string>", "Starts the test described in scenario and creates a XML results file.", new ICommandExecutor() {
               public void execute(ParseResult pr) {
                    try {
                        runAction(pr);
                    } catch (InvalidSyntaxException ex) {
                       System.out.println(ex.getLocalizedMessage());
                    }
                }
            });

            Command process = new Command("process <testresult:string>", "processes the raw XML output file and generates the processed output XML file containing the processed data.", new ICommandExecutor() {
                public void execute(ParseResult pr) {
                    try {
                        processAction(pr);
                    } catch (InvalidSyntaxException ex) {
                        System.out.println(ex.getLocalizedMessage());
                    }
                }
            });
            
          cs.add(helloWorldCommand);
          cs.add(run);
          cs.add(process);
          
        } catch (InvalidSyntaxException ex) {
            Logger.getLogger(CLI.class.getName()).log(Level.SEVERE, null, ex);
        } 

     }

     /*
      * Action appelée par la commande run
      * Lève l'exception InvalidSyntaxException si le fichier n'existe pas
      */
     private void runAction(ParseResult pr) throws InvalidSyntaxException {
         //Ici le bloc exécuté par la commande run
         
           File file = new File((String)pr.getParameterValue(0));
           if(file.exists() && !file.isDirectory()){
                System.out.println("Run Scenario " + pr.getParameterValue(0));
           } else {
                throw new InvalidSyntaxException("Fichier " + pr.getParameterValue(0) + " non existant");
           }
     }

     /*
      * Action appelée par la commande process
      * Lève l'exception InvalidSyntaxException si le fichier n'existe pas
      */
     private void processAction(ParseResult pr) throws InvalidSyntaxException{
         //Ici le bloc exécut par la commande process
           File file = new File((String)pr.getParameterValue(0));
           if(file.exists() && !file.isDirectory()){
                System.out.println("Process file " + pr.getParameterValue(0));
           } else {
               throw new InvalidSyntaxException("Fichier " + pr.getParameterValue(0) + " non existant");
           }
     }

}
