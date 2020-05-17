/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.awt.geom.Point2D;

/**
 *
 * @author andri
 */
public class Cercle implements Formes{
    
    private String name;
    private int rayon;
    private Point2D centre;
    
    /**
     * 
     * @param name
     * @param rayon
     * @param centre 
     */
    public Cercle(String name, int rayon, Point2D centre){
        this.name = name;
        this.rayon = rayon;
        this.centre = centre;
        
    }
   
    
    public void move(double dx, double dy) {
        //centre.move(dx, dy);
    }
    
    public String getName(){
        return  name;
    }
    
    public int getRayon(){
        return rayon;
    }
    
    public Point2D getCentre(){
        return centre;
    }
    
    
}
