package ejemploGmail01;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

//para enviar email añadir la librería javax.mail.jar previamente descargada.
// En intellij File->Project Structure->Libraries-> +

public class Controller implements Initializable {
    @FXML
    Button id_btn_enviarSSL;
    @FXML
    Button id_btn_enviarTLS;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //para que los eventos funcionen añadir fx:controller="ejemploBasico01.Controller" a la vista .fxml
        id_btn_enviarSSL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                accionEnviarSSL();
            }
        });

        id_btn_enviarTLS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                accionEnviarTLS();
            }
        });


    }

    private void accionEnviarTLS() {
        SendEmailTLS miEmail= new SendEmailTLS();
    }


    private void accionEnviarSSL(){
        //creando instancia ya se ejecuta la lógica de enviar mail
        SendEmailSSL miEmail = new SendEmailSSL();

    }
}

