/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.util.List;

/**
 * Classe principale
 * 
 * 
 * @author andri
 */
public enum DrawingApp {
    
    ENVIRONNEMENT;
    
    public void run(String saisie){
        DicoRegex dico = new DicoRegex();
        List<String> valeur;
        String formeType;
        Command command;
        if(dico.isMatching(saisie)){
            valeur = dico.splitSaisie(saisie);
            formeType = valeur.get(1).toLowerCase();
            dico.splitSaisie(saisie);
            if(dico.getMoveCommand(valeur)){
                MoveCommand.init(valeur);
                DrawingTUI.interpreteur.mapCommand.get("move").execute();
            }else if (dico.getAfficheCommand(valeur)){
                AfficheCommand.init(valeur);
                DrawingTUI.interpreteur.mapCommand.get("affiche").execute();
            }else if (dico.getGroupCommand(valeur)){
                Groupes.init(valeur);
                DrawingTUI.interpreteur.mapCommand.get("grouoe").execute();
            }else{
                CreeCommand.init(valeur);
                DrawingTUI.interpreteur.mapCommand.get("cree").execute();
            }
        }else{
            /*command = dico.verifCommand(saisie);
            if(command instaceof Quit){
                DrawingTUI.interpreteur.mapCommand.get("quit").execute();
            }else{
                System.out.println(" Commande n'existe pas");
            }
            */
        }
        
    }
    
}
