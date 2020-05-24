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
        
        PreparedStatement prepare = null;
        try(Connection connection = new DerbyDAOFactory().createConnection()){
            try{
                prepare = connection.prepareStatement(
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
            } finally{
                prepare.close();
                connection.close();
            }
            
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
        
        PreparedStatement prepare = null;
        try(Connection connection = new DerbyDAOFactory().createConnection()){
            try{
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

                prepare.executeUpdate();
                connection.commit();

            }finally{
                prepare.close();
                connection.close();
            }
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

        int colonne2, colonne3, colonne4, colonne5, colonne6, colonne7, colonne8, colonne9;
        ResultSet resultat;
        String colonne1;
        PreparedStatement prepare = null;
        try(Connection connection = new DerbyDAOFactory().createConnection()){
            try{
                prepare = connection.prepareStatement(
                    "SELECT name, val1, val2, val3, val4, val5, val6, val7, val8 FROM Carre");
                resultat = prepare.executeQuery();
                
                while(resultat.next()){
                    do{
                        colonne1 = resultat.getString(1);
                        colonne2 = resultat.getInt(2);
                        colonne3 = resultat.getInt(3);
                        colonne4 = resultat.getInt(4);
                        colonne5 = resultat.getInt(5);
                        colonne6 = resultat.getInt(6);
                        colonne7 = resultat.getInt(7);
                        colonne8 = resultat.getInt(8);
                        colonne9 = resultat.getInt(9);
                        System.out.println(
                            colonne1 + " = Carre((" + colonne2 + "," + colonne3 + "),(" + colonne4 + "," + colonne5
                            + "),(" + colonne6 + "," + colonne7 + "),(" + colonne8 + "," + colonne9 + "))");
                    }while(resultat.next());
                }
            }finally{
                prepare.close();
                connection.close();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }

    @Override
    public Formes find(String name) {
        Carre carre = null;
	int colonne1, colonne3, colonne4, colonne5, colonne6, colonne7, colonne8, colonne9, colonne10;
        String colonne2;
	ResultSet resultat;
	PreparedStatement prepare = null;
	try (Connection connection = new DerbyDAOFactory().createConnection()) {
            try {
		prepare = connection.prepareStatement(
                    "SELECT id, name, val1, val2, val3, val4, val5, val6, val7, val8 FROM Carre WHERE name = ?");
		prepare.setString(1, name);
		resultat = prepare.executeQuery();

		while (resultat.next()) {
                    do {
			colonne1 = resultat.getInt(1);
			colonne2 = resultat.getString(2);
			colonne3 = resultat.getInt(3);
			colonne4 = resultat.getInt(4);
			colonne5 = resultat.getInt(5);
			colonne6 = resultat.getInt(6);
			colonne7 = resultat.getInt(7);
			colonne8 = resultat.getInt(8);
			colonne9 = resultat.getInt(9);
			colonne10 = resultat.getInt(10);
			Point2D a = new Point2D(colonne3, colonne4);
			Point2D b = new Point2D(colonne5, colonne6);
			Point2D c = new Point2D(colonne7, colonne8);
			Point2D d = new Point2D(colonne9, colonne10);
			carre = new Carre(colonne2, a, b, c, d);
                    } while (resultat.next());
		}
            } finally {
		prepare.close();
		connection.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return carre;
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
