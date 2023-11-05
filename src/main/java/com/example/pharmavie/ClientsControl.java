package com.example.pharmavie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientsControl {
    Statement state;
    public void add(Clients c) throws SQLException {

        state=Maconnexion.Connect().createStatement();
        state.executeUpdate("INSERT INTO clients (ID, Name, Email, Tel, Orders) VALUES (" + c.getID() + ", '" + c.getName() + "', '" + c.getEmail() + "', " + c.getTel() + ", " + c.getOrders() + ")");
        //nom de la table et les attributs de la table dans la base de données.
        Maconnexion.closeConnection();
    }

    public void delete(int id) throws SQLException {
        state=Maconnexion.Connect().createStatement();
        state.executeUpdate("DELETE FROM clients WHERE ID="+id);
        Maconnexion.closeConnection();
    }

    public void update(Clients c) throws SQLException {
        state=Maconnexion.Connect().createStatement();
        state.executeUpdate("UPDATE clients set 'Name' = "+" '"+c.getName()+"'"+", 'Email' = "+c.getEmail() +", 'Tel' = " +c.getTel() +", 'Orders' ="+"'" +c.getOrders()+"  WHERE ID= "+c.getID());
        Maconnexion.closeConnection();
    }

    public ObservableList<Clients> getAllClients() throws SQLException {
        ObservableList AllClients= FXCollections.observableArrayList();
        state =Maconnexion.Connect().createStatement();
        ResultSet result=state.executeQuery("SELECT * FROM clients");
        while (result.next())
        {
            Clients OneClient=new Clients();
            OneClient.setID(result.getInt(1));
            OneClient.setName(result.getString(2));
            OneClient.setEmail(result.getString(3));
            OneClient.setTel(result.getString(4));
            OneClient.setOrders(result.getDouble(5));
            AllClients.add(OneClient);
        }
        return AllClients;
    }

    public ObservableList<Clients> searchClients(String name) throws SQLException {
        ObservableList AllClients= FXCollections.observableArrayList();
        state =Maconnexion.Connect().createStatement();
        ResultSet result=state.executeQuery("SELECT * FROM clients WHERE Name like '"+ name + "'");
        while (result.next())
        {
            Clients OneClient=new Clients();
            OneClient.setID(result.getInt(1));
            OneClient.setName(result.getString(2));
            OneClient.setEmail(result.getString(3));
            OneClient.setTel(result.getString(4));
            OneClient.setOrders(result.getDouble(5));
            AllClients.add(OneClient);
        }
        return AllClients;
    }
}
