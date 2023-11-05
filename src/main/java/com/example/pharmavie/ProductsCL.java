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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProductsCL implements Initializable {
    @FXML
    Button o,p,e,s,c;
    @FXML
    TextField tfSearch;
    @FXML
    TextField tfID;
    @FXML
    TextField tfName;
    @FXML
    TextField tfPrice;
    @FXML
    TextField tfNumber;
    @FXML
    TextField tfType;
    @FXML
    Button btnAdd;
    @FXML
    Button btnDelete;
    @FXML
    Button btnUpdate;
    @FXML
    Button btnResearch;
    @FXML
    TableView<Products> table;
    @FXML
    TableColumn<Products,Integer> id;
    @FXML
    TableColumn<Products,String> name;
    @FXML
    TableColumn <Products,Double> price;
    @FXML
    TableColumn <Products,Double> number;
    @FXML
    TableColumn <Products,String> type;

    ProductControl pc=new ProductControl();
    int ID;

    public void search() throws SQLException {
        table.setItems(pc.SearchProducts(tfSearch.getText()));
    }

    @Override
    public void initialize(URL location, ResourceBundle ressources)  {
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        //le 1 id esr celui dans interface et le 2éme est celui dans database
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        number.setCellValueFactory(new PropertyValueFactory<>("Number"));
        type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        try {
            table.setItems(pc.getAllProducts());
        } catch (SQLException ex) {
            System.out.println("error : "+ e.getText());
        }
    }

    @FXML
    public void add(Event e) throws SQLException {
        Products p=new Products();
        p.setID(Integer.parseInt(tfID.getText()));
        p.setName(tfName.getText());
        p.setPrice(Double.parseDouble(tfPrice.getText()));
        p.setNumber(Double.parseDouble(tfNumber.getText()));
        p.setType(tfType.getText());
        pc.add(p);
        table.setItems(pc.getAllProducts());
        tfID.setText("");
        tfName.setText("");
        tfPrice.setText("");
        tfNumber.setText("");
        tfType.setText("");
    }

    @FXML
    public void update(Event e) throws SQLException {
        Products p=new Products();
        //p.setID(Integer.parseInt(tfID.getText()));
        p.setName(tfName.getText());
        p.setPrice(Double.parseDouble(tfPrice.getText()));
        p.setNumber(Double.parseDouble(tfNumber.getText()));
        p.setType(tfType.getText());
        pc.update(p);
        table.setItems(pc.getAllProducts());
        tfID.setText("");
        tfName.setText("");
        tfPrice.setText("");
        tfNumber.setText("");
        tfType.setText("");
    }

    /*public int modifier(int id,String name,Double price,Double number,String type) throws SQLException {
        Maconnexion con=new Maconnexion();
        Connection connection = con.Connect();
        if (connection != null) {
            String requete = "update products set Name=? , Price=? , Number=? , Type=? where id=?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(requete);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2,name);
                preparedStatement.setDouble(3,price);
                preparedStatement.setDouble(4,number);
                preparedStatement.setString(5,type);
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("error ");
            }
        }
        return 0;
    }*/


    @FXML
    public void delete(Event e) throws SQLException {
        pc.delete(ID);
        tfName.setText("");
        tfPrice.setText("");
        tfNumber.setText("");
        tfType.setText("");
    }

    @FXML
    public void clickTable(Event e)
    {
        Products p=(Products) table.getSelectionModel().getSelectedItem();
        tfName.setText(p.getName());
        tfPrice.setText(p.getPrice()+"");
        tfNumber.setText(p.getNumber()+"");
        tfType.setText(p.getType());
        ID=p.getID();

    }


    @FXML
    public void OpenProducts(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Products.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void OpenClients(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Clients.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void OpenSuppliers(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Suppliers.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void OpenEmployees(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Employees.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void OpenOverview(Event e) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage =(Stage) node.getScene().getWindow();
        //stage close
        Parent root= FXMLLoader.load(getClass().getResource("/com/example/pharmavie/Homes.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
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
