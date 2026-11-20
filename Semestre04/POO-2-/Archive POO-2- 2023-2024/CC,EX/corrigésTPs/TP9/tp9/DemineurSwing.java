import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemineurSwing extends JFrame {

    private final int rows = 8;
    private final int cols = 8;
    private final int numMines = 10;

    private JButton[][] gridButtons;
    private boolean[][] mines;
    private boolean[][] revealed;

    public DemineurSwing() {
        setTitle("Démineur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(rows, cols));
        initComponents();
        pack();
        setLocationRelativeTo(null); // Centrer la fenêtre
        setVisible(true);
    }

    private void initComponents() {
        gridButtons = new JButton[rows][cols];
        mines = new boolean[rows][cols];
        revealed = new boolean[rows][cols];

        // Initialiser les boutons et placer les mines
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gridButtons[i][j] = new JButton();
                gridButtons[i][j].addActionListener(new ButtonListener(i, j));
                add(gridButtons[i][j]);
                mines[i][j] = false;
                revealed[i][j] = false;
            }
        }
        placeMines();
    }

    private void placeMines() {
        int count = 0;
        while (count < numMines) {
            int row = (int) (Math.random() * rows);
            int col = (int) (Math.random() * cols);
            if (!mines[row][col]) {
                mines[row][col] = true;
                count++;
            }
        }
    }

    private void reveal(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || revealed[row][col]) {
            return;
        }
        revealed[row][col] = true;
        if (mines[row][col]) {
            JOptionPane.showMessageDialog(this, "Game Over!");
            revealAllMines();
        } else {
            int count = countAdjacentMines(row, col);
            if (count == 0) {
                reveal(row - 1, col - 1);
                reveal(row - 1, col);
                reveal(row - 1, col + 1);
                reveal(row, col - 1);
                reveal(row, col + 1);
                reveal(row + 1, col - 1);
                reveal(row + 1, col);
                reveal(row + 1, col + 1);
            } else {
                gridButtons[row][col].setText(String.valueOf(count));
                gridButtons[row][col].setBackground(Color.LIGHT_GRAY); // Changer la couleur de fond de la case révélée
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols && mines[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void revealAllMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mines[i][j]) {
                    gridButtons[i][j].setText("X");
                    gridButtons[i][j].setBackground(Color.RED); // Changer la couleur de fond de la mine révélée
                }
            }
        }
    }

    private class ButtonListener implements ActionListener {
        private final int row;
        private final int col;

        public ButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            reveal(row, col);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DemineurSwing());
    }
}
