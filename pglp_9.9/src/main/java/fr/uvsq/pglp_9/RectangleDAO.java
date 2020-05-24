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
public class RectangleDAO implements DAO<Rectangle>{

    @Override
    public int insert(Rectangle obj) {
        int valeur = 0;
        DerbyDAOFactory derby = new DerbyDAOFactory();
        try(Connection connection = derby.createConnection()){
            PreparedStatement prepare = connection.prepareStatement(
                    "INSERT INTO Rectangle (name, val1, val2, val3, val4, val5, val6, val7, val8)" +
                            "VALUES (?,?,?,?,?,?,?,?,?,?)");
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

    @Override
    public boolean delete(Rectangle obj) {
        return false;
    }

    @Override
    public void update(Rectangle obj) {
        int valeur = 0;
        DerbyDAOFactory derby = new DerbyDAOFactory();
        try(Connection connection = derby.createConnection()){
            PreparedStatement prepare = connection.prepareStatement(
                "UPDATE Rectangle val1=?, val2=?, val3=?, val4=?, val5=?, val6=?, val7=?, val8=? WHERE name=?");
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
    }

    @Override
    public void findAll() {

        DerbyDAOFactory derby = new DerbyDAOFactory();
	PreparedStatement prepare = null;
	try (Connection connection = derby.createConnection()) {
            try {
                prepare = connection.prepareStatement(
						"SELECT name, val1, val2, val3, val4, val5, val6, val7, val8 FROM Rectangle ");
		ResultSet result = prepare.executeQuery();
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
				colonne8 = result.getInt(8);
				colonne9 = result.getInt(9);
				System.out.println(colonne1 + " = Rectangle((" + colonne2 + "," + colonne3 + "),(" + colonne4
								+ "," + colonne5 + "),(" + colonne6 + "," + colonne7 + "),(" + colonne8 + "," + colonne9
								+ "))");
			} while (result.next());
		}
            } finally {
		prepare.close();
		connection.close();
            }
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
    }

    @Override
    public Rectangle find(String name) {

        DerbyDAOFactory derby = new DerbyDAOFactory();
        Rectangle rectangle = null;
		PreparedStatement prepare = null;
		try (Connection connect = derby.createConnection()) {
			try {
				prepare = connect.prepareStatement(
						"SELECT id, nom, coord1, coord2, coord3, coord4, coord5, coord6, coord7, coord8 FROM Rectangle where nom = ?");
				prepare.setString(1, name);
				ResultSet result = prepare.executeQuery();
				int colonne1, colonne3, colonne4, colonne5, colonne6, colonne7, colonne8, colonne9, colonne10;
				String colonne2;
				while (result.next()) {
					do {
						colonne1 = result.getInt(1);
						colonne2 = result.getString(2);
						colonne3 = result.getInt(3);
						colonne4 = result.getInt(4);
						colonne5 = result.getInt(5);
						colonne6 = result.getInt(6);
						colonne7 = result.getInt(7);
						colonne8 = result.getInt(8);
						colonne9 = result.getInt(9);
						colonne10 = result.getInt(10);
						Point2D a = new Point2D(colonne3, colonne4);
						Point2D b = new Point2D(colonne5, colonne6);
						Point2D c = new Point2D(colonne7, colonne8);
						Point2D d = new Point2D(colonne9, colonne10);
						rectangle = new Rectangle(a, b, c, d, colonne2);
					} while (result.next());
				}
			} finally {
				prepare.close();
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rectangle;
    }

    @Override
    public void move(Rectangle obj, int a, int b) {
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
