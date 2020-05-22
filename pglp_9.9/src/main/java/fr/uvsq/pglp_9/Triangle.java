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
public class Triangle implements Formes{
    
    private String name;
    private Point2D a;
    private Point2D b;
    private Point2D c;
    
    public Triangle(String name, Point2D a, Point2D b, Point2D c){
        this.name = name;
        this.a = a;
        this.b = b;
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

    
    public void getDescription() {
        System.out.println("C'est le triangle  " + this.name + ""
                + "  avec les coordonees : ((" + this.a.getX()+","+this.a.getY()+"),("+ this.b.getX()+","+this.b.getY()+"),("
                + this.c.getX()+","+this.c.getY()+ "))");
    }

    
    
}
