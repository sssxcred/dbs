package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "digital", schema = "public")
@PrimaryKeyJoinColumn(name = "\"product id\"")
public class Digital extends entities.Product {
    @Column(name = "\"file size\"", nullable = false, length = 20)
    private String fileSize;

    @Column(name = "\"file type\"", nullable = false, length = 10)
    private String fileType;

    @Column(name = "version", nullable = false, length = 10)
    private String version;

    @Column(name = "license", nullable = false, length = Integer.MAX_VALUE)
    private String license;

    public Digital() {
    }

    public Digital(String productNumber, String productName, BigDecimal productPrice, String model, String size, String manufacturerID, String shoppingWebsiteID, String fileSize, String fileType, String version, String license) {
        super(productNumber, productName, productPrice, model, size, manufacturerID, shoppingWebsiteID);
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.version = version;
        this.license = license;
    }
}
