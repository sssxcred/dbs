package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "\"shopping website\"", schema = "public", uniqueConstraints = {
        @UniqueConstraint(name = "shopping website_url_key", columnNames = {"url"}),
        @UniqueConstraint(name = "shopping website_name_key", columnNames = {"name"})
})
public class ShoppingWebsite {
    @Id
    @ColumnDefault("nextval('shopping website_id_seq'::regclass)")
    @Column(name = "\"shopping website id\"", nullable = false)
    private Integer id;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "\"contact number\"", nullable = false, length = 9)
    private String contactNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}