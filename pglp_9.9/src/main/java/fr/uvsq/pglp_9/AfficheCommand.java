/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

import java.util.List;

/**
 *
 * @author andri
 */
public class AfficheCommand implements Command{
    private static String name;
    
    /**
     * initialisation createCommand
     * @param list parametre d'une forme graphique
     */
    public static void init(List<String> list){
        name = list.get(1);
    }
    
    @Override
    public void execute() {
        
        DerbyDAOFactory derby = new DerbyDAOFactory();
        int r = 0;
        
        try{
            Carre carre = (Carre) derby.getCarreDAO().find(name);
            if(carre != null){
                carre.getDescription();
                r++;
            }
        }catch(Exception ex){
		// TODO: handle exception

        }
        
        try{
            Cercle cercle = (Cercle) derby.getCercleDAO().find(name);
            if(cercle != null){
                cercle.getDescription();
                r++;
            }
        }catch(Exception ex){
		// TODO: handle exception
        }
        
        try{
            Rectangle rectangle = (Rectangle) derby.getRectangleDAO().find(name);
            if(rectangle != null){
                rectangle.getDescription();
                r++;
            }
        }catch(Exception ex){
            // TODO: handle exception
        }
        
        try{
            Triangle triangle = (Triangle) derby.getTriangleDAO().find(name);
            if(triangle != null){
                triangle.getDescription();
                r++;
            }
        }catch(Exception ex){
            // TODO: handle exception
        }
        
        if(r == 0){
            System.out.println(name + " erreur");
        }
        r = 0;
    }

    
    
    
    
}
