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
public class Category {

    private int cateID;
    private String cateName;
    private String cateDescription;
    private String cateURL;
    private String cateImageURL;

    public Category() {
    }

    public Category(int cateID, String cateName, String cateDescription, String cateURL, String cateImageURL) {
        this.cateID = cateID;
        this.cateName = cateName;
        this.cateDescription = cateDescription;
        this.cateURL = cateURL;
        this.cateImageURL = cateImageURL;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDescription() {
        return cateDescription;
    }

    public void setCateDescription(String cateDescription) {
        this.cateDescription = cateDescription;
    }

    public String getCateURL() {
        return cateURL;
    }

    public void setCateURL(String cateURL) {
        this.cateURL = cateURL;
    }

    public String getCateImageURL() {
        return cateImageURL;
    }

    public void setCateImageURL(String cateImageURL) {
        this.cateImageURL = cateImageURL;
    }

    @Override
    public String toString() {
        return "Category{" + "cateID=" + cateID + ", cateName=" + cateName + ", cateDescription=" + cateDescription + ", cateURL=" + cateURL + ", cateImageURL=" + cateImageURL + '}';
    }

    

}
