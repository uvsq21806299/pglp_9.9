/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.util.Scanner;
import java.util.Stack;



/**
 *
 * @author andri
 */
public class DrawingTUI {
    
    private AfficheCommand affiche = new AfficheCommand();
    private CreeCommand cree = new CreeCommand();
    private MoveCommand move = new MoveCommand();
    
    public static Interpreter interpreteur = new Interpreter() {};
    protected Stack<Command> stock;
    private DrawingApp drawingApp;
    
    /**
     * command initial
     */
    public void init() {
        
        interpreteur.save("affiche", affiche);
        interpreteur.save("Cree", cree);
        interpreteur.save("move", move);
        //drawingApp = DrawingApp.ENVIRONNEMENT;
        stock = new Stack<Command>();
        
    }
    
    
    public void nextCommand(){
        
        Scanner sc = new Scanner(System.in);
        String saisie;
        Command command;
        
        while(true){
            System.out.println("Veuillez saisir la commande :  ");
            saisie = sc.nextLine();
            //drawingApp.run(saisie);
        }
    
    }
    
    public void afficher(Formes formes){
        formes.getDescription();
        
    }
    
}
