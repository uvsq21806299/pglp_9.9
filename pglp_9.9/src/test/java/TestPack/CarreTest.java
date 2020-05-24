/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPack;

import fr.uvsq.pglp_9.DicoRegex;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andri
 */
public class CarreTest {
    
    DicoRegex dico;
    String carre1, carre2;
    
    public CarreTest() {
    }
    
    
    @Before
    public void init() {
        carre1 = "carre1 = Carre((2,5), (2,5), (2,5), (2,5))";
        carre2 = "carre2 = Carre((2,5), (2,5), (2,5), (2,5), (2,5))";
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void carre1Test() {
    
        System.out.println(" Verification : ");
        if(dico.isMatching(carre1)){
            dico.splitSaisie(carre1);
        }else{
            fail(" Erreur, Verifier ");
        }
    }
    
    
    @Test
    public void carre2Test() {
    
        System.out.println(" Verification : ");
        if(dico.isMatching(carre2)){
            dico.splitSaisie(carre2);
        }else{
            System.out.println(" Erreur, Verifier ");
        }
    }
}
