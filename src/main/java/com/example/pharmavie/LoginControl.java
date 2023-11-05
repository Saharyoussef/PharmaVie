package com.example.pharmavie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginControl {
    Statement st;
    //c'est au rapport à sql
    String type;
    Connection con=null;
    /*public boolean login (Admin a) throws SQLException {
            con=Maconnexion.Connect();
            con=Maconnexion.Connect();
            //.connect:pour ouvrir une connexion avec la base de donnée
            //.createStatement :manipuler avec les commandes de sql
            String check="Select * from admin where username= '"+a.getUsername()+"' and password='"+a.getPassword()+"'";
            ResultSet rs= st.executeQuery(check);
            //rs est un tableau qui contient résultat de la commande select
            while(rs.next())
            {
                type=rs.getString(3);
                return true;
            }
        return false;
    }*/
    public boolean login(Admin a) throws SQLException {
        con = Maconnexion.Connect();
        // Créer un objet Statement
        st = con.createStatement();
        // Utiliser l'objet Statement pour exécuter la requête SQL
        String check = "SELECT * FROM admin WHERE username = '" + a.getUsername() + "' AND password = '" + a.getPassword() + "'";
        ResultSet rs = st.executeQuery(check);
        // rs est un tableau qui contient résultat de la commande select
        while (rs.next()) {
            type = rs.getString(2);
            return true;
        }
        return false;
    }

}
//cette classe est pour controler l'interface graphique de longin(control)Toutes les opérations nécessaires.
