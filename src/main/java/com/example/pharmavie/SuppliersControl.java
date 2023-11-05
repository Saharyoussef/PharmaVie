package com.example.pharmavie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SuppliersControl {
    Statement state;
    public void add(Suppliers s) throws SQLException {

        state=Maconnexion.Connect().createStatement();
        state.executeUpdate("INSERT INTO suppliers (ID, Name, Email, Tel, Adress, Brand) VALUES (" + s.getID() + ", '" + s.getName() + "', '" + s.getEmail() + "', " + s.getTel() + ", '" + s.getAdress() + "', '" + s.getBrand() + "')");
        //nom de la table et les attributs de la table dans la base de données.
        Maconnexion.closeConnection();
    }

    public void delete(int id) throws SQLException {
        state=Maconnexion.Connect().createStatement();
        state.executeUpdate("DELETE FROM suppliers WHERE ID="+id);
        Maconnexion.closeConnection();
    }

    public void update(Suppliers s) throws SQLException {
        state=Maconnexion.Connect().createStatement();
        state.executeUpdate("UPDATE employees set 'Name' = "+" '"+s.getName()+"'"+", 'Email' = "+s.getEmail() +", 'Tel' = " +s.getTel() +", 'Adress' ="+"'" +s.getAdress()+" , 'Position' = " +s.getBrand() +" WHERE ID= "+s.getID());
        Maconnexion.closeConnection();
    }

    public ObservableList<Suppliers> getAllSuppliers() throws SQLException {
        ObservableList AllSuppliers= FXCollections.observableArrayList();
        //AllProducts est comme un tableau qui contient tous les produits
        state =Maconnexion.Connect().createStatement();
        //il faut faire la connexion avec la base de données.
        ResultSet result=state.executeQuery("SELECT * FROM Suppliers");
        while (result.next())
        {
            Suppliers OneSupplier=new Suppliers();
            //c'est un seul produit qu'on va afficher
            OneSupplier.setID(result.getInt(1));
            OneSupplier.setName(result.getString(2));
            OneSupplier.setEmail(result.getString(3));
            OneSupplier.setTel(result.getString(4));
            OneSupplier.setAdress(result.getString(5));
            OneSupplier.setBrand(result.getString(6));
            AllSuppliers.add(OneSupplier);
        }
        return AllSuppliers;
    }

    public ObservableList<Suppliers> researchSuppliers(String name) throws SQLException {
        ObservableList AllSuppliers= FXCollections.observableArrayList();
        //AllProducts est comme un tableau qui contient tous les produits
        state =Maconnexion.Connect().createStatement();
        ResultSet result=state.executeQuery("SELECT * FROM suppliers WHERE Name like '"+ name + "'");
        while (result.next())
        {
            Suppliers OneSupplier=new Suppliers();
            OneSupplier.setID(result.getInt(1));
            OneSupplier.setName(result.getString(2));
            OneSupplier.setEmail(result.getString(3));
            OneSupplier.setTel(result.getString(4));
            OneSupplier.setAdress(result.getString(5));
            OneSupplier.setBrand(result.getString(6));
            AllSuppliers.add(OneSupplier);
        }
        return AllSuppliers;
    }

}
