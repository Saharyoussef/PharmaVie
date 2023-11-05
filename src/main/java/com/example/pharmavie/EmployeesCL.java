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

public class EmployeesCL implements Initializable {
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
    TextField tfAdress;
    @FXML
    TextField tfPosition;
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
    TableColumn adress;
    @FXML
    TableColumn position;

    EmployeesControl em=new EmployeesControl();
    int ID;

    public void search() throws SQLException {
        table.setItems(em.ResearchEmployees(tfSearch.getText()));
    }

    @Override
    public void initialize(URL location, ResourceBundle ressources)  {
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        //le 1 id esr celui dans interface et le 2éme est celui dans database
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
        adress.setCellValueFactory(new PropertyValueFactory<>("Adress"));
        position.setCellValueFactory(new PropertyValueFactory<>("Position"));

        try {
            table.setItems(em.getAllEmployees());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void add(Event e) throws SQLException {
        Employees emp=new Employees();
        emp.setID(Integer.parseInt(tfID.getText()));
        emp.setName(tfName.getText());
        emp.setEmail(tfEmail.getText());
        emp.setTel(tfTel.getText());
        emp.setAdress(tfAdress.getText());
        emp.setPosition(tfPosition.getText());

        em.add(emp);
        table.setItems(em.getAllEmployees());
        tfID.setText("");
        tfName.setText("");
        tfEmail.setText("");
        tfTel.setText("");
        tfAdress.setText("");
        tfPosition.setText("");
    }

    public void update(Event e) throws SQLException {
        Employees emp=new Employees();
        emp.setID(Integer.parseInt(tfID.getText()));
        emp.setName(tfName.getText());
        emp.setEmail(tfEmail.getText());
        emp.setTel(tfTel.getText());
        emp.setAdress(tfAdress.getText());
        emp.setPosition(tfPosition.getText());

        em.update(emp);
        table.setItems(em.getAllEmployees());
        tfID.setText("");
        tfName.setText("");
        tfEmail.setText("");
        tfTel.setText("");
        tfAdress.setText("");
        tfPosition.setText("");
    }

    public void delete(Event e) throws SQLException {
        em.delete(ID);
        tfName.setText("");
        tfEmail.setText("");
        tfTel.setText("");
        tfAdress.setText("");
        tfPosition.setText("");
    }

    public void clickTable(Event e)
    {
        Employees emp=(Employees) table.getSelectionModel().getSelectedItem();
        tfName.setText(emp.getName());
        tfEmail.setText(emp.getEmail());
        tfTel.setText(emp.getTel());
        tfAdress.setText(emp.getAdress());
        tfPosition.setText(emp.getPosition());
        ID=emp.getID();

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
