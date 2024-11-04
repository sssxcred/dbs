package entities;

import jakarta.persistence.*;
import main.Main;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "product", schema = "public", indexes = {
        @Index(name = "idx_product_name", columnList = "product name")
}, uniqueConstraints = {
        @UniqueConstraint(name = "product_product name_manufacturer id_model_key", columnNames = {"product name", "manufacturer id", "model"})
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"product id\"", nullable = false)
    private Integer id;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();


    @Column(name = "\"product price\"", nullable = false, precision = 8, scale = 2)
    private BigDecimal productPrice;

    @Column(name = "\"product number\"", nullable = false, length = 12)
    private String productNumber;

    @Column(name = "\"product name\"", nullable = false, length = 127)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"manufacturer id\"", nullable = false)
    private Manufacturer manufacturerId;

    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @Column(name = "size", length = 20)
    private String size;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"shopping website id\"", nullable = false)
    private ShoppingWebsite shoppingWebsiteId;

    public Product() {

    }

    public Product(String productNumber, String productName, BigDecimal productPrice,String model, String size, String manufacturerID, String shoppingWebsiteID) {
        this.productName = productName;
        this.productNumber = productNumber;
        this.productPrice = productPrice;
        this.model = model;
        this.size = size;
        this.manufacturerId = findManufacturerById(manufacturerID);
        this.shoppingWebsiteId = findWebsiteById(shoppingWebsiteID);

    }

    private Manufacturer findManufacturerById(String manufacturerId) {
        EntityManager em = Main.getEntityManager();
        return em.createQuery("SELECT m FROM Manufacturer m WHERE m.id = :id", Manufacturer.class)
                .setParameter("id", Integer.parseInt(manufacturerId)).getSingleResult();
    }

    private ShoppingWebsite findWebsiteById(String shoppingWebsiteId) {
        EntityManager em = Main.getEntityManager();
        return em.createQuery("SELECT sw FROM ShoppingWebsite sw WHERE sw.id = :id", ShoppingWebsite.class)
                .setParameter("id", Integer.parseInt(shoppingWebsiteId))
                .getSingleResult();
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getProductName() {
        return productName;
    }


    // Getters and setters
}
