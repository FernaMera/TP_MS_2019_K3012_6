import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button convertirButton;
    public TextField unNumero;
    public TextArea resultado;
    public ComboBox comboBoxTransformacion;

    public void convertirNumero(){

        //leer numeros del string
        String numeroComplejo = unNumero.getText();
        int finalPrimerNumero = 0;
        int finalSegundoNumero = 0;

        for(int i = 0; i < numeroComplejo.length(); i++)
            if(numeroComplejo.charAt(i) == ';')
                finalPrimerNumero = i;

        double primerNumero = Double.parseDouble(unNumero.getText(1, finalPrimerNumero));

        for(int i = finalPrimerNumero + 1; i < numeroComplejo.length(); i++)
            if(numeroComplejo.charAt(i) == ')' || numeroComplejo.charAt(i) == ']')
                finalSegundoNumero = i;

        double segundoNumero = Double.parseDouble(unNumero.getText(finalPrimerNumero + 1, finalSegundoNumero));

        String option = (String)comboBoxTransformacion.getValue();
        switch (option)
        {
            case "Binomica -> Polar":
            {
                NumeroComplejoBinomica numeroComplejoATransformar = new NumeroComplejoBinomica(primerNumero,segundoNumero);
                System.out.println("Opcion 1 para transformar");

                //TODO: polimorfismo
                resultado.setText("" + numeroComplejoATransformar.pasarAPolar());
                break;
            }
            case "Polar -> Binomica":
            {
                NumeroComplejoPolar numeroComplejoATransformar = new NumeroComplejoPolar(primerNumero, segundoNumero);
                System.out.println("Opcion 2 para transformar");

                //TODO: polimorfismo
                resultado.setText("" + numeroComplejoATransformar.pasarABinomio());
                break;
            }
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Binomica -> Polar",
                        "Polar -> Binomica"
                );
        comboBoxTransformacion.setItems(options);
        comboBoxTransformacion.getSelectionModel().selectFirst();
    }
}
