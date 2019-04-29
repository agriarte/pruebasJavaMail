package ejemploGmail02;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button id_btn_enviarSSL;
    @FXML
    Button id_btn_enviarTLS;
    @FXML
    TextField id_EmailDestino;
    @FXML
    TextField id_asunto;
    @FXML
    TextArea id_cuerpo;


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
        System.out.println("aqui");
        SendEmailTLS miEmail = new SendEmailTLS(id_EmailDestino.getText(),id_asunto.getText(),id_cuerpo.getText());
    }


    private void accionEnviarSSL() {
        //creando instancia ya se ejecuta la lógica de enviar mail
        SendEmailSSL miEmail = new SendEmailSSL(id_EmailDestino.getText(),id_asunto.getText(),id_cuerpo.getText());

    }
}

