/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.util.HashMap;

/**
 *
 * @author andri
 */
public class Interpreter {
    
    protected final HashMap<String, Command> mapCommand = new HashMap<>();
    
    /**
     * save command
     * @param name
     * @param command 
     */
    public void save(String name, Command command){
        mapCommand.put(name, command);
    }
    
    /**
     * command execute
     * @param command 
     */
    public void execute(Command command){
        if (command == null) {
            throw new IllegalStateException(command + " Invalide ");
	} else {
            command.execute();
	}
    }
}
