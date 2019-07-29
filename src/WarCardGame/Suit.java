
package WarCardGame;

/**
 *
 * @author franklinzhao
 */
public enum Suit {

    CLUBS ("Clubs", 1, '\u2663'), 
    DIAMONDS ("Diamonds", 2, '\u2666'), 
    HEARTS ("Hearts", 3, '\u2665'),
    SPADES ("Spades", 4, '\u2660');
    //NONE("JOKE",0,'\u45345');
    

    private String suitname;
    private int num;
    private char unicode;
    public String getSuitname(){
        return this.suitname;
    }
    public int getNum(){
        return this.num;
    }
    public char getUnicode(){
        return this.unicode;
    }
    private Suit(String suitname,int num,char symbol){
        this.suitname = suitname;
        this.num = num;
        this.unicode = symbol;
    }
    
}
