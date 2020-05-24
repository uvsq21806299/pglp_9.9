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
public class Point2D{
    
    private int x;
    private int y;
    
    /**
     * 
     * @param x axe des abscisses
     * @param y axe des ordonnees
     */
    public Point2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    /**
     * 
     * @return x : abscisse
     */
    public int getX()
    {
        return this.x;
    }
    
    /**
     * 
     * @return y : ordonnee
     */
    public int getY()
    {
        return this.y;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    //public void setY(double y)
    {
        this.y = y;
    }

   
    
}
