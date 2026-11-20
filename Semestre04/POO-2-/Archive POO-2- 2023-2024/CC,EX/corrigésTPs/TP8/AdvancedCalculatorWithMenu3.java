import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdvancedCalculatorWithMenu3 extends JFrame implements ActionListener, FocusListener {
    private JTextField operand1Field;
    private JTextField operand2Field;
    private JTextField resultField;
    private JButton calculateButton;
    private JMenuBar menuBar;
    private JMenu calculatorMenu;
    private JMenuItem advancedCalcMenuItem;
    private JPanel advancedPanel;
    private JRadioButton plusButton;
    private JRadioButton minusButton;
    private JRadioButton multiplyButton;
    private JRadioButton divideButton;
    private ButtonGroup operationGroup;

    public AdvancedCalculatorWithMenu3() {
        // Configuration de la fenêtre principale
        //setLayout(null); 
        setSize(400,200);
        setLocationRelativeTo(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
        int x = (screenWidth - getWidth() ) / 2;
        int y = (screenHeight - getHeight() ) / 2;
        System.out.println(screenWidth+ "  "+ getWidth());
        // Place et redimensionne le composant pour qu'il soit centré
        //setBounds(x, y, getWidth(), getHeight());
        
        setTitle("Calculatrice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(400, 300);
        setLayout(new BorderLayout());

        // Crée les panneaux pour les différentes parties de l'interface
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        advancedPanel = new JPanel(new GridLayout(1, 4, 5, 5));

        // Création des composants d'interface
        JLabel operand1Label = new JLabel("Opérande 1:");
        operand1Field = new JTextField();
        
        JLabel operand2Label = new JLabel("Opérande 2:");
        operand2Field = new JTextField();
        
        JLabel resultLabel = new JLabel("Résultat:");
        resultField = new JTextField();
        resultField.setEditable(false);
        
        calculateButton = new JButton("Calculer");
        calculateButton.addActionListener(this);
        
        // Ajout des composants aux panneaux
        inputPanel.add(operand1Label);
        inputPanel.add(operand1Field);
        inputPanel.add(operand2Label);
        inputPanel.add(operand2Field);
        inputPanel.add(resultLabel);
        inputPanel.add(resultField);
        
        buttonPanel.add(calculateButton);
        
        // Configuration du panneau avancé
        operationGroup = new ButtonGroup();
        plusButton = new JRadioButton("+", true);
        minusButton = new JRadioButton("-");
        multiplyButton = new JRadioButton("*");
        divideButton = new JRadioButton("/");

        // Ajout de focus listeners aux boutons radio
        plusButton.addFocusListener(this);
        minusButton.addFocusListener(this);
        multiplyButton.addFocusListener(this);
        divideButton.addFocusListener(this);

        // Ajout des boutons radio au groupe d'opérations
        operationGroup.add(plusButton);
        operationGroup.add(minusButton);
        operationGroup.add(multiplyButton);
        operationGroup.add(divideButton);
        
        // Ajout des boutons radio au panneau avancé
        advancedPanel.add(plusButton);
        advancedPanel.add(minusButton);
        advancedPanel.add(multiplyButton);
        advancedPanel.add(divideButton);
        
        // Cacher le panneau avancé au départ
        advancedPanel.setVisible(false);
        
        // Ajout des panneaux à la fenêtre principale
        getContentPane().add(inputPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        add(advancedPanel, BorderLayout.NORTH);
        
        // Configuration de la barre de menu
        menuBar = new JMenuBar();
        calculatorMenu = new JMenu("Calculatrice");
        advancedCalcMenuItem = new JMenuItem("Calculatrice Avancée");
        advancedCalcMenuItem.addActionListener(this);
        calculatorMenu.add(advancedCalcMenuItem);
        menuBar.add(calculatorMenu);
        setJMenuBar(menuBar);
        
        // Afficher la fenêtre
        setVisible(true);
    }

    // Gestion des événements
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            calculerEtAfficherResultat();
        } else if (e.getSource() == advancedCalcMenuItem) {
            basculerPanelAvance();
        }
    }

    // Méthode pour basculer l'affichage du panneau avancé
    private void basculerPanelAvance() {

        if (advancedPanel.isVisible()) {
            advancedPanel.setVisible(false);
            advancedCalcMenuItem.setText("Calculatrice Avancée");
        } else {
            advancedPanel.setVisible(true);
            advancedCalcMenuItem.setText("Calculatrice Simple");
        }
    }

    // Méthode pour effectuer le calcul et afficher le résultat
    private void calculerEtAfficherResultat() {
        try {
            double operand1 = Double.parseDouble(operand1Field.getText());
            double operand2 = Double.parseDouble(operand2Field.getText());
            double result = 0;

            // Calcul en fonction de l'opération choisie
            if (plusButton.isSelected()) {
                result = operand1 + operand2;
                calculateButton.setText("Additionner");
            } else if (minusButton.isSelected()) {
                result = operand1 - operand2;
                calculateButton.setText("Soustraire");
            } else if (multiplyButton.isSelected()) {
                result = operand1 * operand2;
                calculateButton.setText("Multiplier");
            } else if (divideButton.isSelected()) {
                if (operand2 == 0) {
                    resultField.setText("Erreur: division par zéro");
                    return;
                }
                result = operand1 / operand2;
                calculateButton.setText("Diviser");
            }
            
            // Affichage du résultat
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Entrée invalide");
        }
    }

        private void calculerEtAfficherResultat2() {
        try {
            double operand1 = Double.parseDouble(operand1Field.getText());
            double operand2 = Double.parseDouble(operand2Field.getText());
            double result = 0;

            // Calcul en fonction de l'opération choisie
            if (plusButton.isFocusOwner()) {
                result = operand1 + operand2;
                calculateButton.setText("Additionner");
            } else if (minusButton.isFocusOwner()) {
                result = operand1 - operand2;
                calculateButton.setText("Soustraire");
            } else if (multiplyButton.isFocusOwner()) {
                result = operand1 * operand2;
                calculateButton.setText("Multiplier");
            } else if (divideButton.isFocusOwner()) {
                if (operand2 == 0) {
                    resultField.setText("Erreur: division par zéro");
                    return;
                }
                result = operand1 / operand2;
                calculateButton.setText("Diviser");
            }
            
            // Affichage du résultat
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Entrée invalide");
        }
    }

    // Gestion des événements de focus pour les boutons radio
    @Override
    public void focusGained(FocusEvent e) {
           
            calculerEtAfficherResultat();
    }

    @Override
    public void focusLost(FocusEvent e) {
        // Aucune action spécifique n'est nécessaire lors de la perte de focus
        
    }

    public static void main(String[] args) {
        AdvancedCalculatorWithMenu3 calculator = new AdvancedCalculatorWithMenu3();
        calculator.setVisible(true);
    }
}
