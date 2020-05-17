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
public class Carre implements Formes{
    
    private String name;
    private Point2D abs;
    private Point2D ord;
    
    /**
     * 
     * @return retourne le nom du carre
     */
    public String getName(){
        return name;
    }
    
    /**
     * 
     * @return retourne la Longueur du carre
     */
    public Point2D getAbs(){
        return abs;
    }
    
    /**
     * 
     * @return retourne la Largeur du carre
     */
    public Point2D  getOrd(){
        return ord;
    }
    
    /**
     *
     * @param name
     * @param abs
     * @param ord
     */
    public Carre(String name, Point2D abs, Point2D ord) 
    {
        
            this.name = name;
            this.abs = abs;
            this.ord = ord;
    }

    public void move(double dx, double dy) {
        
    }

    
}
