/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andri
 */
public class DerbyDAOFactory extends DAOFactory{
    
    public static final String DBURL = "jdbc:derby:/C:/Users/andri/DessinDb";

    
    /**
     * 
     * @return connection avec la base de donnees
     * @throws SQLException 
     */
    public static Connection createConnection() throws SQLException
    {
        Connection connection = DriverManager.getConnection(DBURL);
        return connection;
    }
    
    
    @Override
    public CarreDAO getCarreDAO() {
        
        // TODO Auto-generated method stub
	return new CarreDAO();    
    }

    @Override
    public RectangleDAO getRectangleDAO() {
        // TODO Auto-generated method stub
	return new RectangleDAO();    
    }

    /**
     *
     * @return
     */
    @Override
    public CercleDAO getCercleDAO() {
        // TODO Auto-generated method stub
	return new CercleDAO();
    }

    @Override
    public TriangleDAO getTriangleDAO() {
        // TODO Auto-generated method stub
	return new TriangleDAO();
    }

    @Override
    public FormesDAO getFormesDAO() {
        // TODO Auto-generated method stub
	return new FormesDAO();
    }
    
    
    
}
