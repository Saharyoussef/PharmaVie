package com.example.pharmavie;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeCL {
    @FXML
    Button o,p,e,s,c,h;

    public void OpenProducts(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Products.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void OpenClients(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Clients.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void OpenSuppliers(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Suppliers.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void OpenEmployees(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Employees.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void OpenOverview(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Homes.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void OpenHelp(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Chat.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
//cette classe est pour relier interface graphique avec les operations.(view/control)

