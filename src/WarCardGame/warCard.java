package WarCardGame;

class warCard extends Card{

    private Rank rank;
    private Suit suit;
    private int num;

    //default constructor
    public warCard() {

    }

    //constructor
    public warCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;

    }

    public int getNum() {
        //get the numbe of the the card

        this.num = this.getRank().getValue();
        return num;
    }

    public void setRank(Rank rank) {
        this.rank = rank;

    }

    public Rank getRank() {
        return this.rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;

    }

    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public String toString() {
        return suit.getUnicode()+rank.getName();
        //return rank.getName() + "of" + suit.getSuitname();
    }

    public String shortString() {
        return suit.getUnicode()+rank.getName();
    }

    public warCard copy(warCard card) {
        //copy is a method which copies the attributes of a Card object to 
        //another created Card object
        warCard temp = new warCard(card.getRank(), card.getSuit());
        return temp;
    }
    /**
     * 
     * @param card
     * @return 1 if the current card greater than the input card, 2 for less, equal is 3
     */
    public int isGreater(warCard card) {
        //isGreater is a method which compares the value of 2 different Card objects.
        int temp;
        if (rank.getValue() > card.getRank().getValue()) {
            //If the current Card's value is greater than the Card being compared then temp is set to 1
            temp = 1;
        } else if (rank.getValue() < card.getRank().getValue()) {
            //Else, if the Card that is being compared has a greater value than the current Card then temp is set to 2
            temp = 2;
        } else { //Else, both Cards have the same value
            temp = 3;
        }
        
        return temp; //Returns the value of temp after using the method isGreater
    }

}
