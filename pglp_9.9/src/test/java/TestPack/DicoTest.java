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
    public void cercleTest() {
	System.out.println("Vérification cercle ");
	if (dico.isMatching(cercle)) {
            dico.splitSaisie(cercle);            
	} else {
            System.out.println("Erreur de syntaxe ");
	}
    }
    
    @Test
    public void carreTest(){
        System.out.println("Verification carre ");
        if(dico.isMatching(carre)){
            dico.splitSaisie(carre);
        }else{
            System.out.println("Erreur de Syntaxe");
        }
    }
    
    @Test
    public void rectangleTest(){
        System.out.println("Verifier rectangle");
        if(dico.isMatching(rectangle)){
            dico.splitSaisie(rectangle);
        }else{
            System.out.println("Erreur de Syntaxe");
        }
    }
    
    @Test
    public void triangleTest(){
        System.out.println("Verifier triangle");
        if(dico.isMatching(triangle)){
            dico.splitSaisie(triangle);
        }else{
            System.out.println("Erreur de Syntaxe");
        }
    }
        
        
}
