import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel ttt = new JPanel();
    JPanel newPanel = new JPanel();
    JButton[] btns = new JButton[9];
    JButton newGame = new JButton("New Game");
    String lastPlayer = "_";

    public TicTacToe() {
        ttt.setLayout(new GridLayout(3, 3));
        newPanel.setLayout(new FlowLayout());
        for (int j = 0; j < 9; j++) {
            btns[j] = new JButton("_");
            ActionListener btnListener = new ButtonListener();
            btns[j].addActionListener(btnListener);
            btns[j].setFont(new Font("Courier", Font.PLAIN, 48));
            ttt.add(btns[j]);
        }
        ActionListener newGameListener = new NewGameListener();
        newGame.addActionListener(newGameListener);
        newGame.setFont(new Font("Courier", Font.PLAIN, 48));
        newPanel.add(newGame);
        frame.add(ttt, BorderLayout.NORTH);
        frame.add(newPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToe();
    } 

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String currentText = source.getText();

            if (currentText.equals("_") && !lastPlayer.equals("X")) {
                source.setText("X");
                lastPlayer = "X";
            } else if (currentText.equals("_") && lastPlayer.equals("X")){
                source.setText("0");
                lastPlayer = "0";
            } else {
                // do nothing
            }
        }
    }

    class NewGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            for (int i = 0; i < 9; i++) {
                btns[i].setText("_");
            }
        }
    }   
}