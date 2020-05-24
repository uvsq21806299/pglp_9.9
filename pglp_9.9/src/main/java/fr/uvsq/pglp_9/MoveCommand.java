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
public class MoveCommand implements Command{


    public static List<String> name;
    
    public static void init(List<String> list){
        name = list;
    }
	

    @Override
    public void execute() {
        String elementForSearchInDerbyDB = name.get(1), uuid;
		DerbyDAOFactory derby = new DerbyDAOFactory();
		List<String> elementGroup;

		// Recherche dans le groupe d'abord
		if (derby.getFormesDAO().getExistGroup(elementForSearchInDerbyDB)) {
			/**
			 * On sélectionne tous les éléments graphiques du groupe
			 */
			uuid = derby.getFormesDAO().findGroup(elementForSearchInDerbyDB);
			elementGroup = derby.getFormesDAO().getAllElement(uuid);
			for (int i = 0; i < elementGroup.size(); i++) {
				Cercle cercle = derby.getCercleDAO().find(elementGroup.get(i));
				if (cercle != null) {
					derby.getCercleDAO().move(cercle, Integer.parseInt(name.get(2)), Integer.parseInt(name.get(3)));
				} else {
					Carre carre = derby.getCarreDAO().find(elementGroup.get(i));
					if (carre != null) {
						derby.getCarreDAO().move(carre, Integer.parseInt(name.get(2)), Integer.parseInt(name.get(3)));
					} else {
						Rectangle rectangle = (Rectangle) derby.getRectangleDAO().find(elementGroup.get(i));
						if (rectangle != null) {
							derby.getRectangleDAO().move(rectangle, Integer.parseInt(name.get(2)),
									Integer.parseInt(name.get(3)));
						} else {
							Triangle triangle = (Triangle) derby.getTriangleDAO().find(elementGroup.get(i));
							if (triangle != null) {
								derby.getTriangleDAO().move(triangle, Integer.parseInt(name.get(2)),
										Integer.parseInt(name.get(3)));
							} else {

							}
						}
					}
				}
			}
			System.out.println("Le groupe a été déplacer !!!");
		} else {
			Cercle cercle = derby.getCercleDAO().find(elementForSearchInDerbyDB);
			if (cercle != null) {
				derby.getCercleDAO().move(cercle, Integer.parseInt(name.get(2)), Integer.parseInt(name.get(3)));
			} else {
				Carre carre = derby.getCarreDAO().find(elementForSearchInDerbyDB);
				if (carre != null) {
					derby.getCarreDAO().move(carre, Integer.parseInt(name.get(2)), Integer.parseInt(name.get(3)));
				} else {
					Rectangle rectangle = (Rectangle) derby.getRectangleDAO().find(elementForSearchInDerbyDB);
					if (rectangle != null) {
						derby.getRectangleDAO().move(rectangle, Integer.parseInt(name.get(2)),
								Integer.parseInt(name.get(3)));
					} else {
						Triangle triangle = (Triangle) derby.getTriangleDAO().find(elementForSearchInDerbyDB);
						if (triangle != null) {
							derby.getTriangleDAO().move(triangle, Integer.parseInt(name.get(2)),
									Integer.parseInt(name.get(3)));
						} else {

						}
					}
				}
			}
		}
	}
        
    
    
}
