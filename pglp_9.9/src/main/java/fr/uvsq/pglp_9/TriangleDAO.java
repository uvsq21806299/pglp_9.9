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

/**
 *
 * @author andri
 */
public class TriangleDAO implements DAO<Triangle>{

    @Override
    public int insert(Triangle obj) {
        int valeur = 0;
	DerbyDAOFactory derby = new DerbyDAOFactory();
	try (Connection connection = derby.createConnection()) {
            PreparedStatement prepare = connection.prepareStatement(
		"INSERT INTO Triangle (name, val1, val2, val3, val4, val5, val6)" +
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
            connection.commit();
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

    @Override
    public void findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Triangle find(String name) {
        DerbyDAOFactory derby = new DerbyDAOFactory();
	ResultSet result = null;
	PreparedStatement prepare = null;
	try (Connection connection = derby.createConnection()) {
            try {
		prepare = connection.prepareStatement("SELECT name, val1, val2, val3, val4, val5, val6 FROM Triangle ");
		result = prepare.executeQuery();
		System.out.println("Selection de tous les rectangles :");
		int colonne2, colonne3, colonne4, colonne5, colonne6, colonne7, colonne8, colonne9;
		String colonne1;
		while (result.next()) {
                    do {
			colonne1 = result.getString(1);
			colonne2 = result.getInt(2);
			colonne3 = result.getInt(3);
			colonne4 = result.getInt(4);
			colonne5 = result.getInt(5);
			colonne6 = result.getInt(6);
			colonne7 = result.getInt(7);
			System.out.println(colonne1 + " = Triangle((" + colonne2 + "," + colonne3 + "),(" + colonne4
								+ "," + colonne5 + "),(" + colonne6 + "," + colonne7 + "))");
					} while (result.next());
				}
				connection.commit();
			} finally {
				prepare.close();
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return (Triangle) result;
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
