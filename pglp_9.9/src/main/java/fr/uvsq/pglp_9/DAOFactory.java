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
public abstract class DAOFactory {
    
    public static final int ORACLE = 1;
    public static final int DERBY = 2;
    
    
    public abstract CarreDAO getCarreDAO();
    public abstract RectangleDAO getRectangleDAO();
    public abstract CercleDAO getCercleDAO();
    public abstract TriangleDAO getTriangleDAO();
    public abstract FormesDAO getFormesDAO();
    
    public static DAOFactory getDAOFactory(int fact){
        switch(fact){
            case DERBY:
                return new DerbyDAOFactory();
            default:
                return null;
        }
    }
    
    
    
    
}
