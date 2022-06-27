import javax.swing.*;

import java.awt.*;

public class TicTacToeFrame extends JFrame implements TicTacToeView {

    private JButton[][] buttons;

    public TicTacToeFrame() {
        super("Tic Tac Toe! LAB6");

        this.setLayout(new GridLayout(TicTacToeModel.SIZE, TicTacToeModel.SIZE));

        TicTacToeModel model = new TicTacToeModel();

        model.addTicTacToeView(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);

        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];

        // TicTacToeController tttc = new TicTacToeController(model);

        for (int i = 0; i < TicTacToeModel.SIZE; i++) {
            for (int j = 0; j < TicTacToeModel.SIZE; j++) {
                JButton button = new JButton("");
                buttons[i][j] = button;
                // button.setActionCommand( i + " " + j);
                int x = i;
                int y = j;
                button.addActionListener(e -> model.play(x, y));
                this.add(button);
            }
        }
        this.setVisible(true);
    }

    @Override
    public void handleTicTacToeStatusUpdate(TicTacToeEvent e) {
        TicTacToeModel model = (TicTacToeModel) e.getSource();
        String label = model.getTurn() ? "X" : "O";
        buttons[e.getX()][e.getY()].setText(label);
        if (model.getStatus() == TicTacToeModel.Status.X_WON) {
            JOptionPane.showMessageDialog(null, "X won");
        } else if (model.getStatus() == TicTacToeModel.Status.O_WON) {
            JOptionPane.showMessageDialog(null, "O won");
        }

    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
