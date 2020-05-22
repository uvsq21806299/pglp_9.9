/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author andri
 */
public class FormesComposite {
    
    private Collection child;
    
    public FormesComposite(){
        child = new ArrayList<Formes>();
    }
    
    /**
     * 
     * @param formes 
     */
    public void add(Formes formes){
        child.add(formes);
    }
    
    /**
     * 
     * @param formes 
     */
    public void remove(Formes formes){
        child.remove(formes);
    }
    
    
}
