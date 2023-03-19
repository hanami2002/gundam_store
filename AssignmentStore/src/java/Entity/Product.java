/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Marshallein
 */
public class Product {

    private int id;
    private String pname;
    private int price;
    private String imageURL;
    private String description;
    private int sellID;
    private int cateID;

    public Product() {
    }

    public Product(int id, String pname, int price, String imageURL, String description, int sellID, int cateID) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.imageURL = imageURL;
        this.description = description;
        this.sellID = sellID;
        this.cateID = cateID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSellID() {
        return sellID;
    }

    public void setSellID(int sellID) {
        this.sellID = sellID;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", pname=" + pname + ", price=" + price + ", imageURL=" + imageURL + ", description=" + description + ", sellID=" + sellID + ", cateID=" + cateID + '}';
    }

}
