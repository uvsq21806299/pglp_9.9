/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPack;

import fr.uvsq.pglp_9.DicoRegex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andri
 */
public class TriangleTest {
    
    DicoRegex dico;
    String triangle1, triangle2;
    
    public TriangleTest() {
    }
    
    
    @Before
    public void init() {
        
        triangle1 = "triangle1= Triangle((2,4), (2,4), (2,4), (2,4))";
        triangle2 = "triangle2= Triangle((2,4), (2,4), (2,4), (2,4), (2,4))";
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void triangle1Test() {
    
        System.out.println("Verifier ");
        if(dico.isMatching(triangle1)){
            dico.splitSaisie(triangle1);
        }else{
            fail("Erreur de syntaxe");
        }
    }
    
    @Test
    public void triangle2Test(){
        
        System.out.println("Verifier ");
        if(dico.isMatching(triangle2)){
            dico.splitSaisie(triangle2);
        }else{
            System.out.println("Erreur de Syntaxe");
        }
    }
}
