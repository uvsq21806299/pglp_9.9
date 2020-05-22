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

    @Override
    public void move(Formes obj, int a, int b) {
		// TODO Auto-generated method stub
    }
    
}
