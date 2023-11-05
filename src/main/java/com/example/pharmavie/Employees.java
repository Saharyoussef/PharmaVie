package com.example.pharmavie;

public class Employees {
    public int ID;
    public String Name,Email,Tel,Adress,Position;

    public Employees(int ID, String name, String email, String tel, String adress, String position) {
        this.ID = ID;
        Name = name;
        Email = email;
        Tel = tel;
        Adress = adress;
        Position = position;
    }

    public Employees() {

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

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }
}
