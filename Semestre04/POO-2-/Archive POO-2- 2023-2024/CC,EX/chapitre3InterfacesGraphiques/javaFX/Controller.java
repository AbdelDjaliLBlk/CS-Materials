
/**
 * Décrivez votre classe Controller ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller
{
    @FXML private Button calculer;
    @FXML private TextField t1;
    @FXML private TextField t2;
    
    public void calculer (ActionEvent event){
        int n=Integer.valueOf(t1.getText());
        int m=2*n;
        t2.setText(String.valueOf(m));
    }
}
