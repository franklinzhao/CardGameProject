/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarCardGame;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franklinzhao
 */
public class warCardTest {
    
    public warCardTest() {
    }
    /**
     * Test of isGreater method, of class warCard.
     * @return 1 if the current card greater than the input card, 2 for less, equal is 3
     */
    @Test
    public void testIsGreaterGood() {
        System.out.println("Check the warCard method: isGreater.  Good");
        //card1 is ACE of Clubs,14
        warCard card1 = new warCard(Rank.values()[0],Suit.values()[0]);
        //card2 is Two of Diamond,2
        warCard card2 = new warCard(Rank.values()[1],Suit.values()[1]);
        
        int expResult = 1;
        int result = card1.isGreater(card2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of isGreater method, of class warCard.
     * @return 1 if the current card greater than the input card, 2 for less, equal is 3
     */
    @Test
    public void testIsGreaterBad() {
        System.out.println("Check the warCard method: isGreater.  Bad");
        //card1 is King of Hearts, 13
        warCard card1 = new warCard(Rank.values()[12],Suit.values()[2]);        
        //card2 is ACE of Clubs, 14
        warCard card2 = new warCard(Rank.values()[0],Suit.values()[0]);
        int expResult = 2;
        int result = card1.isGreater(card2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of isGreater method, of class warCard.
     * @return 1 if the current card greater than the input card, 2 for less, equal is 3
     */
    @Test
    public void testIsGreaterBoundary() {
        System.out.println("Check the warCard method: isGreater.  Boundary");
        //card1 is King of Hearts, 13
        warCard card1 = new warCard(Rank.values()[12],Suit.values()[2]);        
        //card2 is King of Hearts, 13
        warCard card2 = new warCard(Rank.values()[12],Suit.values()[2]);
        int expResult = 3;
        int result = card1.isGreater(card2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
