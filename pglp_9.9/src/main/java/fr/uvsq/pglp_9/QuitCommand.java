/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

/**
 *
 * @author andri
 */
public class QuitCommand implements Command{

    @Override
    public void execute() {

        System.out.println(" Quitter le programme ");
        System.exit(0);
    }
    
}
