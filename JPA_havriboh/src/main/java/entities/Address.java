package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "address", schema = "public")
public class Address {
    @Id
    @ColumnDefault("nextval('address_customer id_seq'::regclass)")
    @Column(name = "\"customer id\"", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('address_customer id_seq'::regclass)")
    @JoinColumn(name = "\"customer id\"", nullable = false)
    private Customer customer;

    @Column(name = "street", nullable = false, length = 30)
    private String street;

    @Column(name = "city", nullable = false, length = 30)
    private String city;

    @Column(name = "state", nullable = false, length = 11)
    private String state;

    @Column(name = "\"postal code\"", nullable = false, length = 10)
    private String postalCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}