public class User2 extends User {
    private String user2name;
    private String stoneColor;
    private int stonecount=15;
    private int baslangicZari;
    private int dice1count;
    private int dice2count;
    public User2(String user2name ,String Color){
        super(user2name,Color);
    }
    public User2(){

    }
    public String getUser2name() {
        return user2name;
    }

    public void setUser2name(String user2name) {
        this.user2name = user2name;
    }




}
