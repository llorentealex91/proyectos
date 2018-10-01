/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanadialogos;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btInfo;
    @FXML
    private Button btConfir;
    @FXML
    private Button btID;
    @FXML
    private Button btIDV;
    @FXML
    private Button btConfirVarios;
    @FXML
    private Button btWarning;
    @FXML
    private Label nombre;
    @FXML
    private Label opcion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void info(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Modulo de Programacion");
        alert.setHeaderText("Bienvenido al curso de JAVA FX");
        alert.setContentText("En este tema veremos las ventanas de dialogo");
        alert.showAndWait();
    }

    @FXML
    private void confirmacion(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Modulo de Programacion");
        alert.setHeaderText("Encuesta sobre el curso de JAVA FX");
        alert.setContentText("¿Te gusta el curso de Java FX?");

        ButtonType si = new ButtonType("Si");
        ButtonType no = new ButtonType("No");
        ButtonType abstengo = new ButtonType("Me Abstengo");

        alert.getButtonTypes().setAll(si, no, abstengo);

        Optional<ButtonType> result;
        do {
            result = alert.showAndWait();
            if (result.get() == si) {
                Alert info = new Alert(AlertType.INFORMATION);
                info.setTitle("Modulo de Programacion");
                info.setHeaderText(null);
                info.setContentText("Me alegro");
                info.showAndWait();
            } else if (result.get() == no) {
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Modulo de Programacion");
                error.setHeaderText(null);
                error.setContentText("Intentaremos Mejorar");
                error.showAndWait();
            } else if (result.get() == abstengo) {
                Alert error = new Alert(AlertType.WARNING);
                error.setTitle("Modulo de Programacion");
                error.setHeaderText(null);
                error.setContentText("Necesitamos tu opinion");
                error.showAndWait();
            }
        } while (result.get() == abstengo);

    }

    @FXML
    private void inputDialog(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Modulo de Programacion");
        dialog.setHeaderText("Ventana para solicitar tu nombre");
        dialog.setContentText("Nombre: ");

        Optional<String> resultado;
        do {
            resultado = dialog.showAndWait();
            if (resultado.isPresent() && !(resultado.get().isEmpty())) {
                nombre.setText("Gracias " + resultado.get());
            } else {
                nombre.setText("Debe escribir su nombre");
            }
        } while (resultado.isPresent() == false || resultado.get().isEmpty());
    }

    @FXML
    private void inputDialogVarios(ActionEvent event) {
        List<String> op = new ArrayList<>();
        op.add("muy bueno");
        op.add("bueno");
        op.add("malo");
        op.add("muy malo");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("muy bueno", op);
        dialog.setTitle("Modulo de Programacion");
        dialog.setHeaderText("Deseamos tu opinion");
        dialog.setContentText("Elige una opcion ");

        Optional<String> resultado = dialog.showAndWait();
        if (resultado.isPresent()) {
            opcion.setText(resultado.get());
        }

    }

    @FXML
    private void confirmacionVarios(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Modulo de Programacion");
        alert.setHeaderText("Danos tu opinion del curso");
        alert.setContentText("Elige una opcion");

        ButtonType mb = new ButtonType("Muy Bueno");
        ButtonType b = new ButtonType("Bueno");
        ButtonType r = new ButtonType("Regular");
        ButtonType mm = new ButtonType("Muy Malo");
        alert.getButtonTypes().setAll(mb, b, r, mm);

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent()){
            JOptionPane.showMessageDialog(null, result.get().getText());
            
            Alert alert2 = new Alert(AlertType.NONE);
            alert2.getDialogPane().getButtonTypes().add(ButtonType.OK);
            alert2.setContentText(result.get().getText());
            alert2.showAndWait();
        }
        
    }

    @FXML
    private void warning(ActionEvent event) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Modulo de Programacion");
        alert.setHeaderText("Ventana de aviso de algun peligro (warning)");
        alert.setContentText("Si te equivocas saldra esta ventana");
        alert.showAndWait();
    }

}
