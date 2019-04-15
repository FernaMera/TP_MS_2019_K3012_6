import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button convertirButton;
    public TextField unNumero;
    public TextArea resultado;

    public void convertirNumero(){
        resultado.setText("" + unNumero.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
