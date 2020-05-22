/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.util.List;

/**
 *
 * @author andri
 */
public class MoveCommand implements Command{


    public static List<String> name;
    
    public static void init(List<String> list){
        name = list;
    }
	

    @Override
    public void execute() {
        
        
    }
    
}
