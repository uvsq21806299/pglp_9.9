/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author andri
 */
public class Groupes implements Command{
    
    static List<String> group;
    static String groupName;
    static String uuid = UUID.randomUUID().toString();
    

    public static void init(List<String> valeur){
        group = valeur;
    }
    
    
    @Override
    public void execute() {
        
        groupName = group.get(0);
        FormesDAO groupDAO = new FormesDAO();
        groupDAO.insertGroup(groupName, uuid);
        DerbyDAOFactory derby = new DerbyDAOFactory();
        for(int i=1; i<= group.size()-1; i++){
            String elementForSearchInDerbyDB = group.get(i);
            try{
                Cercle cercle = (Cercle) derby.getCercleDAO().find(elementForSearchInDerbyDB);
                if(cercle != null){
                    groupDAO.insert(cercle);
                }
            }catch(Exception ex){
                
            }
            
            try{
                Carre carre = (Carre) derby.getCarreDAO().find(elementForSearchInDerbyDB);
                if(carre != null){
                    groupDAO.insert(carre);
                }
            }catch(Exception ex){
                
            }
            
            try{
                Rectangle rectangle = (Rectangle) derby.getRectangleDAO().find(elementForSearchInDerbyDB);
                if(rectangle != null){
                    groupDAO.insert(rectangle);
                }
            }catch(Exception ex){
                
            }
            
            try{
                Triangle triangle = (Triangle) derby.getTriangleDAO().find(elementForSearchInDerbyDB);
                if(triangle != null){
                    groupDAO.insert(triangle);
                }
            }catch(Exception ex){
                
            }
        }
        System.out.println(" Creee groupe ");
        
    }

    
    
    
}
