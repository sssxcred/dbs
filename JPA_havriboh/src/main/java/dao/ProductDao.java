package dao;

import entities.Product;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;


@Transactional
public class ProductDao extends BaseDao<Product, Integer> {
    public ProductDao() {
        super(Product.class);
    }

    public void create(String productNumber, String productName, BigDecimal productPrice, String model, String size, String manufacturerID, String shoppingWebsiteID) {
        Product product = new Product(productNumber, productName, productPrice, model, size, manufacturerID, shoppingWebsiteID);
        getEntityManager().persist(product);
        System.out.println("Product created: " + productName);
    }

    public void updatePriceByNumber(String productNumber, BigDecimal productPrice) {
        if (productNumber == null) {
            return;
        }
        getEntityManager().createQuery("UPDATE Product p SET p.productPrice = :productPrice WHERE p.productNumber = :productNumber")
                .setParameter("productPrice", productPrice)
                .setParameter("productNumber", productNumber)
                .executeUpdate();
        System.out.println("Product with number: " + productNumber + " New price is: " + productPrice);

    }

    public void deleteByNumber(String productNumber) {
        if (productNumber == null) {
            return;
        }
        getEntityManager().createQuery("DELETE FROM Product p WHERE p.productNumber = :productNumber")
                .setParameter("productNumber", productNumber)
                .executeUpdate();
        System.out.println("Product with number: " + productNumber + " deleted");
    }
}