/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author Marshallein
 */
public class Cart implements Serializable {

    private int id;
    private String cname;
    private int price;
    private String imageURL;
    private int amount;

    public Cart() {
    }

    public Cart(int id, String cname, int price, String imageURL, int amount) {
        this.id = id;
        this.cname = cname;
        this.price = price;
        this.imageURL = imageURL;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", cname=" + cname + ", price=" + price + ", imageURL=" + imageURL + ", amount=" + amount + '}';
    }

}
