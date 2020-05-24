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
    private Point2D a;
    private Point2D b;
    private Point2D c;
    private Point2D d;
    
    @Override
    public void getDescription() {
        System.out.println("C'est le carre " + this.name + ""
                + "  avec les coordonees : ((" + this.a.getX()+","+this.a.getY()+"),("+ this.b.getX()+","+this.b.getY()+"),("
                + this.c.getX()+","+this.c.getY()+ "),(" + this.d.getX()+","+this.d.getY()+ "))");
    } 

    

    /**
     * 
     * @return retourne le nom du carre
     */
    public String getName(){
        return name;
    }
    
    /**
     * 
     * @return retourne le point a
     */
    public Point2D getA(){
        return a;
    }
    
    /**
     * 
     * @return retourne le point b
     */
    public Point2D  getB(){
        return b;
    }
    
    /**
     * 
     * @return retourne le point c
     */
    public Point2D  getC(){
        return c;
    }
    
    /**
     * 
     * @return retourne le point d
     */
    public Point2D  getD(){
        return d;
    }
    
    /**
     * 
     * @param name
     * @param a
     * @param b
     * @param c
     * @param d 
     */
    Carre(String name, Point2D pointa, Point2D pointb,Point2D pointc, Point2D pointd) 
    {
            this.name = name;
            this.a = pointa;
            this.b = pointb;
            this.c = pointc;
            this.d = pointd;    
    }
       
    
}
