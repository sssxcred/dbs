package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.Objects;

@Embeddable
public class StatisticId implements java.io.Serializable {
    private static final long serialVersionUID = 5945076924219258959L;
    @Column(name = "\"shopping website id\"", nullable = false)
    private Integer shoppingWebsiteId;

    @ColumnDefault("now()")
    @Column(name = "\"date of creation statics\"", nullable = false)
    private Instant dateOfCreationStatics;

    public Integer getShoppingWebsiteId() {
        return shoppingWebsiteId;
    }

    public void setShoppingWebsiteId(Integer shoppingWebsiteId) {
        this.shoppingWebsiteId = shoppingWebsiteId;
    }

    public Instant getDateOfCreationStatics() {
        return dateOfCreationStatics;
    }

    public void setDateOfCreationStatics(Instant dateOfCreationStatics) {
        this.dateOfCreationStatics = dateOfCreationStatics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StatisticId entity = (StatisticId) o;
        return Objects.equals(this.dateOfCreationStatics, entity.dateOfCreationStatics) &&
                Objects.equals(this.shoppingWebsiteId, entity.shoppingWebsiteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfCreationStatics, shoppingWebsiteId);
    }

}