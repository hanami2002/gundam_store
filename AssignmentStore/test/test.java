
import DAO.AccountDAO;
import DAO.CategoryDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import Entity.Account;
import Entity.Category;
import Entity.Order;
import Entity.Product;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marshallein
 */
public class test {

    public static void main(String[] args) {
        CategoryDAO catedao = new CategoryDAO();
        ProductDAO prodao = new ProductDAO();
        AccountDAO accdao = new AccountDAO();

        Account acc = accdao.getAccount("Antran", "1234");
        ArrayList<Category> listC = catedao.getAllCategory();
        ArrayList<Product> listP = prodao.pagingProduct(1);
        //        System.out.println(listC);
        //        System.out.println(listP);
//        Product news = new Product(28, "lmoa", 27, "lmao", "lmao", 1, 1);
//
//        prodao.addProduct(news);
//        Account newss = new Account(6, "test1", "1234", 1, 0);

//        accdao.addAccount(newss);
//        accdao.deleteAccount("13");
//        Category e = catedao.getOneCate("2");
        OrderDAO orddao = new OrderDAO();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

    }
}
