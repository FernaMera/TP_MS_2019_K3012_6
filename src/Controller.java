import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button convertirButton;
    public TextField unNumero;
    public TextField numeroOpBasico1;
    public TextField numeroOpBasico2;
    public TextArea resultado;
    public TextArea resultadoBasico;
    public ComboBox comboBoxTransformacion;

    public void convertirNumero(){

        //leer numeros del string
        String input = unNumero.getText();
        if(input.isEmpty())
            return;

        String option = (String)comboBoxTransformacion.getValue();
        switch (option)
        {
            case "Binomica -> Polar":
            {
                try {
                    NumeroComplejoBinomica numeroComplejoATransformar = new NumeroComplejoBinomica(input);
                    resultado.setText(numeroComplejoATransformar.pasarAPolar());
                    break;
                } catch (Exception e){
                    mostrarAlerta();
                    return;
                }
            }
            case "Polar -> Binomica":
            {
                try {
                    NumeroComplejoPolar numeroComplejoATransformar = new NumeroComplejoPolar(input);
                    resultado.setText(numeroComplejoATransformar.pasarABinomica());
                    break;
                } catch (Exception e) {
                    mostrarAlerta();
                    return;
                }
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

    public void cambiarOpcionTransformacion()
    {
        String option = (String)comboBoxTransformacion.getValue();
        if (option == "Binomica -> Polar")
            unNumero.setPromptText("(a;b)");
        if (option == "Polar -> Binomica")
            unNumero.setPromptText("[a;b]");
    }

    public void sumar()
    {
        NumeroComplejoBinomica numeroComplejo1 = obtenerNumero(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejo2 = obtenerNumero(numeroOpBasico2);

        try {
            String resultado1 = numeroComplejo1.sumar(numeroComplejo2);

            //pasar a polar
            NumeroComplejoBinomica numeroAConvertir = new NumeroComplejoBinomica(resultado1);
            resultadoBasico.setText(resultado1 + " o " + numeroAConvertir.pasarAPolar());
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void restar()
    {
        NumeroComplejoBinomica numeroComplejo1 = obtenerNumero(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejo2 = obtenerNumero(numeroOpBasico2);

        try {
            String resultado1 = numeroComplejo1.restar(numeroComplejo2);

            //pasar a polar
            NumeroComplejoBinomica numeroAConvertir = new NumeroComplejoBinomica(resultado1);
            resultadoBasico.setText(resultado1 + " o " + numeroAConvertir.pasarAPolar());
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void multiplicar()
    {
        NumeroComplejoBinomica numeroComplejo1 = obtenerNumero(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejo2 = obtenerNumero(numeroOpBasico2);

        try {
            String resultado1 = numeroComplejo1.multiplicar(numeroComplejo2);

            //pasar a polar
            NumeroComplejoBinomica numeroAConvertir = new NumeroComplejoBinomica(resultado1);
            resultadoBasico.setText(resultado1 + " o " + numeroAConvertir.pasarAPolar());
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void dividir()
    {
        NumeroComplejoBinomica numeroComplejo1 = obtenerNumero(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejo2 = obtenerNumero(numeroOpBasico2);

        try {
            String resultado1 = numeroComplejo1.dividir(numeroComplejo2);

            //pasar a polar
            NumeroComplejoBinomica numeroAConvertir = new NumeroComplejoBinomica(resultado1);
            resultadoBasico.setText(resultado1 + " o " + numeroAConvertir.pasarAPolar());
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void cerrarAplicacion()
    {
        Platform.exit();
    }

    public void acercaDe()
    {
        //TODO
    }

    //Metodos Auxiliares
    private NumeroComplejoBinomica obtenerNumero(TextField numero)
    {
        String input;
        NumeroComplejoBinomica numeroComplejo;
        NumeroComplejoPolar otroNumeroComplejo;

        input = numero.getText();
        if(input.isEmpty())
            return null;

        if (input.charAt(0) == '(')
            numeroComplejo =  new NumeroComplejoBinomica(input);
        else{
            otroNumeroComplejo =  new NumeroComplejoPolar(input);

            //pasar a binomica
            numeroComplejo = new NumeroComplejoBinomica(otroNumeroComplejo.pasarABinomica());
        }

        return numeroComplejo;
    }

    private void mostrarAlerta()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Precaucion");
        alert.setHeaderText("Error de Sintaxis");
        alert.setContentText("Los numeros complejos no deben tener letras ni otros caracteres");

        alert.showAndWait();
    }
}
