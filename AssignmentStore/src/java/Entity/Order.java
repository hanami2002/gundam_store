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
public class Order {

    private int orderID;
    private int accID;
    private String listOfOrder;
    private double totalMoney;
    private String address;
    private int phone;
    private String note;
    private String customer;
    private String date;
    private String status;

    public Order() {
    }

    public Order(int orderID, int accID, String listOfOrder, double totalMoney, String address, int phone, String note, String customer, String date, String status) {
        this.orderID = orderID;
        this.accID = accID;
        this.listOfOrder = listOfOrder;
        this.totalMoney = totalMoney;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.customer = customer;
        this.date = date;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getListOfOrder() {
        return listOfOrder;
    }

    public void setListOfOrder(String listOfOrder) {
        this.listOfOrder = listOfOrder;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", accID=" + accID + ", listOfOrder=" + listOfOrder + ", totalMoney=" + totalMoney + ", address=" + address + ", phone=" + phone + ", note=" + note + ", customer=" + customer + ", date=" + date + ", status=" + status + '}';
    }

}
