package jp.ac.uryukyu.ie.e215739;

public class Tictactoe {
    String[] bord;
    int turn;
    int target;
    static String MARU = "○";
    static String BATU = "x";
    
    Tictactoe() {
        bord = new String[] { "-", "-", "-", "-", "-", "-", "-", "-", "-" };
        turn = 1;
    }
    
    
    public void display(String[] bord){
        for(int i = 0;i < 9; i++){
            System.out.println(bord[i] + bord[i + 1] + bord[i + 2]);
            i += 2;
        }
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
    
}

