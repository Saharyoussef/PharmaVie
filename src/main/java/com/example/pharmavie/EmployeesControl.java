package com.example.pharmavie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmployeesControl {
    Statement state;
    public void add(Employees e) throws SQLException {

        state=Maconnexion.Connect().createStatement();
        state.executeUpdate("INSERT INTO `employees` (`ID`, `Name`, `Email`, `Tel`, `Adress`, `Position`) VALUES (" + e.getID() + ", '" + e.getName() + "', '" + e.getEmail() + "', '" + e.getTel() + "', '" + e.getAdress() + "', '" + e.getPosition() + "')");
        //nom de la table et les attributs de la table dans la base de données.
        Maconnexion.closeConnection();
    }

    public void delete(int id) throws SQLException {
        state=Maconnexion.Connect().createStatement();
        state.executeUpdate("DELETE FROM employees WHERE ID="+id);
        Maconnexion.closeConnection();
    }

    public void update(Employees e) throws SQLException {
        state=Maconnexion.Connect().createStatement();
        state.executeUpdate("UPDATE employees set 'Name' = "+" '"+e.getName()+"'"+", 'Email' = "+e.getEmail() +", 'Tel' = " +e.getTel() +", 'Adress' ="+"'" +e.getAdress()+" , 'Position' = " +e.getPosition() +" WHERE ID= "+e.getID());
        Maconnexion.closeConnection();
    }

    public ObservableList<Employees> getAllEmployees() throws SQLException {
        ObservableList AllEmployees= FXCollections.observableArrayList();
        state =Maconnexion.Connect().createStatement();
        ResultSet result=state.executeQuery("SELECT * FROM employees");
        while (result.next())
        {
            Employees OneEmployee=new Employees();
            OneEmployee.setID(result.getInt(1));
            OneEmployee.setName(result.getString(2));
            OneEmployee.setEmail(result.getString(3));
            OneEmployee.setTel(result.getString(4));
            OneEmployee.setAdress(result.getString(5));
            OneEmployee.setPosition(result.getString(6));
            AllEmployees.add(OneEmployee);
        }
        return AllEmployees;
    }

    public ObservableList<Employees> ResearchEmployees(String name) throws SQLException {
        ObservableList AllEmployees= FXCollections.observableArrayList();
        state =Maconnexion.Connect().createStatement();
        ResultSet result=state.executeQuery("SELECT * FROM employees WHERE Name like '"+ name + "'");
        while (result.next())
        {
            Employees OneEmployee=new Employees();
            OneEmployee.setID(result.getInt(1));
            OneEmployee.setName(result.getString(2));
            OneEmployee.setEmail(result.getString(3));
            OneEmployee.setTel(result.getString(4));
            OneEmployee.setAdress(result.getString(5));
            OneEmployee.setPosition(result.getString(6));
            AllEmployees.add(OneEmployee);
        }
        return AllEmployees;
    }

}
