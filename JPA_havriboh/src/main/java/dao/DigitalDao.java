package dao;

import entities.Digital;

import java.math.BigDecimal;

public class DigitalDao extends BaseDao<Digital, Integer>{


    public DigitalDao() {
        super(Digital.class);
    }


    public void create(String productNumber, String productName, BigDecimal productPrice, String model, String size, String manufacturerID, String shoppingWebsiteID, String fileSize, String fileType, String version, String license) {
        Digital digital = new Digital(productNumber, productName, productPrice, model, size, manufacturerID, shoppingWebsiteID, fileSize, fileType, version, license);
        getEntityManager().persist(digital);
        System.out.println("Digital created: " + productName);
    }

    public void updateVersionByNumber(String productNumber, String version) {
        if (productNumber == null) {
            return;
        }
        getEntityManager().createQuery("UPDATE Digital d SET d.version = :version WHERE d.productNumber = :productNumber")
                .setParameter("version", version)
                .setParameter("productNumber", productNumber)
                .executeUpdate();
        System.out.println("Digital with number: " + productNumber + " New version is: " + version);
    }

    public void deleteByNumber(String productNumber) {
        if (productNumber == null) {
            return;
        }
        getEntityManager().createQuery("DELETE FROM Digital d WHERE d.productNumber = :productNumber")
                .setParameter("productNumber", productNumber)
                .executeUpdate();
        System.out.println("Digital with number: " + productNumber + " deleted");
    }
}
