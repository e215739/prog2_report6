package jp.ac.uryukyu.ie.e215739;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * ○×ゲームのクラス
 * String[] bord; //盤面
 * int turn; //ターン
 * int target; //挿入するマス目の番号
 * static String MARU; //マスに挿入する記号　○
 * static String BATU; //マスに挿入する記号　×
 * Scanner scanner; //プレイヤーの入力受付用
 * boolean isEnd; //ゲームを続けるかどうかの判定
 */
public class Tictactoe {
    private String[] bord;
    private int turn;
    private int target;
    private static String MARU = "○";
    private static String BATU = "×";
    private Scanner scanner;
    private boolean isEnd;
    private ArrayList<Integer> canInsertion;
    
    /**
     * コンストラクタ。盤面、ターン、スキャナー、終了を指定する。
     */
    public Tictactoe() {
        bord = new String[] { "-", "-", "-", "-", "-", "-", "-", "-", "-" };
        turn = 1;
        scanner = new Scanner(System.in);
        isEnd = false;
        canInsertion = new ArrayList<>();
    }

    /**
     * ○×ゲームを始めるメソッド
     */
    public void start() {
        while (!isEnd) {
            canInsertion = makeCanInsertion(bord);
            display(bord);
            target = player(canInsertion);
            insertion();
            isEnd = judge(bord);
            turn++;
        }
    }

    /**
     * 
     * @param bord 盤面の状況
     * @return 記号を挿入できる場所
     */
    public ArrayList<Integer> makeCanInsertion(String[] bord) {
        ArrayList<Integer> canInsertion = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (bord[i] == "-") {
                canInsertion.add(i + 1);
            }
        }

        return canInsertion;
    }
    
    /**
     * ターミナルに盤面を表示するメソッド
     * @param bord　表示したい盤面
     */
    public void display(String[] bord){
        for(int i = 0;i < 9; i++){
            System.out.println(bord[i] + bord[i + 1] + bord[i + 2]);
            i += 2;
        }
    }

    /**
     * 標準入力を取得するメソッド
     * @return　取得した入力
     */
    public int player(ArrayList<Integer> canInsertion) {
        System.out.println("入れたい場所を入力してください");
        System.out.println(canInsertion.toString());
        target = scanner.nextInt();
        return target;
    }

    /**
     * 盤面に○か×を挿入するメソッド
     */
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

    /**
     * ゲームが終了するかを判定するメソッド
     * @param bord　確認するボード
     * @return　ゲームの終了状態
     */
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

