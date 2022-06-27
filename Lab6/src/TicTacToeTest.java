package src;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTest {

    TicTacToeModel ttt;

    @Test
    public void getStatus() {
    }

    public void testInitialStatus() {
        ttt = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, ttt.getStatus());
    }
}