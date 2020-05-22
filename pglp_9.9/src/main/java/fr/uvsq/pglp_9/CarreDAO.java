/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
public class CarreDAO implements DAO<Carre>{
    
    /**
     * 
     * @param obj
     * Creer et inserer un nouveau carre dans la base 
     * @return  
     */
    @Override
    public int insert(Carre obj) {
        // TODO Auto-generated method stub
        int valeur = 0;
        
        DerbyDAOFactory derby = new DerbyDAOFactory();
        try(Connection connection = derby.createConnection()){
            PreparedStatement prepare = connection.prepareStatement(
                "INSERT INTO Carre (name, val1, val2, val3, val4, val5, val6, val8" +
                        "VALUES (?,?,?,?,?,?,?,?");
            prepare.setString(1, obj.getName());
            prepare.setInt(2, (int) obj.getA().getX());
            prepare.setInt(3, (int) obj.getA().getY());
            prepare.setInt(4, (int) obj.getB().getX());
            prepare.setInt(5, (int) obj.getB().getY());
            prepare.setInt(6, (int) obj.getC().getX());
            prepare.setInt(7, (int) obj.getC().getY());
            prepare.setInt(8, (int) obj.getD().getX());
            prepare.setInt(9, (int) obj.getD().getY());
            
            valeur = prepare.executeUpdate();
            connection.commit();
            connection.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valeur;
    }
    
    /**
     * Suppression d'un carre
     * @param obj
     * @return 
     */
    @Override
    public boolean delete(Carre obj) {
        return false;
    }

    /**
     * 
     * mis a jour des coordonnes d'un carre de la base
     * @param obj 
     */
    @Override
    public void update(Carre obj) {
        int valeur = 0;
        DerbyDAOFactory derby = new DerbyDAOFactory();
        PreparedStatement prepare;
        try(Connection connection = derby.createConnection()){
            prepare = connection.prepareStatement(
                    "UPDATE Carre SET val1=?, val2=?, val3=?, val4=?, val5=?, val6=?, val7=?, val8=? WHERE name=?");
            prepare.setString(1, obj.getName());
            prepare.setInt(2, (int) obj.getA().getX());
            prepare.setInt(3, (int) obj.getA().getY());
            prepare.setInt(4, (int) obj.getB().getX());
            prepare.setInt(5, (int) obj.getB().getY());
            prepare.setInt(6, (int) obj.getC().getX());
            prepare.setInt(7, (int) obj.getC().getY());
            prepare.setInt(8, (int) obj.getD().getX());
            prepare.setInt(9, (int) obj.getD().getY());
            
            System.out.println("Création d'un carre " + obj);
            prepare.executeUpdate();
            connection.commit();
            connection.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    /**
     * 
     * afficher tous les carres contenues dans la base
     * 
     */
    @Override
    public void findAll() {
        DerbyDAOFactory derby = new DerbyDAOFactory();
        
    }

    @Override
    public Formes find(String name) {
        return null;
    }

    @Override
    public void move(Carre obj, int a, int b) {
        obj.getA().setX(obj.getA().getX()+ a);
        obj.getA().setY(obj.getA().getY()+ b);
        obj.getB().setX(obj.getB().getX()+ a);
        obj.getB().setY(obj.getB().getY()+ b);
        obj.getC().setX(obj.getC().getX()+ a);
        obj.getC().setY(obj.getC().getY()+ b);
        obj.getD().setX(obj.getD().getX()+ a);
        obj.getD().setY(obj.getD().getY()+ b);
        update(obj);
        
              
    }
    
    
}
