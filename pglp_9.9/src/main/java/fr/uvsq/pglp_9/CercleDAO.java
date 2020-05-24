/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
class CercleDAO implements DAO<Cercle>{

    @Override
    public int insert(Cercle obj) {
        int valeur = 0;
        
        DerbyDAOFactory derby = new DerbyDAOFactory();
        PreparedStatement prepare = null;
        try(Connection connection = derby.createConnection()){
            try{
                prepare = connection.prepareStatement(
                    "INSERT INTO Cercle (name, rayon, val1, val2" +
                    "VALUES (?,?,?,?)");
            
                prepare.setString(1, obj.getName());
                prepare.setInt(2, obj.getRayon());
                prepare.setInt(3, (int) obj.getCentre().getX());
                prepare.setInt(4, (int) obj.getCentre().getY());

                valeur = prepare.executeUpdate();
                connection.commit();
            }finally{
                prepare.close();
                connection.close();
            }
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
        return valeur;
    }

    @Override
    public boolean delete(Cercle obj) {
        return false;
    }

    @Override
    public void update(Cercle obj) {
        int valeur = 0;
         
        DerbyDAOFactory derby = new DerbyDAOFactory();
        PreparedStatement prepare = null;
        try(Connection connection = derby.createConnection()){
            try{
                prepare = connection.prepareStatement(
                    "UPDATE Cercle SET val1=?, val2=? WHERE name=? ");
            prepare.setString(1, obj.getName());
            prepare.setInt(2, (int) obj.getCentre().getX());
            prepare.setInt(3, (int) obj.getCentre().getY());
            
            valeur = prepare.executeUpdate();
            connection.commit();
            }finally{
                
                connection.close();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
    }

    @Override
    public void findAll() {

    }

    @Override
    public Cercle find(String name) {

        Point2D a = new Point2D(0, 0);
        DerbyDAOFactory derby = new DerbyDAOFactory();
        Cercle cercle = null;
        PreparedStatement prepare = null;
        try(Connection connection = derby.createConnection()){
            try{
                prepare = connection.prepareStatement("SELECT nom, rayon, val1, val2 FROM Cercle WHERE name=?");
                prepare.setString(1, name);
                ResultSet resultat = prepare.executeQuery();
                int colonne1, colonne3, colonne4, colonne5;
                String colonne2;
                while(resultat.next()){
                    do{
                        colonne1 = resultat.getInt(1);
                        colonne2 = resultat.getString(2);
                        colonne3 = resultat.getInt(3);
                        colonne4 = resultat.getInt(4);
                        colonne5 = resultat.getInt(5);
                        Point2D centre = new Point2D(colonne4, colonne5);
                        cercle = new Cercle(centre, colonne3, colonne2);
                    }while(resultat.next());
                }
            }finally{
                prepare.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cercle;
        
    }

    @Override
    public void move(Cercle obj, int a, int b) {
        obj.getCentre().setX(obj.getCentre().getX()+ a);
        obj.getCentre().setY(obj.getCentre().getY()+ b);
        update(obj);
    }
    
    
}
