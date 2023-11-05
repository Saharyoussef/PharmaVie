package com.example.pharmavie;

public class Admin {
    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin() {
        this.username = username;
        this.password = password;
    }
}
//cette classe est pour data (Model) relié à la base de données.les memes attributs dans la base donnée.
//on a dans la base de donnée une table admin qui contient 2 attributs : username, password
