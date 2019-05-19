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
    public TextField numeroOpAvanzado1;
    public TextField numeroOpAvanzadoN;
    public TextArea resultado;
    public TextArea resultadoBasico;
    public TextArea resultadoAvanzado;
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
        if (option.equals("Binomica -> Polar"))
            unNumero.setPromptText("(a;b)");
        if (option.equals("Polar -> Binomica"))
            unNumero.setPromptText("[a;b]");
    }

    public void sumar()
    {
        NumeroComplejoInterfaz numeroComplejo1 = obtenerNumeroComplejo(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejoB2;
        NumeroComplejoPolar numeroComplejoP2;
        String input;

        input = numeroOpBasico2.getText();
        if(input.isEmpty())
            return;

        try {
            String resultado1;

            if (input.charAt(0) == '('){
                numeroComplejoB2 = new NumeroComplejoBinomica(input);
                resultado1 = numeroComplejo1.sumar(numeroComplejoB2);
            } else {
                numeroComplejoP2 = new NumeroComplejoPolar(input);
                resultado1 = numeroComplejo1.sumar(numeroComplejoP2);
            }

            //pasar a polar
            NumeroComplejoBinomica numeroAConvertir = new NumeroComplejoBinomica(resultado1);
            resultadoBasico.setText(resultado1 + " o " + numeroAConvertir.pasarAPolar());
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void restar()
    {
        NumeroComplejoInterfaz numeroComplejo1 = obtenerNumeroComplejo(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejoB2;
        NumeroComplejoPolar numeroComplejoP2;
        String input;

        input = numeroOpBasico2.getText();
        if(input.isEmpty())
            return;

        try {
            String resultado1;

            if (input.charAt(0) == '('){
                numeroComplejoB2 = new NumeroComplejoBinomica(input);
                resultado1 = numeroComplejo1.restar(numeroComplejoB2);
            } else {
                numeroComplejoP2 = new NumeroComplejoPolar(input);
                resultado1 = numeroComplejo1.restar(numeroComplejoP2);
            }

            //pasar a polar
            NumeroComplejoBinomica numeroAConvertir = new NumeroComplejoBinomica(resultado1);
            resultadoBasico.setText(resultado1 + " o " + numeroAConvertir.pasarAPolar());
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void multiplicar()
    {
        NumeroComplejoInterfaz numeroComplejo1 = obtenerNumeroComplejo(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejoB2;
        NumeroComplejoPolar numeroComplejoP2;
        String input;

        input = numeroOpBasico2.getText();
        if(input.isEmpty())
            return;

        try {
            String resultado1;

            if (input.charAt(0) == '('){
                numeroComplejoB2 = new NumeroComplejoBinomica(input);
                resultado1 = numeroComplejo1.multiplicar(numeroComplejoB2);
            } else {
                numeroComplejoP2 = new NumeroComplejoPolar(input);
                resultado1 = numeroComplejo1.multiplicar(numeroComplejoP2);
            }
            resultadoBasico.setText(resultado1);
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void dividir()
    {
        NumeroComplejoInterfaz numeroComplejo1 = obtenerNumeroComplejo(numeroOpBasico1);
        NumeroComplejoBinomica numeroComplejoB2;
        NumeroComplejoPolar numeroComplejoP2;
        String input;

        input = numeroOpBasico2.getText();
        if(input.isEmpty())
            return;

        try {
            String resultado1;

            if (input.charAt(0) == '('){
                numeroComplejoB2 = new NumeroComplejoBinomica(input);
                resultado1 = numeroComplejo1.dividir(numeroComplejoB2);
            } else {
                numeroComplejoP2 = new NumeroComplejoPolar(input);
                resultado1 = numeroComplejo1.dividir(numeroComplejoP2);
            }
            resultadoBasico.setText(resultado1);
        } catch(Exception nullNumbers) {
            //does nothing
        }
    }

    public void potenciar()
    {
        NumeroComplejoInterfaz numeroComplejo = obtenerNumeroComplejo(numeroOpAvanzado1);
        int numeroNatural = Integer.parseInt(numeroOpAvanzadoN.getText());

        try{
            resultadoAvanzado.setText(numeroComplejo.potenciar(numeroNatural));
        } catch (Exception nullNumbers) {
            //NOTHING
        }
    }

    public void raiz()
    {
        NumeroComplejoInterfaz numeroComplejo = obtenerNumeroComplejo(numeroOpAvanzado1);
        int numeroNatural = Integer.parseInt(numeroOpAvanzadoN.getText());

        try{
            resultadoAvanzado.setText(numeroComplejo.raiz(numeroNatural));
        } catch (Exception nullNumbers) {
            //NOTHING
        }
    }

    public void cerrarAplicacion()
    {
        Platform.exit();
    }

    public void acercaDe()
    {
        //TODO
        Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);

        dialogPane.setTitle("Acerca");
        dialogPane.setHeaderText("Trabajo Practico de Matemarica Superior");
        dialogPane.setContentText("Creado por Grupo 6: Noelia, Marisol, Rafael, Fernando y Luis");

        dialogPane.showAndWait();
    }

    //Metodos Auxiliares
    private NumeroComplejoInterfaz obtenerNumeroComplejo(TextField numero)
    {
        String input;

        input = numero.getText();
        if(input.isEmpty())
            return null;

        if (input.charAt(0) == '(')
            return new NumeroComplejoBinomica(input);
        else
            return new NumeroComplejoPolar(input);
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
