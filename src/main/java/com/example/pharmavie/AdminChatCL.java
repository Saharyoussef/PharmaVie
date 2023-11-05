package com.example.pharmavie;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminChatCL implements Initializable {
    @FXML
    Button send;
    @FXML
    TextField msg;
    @FXML
    ScrollPane scroll;
    @FXML
    VBox vboxMsg;
    @FXML
    Button o,p,e,s,c;
    private AdminChat admin;


    public void initialize(URL location, ResourceBundle ressources)
    {
        try {
            admin=new AdminChat(new Socket("127.0.0.1" , 9002));
            admin.ReceiveMsgFromServer(vboxMsg);
            System.out.println("Connected to the server");
        } catch (IOException e) {
            e.printStackTrace();
        }
        vboxMsg.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                scroll.setVvalue((Double) newValue);
            }
        });

        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String MsgToSend=msg.getText();
                if(!MsgToSend.isEmpty())
                {
                    HBox hbox=new HBox();
                    hbox.setAlignment(Pos.CENTER_RIGHT);
                    hbox.setPadding(new Insets(5,5,5,10));
                    Text text =new Text(MsgToSend);
                    TextFlow textFlow=new TextFlow(text);
                    textFlow.setStyle("-fx-color : rgb(239,242,255) " +
                            "-fx-background-color : rgb(15,125,242) " +
                            "-fx-background-radius : 20px");
                    textFlow.setPadding(new Insets(5,10,5,10));
                    text.setFill(Color.color(0.934,0.945,0.990));
                    hbox.getChildren().add(textFlow);
                    vboxMsg.getChildren().add(hbox);
                    admin.SendMsgToServer(MsgToSend);
                    msg.clear();
                }

            }
        });

    }

    public static void AddLabel(String MsgFromServer , VBox vbox)
    {
        HBox hbox=new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(5,5,5,10));
        Text text =new Text(MsgFromServer);
        TextFlow textFlow=new TextFlow(text);
        textFlow.setStyle("-fx-background-color : rgb(233,233,235) " +
                "-fx-background-radius : 20px");
        textFlow.setPadding(new Insets(5,10,5,10));
        hbox.getChildren().add(textFlow);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vbox.getChildren().add(hbox);
            }
        });

    }


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


}
