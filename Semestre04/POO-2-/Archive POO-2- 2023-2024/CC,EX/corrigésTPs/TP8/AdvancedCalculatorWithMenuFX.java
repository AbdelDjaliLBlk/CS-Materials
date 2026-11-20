import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

import java.awt.event.*;
public class AdvancedCalculatorWithMenuFX extends Application {

    private TextField operand1Field;
    private TextField operand2Field;
    private TextField resultField;
    private Button calculateButton;
    private MenuItem advancedCalcMenuItem;
    private ToggleGroup operationGroup;
    private RadioButton plusButton;
    private RadioButton minusButton;
    private RadioButton multiplyButton;
    private RadioButton divideButton;
    private HBox advancedPanel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Configuration de la scène principale
        primaryStage.setTitle("Calculatrice");
        
        // Crée les panneaux pour les différentes parties de l'interface
        GridPane inputPanel = new GridPane();
        inputPanel.setPadding(new Insets(10,10,10,10));
        inputPanel.setHgap(10);
        inputPanel.setVgap(10);
        inputPanel.setAlignment(Pos.CENTER);
        
        HBox buttonPanel = new HBox(10);
        buttonPanel.setAlignment(Pos.CENTER);
        
        advancedPanel = new HBox(10);
        advancedPanel.setAlignment(Pos.CENTER);
        
        // Création des composants d'interface
        Label operand1Label = new Label("Opérande 1:");
        operand1Field = new TextField();
        
        Label operand2Label = new Label("Opérande 2:");
        operand2Field = new TextField();
        
        Label resultLabel = new Label("Résultat:");
        resultField = new TextField();
        resultField.setEditable(false);
        
        calculateButton = new Button("Calculer");
        
        // Version Lambda
        // calculateButton.setOnAction(e -> calculerEtAfficherResultat());
        // Version non Lambda
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Appelle la méthode calculerEtAfficherResultat() lorsque l'événement est déclenché
                calculerEtAfficherResultat();
            }
        };
        // Attache l'EventHandler au bouton calculateButton
        calculateButton.setOnAction(eventHandler);
        
        
        // Ajout des composants aux panneaux
        inputPanel.add(operand1Label, 0, 0);
        inputPanel.add(operand1Field, 1, 0); // column=1 row=0
        inputPanel.add(operand2Label, 0, 1);
        inputPanel.add(operand2Field, 1, 1);
        inputPanel.add(resultLabel, 0, 2);
        inputPanel.add(resultField, 1, 2);
        
        buttonPanel.getChildren().add(calculateButton);
        
        // Configuration du panneau avancé
        operationGroup = new ToggleGroup();
        plusButton = new RadioButton("+");
        plusButton.setToggleGroup(operationGroup);
        plusButton.setSelected(true);
        
        minusButton = new RadioButton("-");
        minusButton.setToggleGroup(operationGroup);
        
        multiplyButton = new RadioButton("*");
        multiplyButton.setToggleGroup(operationGroup);
        
        divideButton = new RadioButton("/");
        divideButton.setToggleGroup(operationGroup);
        
        changedMethod(plusButton);
        changedMethod(minusButton);
        changedMethod(multiplyButton);
        changedMethod(divideButton);
        
        // Ajout des boutons radio au panneau avancé
        advancedPanel.getChildren().addAll(plusButton, minusButton, multiplyButton, divideButton);
        
        // Cacher le panneau avancé au départ
        advancedPanel.setVisible(false);
        
        // Configuration de la barre de menu
        MenuBar menuBar = new MenuBar();
        Menu calculatorMenu = new Menu("Calculatrice");
        advancedCalcMenuItem = new MenuItem("Calculatrice Avancée");
        
        advancedCalcMenuItem.setOnAction(e -> basculerPanelAvance()); // Notation Lambda
        
        // Equivaut
        // advancedCalcMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            // @Override
            // public void handle(ActionEvent event) {
                // basculerPanelAvance();
            // }
        // });
        calculatorMenu.getItems().add(advancedCalcMenuItem);
        menuBar.getMenus().add(calculatorMenu);
        
        // Configuration de la disposition
        BorderPane root = new BorderPane();
        BorderPane root1 = new BorderPane();
        BorderPane root2 = new BorderPane();
        root.setTop(root2);
        root.setBottom(root1);
        root1.setTop(advancedPanel);
        root1.setCenter(inputPanel);
        root1.setBottom(buttonPanel);
        root2.setTop(menuBar);
        

        // Configuration de la scène
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        
        // Afficher la scène
        primaryStage.show();
    }

    // changedMethod associe à un RadioButton un écouteur (un observateur)  de ChangeListener<Boolean> 
    // en mettant à jour le résultat dans resultField
    void changedMethod(RadioButton r){ 
         // la propriété focusedProperty() fournit l'état de focus d'un composant d'interface utilisateur.
        r.focusedProperty().addListener(new ChangeListener<Boolean>() {
            // ObservableValue<? extends Boolean> est une interface générique qui représente une valeur observable
            //      de type Boolean ou de ses sous-types.
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // Cette méthode est appelée lorsque le focus change
                if (newValue) {
                    // Si le plusButton gagne le focus
                    calculerEtAfficherResultat2();
                }
            }
        });
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
            RadioButton selectedButton = (RadioButton) operationGroup.getSelectedToggle();
            if (selectedButton == plusButton) {
                result = operand1 + operand2;
                calculateButton.setText("Additionner");
            } else if (selectedButton == minusButton) {
                result = operand1 - operand2;
                calculateButton.setText("Soustraire");
            } else if (selectedButton == multiplyButton) {
                result = operand1 * operand2;
                calculateButton.setText("Multiplier");
            } else if (selectedButton == divideButton) {
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
            if (plusButton.isFocused()) {
                result = operand1 + operand2;
                calculateButton.setText("Additionner");
            } else if (minusButton.isFocused()) {
                result = operand1 - operand2;
                calculateButton.setText("Soustraire");
            } else if (multiplyButton.isFocused()) {
                result = operand1 * operand2;
                calculateButton.setText("Multiplier");
            } else if (divideButton.isFocused()) {
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


}

