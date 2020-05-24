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
public class CreeCommand implements Command{
    
    private static List<String> formes;
    
    /**
     * 
     * @param list parametre d'une forme graphique
     */
    public static void init(List<String> list){
        formes = list;
    }

    @Override
    public void execute() {

        String formeType = formes.get(1).toLowerCase();
        DerbyDAOFactory derby = new DerbyDAOFactory();
        
        switch(formeType){
            
            case "carre":
                Point2D a = new Point2D(Integer.parseInt(formes.get(2)), Integer.parseInt(formes.get(3)));
                Point2D b = new Point2D(Integer.parseInt(formes.get(4)), Integer.parseInt(formes.get(5)));
                Point2D c = new Point2D(Integer.parseInt(formes.get(6)), Integer.parseInt(formes.get(7)));
                Point2D d = new Point2D(Integer.parseInt(formes.get(8)), Integer.parseInt(formes.get(9)));
                Carre carre = new Carre(a, b, c, d, formes.get(0));
                derby.getCarreDAO().insert(carre);
                DrawingTUI.afficher(carre);
                break;
                
            case "cercle":
                Point2D centre = new Point2D(Integer.parseInt(formes.get(2)), Integer.parseInt(formes.get(3)));
                Cercle cercle = new Cercle(centre, Integer.parseInt(formes.get(4)), formes.get(0));
                derby.getCercleDAO().insert(cercle);
                DrawingTUI.afficher(cercle);
                break;
                
            case "rectangle":
                Point2D a1 = new Point2D(Integer.parseInt(formes.get(2)), Integer.parseInt(formes.get(3)));
                Point2D b1 = new Point2D(Integer.parseInt(formes.get(4)), Integer.parseInt(formes.get(5)));
                Point2D c1 = new Point2D(Integer.parseInt(formes.get(6)), Integer.parseInt(formes.get(7)));
                Point2D d1 = new Point2D(Integer.parseInt(formes.get(8)), Integer.parseInt(formes.get(9)));
                Rectangle rectangle = new Rectangle(a1, b1, c1, d1, formes.get(0));
                derby.getRectangleDAO().insert(rectangle);
                DrawingTUI.afficher(rectangle);
                break;
                
            case "triangle":
                Point2D a2 = new Point2D(Integer.parseInt(formes.get(2)), Integer.parseInt(formes.get(3)));
                Point2D b2 = new Point2D(Integer.parseInt(formes.get(4)), Integer.parseInt(formes.get(5)));
                Point2D c2 = new Point2D(Integer.parseInt(formes.get(6)), Integer.parseInt(formes.get(7)));
                Triangle triangle = new Triangle(a2, b2, c2, formes.get(0));
                derby.getTriangleDAO().insert(triangle);
                DrawingTUI.afficher(triangle);
                break;
                
            default:
                System.out.println(" Cette Forme n'existe pas");
                break;
                
       }
        
        
    }
    
    
    
}
