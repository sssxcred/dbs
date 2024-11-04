package dao;

import entities.Physical;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PhysicalDao extends BaseDao<Physical, Integer>{
    public PhysicalDao() {
        super(Physical.class);
    }

    public void create(String productNumber, String productName, BigDecimal productPrice, String model, String size, String manufacturerID, String shoppingWebsiteID, String color, String weight, String material) {
        Physical physical = new Physical(productNumber, productName, productPrice, model, size, manufacturerID, shoppingWebsiteID, color, weight, material);
        getEntityManager().persist(physical);
        System.out.println("Physical created: " + productName);
    }

    public void updateColorByNumber(String productNumber, String color) {
        if (productNumber == null) {
            return;
        }
        getEntityManager().createQuery("UPDATE Physical p SET p.color = :color WHERE p.productNumber = :productNumber")
                .setParameter("color", color)
                .setParameter("productNumber", productNumber)
                .executeUpdate();
        System.out.println("Physical with number: " + productNumber + " New color is: " + color);

    }

    public void updateWeightByNumber(String productNumber, String weight) {
        if (productNumber == null) {
            return;
        }
        getEntityManager().createQuery("UPDATE Physical p SET p.weight = :weight WHERE p.productNumber = :productNumber")
                .setParameter("weight", weight)
                .setParameter("productNumber", productNumber)
                .executeUpdate();
        System.out.println("Physical with number: " + productNumber + " New weight is: " + weight);

    }

    public void deleteByNumber(String productNumber) {
        if (productNumber == null) {
            return;
        }
        getEntityManager().createQuery("DELETE FROM Physical p WHERE p.productNumber = :productNumber")
                .setParameter("productNumber", productNumber)
                .executeUpdate();
        System.out.println("Physical with number: " + productNumber + " deleted");
    }
}
