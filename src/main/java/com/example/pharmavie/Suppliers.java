package com.example.pharmavie;

public class Suppliers {
    public String Name,Email,Tel,Adress,Brand;
    public int ID;

    public Suppliers(String name, String email, String tel, String adress, String brand, int ID) {
        Name = name;
        Email = email;
        Tel = tel;
        Adress = adress;
        Brand = brand;
        this.ID = ID;
    }

    public Suppliers() {

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

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
