/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPack;

import fr.uvsq.pglp_9.DicoRegex;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author andri
 */
public class DicoTest {
    
    DicoRegex dico;
    String carre;
    String cercle;
    String rectangle;
    String triangle;
    
    
    public DicoTest() {
    }
    
    @Before
    public void init() {
        carre = "carre1 = Carre((2,2), (3,3),(6,6),(7,7))";
        cercle = "cercle1 = Cercle((2,5),3)";
        rectangle = "rectangle = Rectangle((3,3), (5,5), (6,6), (7,7))";
        triangle = "triangle = Triangle((5, 10), (2,6), (12,15)";
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    
    @Test
    public void hello() {}
}
