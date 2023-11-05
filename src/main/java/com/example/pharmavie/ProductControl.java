package com.example.pharmavie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductControl {
    Statement state;
    public void add(Products p) throws SQLException {

            state=Maconnexion.Connect().createStatement();
            state.executeUpdate("INSERT INTO products (ID, Name, Price, Number, Type) VALUES (" + p.getID() + ", '" + p.getName() + "', " + p.getPrice() + ", " + p.getNumber() + ", '" + p.getType() + "')");
            //nom de la table et les attributs de la table dans la base de données.
            Maconnexion.closeConnection();
    }

    public void delete(int id) throws SQLException {
        state=Maconnexion.Connect().createStatement();
        state.executeUpdate("DELETE FROM products WHERE ID="+id);
        Maconnexion.closeConnection();
    }

    public void update(Products p) throws SQLException {
        state=Maconnexion.Connect().createStatement();
        //state.executeUpdate("UPDATE products set Name = "+" '"+p.getName()+"'"+", Number = "+p.getNumber()+", Price = " +p.getPrice() +", Type ="+"'" +p.getType()+" WHERE ID= "+p.getID());
        //String query = "UPDATE products SET Name=?, Number=?, Price=?, Type=? WHERE ID=?";
        String query = "UPDATE products SET Name='" + p.getName() + "', Number=" + p.getNumber() + ", Price=" + p.getPrice() + ", Type='" + p.getType() + "' WHERE ID=" + p.getID();
        state.executeUpdate(query);
        Maconnexion.closeConnection();
    }

   public ObservableList<Products> getAllProducts() throws SQLException {
        ObservableList AllProducts= FXCollections.observableArrayList();
        //AllProducts est comme un tableau qui contient tous les produits
        state =Maconnexion.Connect().createStatement();
        //il faut faire la connexion avec la base de données.
        ResultSet result=state.executeQuery("SELECT * FROM products");
        while (result.next())
        {
            Products OneProduct=new Products();
            //c'est un seul produit qu'on va afficher
            OneProduct.setID(result.getInt(1));
            OneProduct.setName(result.getString(2));
            OneProduct.setPrice(result.getDouble(3));
            OneProduct.setNumber(result.getDouble(4));
            OneProduct.setType(result.getString(5));
            AllProducts.add(OneProduct);
        }
        return AllProducts;
    }
    //cette fonction va retourner tous les produits de la base de données dans l'interface grahique

    public ObservableList<Products> SearchProducts(String name) throws SQLException {
        ObservableList AllProducts= FXCollections.observableArrayList();
        //AllProducts est comme un tableau qui contient tous les produits
        state =Maconnexion.Connect().createStatement();
        //il faut faire la connexion avec la base de données.
        System.out.println("SELECT * FROM products WHERE Name like '%' + '"+ name + "' + '%' ");
        ResultSet result=state.executeQuery("SELECT * FROM products WHERE Name like '"+ name + "'");
        //on met % pour que si meme on n'a pas écrit le mot tout entier on aura la recherche
        while (result.next())
        {
            Products OneProduct=new Products();
            //c'est un seul produit qu'on va afficher
            OneProduct.setID(result.getInt(1));
            OneProduct.setName(result.getString(2));
            OneProduct.setPrice(result.getDouble(3));
            OneProduct.setNumber(result.getDouble(4));
            OneProduct.setType(result.getString(5));
            AllProducts.add(OneProduct);
        }
        return AllProducts;
    }
    //cette fonction pour la recherche.
}
