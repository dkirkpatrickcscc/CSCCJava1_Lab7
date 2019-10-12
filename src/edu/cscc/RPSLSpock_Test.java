package edu.cscc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.apache.commons.lang3.StringUtils;

/**
 * Rock Paper Scissors Lizard Spock Test class - Lab7
 * @author David Kirkpatrick -- CSCI2467 Java 1 - Fall 2019 (Instructor Myers) 10/09/2019
 * @version 1.0
 */
public class RPSLSpock_Test {
    private RPSLSpock rpslspk;

    @Before
    public void pretests() {
        rpslspk = new RPSLSpock();
    }

    @Test
    public void testSuite() {
        Assert.assertTrue(rpslspk.isValidPick("rock") == true);
        Assert.assertTrue(rpslspk.isValidPick("paper") == true);
        Assert.assertTrue(rpslspk.isValidPick("scissors") == true);
        Assert.assertTrue(rpslspk.isValidPick("lizard") == true);
        Assert.assertTrue(rpslspk.isValidPick("spock") == true);
        Assert.assertTrue(rpslspk.isValidPick("your momma") == false);

        Assert.assertFalse(StringUtils.equalsIgnoreCase(rpslspk.generatePick(), null) && StringUtils.isEmpty(rpslspk.generatePick()));
        Assert.assertTrue(rpslspk.isValidPick(rpslspk.generatePick()) == true);
        for(int counter=0 ; counter < 1000000 ; counter++) {
            String junkTest = rpslspk.generatePick();
            Assert.assertTrue(StringUtils.equalsIgnoreCase(junkTest, "rock") ||
                    StringUtils.equalsIgnoreCase(junkTest, "paper") ||
                    StringUtils.equalsIgnoreCase(junkTest, "scissors") ||
                    StringUtils.equalsIgnoreCase(junkTest, "lizard") ||
                    StringUtils.equalsIgnoreCase(junkTest, "spock"));
        }

        Assert.assertTrue(rpslspk.isComputerWin("rock", "scissors"));
        Assert.assertTrue(rpslspk.isComputerWin("rock", "lizard"));
        Assert.assertTrue(rpslspk.isComputerWin("paper", "rock"));
        Assert.assertTrue(rpslspk.isComputerWin("paper", "spock"));
        Assert.assertTrue(rpslspk.isComputerWin("scissors", "paper"));
        Assert.assertTrue(rpslspk.isComputerWin("scissors", "lizard"));
        Assert.assertTrue(rpslspk.isComputerWin("lizard", "paper"));
        Assert.assertTrue(rpslspk.isComputerWin("lizard", "spock"));
        Assert.assertTrue(rpslspk.isComputerWin("spock", "rock"));
        Assert.assertTrue(rpslspk.isComputerWin("spock", "scissors"));
        Assert.assertFalse(rpslspk.isComputerWin("spock", "lizard"));
    }
}