package model;

import java.util.Date;

public class Sale {
    private int id;
    private Date date;
    private String seller;
    private String product;
    private String category;
    private double value;

    public Sale(int id, Date date, String seller, String product, String category, double value) {
        this.id = id;
        this.date = date;
        this.seller = seller;
        this.product = product;
        this.category = category;
        this.value = value;
    }

    public String getSeller() { return seller; }
    public String getCategory() { return category; }
    public double getValue() { return value; }
}