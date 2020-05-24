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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
public class FormesDAO implements DAO<Formes>{

    @Override
    public int insert(Formes obj) {

        int res = 0;
        DerbyDAOFactory derby = new DerbyDAOFactory();
        PreparedStatement prepare = null;
        try(Connection connection = derby.createConnection()){
            try{
                Cercle cercle;
                cercle = (Cercle) obj;
                prepare = connection.prepareStatement(
                    "INSERT INTO Groupe (uuid, name) VALUES (?, ?) ");
                prepare.setString(1, Groupes.uuid);
                prepare.setString(2, cercle.getName());
                res = prepare.executeUpdate();
                connection.commit();
            }
            finally{
                prepare.close();
                connection.close();
            }
            
            try{
                Carre carre;
                carre = (Carre) obj;
                prepare = connection.prepareStatement(
                    "INSERT INTO Groupe (uuid, name) VALUES (?, ?) ");
                prepare.setString(1, Groupes.uuid);
                prepare.setString(2, carre.getName());
                res = prepare.executeUpdate();
                connection.commit();
            }
            finally{
                prepare.close();
                connection.close();
            }
            
            try{
                Rectangle rectangle;
                rectangle = (Rectangle) obj;
                prepare = connection.prepareStatement(
                    "INSERT INTO Groupe (uuid, name) VALUES (?, ?) ");
                prepare.setString(1, Groupes.uuid);
                prepare.setString(2, rectangle.getName());
                res = prepare.executeUpdate();
                connection.commit();
            }
            finally{
                prepare.close();
                connection.close();
            }
            
            try{
                Triangle triangle;
                triangle = (Triangle) obj;
                prepare = connection.prepareStatement(
                    "INSERT INTO Groupe (uuid, name) VALUES (?, ?) ");
                prepare.setString(1, Groupes.uuid);
                prepare.setString(2, triangle.getName());
                res = prepare.executeUpdate();
                connection.commit();
            }
            finally{
                prepare.close();
                connection.close();
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    public List<String> getAllElement(String uuid) {
	DerbyDAOFactory derby = new DerbyDAOFactory();
	List<String> liste = new ArrayList<String>();
	PreparedStatement prepare = null;
	try (Connection connection = derby.createConnection()) {
            try {
		prepare = connection.prepareStatement("SELECT nomelement FROM GraphiqueEnsemble where uuidgroup = ?");
		prepare.setString(1, uuid);
		ResultSet result = prepare.executeQuery();
		String colonne2;
                while (result.next()) {
                    do {
                        colonne2 = result.getString(1);
			liste.add(colonne2);
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
		return liste;
	}
    
    @Override
    public boolean delete(Formes obj) {
        return false;
    }

    @Override
    public void update(Formes obj) {
    }

    @Override
    public void findAll() {
    }

    @Override
    public Formes find(String name) {
        return null;
    }
    
    public String findGroup(String nameGroup){
        DerbyDAOFactory derby = new DerbyDAOFactory();
        String col1, col2 = null;
        PreparedStatement prepare = null;
        try(Connection connection = derby.createConnection()){
            try{
                prepare = connection.prepareStatement("SELECT name, uuid FROM GroupForm WHERE name = ?");
                prepare.setString(1, nameGroup);
                ResultSet res = prepare.executeQuery();
                while(res.next()){
                    col1 = res.getString(1);
                    col2 = res.getString(2);
                }
                connection.commit();
            }finally{
                prepare.close();
                connection.close();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return col2;
    }


    public boolean getExistGroup(String nameGroup){
        
        DerbyDAOFactory derby = new DerbyDAOFactory();
        String col1, col2 = null;
        boolean resultat = false;
        PreparedStatement prepare = null;
        try(Connection connection = derby.createConnection()){
            try{
                prepare = connection.prepareStatement("SELECT nom, uuid FROM GroupForm WHERE name = ?");
                prepare.setString(1, nameGroup);
                ResultSet res = prepare.executeQuery();
                while(res.next()){
                    col1 = res.getString(1);
                    col2 = res.getString(2);
                    resultat = true;
                }
            }finally{
                prepare.close();
                connection.close();
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return resultat;
    }
    
    public void insertGroup(String nom, String uuid) {
	int res = 0;
	DerbyDAOFactory derby = new DerbyDAOFactory();
	PreparedStatement prepare = null;
	try (Connection connection = derby.createConnection()) {
            try {
		prepare = connection.prepareStatement("INSERT INTO GroupGraphique (nom)" + "VALUES (?)");
				prepare.setString(1, nom);
                                prepare.setString(2, uuid);
				res = prepare.executeUpdate();
				connection.commit();
			} finally {
				prepare.close();
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
    
    @Override
    public void move(Formes obj, int a, int b) {
		// TODO Auto-generated method stub
    }
    
}
