package jp.ac.uryukyu.ie.e215739;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TictactoeTest {
    
    @Test
    void judgeTest(){
        String[] bord = { "○", "-", "-", "○", "-", "-", "○", "-", "-" };
        Tictactoe game = new Tictactoe();
        boolean result = game.judge(bord);
        assertEquals(true, result);
    }
}
