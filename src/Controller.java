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

        double[] numeroComplejo = this.scanner(input);
        if (numeroComplejo == null)
            return;

        String option = (String)comboBoxTransformacion.getValue();
        switch (option)
        {
            case "Binomica -> Polar":
            {
                NumeroComplejoBinomica numeroComplejoATransformar =
                        new NumeroComplejoBinomica(numeroComplejo[0],numeroComplejo[1]);
                System.out.println("Opcion 1 para transformar");

                //TODO: polimorfismo
                resultado.setText(numeroComplejoATransformar.pasarAPolar());
                break;
            }
            case "Polar -> Binomica":
            {
                NumeroComplejoPolar numeroComplejoATransformar =
                        new NumeroComplejoPolar(numeroComplejo[0],numeroComplejo[1]);
                System.out.println("Opcion 2 para transformar");

                //TODO: polimorfismo
                resultado.setText(numeroComplejoATransformar.pasarABinomica());
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
            resultadoBasico.setText(numeroComplejo1.sumar(numeroComplejo2));
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void restar()
    {
        NumeroComplejoBinomica numeroComplejo1 = obtenerNumero(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejo2 = obtenerNumero(numeroOpBasico2);

        try {
            resultadoBasico.setText(numeroComplejo1.restar(numeroComplejo2));
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void multiplicar()
    {
        NumeroComplejoBinomica numeroComplejo1 = obtenerNumero(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejo2 = obtenerNumero(numeroOpBasico2);

        try {
            resultadoBasico.setText(numeroComplejo1.multiplicar(numeroComplejo2));
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void dividir()
    {
        NumeroComplejoBinomica numeroComplejo1 = obtenerNumero(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejo2 = obtenerNumero(numeroOpBasico2);

        try {
            resultadoBasico.setText(numeroComplejo1.dividir(numeroComplejo2));
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
    private double[] scanner(String input)
    {
        int finalPrimerNumero = 0;
        int finalSegundoNumero = 0;
        double[] value = new double[2];

        String numeroComplejo = input.replace(',', '.');

        for(int i = 0; i < numeroComplejo.length(); i++)
            if (numeroComplejo.charAt(i) == ';')
                finalPrimerNumero = i;

        try {
            value[0] = Double.parseDouble(numeroComplejo.substring(1, finalPrimerNumero));
        }
        catch (Exception e)
        {
            mostrarAlerta();
            return null;
        }

        for(int i = finalPrimerNumero + 1; i < numeroComplejo.length(); i++)
            if(numeroComplejo.charAt(i) == ')' || numeroComplejo.charAt(i) == ']')
                finalSegundoNumero = i;

        try {
            value[1] = Double.parseDouble(numeroComplejo.substring(finalPrimerNumero + 1, finalSegundoNumero));
        }
        catch (Exception e)
        {
            mostrarAlerta();
            return null;
        }

        return value;
    }

    private NumeroComplejoBinomica obtenerNumero(TextField numero)
    {
        double[] numeroComplejoInput;
        String input;
        NumeroComplejoBinomica numeroComplejo;
        String pasaje;
        NumeroComplejoPolar otroNumeroComplejo;

        input = numero.getText();
        if(input.isEmpty())
            return null;

        numeroComplejoInput = this.scanner(input);
        if(numeroComplejoInput == null)
            return null;

        if (input.charAt(0) == '(')
            numeroComplejo =  new NumeroComplejoBinomica(numeroComplejoInput[0], numeroComplejoInput[1]);
        else{
            otroNumeroComplejo =  new NumeroComplejoPolar(numeroComplejoInput[0], numeroComplejoInput[1]);

            //pasar a binomica
            pasaje = otroNumeroComplejo.pasarABinomica();

            numeroComplejoInput = this.scanner(pasaje);
            numeroComplejo = new NumeroComplejoBinomica(numeroComplejoInput[0], numeroComplejoInput[1]);
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
