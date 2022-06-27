import javax.swing.*;
import java.util.*;

public class TicTacToeModel {

    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {
        X_WON, O_WON, TIE, UNDECIDED
    };

    private char[][] grid;
    private boolean turn;
    private Status status;
    private List<TicTacToeView> views;

    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        views = new ArrayList<>();

    }

    public void addTicTacToeView(TicTacToeView view) {
        this.views.add(view);

    }

    public void removeTicTacToeView(TicTacToeView view) {
        this.views.remove(view);

    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {
        return status;
    }

    private void updateStatus() {

        // check row
        for (int row = 0; row < SIZE; row++) {
            if (grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2]) {
                if (grid[row][0] == 'X') {
                    status = Status.X_WON;
                } else if (grid[row][0] == 'O') {
                    status = Status.O_WON;
                }
            }
        }
        // check col
        for (int col = 0; col < SIZE; col++) {
            if (grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]) {
                if (grid[0][col] == 'X') {
                    status = Status.X_WON;
                } else if (grid[0][col] == 'O') {
                    status = Status.O_WON;
                }
            }
        }

        // check diagonal
        for (int diag = 0; diag < SIZE; diag++) {
            if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
                if (grid[0][0] == 'X') {
                    status = Status.X_WON;
                } else if (grid[0][0] == 'O') {
                    status = Status.O_WON;
                }
            }
        }

        // check other diagonal
        for (int otherDiag = 0; otherDiag < SIZE; otherDiag++) {
            if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
                if (grid[0][2] == 'X') {
                    status = Status.X_WON;
                } else if (grid[0][2] == 'O') {
                    status = Status.O_WON;
                }
            }
        }
    }

    public boolean getTurn() {
        return turn;
    }

    public void play(int x, int y) {
        if (grid[x][y] != ' ')
            return;
        grid[x][y] = turn ? 'X' : 'O';
        updateStatus();
        for (TicTacToeView view : views) {
            view.handleTicTacToeStatusUpdate(new TicTacToeEvent(this, status, x, y));
        }
        changeTurn();
    }
}
