/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPack;

import fr.uvsq.pglp_9.DicoRegex;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author andri
 */
public class RectangleTest {
    
    DicoRegex dico;
    String rectangle1, rectangle2;
    
    public RectangleTest() {
    }
    
    
    @Before
    public void init() {
        
        rectangle1 = "rect1 = Rectangle((2, 5), (2, 5), (2, 5), (2, 5))";
	rectangle2 = "rect2 = Rectangle((2, 5), (2, 5), (2, 5), (2, 5),(2, 5))";
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void rectangle1Test() {
    
        System.out.println("Verification ");
        if(dico.isMatching(rectangle1)){
            dico.splitSaisie(rectangle1);
        }else{
            fail("Erreur de Syntax");
        }
    }
    
    @Test
    public void rectangle2Test(){
        
        System.out.println("Verifier ");
        if(dico.isMatching(rectangle2)){
            dico.splitSaisie(rectangle2);
        }else{
            System.out.println("Erreur de Syntaxe ");
        }
    }
}
