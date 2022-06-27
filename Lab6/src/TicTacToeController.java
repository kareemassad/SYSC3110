import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController implements ActionListener {
    private TicTacToeModel model;

    public TicTacToeController(TicTacToeModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] cord = e.getActionCommand().split(" ");
        model.play(Integer.parseInt(cord[0]), Integer.parseInt(cord[1]));
    }
}
