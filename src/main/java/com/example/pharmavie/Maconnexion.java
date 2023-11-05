package com.example.pharmavie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Maconnexion {
    private static Connection con=null;
    /*public static Connection Connect()
    {
        String nomDriver="com.mysql.jdbc.Driver";
        try
        {
            Class.forName(nomDriver);
        }
        //il faut avant chaque connection insérer driver
        catch(ClassNotFoundException e)
        {
            System.out.println("Erreur Driver"+e.getMessage());
        }
        //connection à la base
        String url="jdbc:mysql://127.0.0.1/pharmavie";
        String user="root";
        String mp="";
        Connection con=null;
        try
        {
            con= DriverManager.getConnection(url,user,mp);
            return con;
        }
        catch (SQLException e)
        {
            return null;
        }
    }*/

//    public static Connection Connect() throws SQLException {
//        String url="jdbc:mysql://localhost/pharmavie";
//        String user="root";
//        String mp="";
//        if(con==null)
//            con= (Connection) DriverManager.getConnection(url,user,mp);
//        return con;
//    }
//
//    public static void closeConnection()
//    {
//        if(con!=null)
//            con=null;
//    }



    public static Connection Connect() {
        String nomDriver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;
        try {
            Class.forName(nomDriver);
        } catch (ClassNotFoundException e) {
            System.out.println("erreur: " + e.getMessage());
        }

        String url = "jdbc:mysql://localhost/pharmavie";
        String user = "root";
        String mp = "";
        try {
            connection = DriverManager.getConnection(url, user, mp);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("erreur de connection :" + e.getMessage());
        }
        return connection;
    }
    public static void closeConnection()
    {
        if(con!=null)
            con=null;
    }

    public static void main(String[] args) {
        Maconnexion.Connect();
    }
}
//si on ne prend pas d'objets de la classe connection on doit  mettre static et aussi mettre tous les variables static.
//cette classe est juste pour la connexion avec database(Control)
