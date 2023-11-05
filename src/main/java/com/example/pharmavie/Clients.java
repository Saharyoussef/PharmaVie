package com.example.pharmavie;

public class Clients {
    public int ID;
    public String Name,Email,Tel;
    public double Orders;

    public Clients(int ID, String name, String email, String tel, double orders) {
        this.ID = ID;
        Name = name;
        Email = email;
        Tel = tel;
        Orders = orders;
    }

    public Clients() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public double getOrders() {
        return Orders;
    }

    public void setOrders(double orders) {
        Orders = orders;
    }
}
