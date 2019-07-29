package WarCardGame;

import java.util.ArrayList;
import java.util.Scanner;

public class warGame{

    private ArrayList<warCard> playerDeck;
    private ArrayList<warCard> computerDeck;
    warGroupOfCards deckOfCards = new warGroupOfCards();

    private Scanner sc;
    private int playerWins;
    private int computerWins;
    int tieScore = deckOfCards.getTieScore();
    private ArrayList<warCard> tiedCards = deckOfCards.getTiedCards();

    /**
     * Constructor method that will be run with all the default values we want
     * for the game.
     */
    public warGame() {
        System.out.println(" __      ___   ___  ___   _   __  __ ___");
        System.out.println(" \\ \\    / /_\\ | _ \\/ __| /_\\ |  \\/  | __|");
        System.out.println("  \\ \\/\\/ / _ \\|   / (_ |/ _ \\| |\\/| | _|");
        System.out.println("   \\_/\\_/_/ \\_\\_|_\\\\___/_/ \\_\\_|  |_|___| \n");
        System.out.println("You are playing the card game war. Please choose an option: \n");
        sc = new Scanner(System.in);
        //initialize the deck of cards
        //deckOfCards.initializeDeck();
        //deckOfCards.splitDeck(deckOfCards.shuffleDeck(deckOfCards));

        playerDeck = deckOfCards.getPlayerDeck();
        computerDeck = deckOfCards.getComputerDeck();
        mainMenu();

    }

    /**
     * Plays a single round, compare top cards and determine winner.
     */
    public void battle() {
        if (deckOfCards.getPlayerDeck().isEmpty()) {
            System.out.println();
        }
        warCard playerCard = playerDeck.remove(0);
        
        warCard computerCard = computerDeck.remove(0);
        
        switch (playerCard.isGreater(computerCard)) {
            case 2:
                if (tieScore > 0) {
                    computerWins += tieScore;
                    System.out.println("You were defeated in the tiebreaker and lost a total of " + (tieScore + 1) + " battles. \n");
                    tieScore = 0;
                    computerDeck.add(computerCard);
                    computerDeck.add(playerCard);
                    computerDeck.addAll(tiedCards);
                    tiedCards.clear();
                } else {
                    computerWins++;
                    System.out.println("You lost a battle! \n");
                    deckOfCards.distributeCards(playerCard, computerCard, computerDeck);
                }   break;
            case 1:
                if (tieScore > 0) {
                    playerWins += tieScore;
                    System.out.println("You won the tiebreaker and a total of " + (tieScore + 1) + " battles. \n");
                    tieScore = 0;
                    playerDeck.add(computerCard);
                    playerDeck.add(playerCard);
                    playerDeck.addAll(tiedCards);
                    tiedCards.clear();
                } else {
                    playerWins++;
                    System.out.println("You won a battle! \n");
                    deckOfCards.distributeCards(playerCard, computerCard, playerDeck);
                }   break;
            default:
                tiedCards.add(computerCard);
                tiedCards.add(playerCard);
                tieScore++;
                battle();
                break;
        }
    }

    /**
     * Calculate and display the percentage of player wins.
     */
    public void displayStatistics() {
        if (playerWins > 0 || computerWins > 0) {
            double percentageWins = (double) playerWins / (playerWins + computerWins);
            System.out.printf("You have won %.2f%% of the time. \n", 100*percentageWins);
        } else {
            System.out.println("You have not played any games yet. \n");
        }
    }

    /**
     * Displays the number of cards in both player and computer decks.
     */
    public void displayScore() {
        System.out.println(playerDeck.size() + "\n");
    }

    /**
     * Prints menu options for player to choose from. 1. Plays one round of war
     * 2. Displays the player and computer "score" as their deck sizes 3.
     * Displays the Player's cards in ascending order 4. Displays the percentage
     * of battles the player has won 5. Quits the game
     */
    public void printMenu() {
        System.out.println("1) Play");
        System.out.println("2) Display Scores");
        System.out.println("3) Display Cards");
        System.out.println("4) Win Percentage");
        System.out.println("5) Quit \n");
        
    }

    /**
     * Prints out the main menu and checks to make sure user options are within
     * range.
     */
    public void mainMenu() {
        printMenu();
        int chose = -1;
        OUTER:
        while (true) {
            chose = sc.nextInt();
            if (chose > 0 && chose < 6) {
                switch (chose) {
                    case 1:

                        if (playerDeck.size() > 0) {
                            battle();
                        } else {
                            System.out.println("You have no more cards to play war with. Game Over.\n");
                        }
                        break;
                    case 2:
                        System.out.println("Your deck size is: " + playerDeck.size());
                        System.out.println("The computer's deck size is: " + computerDeck.size());
                        break;
                    case 3:
                        /*
                        * This would print out the players deck from top to bottom.
                        *
                        for (int c = playerDeck.size() - 1; c >= 0; c--) {
                        System.out.print(playerDeck.get(c) + " ");
                        }
                         */
                        //System.out.println(deckOfCards.sortDeck(playerDeck));
                        deckOfCards.printPlayerDeck();
                        break;
                    case 4:
                        displayStatistics();
                        break;
                    case 5:
                        System.out.println("Goodbye.");
                        break OUTER;
                    default:
                        break;
                }
            } else {
                System.out.println("Please choose a valid option: ");
                mainMenu();
            }
        }
    }

 
}
