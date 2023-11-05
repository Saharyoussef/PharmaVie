package com.example.pharmavie;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientsCL implements Initializable {
    @FXML
    Button o,p,e,s,c;
    @FXML
    TextField tfSearch;
    @FXML
    TextField tfID;
    @FXML
    TextField tfName;
    @FXML
    TextField tfEmail;
    @FXML
    TextField tfTel;
    @FXML
    TextField tfOrders;
    @FXML
    Button btnAdd;
    @FXML
    Button btnDelete;
    @FXML
    Button btnUpdate;
    @FXML
    Button btnResearch;
    @FXML
    TableView table;
    @FXML
    TableColumn id;
    @FXML
    TableColumn name;
    @FXML
    TableColumn email;
    @FXML
    TableColumn tel;
    @FXML
    TableColumn orders;

    ClientsControl ct=new ClientsControl();
    int ID;

    public void search() throws SQLException {
        table.setItems(ct.searchClients(tfSearch.getText()));
    }

    @Override
    public void initialize(URL location, ResourceBundle ressources)  {
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        //le 1 id esr celui dans interface et le 2éme est celui dans database
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
//        adress.setCellValueFactory(new PropertyValueFactory<>("Adress"));
        orders.setCellValueFactory(new PropertyValueFactory<>("Orders"));

        try {
            table.setItems(ct.getAllClients());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void add(Event e) throws SQLException {
        Clients cl=new Clients();
        cl.setID(Integer.parseInt(tfID.getText()));
        cl.setName(tfName.getText());
        cl.setEmail(tfEmail.getText());
        cl.setTel(tfTel.getText());
        cl.setOrders(Double.parseDouble(tfOrders.getText()));

        ct.add(cl);
        table.setItems(ct.getAllClients());
        tfID.setText("");
        tfName.setText("");
        tfEmail.setText("");
        tfTel.setText("");
        tfOrders.setText("");
    }

    public void update(Event e) throws SQLException {
        Clients cl=new Clients();
        cl.setID(Integer.parseInt(tfID.getText()));
        cl.setName(tfName.getText());
        cl.setEmail(tfEmail.getText());
        cl.setTel(tfTel.getText());
        cl.setOrders(Double.parseDouble(tfOrders.getText()));

        ct.update(cl);
        table.setItems(ct.getAllClients());
        tfID.setText("");
        tfName.setText("");
        tfEmail.setText("");
        tfTel.setText("");
        tfOrders.setText("");

    }

    public void delete(Event e) throws SQLException {
        ct.delete(ID);
        tfName.setText("");
        tfEmail.setText("");
        tfTel.setText("");
        tfOrders.setText("");
    }

    public void clickTable(Event e)
    {
        Clients c=(Clients) table.getSelectionModel().getSelectedItem();
        tfName.setText(c.getName());
        tfEmail.setText(c.getEmail());
        tfTel.setText(c.getTel());
        tfOrders.setText(c.getOrders()+"");
        ID=c.getID();

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
