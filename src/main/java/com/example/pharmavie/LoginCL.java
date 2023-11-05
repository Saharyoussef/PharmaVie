package com.example.pharmavie;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;

public class LoginCL {
    @FXML
    TextField User;
    //nommer les memes que dans scene builder dans case id
    @FXML
    PasswordField Pass;
    @FXML
    Button Login;
    @FXML
    Label Error;
    Admin a=new Admin();
    LoginControl lc=new LoginControl();
    //cette fct va envoyer au admin nom et mdp et lui il va l'envoyer à Login function dans LoginControl class

    public void sign(Event e) throws IOException, SQLException {
        a.setUsername(User.getText());
        //admin va changer nom avec setUsername avec le nom entré dans l'interface graphique
        a.setPassword(Pass.getText());
        if(lc.login(a))
        {
            Node node=(Node) e.getSource();
            Stage stage =(Stage) node.getScene().getWindow();
            //stage close
            Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Homes.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
            Error.setText("Username or Password doesn't exist!");
    }

}
//cette classe est pour relier interface graphique avec les operations.(view/control)
