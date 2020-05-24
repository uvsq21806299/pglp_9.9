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
    public Cercle(String name, int rayon, Point2D centreC){
        this.name = name;
        this.rayon = rayon;
        this.centre = centreC;
        
    }
   

    /**
     * 
     * @return retourne le nom du cercle
     */
    public String getName(){
        return  name;
    }
    
    /**
     * 
     * @return retourne le rayon du cercle
     */
    public int getRayon(){
        return rayon;
    }
    
    /**
     * 
     * @return retourne le centre du cercle
     */
    public Point2D getCentre(){
        return centre;
    }

    @Override
    public void getDescription() {
        System.out.println("C'est le cercle " +this.name+""
                + " avec : ( centre : (" + this.centre.getX() + "," + this.centre.getY()+ ""
                + "), rayon : (" + this.rayon + "))");
        
    }
    
    
}
