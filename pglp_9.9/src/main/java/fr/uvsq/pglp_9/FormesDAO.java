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
                    "INSERT INTO Groupe (name) VALUES (?) ");
                prepare.setString(1, cercle.getName());
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
        String col = null;
        PreparedStatement prepare = null;
        try(Connection connection = derby.createConnection()){
            try{
                prepare = connection.prepareStatement("SELECT name FROM GroupForm WHERE name = ?");
                prepare.setString(1, nameGroup);
                ResultSet res = prepare.executeQuery();
                while(res.next()){
                    col = res.getString(1);
                }
                connection.commit();
            }finally{
                prepare.close();
                connection.close();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return col;
    }


    public boolean getExistGroup(String nameGroup){
        
        DerbyDAOFactory derby = new DerbyDAOFactory();
        String col = null;
        boolean resultat = false;
        PreparedStatement prepare = null;
        try(Connection connection = derby.createConnection()){
            try{
                prepare = connection.prepareStatement("SELECT nom FROM GroupForm WHERE name = ?");
                prepare.setString(1, nameGroup);
                ResultSet res = prepare.executeQuery();
                while(res.next()){
                    col = res.getString(1);
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
