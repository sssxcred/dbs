package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "physical", schema = "public")
@PrimaryKeyJoinColumn(name = "\"product id\"")
public class Physical extends Product {
    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "material", nullable = false, length = 50)
    private String material;

    @Column(name = "weight", nullable = false, length = 20)
    private String weight;

    public Physical() {
    }

    public Physical(String productNumber, String productName, BigDecimal productPrice, String model, String size, String manufacturerID, String shoppingWebsiteID, String color, String weight, String material) {
        super(productNumber, productName, productPrice, model, size, manufacturerID, shoppingWebsiteID);
        this.color = color;
        this.weight = weight;
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}

