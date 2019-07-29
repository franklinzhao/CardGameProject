package WarCardGame;

import java.util.Random;

/**
 *
 * @author franklinzhao
 */
public class warPlayer {

    private String humanPlayer;
    private String computerPlayer;
    private String option;
    private String roundwinner = "";

    private String gamewinner = "";

    //constructor
    public warPlayer() {

    }

    public String getHumanPlayer() {
        return humanPlayer;
    }

    public void setHumanPlayer(String humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    public String getComputerPlayer() {
        return computerPlayer;
    }

    public void setComputerPlayer(String computerPlayer) {
        this.computerPlayer = computerPlayer;
    }

    public String getRoundwinner() {
        return roundwinner;
    }

    public void setRoundwinner(String roundwinner) {
        this.roundwinner = roundwinner;
    }

    public String getGamewinner() {
        return gamewinner;
    }

    public void setGamewinner(String gamewinner) {
        this.gamewinner = gamewinner;
    }

}
