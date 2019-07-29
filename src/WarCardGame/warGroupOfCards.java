package WarCardGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author guolinzhao
 */
public class warGroupOfCards{

//    private int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private warCard[] cards = new warCard[52];
    private ArrayList<warCard> deck = new ArrayList<warCard>();
    private int tieScore = 0;
    private ArrayList<warCard> tiedCards = new ArrayList<warCard>();
    private Random rnd = new Random();
    private ArrayList<warCard> playerDeck = new ArrayList<warCard>();
    private ArrayList<warCard> computerDeck = new ArrayList<warCard>();

    public ArrayList<warCard> getTiedCards() {
        return tiedCards;
    }

    public void setTiedCards(ArrayList<warCard> tiedCards) {
        this.tiedCards = tiedCards;
    }

    public int getTieScore() {
        return tieScore;
    }

    public void setTieScore(int tieScore) {
        this.tieScore = tieScore;
    }

    public ArrayList<warCard> getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(ArrayList<warCard> playerDeck) {
        this.playerDeck = playerDeck;
    }

    public ArrayList<warCard> getComputerDeck() {
        return computerDeck;
    }

    public void setComputerDeck(ArrayList<warCard> computerDeck) {
        this.computerDeck = computerDeck;
    }

    public warGroupOfCards() {
        init();
    }

    /**
     * constructor
     */
//    public GroupOfCards() {
//    }
    private void init() {
        /*
        The init() method uses nested loops to 
        load the cards array with one of each 
        card in a standard card deck (e.g. one 
        of each card rank with each suit).
         */
        deck.ensureCapacity(52);
        int i = 0;
        for (int s = 0; s < 4; s++) {
            for (int r = 0; r < 13; r++) {
                warCard card = new warCard();
                card.setRank(Rank.values()[r]);
                card.setSuit(Suit.values()[s]);
                deck.add(card);
                i++;
            }
        }
        deck.trimToSize();
        splitDeck(shuffleDeck(deck));
    }

    public warCard pickCard() {
        //The pickCard() method generates a random array index and returns the 
        //Card object at that index in the cards array.
        int i = (int) (Math.random() * (51) + 1);
        //Card c = 
        return deck.get(i);
    }

    @Override
    public String toString() {
        //The toString() method returns a String containing the list of Card objects 
        //in the cards array (see sample program and output below).
        String ss = "";
        for (int i = 0; i < 52; i++) {

            ss += deck.get(i).shortString() + "\n";
        }
        return ss;

    }

    public void printCardDeck() {
        int counter = 0;
        //for(Card c:cards){
        for (warCard card : deck) {
            System.out.printf("%s ", card.shortString());
            counter++;
            if (counter % 13 == 0) {
                System.out.println();
            }
        }

    }
    
    /**
     * Take newly created deck and shuffle it by randomly selecting two elements
     * and switching them
     *
     * @return Shuffled deck
     */
    public ArrayList<warCard> shuffleDeck(ArrayList<warCard> deck) {

        ArrayList<warCard> shuffledDeck = new ArrayList<warCard>();

        int size = deck.size();
        for (int i = 0; i < size; i++) {
            int r = rnd.nextInt(deck.size());
            shuffledDeck.add(deck.remove(r));
        }
        return shuffledDeck;
    }

    /**
     * Pass in the shuffled deck, remove half of it and place into a new deck
     * set playerDeck and computerDeck
     *
     * @param toSplit
     */
    public void splitDeck(ArrayList<warCard> toSplit) {
//        playerDeck = new ArrayList<Integer>();
//        System.arraycopy(toSplit, 0, playerDeck, 0,26);
////        computerDeck = new ArrayList<Integer>();
//        //this.computerDeck = toSplit.subList(26, 52);
//        System.arraycopy(toSplit, 26, computerDeck, 0,26);
        if (toSplit.isEmpty() || toSplit == null) {
            throw new IllegalArgumentException("Error: the deck is empty or null.");
        } else {
            for (int i = 0; i < toSplit.size() / 2; i++) {
                playerDeck.add(i, toSplit.get(i));
                computerDeck.add(i, toSplit.get(i + toSplit.size() / 2));
            }
        }
    }

    /**
     * Returns sorted deck that has been passed in using bubble sort.
     *
     * @param playerDeck2
     * @return playerCopy is the sorted copy of the deck we passed in.
     */
    public ArrayList<warCard> sortDeck(ArrayList<warCard> playerDeck2) {
        ArrayList<warCard> playerCopy = new ArrayList<warCard>();
        playerCopy.addAll(playerDeck2);
        int n = playerCopy.size();
        warCard temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (playerCopy.get(j - 1).getRank().getValue() > playerCopy.get(j).getRank().getValue()) {
                    temp = playerCopy.get(j - 1);
                    playerCopy.set(j - 1, playerCopy.get(j));
                    playerCopy.set(j, temp);
                }
            }
        }
        return playerCopy;
    }

    /**
     * Prints contents of the deck in ascending order, call sortDeck method in
     * here
     */
    public void printPlayerDeck() {
        int counter = 0;
        
        for (warCard card : playerDeck) {
            System.out.printf("%s ", card.shortString());
            counter++;
            if (counter % 6 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Places battle cards at bottom of winner's deck. Removes cards from losers
     * hand.
     *
     * @param card1 Passes in player card to distribute.
     * @param card2 Passes in computer card to distribute.
     * @param winnerDeck Passes in the winner's deck that we will be
     * distributing the cards to.
     */
    public void distributeCards(warCard card1, warCard card2, ArrayList<warCard> winnerDeck) {
        winnerDeck.add(card1);
        winnerDeck.add(card2);
    }

}
