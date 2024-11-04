package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "\"order\"", schema = "public")
public class Order {
    @Id
    @Column(name = "\"customer id\"", nullable = false)
    private Integer customerId;

    @Column(name = "number", nullable = false, length = 10)
    private String number;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"customer id\"", nullable = false, insertable = false, updatable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "containing",
            joinColumns = @JoinColumn(name = "\"order customer id\"", referencedColumnName = "\"customer id\""),
            inverseJoinColumns = @JoinColumn(name = "\"product id\"")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Product> products = new HashSet<>();


    @Column(name = "discount", nullable = false, length = 4)
    private String discount;

    public Order(String number, LocalDate date, String discount, Integer customerId) {
        this.number = number;
        this.date = date;
        this.discount = discount;
        this.customerId = customerId;
    }

    public Order() {

    }

    public Collection<Product> getProducts () {
        return products;
    }

    public String getNumber() {
        return number;
    }


    // Constructors, getters, setters, equals, hashCode, etc.
}
