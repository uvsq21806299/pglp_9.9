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
public class TriangleDAO implements DAO<Triangle>{

    @Override
    public int insert(Triangle obj) {
        int valeur = 0;
	DerbyDAOFactory derby = new DerbyDAOFactory();
	try (Connection connect = derby.createConnection()) {
            PreparedStatement prepare = connect.prepareStatement(
		"INSERT INTO Triangle (nom, coord1, coord2, coord3, coord4, coord5, coord6)" +
		"VALUES (?, ?, ?, ?, ?, ?, ?)");
            prepare.setString(1, obj.getName());
            prepare.setInt(2, (int) obj.getA().getX());
            prepare.setInt(3, (int) obj.getA().getY());
            prepare.setInt(4, (int) obj.getB().getX());
            prepare.setInt(5, (int) obj.getB().getY());
            prepare.setInt(6, (int) obj.getC().getX());
            prepare.setInt(7, (int) obj.getC().getY());
            
            System.out.println("Création d'un triangle " + obj);
            valeur = prepare.executeUpdate();
            connect.commit();
	}
	catch (SQLException ex) {
            ex.printStackTrace();
	}
	return valeur;    
    }
    

    @Override
    public boolean delete(Triangle obj) {
        return false;
    }

    @Override
    public void update(Triangle obj) {
        int valeur = 0;
        
        DerbyDAOFactory derby = new DerbyDAOFactory();
        try(Connection connection = derby.createConnection()){
            PreparedStatement prepare = connection.prepareStatement(
                    "UPDATE Triangle SET val1=?, val2=?, val3=?, val4=?, val5=?, val6=?");
            prepare.setString(1, obj.getName());
            prepare.setInt(2, (int) obj.getA().getX());
            prepare.setInt(3, (int) obj.getA().getY());
            prepare.setInt(4, (int) obj.getB().getX());
            prepare.setInt(5, (int) obj.getB().getY());
            prepare.setInt(6, (int) obj.getC().getX());
            prepare.setInt(7, (int) obj.getC().getY());
            
            
            valeur = prepare.executeUpdate();
            connection.commit();
            connection.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Formes find(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(Triangle obj, int a, int b) {

        obj.getA().setX(obj.getA()+ a);
        obj.getA().setX(obj.getA()+ b);
        obj.getB().setX(obj.getB()+ a);
        obj.getB().setX(obj.getB()+ b);
        obj.getC().setX(obj.getC()+ a);
        obj.getC().setX(obj.getC()+ b);
        update(obj);
        
    }
    
}
