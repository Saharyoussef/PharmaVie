package com.example.pharmavie;

public class Products {
    public int ID;
    public double Price,Number;
    public String Name,Type;

    public Products(int ID, double price, double number, String name, String type) {
        this.ID = ID;
        Price = price;
        Number = number;
        Name = name;
        Type = type;
    }

    public Products() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getNumber() {
        return Number;
    }

    public void setNumber(double number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
