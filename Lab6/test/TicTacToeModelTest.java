import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeModelTest {

    TicTacToeModel  ttt;

    @Test
    public void testInitialStatus() {
        ttt = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, ttt.getStatus());
    }
    @Test
    public void testRowWin(){
        ttt = new TicTacToeModel();
        // x @ 0,0
        ttt.play(0,0);
        // O @ 1,0
        ttt.play(1,0);
        ttt.play(0,1);
        ttt.play(1,1);
        ttt.play(0,2);

        assertEquals(TicTacToeModel.Status.X_WON, ttt.getStatus());
    }
    @Test
    public void testColWin(){
        ttt = new TicTacToeModel();
        ttt.play(0,0);
        ttt.play(0,1);
        ttt.play(1,0);
        ttt.play(1,1);
        ttt.play(2,0);

        assertEquals(TicTacToeModel.Status.X_WON, ttt.getStatus());
    }
    @Test
    public void testDiagWin(){
        ttt = new TicTacToeModel();
        ttt.play( 0,0);
        ttt.play(0,1);
        ttt.play(1,1);
        ttt.play(0,2);
        ttt.play(2,2);

        assertEquals(TicTacToeModel.Status.X_WON, ttt.getStatus());
    }
    @Test
    public void testOtherDiagWin(){
        ttt = new TicTacToeModel();
        ttt.play(0,2);
        ttt.play(0,0);
        ttt.play(1,1);
        ttt.play(1,0);
        ttt.play(2,0);

        assertEquals(TicTacToeModel.Status.X_WON, ttt.getStatus());
    }
    @Test
    public void testDraw(){
        ttt = new TicTacToeModel();
        ttt.play(1,1);
        ttt.play(0,0);
        ttt.play(2,2);
        ttt.play(0,2);
        ttt.play(0,1);
        ttt.play(1,2);
        ttt.play(0,1);
        ttt.play(2,1);
        ttt.play(0,2);

        assertEquals(TicTacToeModel.Status.X_WON, ttt.getStatus());
    }
}