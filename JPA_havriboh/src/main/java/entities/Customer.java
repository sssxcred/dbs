package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "customer", schema = "public", uniqueConstraints = {
        @UniqueConstraint(name = "customer_login_key", columnNames = {"login"})
})
public class Customer {
    @Id
    @ColumnDefault("nextval('customer_id_seq'::regclass)")
    @Column(name = "\"customer id\"", nullable = false)
    private Integer id;

    @Column(name = "login", nullable = false, length = 32)
    private String login;

    @Column(name = "password", nullable = false, length = 32)
    private String password;

    @Column(name = "\"first name\"", nullable = false, length = 30)
    private String firstName;

    @Column(name = "\"last name\"", nullable = false, length = 30)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"recommended id\"")
    private Customer recommendedId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Customer getRecommendedId() {
        return recommendedId;
    }

    public void setRecommendedId(Customer recommendedId) {
        this.recommendedId = recommendedId;
    }

}