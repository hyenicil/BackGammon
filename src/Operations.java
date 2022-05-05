import javax.management.monitor.StringMonitor;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Operations {
    ArrayList<ArrayList<String>> regions = new ArrayList<>(24);
    ArrayList<String> brokenStoneUser1 = new ArrayList<>(15);
    ArrayList<String> brokenStoneUser2 = new ArrayList<>(15);
    ArrayList<String> out1 = new ArrayList<>(15);
    ArrayList<String> out2 = new ArrayList<>(15);
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    User user1 = new User1();
    User user2 = new User2();
    private int dice1;
    private int dice2;
    private int brokenStone1 = 0;
    private int brokenStone2 = 0;
    private int area;
    private String dice;
    private int diceRight;
    private int diceRight2;
    private String board;

    public void getUser() {
        System.out.print("1.Kullanici ismi:");
        user1.setUsername(scanner.nextLine());
        user1.setStoneColor("White");
        System.out.print("2.Kullanici ismi:");
        user2.setUsername(scanner.nextLine());
        user2.setStoneColor("Black");
    }

    public void BaslangicZari() {
        getUser();
        System.out.println("Baslangic Zarlari Atiliyor");
        while (true) {
            user1.setBaslangicZari(random.nextInt(5) + 1);
            user2.setBaslangicZari(random.nextInt(5) + 1);
            System.out.println(user1.getUsername() + " baslama zari :" + user1.getBaslangicZari());
            System.out.println(user2.getUsername() + " baslama zari :" + user2.getBaslangicZari());

            if (user1.getBaslangicZari() > user2.getBaslangicZari()) {

                System.out.println(user1.getUsername() + " kullanici oyuna basliyor.");
                user1.setStart(1);
                user2.setStart(0);
                userhamle(user1);
                break;
            } else if (user1.getBaslangicZari() < user2.getBaslangicZari()) {

                System.out.println(user2.getUsername() + " kullanici oyuna basliyor.");
                user1.setStart(0);
                user2.setStart(1);
                userhamle(user2);
                break;

            } else {
                System.out.println("Tekrar Zar Atiliyor...");

            }
        }
    }

    public void Oyun() {
        for (int i = 0; i < 24; i++) {
            regions.add(new ArrayList(15));
        }
        regions.get(0).add("Black");
        regions.get(0).add("Black");
        regions.get(5).add("White");
        regions.get(5).add("White");
        regions.get(5).add("White");
        regions.get(5).add("White");
        regions.get(5).add("White");
        regions.get(7).add("White");
        regions.get(7).add("White");
        regions.get(7).add("White");

        regions.get(11).add("Black");
        regions.get(11).add("Black");
        regions.get(11).add("Black");
        regions.get(11).add("Black");
        regions.get(11).add("Black");

        regions.get(12).add("White");
        regions.get(12).add("White");
        regions.get(12).add("White");
        regions.get(12).add("White");
        regions.get(12).add("White");
        regions.get(16).add("Black");
        regions.get(16).add("Black");
        regions.get(16).add("Black");
        regions.get(18).add("Black");
        regions.get(18).add("Black");
        regions.get(18).add("Black");
        regions.get(18).add("Black");
        regions.get(18).add("Black");
        regions.get(23).add("White");
        regions.get(23).add("White");

        board();


    }

    public void areaController1(int a,User user){

    }

    public void moveUser1Dice1(User user) {
        int out = area;
        int in = user.getDice1count();
      if(disaCikmaController(user)==1){
            System.out.println("Disa cikma");
            while(true){
                if (in > out) {
                    out1.add(user.getStoneColor());
                    regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                    break;
                }
                else if (out >= in && regions.get(out).size() != 0) {
                    if (((regions.get(out - in).size() >= 1)) && (user.getStoneColor() == regions.get(out - in).get(regions.get(out - in).size() - 1))) {
                        regions.get(out - in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        break;
                    } else if ((regions.get(out - in).size() == 1) && (user.getStoneColor() != regions.get(out - in).get(regions.get(out - in).size() - 1))) {

                        regions.get(out - in).remove(regions.get(out-in).size() - 1);
                        regions.get(out - in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        kirma(user2);
                        break;
                    } else if (((regions.get(out - in).size() == 0))) {
                        regions.get(out - in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        break;
                    } else if (regions.get(out - in).size() > 1 && (user.getStoneColor() != regions.get(out - in).get(regions.get(out - in).size() - 1))) {
                        System.out.println("Bu alan Rakibe ait bir alandir..");
                        area=girdi();
                        break;
                    }
                }

            }

                bittiMi();

            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice2count()+" ");
                area = girdi();
              moveUser1Dice2(user);

            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user2.getUsername());
                userhamle(user2);
            }

        }
        else{

        while (true) {
            if (out >= in && regions.get(out).size() != 0) {
                if (((regions.get(out - in).size() >= 1)) && (user.getStoneColor() == regions.get(out - in).get(regions.get(out - in).size() - 1))) {
                    regions.get(out - in).add(user.getStoneColor());
                    regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                    break;
                } else if ((regions.get(out - in).size() == 1) && (user.getStoneColor() != regions.get(out - in).get(regions.get(out - in).size() - 1))) {

                    regions.get(out - in).remove(regions.get(out -in).size() - 1);
                    regions.get(out - in).add(user.getStoneColor());
                    regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                    kirma(user2);
                    break;
                } else if (((regions.get(out - in).size() == 0))) {
                    regions.get(out - in).add(user.getStoneColor());
                    regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                    break;
                } else if (regions.get(out - in).size() > 1 && (user.getStoneColor() != regions.get(out - in).get(regions.get(out - in).size() - 1))) {
                    System.out.println("Bu alan Rakibe ait bir alandir..");
                    area=girdi();
                    break;
                }
            }
        }

        if (user.getDiceRight() >= 1) {
            diceRight--;
            user.setDiceRight(diceRight);
            board();
            System.out.print("Sonraki zar degeri:" + user.getDice2count()+" ");
            area = girdi();
            moveUser1Dice2(user);



        } else if (user.getDiceRight() == 0) {
            board();
            user.setStart(0);
            System.out.println("Sira:" + user2.getUsername());
            userhamle(user2);
        }
    }
    }

    public void moveUser1Dice2(User user) {
        int out = area;

          int in = user.getDice2count();

     if (disaCikmaController(user) == 1) {
            while (true) {
                if (in > out) {
                    out1.add(user.getStoneColor());
                    regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                    break;
                }
              else  if (out >= in && regions.get(out).size() != 0) {
                    if (((regions.get(out - in).size() >= 1)) && (user.getStoneColor() == regions.get(out - in).get(regions.get(out - in).size() - 1))) {
                        regions.get(out - in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));

                        break;
                    } else if ((regions.get(out - in).size() == 1) && (user.getStoneColor() != regions.get(out - in).get(regions.get(out - in).size() - 1))) {

                        regions.get(out - in).remove(regions.get(out - in).size() - 1);
                        regions.get(out - in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        kirma(user2);
                        break;
                    } else if (((regions.get(out - in).size() == 0))) {
                        regions.get(out - in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        break;
                    } else if (regions.get(out - in).size() > 1 && (user.getStoneColor() != regions.get(out - in).get(regions.get(out - in).size() - 1))) {
                        System.out.println("Bu alan Rakibe ait bir alandir..");
                        area=girdi();
                    }
                }
            }
         bittiMi();

            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice1count()+" ");
                area = girdi();
                moveUser1Dice2(user);

            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user2.getUsername());
                userhamle(user2);
            }

        }
        else{
            while (true) {
              if (out >= in && regions.get(out).size() != 0) {
                  if (((regions.get(out - in).size() >= 1)) && (user.getStoneColor() == regions.get(out - in).get(regions.get(out - in).size() - 1))) {
                      regions.get(out - in).add(user.getStoneColor());
                      regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));

                      break;
                  } else if ((regions.get(out - in).size() == 1) && (user.getStoneColor() != regions.get(out - in).get(regions.get(out - in).size() - 1))) {

                      regions.get(out - in).remove(regions.get(out - in).size() - 1);
                      regions.get(out - in).add(user.getStoneColor());
                      regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                      kirma(user2);
                      break;
                  } else if (((regions.get(out - in).size() == 0))) {
                      regions.get(out - in).add(user.getStoneColor());
                      regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                      break;
                  } else if (regions.get(out - in).size() > 1 && (user.getStoneColor() != regions.get(out - in).get(regions.get(out - in).size() - 1))) {
                      System.out.println("Bu alan Rakibe ait bir alandir..");
                       area=girdi();
                  }
              }
          }

          if (user.getDiceRight() >= 1) {
              diceRight--;
              user.setDiceRight(diceRight);
              board();
                  System.out.print("Sonraki zar degeri:" + user.getDice1count()+" ");
                  area = girdi();
                  moveUser1Dice1(user);

          } else if (user.getDiceRight() == 0) {
              board();
              user.setStart(0);
              System.out.println("Sira:" + user2.getUsername());
              userhamle(user2);
          }
      }}

    public void moveUser2Dice1(User user) {
        int out = area;
        int in = user.getDice1count();
        if(disaCikmaController(user)==1){
            int a=0;
            if (area == 18) {
                a = 6;
            } else if (area == 19) {
                a = 5;
            } else if (area == 20) {
                a = 4;
            } else if (area == 21) {
                a = 3;
            } else if (area == 22) {
                a = 2;
            } else if (area == 23) {
                a = 1;
            }
            while(true) {
                if (in > a) {
                    out2.add(user.getStoneColor());
                    regions.get(out).remove(regions.get(out).get(regions.get(out).size()));
                    break;
                }
                else if (out + in < 24 && regions.get(out).size() != 0) {
                    if (((regions.get(out + in).size() >= 1)) && (user.getStoneColor() == regions.get(out + in).get(regions.get(out + in).size() - 1))) {
                        regions.get(out + in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        break;
                    } else if ((regions.get(in + out).size() == 1) && (user.getStoneColor() != regions.get(in + out).get(regions.get(in + out).size() - 1))) {

                        regions.get(out + in).remove(regions.get(in + out).size() - 1);
                        regions.get(out + in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        kirma(user1);
                        break;
                    } else if (((regions.get(out + in).size() == 0))) {
                        regions.get(out + in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        break;
                    } else if (regions.get(in + out).size() > 1 && (user.getStoneColor() != regions.get(in + out).get(regions.get(in + out).size() - 1))) {
                        System.out.println("Bu alan Rakibe ait bir alandir..");
                        area=girdi();
                    }
                }
            }
            bittiMi();

            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);//if lazim iceriye taslar girdimi diye kontrol etmeli
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice2count()+" ");
                area = girdi();
                moveUser2Dice2(user);
            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user1.getUsername());
                userhamle(user1);
            }


        }
        else{

            while (true) {
                if (out + in < 24 && regions.get(out).size() != 0) {
                    if (((regions.get(out + in).size() >= 1)) && (user.getStoneColor() == regions.get(out + in).get(regions.get(out + in).size() - 1))) {
                        regions.get(out + in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        break;
                    } else if ((regions.get(in + out).size() == 1) && (user.getStoneColor() != regions.get(in + out).get(regions.get(in + out).size() - 1))) {

                        regions.get(out + in).remove(regions.get(in + out).size() - 1);
                        regions.get(out + in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        kirma(user1);
                        break;
                    } else if (((regions.get(out + in).size() == 0))) {
                        regions.get(out + in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        break;
                    } else if (regions.get(in + out).size() > 1 && (user.getStoneColor() != regions.get(in + out).get(regions.get(in + out).size() - 1))) {
                        System.out.println("Bu alan Rakibe ait bir alandir..");
                    area=girdi();
                    }
                }
            }

            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);//if lazim iceriye taslar girdimi diye kontrol etmeli
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice2count()+" ");
                area = girdi();
                moveUser2Dice2(user);
            }
            else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user1.getUsername());
                userhamle(user1);
            }
        }
    }

    public void moveUser2Dice2(User user) {
        int out = area;
//   areaController(user,out,2);

        int in = user.getDice2count();
      if (disaCikmaController(user) == 1) {
            int a=0;
            if (area == 18) {
                a = 6;
            } else if (area == 19) {
                a = 5;
            } else if (area == 20) {
                a = 4;
            } else if (area == 21) {
                a = 3;
            } else if (area == 22) {
                a = 2;
            } else if (area == 23) {
                a = 1;
            }
            while(true){
            if (in > a) {
                out2.add(user.getStoneColor());
                regions.get(out).remove(regions.get(out).get(regions.get(out).size()));
                break;
            }
                if (out + in < 24 && regions.get(out).size() != 0) {
                    if (((regions.get(out + in).size() >= 1)) && (user.getStoneColor() == regions.get(out + in).get(regions.get(out + in).size() - 1))) {
                        regions.get(out + in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        break;
                    } else if ((regions.get(in + out).size() == 1) && (user.getStoneColor() != regions.get(in + out).get(regions.get(in + out).size() - 1))) {

                        regions.get(out + in).remove(regions.get(in + out).size() - 1);
                        regions.get(out + in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        kirma(user1);
                        break;
                    } else if (((regions.get(out + in).size() == 0))) {
                        regions.get(out + in).add(user.getStoneColor());
                        regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                        break;
                    } else if (regions.get(in + out).size() > 1 && (user.getStoneColor() != regions.get(in + out).get(regions.get(in + out).size() - 1))) {
                        System.out.println("Bu alan Rakibe ait bir alandir..");
                        area=girdi();
                    }
                }

            }
          bittiMi();

            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);//if lazim iceriye taslar girdimi diye kontrol etmeli
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice2count()+" ");
                area = girdi();
                moveUser2Dice1(user);
            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user1.getUsername());
                userhamle(user1);
            }
      }
        else{
                while (true) {
                    if (out + in < 24 && regions.get(out).size() != 0) {
                        if (((regions.get(out + in).size() >= 1)) && (user.getStoneColor() == regions.get(out + in).get(regions.get(out + in).size() - 1))) {
                            regions.get(out + in).add(user.getStoneColor());
                            regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                            break;
                        } else if ((regions.get(in + out).size() == 1) && (user.getStoneColor() != regions.get(in + out).get(regions.get(in + out).size() - 1))) {

                            regions.get(out + in).remove(regions.get(in + out).size() - 1);
                            regions.get(out + in).add(user.getStoneColor());
                            regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                            kirma(user1);
                            break;
                        } else if (((regions.get(out + in).size() == 0))) {
                            regions.get(out + in).add(user.getStoneColor());
                            regions.get(out).remove(regions.get(out).get(regions.get(out).size() - 1));
                            break;
                        } else if (regions.get(in + out).size() > 1 && (user.getStoneColor() != regions.get(in + out).get(regions.get(in + out).size() - 1))) {
                            System.out.println("Bu alan Rakibe ait bir alandir..");
                           area=girdi();
                        }
                    }
                }

                if (user.getDiceRight() >= 1) {
                    diceRight--;
                    user.setDiceRight(diceRight);
                    board();
                    System.out.print("Sonraki zar degeri:" + user.getDice1count()+" ");
                    area = girdi();
                    moveUser2Dice1(user);

                } else if (user.getDiceRight() == 0) {
                    board();
                    user.setStart(0);
                    System.out.println("Sira:" + user1.getUsername());
                    userhamle(user1);
                }
            }
    }

    public void geriAlmaUser1Dice1(User user,int dice){
        if (dice == 1) {
            dice = 23;
        } else if (dice == 2) {
            dice = 22;
        } else if (dice == 3) {
            dice = 21;
        } else if (dice == 4) {
            dice = 20;
        } else if (dice == 5) {
            dice = 19;
        } else if (dice == 6) {
            dice = 18;
        }
        while (true){
        if (regions.get(dice).size() == 0) {
            regions.get(dice).add(user.getStoneColor());
            brokenStoneUser1.remove(brokenStoneUser1.size() - 1);
            break;
        } else if (regions.get(dice).size() >= 1 && (user.getStoneColor() == regions.get(dice).get(regions.get(dice).size() - 1))) {
            regions.get(dice).add(user.getStoneColor());
            brokenStoneUser1.remove(brokenStoneUser1.size() - 1);
            break;
        } else if (regions.get(dice).size() == 1 && (user.getStoneColor() != regions.get(dice).get(regions.get(dice).size() - 1))) {
            regions.get(dice).remove(regions.get(dice).get(regions.get(dice).size()-1));
            regions.get(dice).add(user.getStoneColor());
            brokenStoneUser1.remove(brokenStoneUser1.size() - 1);
            kirma(user2);
            break;
        }
        else if (regions.get(dice).size() > 1 && (user.getStoneColor() != regions.get(dice).get(regions.get(dice).size() - 1))) {
            System.out.println("Bu alan Rakibe ait bir alandir..");
            break;
        }else {
            System.out.println("Alan dolu ");
            break;
        }
        }
        if(brokenStoneUser1.size()>=1){

            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice2count()+" ");
                geriAlmaUser1Dice2(user,user.getDice2count());
            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user2.getUsername());
                userhamle(user2);
            }
        }
        else{
            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice2count()+" ");
                area = girdi();
                moveUser1Dice2(user);
            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user2.getUsername());
                userhamle(user2);
            }
        }
    }
    public void geriAlmaUser1Dice2(User user,int dice){
        if (dice == 1) {
            dice = 23;
        } else if (dice == 2) {
            dice = 22;
        } else if (dice == 3) {
            dice = 21;
        } else if (dice == 4) {
            dice = 20;
        } else if (dice == 5) {
            dice = 19;
        } else if (dice == 6) {
            dice = 18;
        }
        while (true){
            if (regions.get(dice).size() == 0) {
                regions.get(dice).add(user.getStoneColor());
                brokenStoneUser1.remove(brokenStoneUser1.size() - 1);
                break;
            } else if (regions.get(dice).size() >= 1 && (user.getStoneColor() == regions.get(dice).get(regions.get(dice).size() - 1))) {
                regions.get(dice).add(user.getStoneColor());
                brokenStoneUser1.remove(brokenStoneUser1.size() - 1);
                break;
            } else if (regions.get(dice).size() == 1 && (user.getStoneColor() != regions.get(dice).get(regions.get(dice).size() - 1))) {
                regions.get(dice).remove(regions.get(dice).get(regions.get(dice).size()-1));
                regions.get(dice).add(user.getStoneColor());
                brokenStoneUser1.remove(brokenStoneUser1.size() - 1);
                kirma(user2);
                break;
            }
            else if (regions.get(dice).size() > 1 && (user.getStoneColor() != regions.get(dice).get(regions.get(dice).size() - 1))) {
                System.out.println("Bu alan Rakibe ait bir alandir..");
                break;
            }else {
                System.out.println("Alan dolu...");
               break;
            }
        }
        if(brokenStoneUser1.size()>=1){

            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice1count()+" ");
                geriAlmaUser1Dice1(user,user.getDice1count());
            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user2.getUsername());
                userhamle(user2);
            }
        }
        else{
            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice1count()+" ");
                area = girdi();
                moveUser1Dice1(user);
            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user2.getUsername());
                userhamle(user2);
            }
        }
    }
    public void geriAlmaUser2Dice1(User user,int dice){

        while (true){
            if (regions.get(dice - 1).size() == 0) {
                regions.get(dice - 1).add(user.getStoneColor());
                brokenStoneUser2.remove(brokenStoneUser2.size() - 1);
                break;
            } else if (regions.get(dice - 1).size() >= 1 && (user.getStoneColor() == regions.get(dice - 1).get(regions.get(dice - 1).size() - 1))) {
                regions.get(dice - 1).add(user.getStoneColor());
                brokenStoneUser2.remove(brokenStoneUser2.size() - 1);
                break;
            } else if (regions.get(dice - 1).size() == 1 && (user.getStoneColor() != regions.get(dice - 1).get(regions.get(dice - 1).size() - 1))) {
                regions.get(dice-1).remove(regions.get(dice-1).get(regions.get(dice-1).size()-1));
                regions.get(dice-1).add(user.getStoneColor());
                brokenStoneUser2.remove(brokenStoneUser2.size() - 1);
                kirma(user1);
                break;
            }
            else if (regions.get(dice-1).size() > 1 && (user.getStoneColor() != regions.get(dice-1).get(regions.get(dice-1).size() - 1))) {
                System.out.println("Bu alan Rakibe ait bir alandir..");
                break;
            }

            else {
                System.out.println("Alan dolu 1 el bekleyin");
                break;
            }
        }
        if(brokenStoneUser2.size()>=1){
            System.out.println("Buraya girdi.");
            if (user.getDiceRight() >= 1) {

                diceRight--;
                user.setDiceRight(diceRight);
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice2count()+" ");
                geriAlmaUser2Dice2(user,user.getDice2count());
            }
            else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user1.getUsername());
                userhamle(user1);
            }
        }
        else{

            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice2count()+" ");
                area = girdi();
                moveUser2Dice2(user);
            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user1.getUsername());
                userhamle(user1);
            }
        }

    }
    public void geriAlmaUser2Dice2(User user,int dice){
        while (true){
            if (regions.get(dice - 1).size() == 0) {
                regions.get(dice - 1).add(user.getStoneColor());
                brokenStoneUser2.remove(brokenStoneUser2.size() - 1);
                break;
            } else if (regions.get(dice - 1).size() >= 1 && (user.getStoneColor() == regions.get(dice - 1).get(regions.get(dice - 1).size() - 1))) {
                regions.get(dice - 1).add(user.getStoneColor());
                brokenStoneUser2.remove(brokenStoneUser2.size() - 1);
                break;
            } else if (regions.get(dice - 1).size() == 1 && (user.getStoneColor() != regions.get(dice - 1).get(regions.get(dice - 1).size() - 1))) {
                regions.get(dice-1).remove(regions.get(dice-1).get(regions.get(dice-1).size()-1));
                regions.get(dice-1).add(user.getStoneColor());
                brokenStoneUser2.remove(brokenStoneUser2.size() - 1);
                kirma(user1);
                break;
            }else if (regions.get(dice-1).size() > 1 && (user.getStoneColor() != regions.get(dice-1).get(regions.get(dice-1).size() - 1))) {
                System.out.println("Bu alan Rakibe ait bir alandir..");
                break;
            }

            else {
                System.out.println("Alan dolu");
                break;
            }
        }
        if(brokenStoneUser2.size()>=1){
            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice1count()+" ");
                geriAlmaUser2Dice1(user,user.getDice1count());
            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user1.getUsername());
                userhamle(user1);
            }
        }
        else{

            if (user.getDiceRight() >= 1) {
                diceRight--;
                user.setDiceRight(diceRight);
                board();
                System.out.print("Sonraki zar degeri:" + user.getDice1count()+" ");
                area = girdi();
                moveUser2Dice1(user);
            } else if (user.getDiceRight() == 0) {
                board();
                user.setStart(0);
                System.out.println("Sira:" + user1.getUsername());
                userhamle(user1);
            }

        }
    }


    public void areaController(User user,int a,int dice) {
        if ( regions.get(a).get(0)==user.getStoneColor()) {

            if (user.getStoneColor().equals("White")) {
                if(dice==1){

                    moveUser1Dice1(user);
                }
                else{

                    moveUser1Dice2(user);
                }
            }

            else if (user.getStoneColor().equals("Black")) {
                if(dice==1){
                    area = girdi();
                    moveUser2Dice1(user);
                }
                else{
                    area = girdi();
                    moveUser2Dice2(user);
                }
            }
        }
        else {
            System.out.println("Bu aLan size Ait degildir ");
            area = girdi();
            if (user.getStoneColor().equals("White")) {
                if(dice==1){
                    moveUser1Dice1(user);
                }
                else{
                    moveUser1Dice2(user);
                }
            }

            else if (user.getStoneColor().equals("Black")) {
                if(dice==1){
                    moveUser2Dice1(user);
                }
                else{
                    moveUser2Dice2(user);
                }
            }
        }

    }

    public void bittiMi(){
        if(out1.size()==15){
            System.out.println("Tebrikler "+user1.getUsername()+ " kazandin.");
        }
        else if(out2.size()==15){
            System.out.println("Tebrikler "+user2.getUsername()+ " kazandin");
        }
    }

    public int getDice1(User user) {
        user.setDice1count(random.nextInt(5) + 1);
        System.out.println("1.Zar:" + user.getDice1count());
        this.setDice1(user.getDice1count());
        return this.getDice1();
    }

    public int getDice2(User user) {
        user.setDice2count(random.nextInt(5) + 1);
        System.out.println("2.Zar:" + user.getDice2count());
        this.setDice2(user.getDice2count());

        return this.getDice2();
    }

    public void zarAt(User user) {
        getDice1(user);
        getDice2(user);
        user.setDiceRight(2);
    }

    public void userhamle(User user) {

        if (user.getStoneColor().equals("White")) {
            zarAt(user);
            if(user.getDice1count()==user.getDice2count()){
                user.setDiceRight(4);
            }
            if (brokenStoneUser1.size() >= 1) {
              geriAlma(user);
            }
            diceRight = user.getDiceRight();
            area = girdi();
            System.out.print("Hangi Zarı Secmek Istıyorsunuz:");
            setDice(scanner.nextLine());

            if (getDice().equals("1")) {
                diceRight--;
                user.setDiceRight(diceRight);
                moveUser1Dice1(user);
            } else if (getDice().equals("2")) {
                diceRight--;
                user.setDiceRight(diceRight);
                System.out.println("2");
                moveUser1Dice2(user);
            } else {
                System.out.println("Gecersiz zar secimi....");
            }

        } else if (user.getStoneColor().equals("Black")) {


            zarAt(user);

            if(user.getDice1count()==user.getDice2count()){
                user.setDiceRight(4);
                diceRight = user.getDiceRight();
            }
            if (brokenStoneUser2.size() >= 1) {
                diceRight = user.getDiceRight();
                geriAlma(user);
            }
            diceRight = user.getDiceRight();
            area = girdi();
            System.out.print("Hangi Zarı Secmek Istıyorsunuz:");
            setDice(scanner.nextLine());
            if (getDice().equals("1")) {
                diceRight--;
                user.setDiceRight(diceRight);
                moveUser2Dice1(user);
            } else if (getDice().equals("2")) {
                diceRight--;
                user.setDiceRight(diceRight);
                moveUser2Dice2(user);
            } else {
                System.out.println("Gecersiz zar secimi....");
            }

        }
        else {
            System.out.println("Gecersiz Islem Tekrar Girin...");

        }

    }

    public void kirma(User user) {
        if (user.getStoneColor().equals("White")) {
            brokenStoneUser1.add(user.getStoneColor());
        }
        else if (user.getStoneColor().equals("Black")) {

            brokenStoneUser2.add(user.getStoneColor());
        }

    }

    public int girdi() {
        System.out.print("Hamle Yapilacak Alan:");
        String girdi = scanner.nextLine();
        if (girdi.equals("A")) {
            return 0;
        } else if (girdi.equals("B")) {
            return 1;
        } else if (girdi.equals("C")) {
            return 2;
        } else if (girdi.equals("D")) {
            return 3;
        } else if (girdi.equals("E")) {
            return 4;
        } else if (girdi.equals("F")) {
            return 5;
        } else if (girdi.equals("G")) {
            return 6;
        } else if (girdi.equals("H")) {
            return 7;
        } else if (girdi.equals("I")) {
            return 8;
        } else if (girdi.equals("J")) {
            return 9;
        } else if (girdi.equals("K")) {
            return 10;
        } else if (girdi.equals("L")) {
            return 11;
        } else if (girdi.equals("A2")) {
            return 12;
        } else if (girdi.equals("B2")) {
            return 13;
        } else if (girdi.equals("C2")) {
            return 14;
        } else if (girdi.equals("D2")) {
            return 15;
        } else if (girdi.equals("E2")) {
            return 16;
        } else if (girdi.equals("F2")) {
            return 17;
        } else if (girdi.equals("G2")) {
            return 18;
        } else if (girdi.equals("H2")) {
            return 19;
        } else if (girdi.equals("I2")) {
            return 20;
        } else if (girdi.equals("J2")) {
            return 21;
        } else if (girdi.equals("K2")) {
            return 22;
        } else if (girdi.equals("L2")) {
            return 23;
        } else if (girdi.equals("a")) {
            return 0;
        } else if (girdi.equals("b")) {
            return 1;
        } else if (girdi.equals("c")) {
            return 2;
        } else if (girdi.equals("d")) {
            return 3;
        } else if (girdi.equals("e")) {
            return 4;
        } else if (girdi.equals("f")) {
            return 5;
        } else if (girdi.equals("g")) {
            return 6;
        } else if (girdi.equals("h")) {
            return 7;
        } else if (girdi.equals("i")) {
            return 8;
        } else if (girdi.equals("j")) {
            return 9;
        } else if (girdi.equals("k")) {
            return 10;
        } else if (girdi.equals("l")) {
            return 11;
        } else if (girdi.equals("a2")) {
            return 12;
        } else if (girdi.equals("b2")) {
            return 13;
        } else if (girdi.equals("c2")) {
            return 14;
        } else if (girdi.equals("d2")) {
            return 15;
        } else if (girdi.equals("e2")) {
            return 16;
        } else if (girdi.equals("f2")) {
            return 17;
        } else if (girdi.equals("g2")) {
            return 18;
        } else if (girdi.equals("h2")) {
            return 19;
        } else if (girdi.equals("i2")) {
            return 20;
        } else if (girdi.equals("j2")) {
            return 21;
        } else if (girdi.equals("k2")) {
            return 22;
        } else if (girdi.equals("l2")) {
            return 23;
        } else {
            System.out.println("Geçersiz Alan...");
        }
        return 0;
    }

    public void geriAlma(User user) {

        int dice=0;
        if (user.getStoneColor().equals("White")) {
                System.out.println("Kirik tasiniz var..Once onu iceriye aliniz...");
                System.out.print("Hangi Zarı Secmek Istıyorsunuz:");
                setDice(scanner.nextLine());
                if (getDice().equals("1")) {
                    diceRight--;
                    user.setDiceRight(diceRight);
                    dice=user.getDice1count();
                    geriAlmaUser1Dice1(user,dice);
                }
                else if (getDice().equals("2")) {
                    diceRight--;
                    user.setDiceRight(diceRight);
                    dice= user.getDice2count();
                    geriAlmaUser1Dice2(user,dice);
                }
            }


        else if (user.getStoneColor().equals("Black")) {

            System.out.println("Kirik tasiniz var..Once onu iceriye aliniz...");
            System.out.print("Hangi Zarı Secmek Istıyorsunuz:");
            setDice(scanner.nextLine());
            if (getDice().equals("1")) {
                diceRight--;
                user.setDiceRight(diceRight);
                dice=user.getDice1count();
                geriAlmaUser2Dice1(user,dice);
            } else if (getDice().equals("2")) {
                diceRight--;
                user.setDiceRight(diceRight);
                dice= user.getDice2count();
                geriAlmaUser2Dice2(user,dice);

            }

        }
    }

    public int disaCikmaController(User user){
        int error;
        if (user.getStoneColor().equals("White")) {
            error = 0;
            for (int i = 6; i < 24; i++) {
                if (regions.get(i).size()>= 1 && regions.get(i).get(0)==user.getStoneColor()) {
                    error++;
                }
            }
            if (error > 0) {
               return 0;
            }
            else if(error==0){
                return  1;
            }
        }
        if (user.getStoneColor().equals("Black")) {
            error = 0;
            for (int i = 0; i < 18; i++) {
                if ( regions.get(i).size()>=1 && regions.get(i).get(0) == user.getStoneColor())  {
                    error++;
                }
            }
            if (error > 0) {
                return 0;
            }
            else if(error==0){
                return  1;
            }
        }
        return  0;
    }

    public void board() {

        String A = String.valueOf(regions.get(0).size());if(A.equals("0")){A=" ";}
        String B = String.valueOf(regions.get(1).size());if(B.equals("0")){B=" ";}
        String C = String.valueOf(regions.get(2).size());if(C.equals("0")){C=" ";}
        String D = String.valueOf(regions.get(3).size());if(D.equals("0")){D=" ";}
        String E = String.valueOf(regions.get(4).size());if(E.equals("0")){E=" ";}
        String F = String.valueOf(regions.get(5).size());if(F.equals("0")){F=" ";}
        String G = String.valueOf(regions.get(6).size());if(G.equals("0")){G=" ";}
        String H = String.valueOf(regions.get(7).size());if(H.equals("0")){H=" ";}
        String I = String.valueOf(regions.get(8).size());if(I.equals("0")){I=" ";}
        String J = String.valueOf(regions.get(9).size());if(J.equals("0")){J=" ";}
        String K = String.valueOf(regions.get(10).size());if(K.equals("0")){K=" ";}
        String L = String.valueOf(regions.get(11).size());if(L.equals("0")){L=" ";}
        String A2 = String.valueOf(regions.get(12).size());if(A2.equals("0")){A2=" ";}
        String B2 = String.valueOf(regions.get(13).size());if(B2.equals("0")){B2=" ";}
        String C2 = String.valueOf(regions.get(14).size());if(C2.equals("0")){C2=" ";}
        String D2 = String.valueOf(regions.get(15).size());if(D2.equals("0")){D2=" ";}
        String E2 = String.valueOf(regions.get(16).size());if(E2.equals("0")){E2=" ";}
        String F2 = String.valueOf(regions.get(17).size());if(F2.equals("0")){F2=" ";}
        String G2 = String.valueOf(regions.get(18).size());if(G2.equals("0")){G2=" ";}
        String H2 = String.valueOf(regions.get(19).size());if(H2.equals("0")){H2=" ";}
        String I2 = String.valueOf(regions.get(20).size());if(I2.equals("0")){I2=" ";}
        String J2 = String.valueOf(regions.get(21).size());if(J2.equals("0")){J2=" ";}
        String K2 = String.valueOf(regions.get(22).size());if(K2.equals("0")){K2=" ";}
        String L2 = String.valueOf(regions.get(23).size());if(L2.equals("0")){L2=" ";}

        ///Yukaridakileri string yapmam gerek
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        String e = "";
        String f = "";
        String g = "";
        String h = "";
        String i = "";
        String j = "";
        String k = "";
        String l = "";
        String a2;
        String b2;
        String c2;
        String d2;
        String e2;
        String f2;
        String g2;
        String h2;
        String i2;
        String j2;
        String k2;
        String l2;

        if (regions.get(0).size() > 0) {
            a = regions.get(0).get(0);
        } else {
            a = "     ";
        }
        if (regions.get(1).size() > 0) {
            b = regions.get(1).get(0);
        } else {
            b = "     ";
        }
        if (regions.get(2).size() > 0) {
            c = regions.get(2).get(0);
        } else {
            c = "     ";
        }
        if (regions.get(3).size() > 0) {
            d = regions.get(3).get(0);
        } else {
            d = "     ";
        }
        if (regions.get(4).size() > 0) {
            e = regions.get(4).get(0);
        } else {
            e = "     ";
        }
        if (regions.get(5).size() > 0) {
            f = regions.get(5).get(0);
        } else {
            f = "     ";
        }
        if (regions.get(6).size() > 0) {
            g = regions.get(6).get(0);
        } else {
            g = "     ";
        }
        if (regions.get(7).size() > 0) {
            h = regions.get(7).get(0);
        } else {
            h = "     ";
        }
        if (regions.get(8).size() > 0) {
            i = regions.get(8).get(0);
        } else {
            i = "     ";
        }
        if (regions.get(9).size() > 0) {
            j = regions.get(9).get(0);
        } else {
            j = "     ";
        }
        if (regions.get(10).size() > 0) {
            k = regions.get(10).get(0);
        } else {
            k = "     ";
        }
        if (regions.get(11).size() > 0) {
            l = regions.get(11).get(0);
        } else {
            l = "     ";
        }
        if (regions.get(12).size() > 0) {
            a2 = regions.get(12).get(0);
        } else {
            a2 = "     ";
        }
        if (regions.get(13).size() > 0) {
            b2 = regions.get(13).get(0);
        } else {
            b2 = "     ";
        }
        if (regions.get(14).size() > 0) {
            c2 = regions.get(14).get(0);
        } else {
            c2 = "     ";
        }
        if (regions.get(15).size() > 0) {
            d2 = regions.get(15).get(0);
        } else {
            d2 = "     ";
        }
        if (regions.get(16).size() > 0) {
            e2 = regions.get(16).get(0);
        } else {
            e2 = "     ";
            ;
        }
        if (regions.get(17).size() > 0) {
            f2 = regions.get(17).get(0);
        } else {
            f2 = "     ";
        }
        if (regions.get(18).size() > 0) {
            g2 = regions.get(18).get(0);
        } else {
            g2 = "     ";
        }
        if (regions.get(19).size() > 0) {
            h2 = regions.get(19).get(0);
        } else {
            h2 = "     ";
        }
        if (regions.get(20).size() > 0) {
            i2 = regions.get(20).get(0);
        } else {
            i2 = "     ";
        }
        if (regions.get(21).size() > 0) {
            j2 = regions.get(21).get(0);
        } else {
            j2 = "     ";
        }
        if (regions.get(22).size() > 0) {
            k2 = regions.get(22).get(0);
        } else {
            k2 = "     ";
        }
        if (regions.get(23).size() > 0) {
            l2 = regions.get(23).get(0);
        } else {
            l2 = "     ";
        }


        int dice1 = this.getDice1();
        int dice2 = this.getDice2();
        int user1brokenStone = user1.getBrokenStone();
        int user2brokenStone = user2.getBrokenStone();


    board ="Oyuncu 2:"+ user2.getUsername()+"                                                                                                               Oyuncu 1:"+user1.getUsername() +"  \n"
                     +"      L           K           J           I           H           G            F           E           D           C           B           A      \n"
                     + "__________________________________________________________________________________________________________________________________________________\n"
                     + "|     " + L + "     |     " + K + "     |     " + J + "     |     " + I + "     |     " + H + "     |     " + G + "     ||     " + F + "     |     " + E + "     |     " + D + "     |     " + C + "     |     " + B + "     |     " + A + "     | \n"
                     + "|   " + l + "   |   " + k + "   |   " + j + "   |   " + i + "   |   " + h + "   |   " + g + "   ||   " + f + "   |   " + e + "   |   " + d + "   |   " + c + "   |   " + b + "   |   " + a + "   | 1\n"
                     + "|___________|___________|___________|___________|___________|___________||___________|___________|___________|___________|___________|___________|\n"
                     + "|           |           |           |           |  Oyuncu 2 |           ||           |  Oyuncu 1 |           |           |           |           |\n"
                     + "|           |           |           |           |B R O K E N|   DICE1:  ||   DICE2:  |B R O K E N|           |           |           |           |\n"
                     + "|           |           |           |           |   STONE   |     " + dice1 + "     ||     " + dice2 + "     |   STONE   |           |           |           |           | 2\n"
                     + "|           |           |           |           |     " + brokenStoneUser2.size()+ "     |           ||           |     " + brokenStoneUser1.size() + "     |           |           |           |           |\n"
                     + "|___________|___________|___________|___________|___________|___________||___________|___________|___________|___________|___________|___________|\n"
                     + "|     " + A2 + "     |     " + B2 + "     |     " + C2 + "     |     " + D2 + "     |     " + E2 + "     |     " + F2 + "     ||     " + G2 + "     |     " + H2 + "     |     " + I2 + "     |     " + J2 + "     |     " + K2 + "     |     " + L2 + "     |\n"
                     + "|   " + a2 + "   |   " + b2 + "   |   " + c2 + "   |   " + d2 + "   |   " + e2 + "   |   " + f2 + "   ||   " + g2 + "   |   " + h2 + "   |   " + i2 + "   |   " + j2 + "   |   " + k2 + "   |   " + l2 + "   | 3\n"
                     + "|___________|___________|___________|___________|___________|___________||___________|___________|___________|___________|___________|___________|\n"
                     + "      A2          B2          C2          D2          E2          F2           G2          H2          I2           J2         K2          L2      \n";
        System.out.println(board);
        try{
            fileWrite(board);
            fileSave(regions);
        }
        catch (FileNotFoundException ex){
            System.out.println("File not Exception olustu.....");
        }


    }

    public void fileWrite(String s) throws FileNotFoundException {
        FileOutputStream backgommon=null;
        try {
            backgommon = new FileOutputStream("board.txt");
            String boardWriter=s;
            byte[] s_array = boardWriter.getBytes();
            backgommon.write(s_array);
        }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fileSave(ArrayList arrayList){
        FileOutputStream saveBackgommon=null;

        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("save.bin"))) {
        out.writeObject(arrayList);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fileOku(){
    //    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("save.bin"))){

      //      ArrayList<ArrayList<String>> regions = (ArrayList<ArrayList<String>> )in.readObject();
/*
            System.out.println("************************************");
            for (regions o : regions) {
                System.out.println(o);
                System.out.println("-------------------------------------------");
            }
            System.out.println("************************************");
            for (Ogrenci o : ogrenci_list) {
                System.out.println(o);
                System.out.println("-------------------------------------------");
            }
            System.out.println("************************************");

        } catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı...");
        }
        catch (IOException ex) {
            System.out.println("IOException Oluştu...");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjeyiOku.class.getName()).log(Level.SEVERE, null, ex);   */
        }

    public int getDice1() {
        return dice1;
    }

    public void setDice1(int dice1) {
        this.dice1 = dice1;
    }

    public int getDice2() {
        return dice2;
    }

    public void setDice2(int dice2) {
        this.dice2 = dice2;
    }

    public int getBrokenStone1() {
        return brokenStone1;
    }

    public void setBrokenStone1(int brokenStone1) {
        this.brokenStone1 = brokenStone1;
    }

    public int getBrokenStone2() {
        return brokenStone2;
    }

    public void setBrokenStone2(int brokenStone2) {
        this.brokenStone2 = brokenStone2;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getDice() {
        return dice;
    }

    public void setDice(String dice) {
        this.dice = dice;
    }

    public int getDiceRight() {
        return diceRight;
    }

    public void setDiceRight(int diceRight) {
        this.diceRight = diceRight;
    }

    public int getDiceRight2() {
        return diceRight2;
    }

    public void setDiceRight2(int diceRight2) {
        this.diceRight2 = diceRight2;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }
}

