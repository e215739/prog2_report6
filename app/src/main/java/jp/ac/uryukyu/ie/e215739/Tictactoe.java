package jp.ac.uryukyu.ie.e215739;

import java.util.Scanner;

public class Tictactoe {
    String[] bord;
    int turn;
    int target;
    static String MARU = "○";
    static String BATU = "x";
    Scanner scanner;
    
    Tictactoe() {
        bord = new String[] { "-", "-", "-", "-", "-", "-", "-", "-", "-" };
        turn = 1;
        scanner = new Scanner(System.in);
    }
    
    
    public void display(String[] bord){
        for(int i = 0;i < 9; i++){
            System.out.println(bord[i] + bord[i + 1] + bord[i + 2]);
            i += 2;
        }
    }

    public int player() {
        System.out.println("入れたい場所を入力してください");
        target = scanner.nextInt();
        return target;
    }

    public void insertion() {
        String player;
        if (turn % 2 == 1) {
            player = MARU;

        } else {
            player = BATU;
        }

        switch (target) {
            case 1:
                bord[0] = player;
                break;
            case 2:
                bord[1] = player;
                break;
            case 3:
                bord[2] = player;
                break;
            case 4:
                bord[3] = player;
                break;
            case 5:
                bord[4] = player;
                break;
            case 6:
                bord[5] = player;
                break;
            case 7:
                bord[6] = player;
                break;
            case 8:
                bord[7] = player;
                break;
            case 9:
                bord[8] = player;
                break;
        }
    }

    public boolean judge(String[] bord) {
        for (int i = 0; i < 9; i++) {
            if (bord[i] != "-" && bord[i] == bord[i + 1] && bord[i] == bord[i + 2]) {//across
                System.out.println(bord[i] + "の勝ち");
                return true;
            } else {
                i += 2;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (bord[i] != "-" && bord[i] == bord[i + 3] && bord[i] == bord[i + 6]) {//down
                System.out.println(bord[i] + "の勝ち");
                return true;
            } 
        }
        
        if (bord[6] != "-" && bord[6] == bord[4] && bord[6] == bord[2]) {//slanting
            System.out.println(bord[6] + "の勝ち");
            return true;
        }

        if (bord[0] != "-" && bord[0] == bord[4] && bord[0] == bord[8]) {
            System.out.println(bord[0] + "の勝ち");
            return true;
        }

        if (turn == 9) {
            System.out.println("引き分け");
            return true;
        }
        return false;
        
    }
    
}

