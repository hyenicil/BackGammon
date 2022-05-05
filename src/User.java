import java.util.Random;
import java.util.Scanner;
public class User {
    Scanner scanner=new Scanner(System.in);
    Random random=new Random();

    private String username;
    private  int stoneCount=15;
    private String stoneColor;
    private int baslangicZari;
    private int dice1count;
    private int dice2count;
    private  int brokenStone;
    private int diceRight;
    private int start;

    public User(){

    }
    public User(String username,String color){
        this.setUsername(username);
        this.stoneColor=color;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStoneCount() {
        return stoneCount;
    }

    public void setStoneCount(int stoneCount) {
        this.stoneCount = stoneCount;
    }

    public int getBaslangicZari() {
        return baslangicZari;
    }

    public void setBaslangicZari(int baslangicZari) {
        this.baslangicZari = baslangicZari;
    }

    public int getDice1count() {
        return dice1count;
    }

    public void setDice1count(int dice1count) {
        this.dice1count = dice1count;
    }

    public int getDice2count() {
        return dice2count;
    }

    public void setDice2count(int dice2count) {
        this.dice2count = dice2count;
    }

    public String getStoneColor(){
        return stoneColor;
    }
    public void setStoneColor(String color){
        this.stoneColor=color;
    }

    public int getBrokenStone() {
        return brokenStone;
    }

    public void setBrokenStone(int brokenStone) {
        this.brokenStone = brokenStone;
    }

    public int getDiceRight() {
        return diceRight;
    }

    public void setDiceRight(int diceRight) {
        this.diceRight = diceRight;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
