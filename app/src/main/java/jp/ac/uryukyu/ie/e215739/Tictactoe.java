package jp.ac.uryukyu.ie.e215739;

public class Tictactoe {
    String[] bord;

    public void display(String[] bord){
        for(int i = 0;i < 9; i++){
            System.out.println(bord[i] + bord[i + 1] + bord[i + 2]);
            i += 2;
        }
    }
}

