package edu.cscc;

import java.util.Random;

/**
 * Rock Paper Scissors Lizard Spock class - Lab7
 * @author David Kirkpatrick -- CSCI2467 Java 1 - Fall 2019 (Instructor Myers) 10/09/2019
 * @version 1.0
 */
public class RPSLSpock {
    static Random rand = new Random(System.currentTimeMillis());

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
    public static final String LIZARD = "lizard";
    public static final String SPOCK = "spock";

    /**
     * Constructor
     * empty because no private variables; all are Constant Strings (public static final).
     */
    public RPSLSpock() {

    }

    /**
     * @return random number
     */
    public static Random getRand() {
        return rand;
    }

    /**
     * @param rand random number
     */
    public static void setRand(Random rand) {
        RPSLSpock.rand = rand;
    }

    /**
     * Check if human pick input is null, return false,
     *      if pick input not null, trim(eliminating leading and trailing spaces) pick variable,
     *      then return pick variable is equal to Constants, ignoring case.
     * @param pick check if random pick is null
     * @return boolean after comparing Constants to random pick
     */
    public static boolean isValidPick(String pick) {
        if (pick == null) {
            return false;
        }
        pick = pick.trim();
        return (ROCK.equalsIgnoreCase(pick) ||
                PAPER.equalsIgnoreCase(pick) ||
                SCISSORS.equalsIgnoreCase(pick) ||
                LIZARD.equalsIgnoreCase(pick) ||
                SPOCK.equalsIgnoreCase(pick));
    }

    /**
     * Generate a random number between 0 and 4,
     *      assign the 5 Constant Strings defined above the computer pick variable, cases 0 - 4,
     *      then return the computer pick variable.
     * @return pick name assigned from random number in case statement
     */
    public static String generatePick() {
        String pick = null;
        switch (getRand().nextInt(5)) {
            case 0:
                pick = ROCK;
                break;
            case 1:
                pick = PAPER;
                break;
            case 2:
                pick = SCISSORS;
                break;
            case 3:
                pick = LIZARD;
                break;
            case 4:
                pick = SPOCK;
                break;
        }
        return pick;
    }

    /**
     * Check who won by comparing computer pick (c_pick) to human pick (h_pick)
     * @param c_pick computer pick
     * @param h_pick human pick
     * @return boolean comparing computer pick to human pick
     */
    public static boolean isComputerWin(String c_pick,String h_pick) {
        h_pick = h_pick.toLowerCase();
        return ((ROCK.equals(c_pick) && (SCISSORS.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (PAPER.equals(c_pick) && (ROCK.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SCISSORS.equals(c_pick) && (PAPER.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (LIZARD.equals(c_pick) && (PAPER.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SPOCK.equals(c_pick) && (ROCK.equals(h_pick) || SCISSORS.equals(h_pick))));
    }
}