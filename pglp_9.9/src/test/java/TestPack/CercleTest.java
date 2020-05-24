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
public class CercleTest {
    
    DicoRegex dico;
    String cercle1, cercle2;
    
    public CercleTest() {
    }
    
    @Before
    public void init() {
        cercle1 = "c1 = Cercle((2,5),3)";
        cercle2 = "c2 = Cercle((2,5), (4,7), 3)";
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void cercle1Test() {
    
        System.out.println("Verification : ");
        if(dico.isMatching(cercle1)){
            dico.splitSaisie(cercle1);
        }else{
            
        }
    }
    
    @Test
    public void cercle2Test(){
        
        System.out.println("Verification : ");
        if(dico.isMatching(cercle2)){
            dico.splitSaisie(cercle2);
        }else{
            System.out.println("Erreur");
        }
    }
}
