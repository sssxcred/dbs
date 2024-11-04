package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "statistics", schema = "public")
public class Statistic {
    @EmbeddedId
    private StatisticId id;

    @MapsId("shoppingWebsiteId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"shopping website id\"", nullable = false)
    private ShoppingWebsite shoppingWebsiteId;

    @Column(name = "sales", nullable = false, precision = 10, scale = 2)
    private BigDecimal sales;

    @Column(name = "\"number of orders\"", nullable = false)
    private Integer numberOfOrders;

    public StatisticId getId() {
        return id;
    }

    public void setId(StatisticId id) {
        this.id = id;
    }

    public ShoppingWebsite getShoppingWebsiteId() {
        return shoppingWebsiteId;
    }

    public void setShoppingWebsiteId(ShoppingWebsite shoppingWebsiteId) {
        this.shoppingWebsiteId = shoppingWebsiteId;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

}