package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ManageId implements java.io.Serializable {
    private static final long serialVersionUID = -2892397273273068884L;
    @Column(name = "\"admin manage\"", nullable = false)
    private Integer adminManage;

    @Column(name = "\"shopping website manage\"", nullable = false)
    private Integer shoppingWebsiteManage;

    public Integer getAdminManage() {
        return adminManage;
    }

    public void setAdminManage(Integer adminManage) {
        this.adminManage = adminManage;
    }

    public Integer getShoppingWebsiteManage() {
        return shoppingWebsiteManage;
    }

    public void setShoppingWebsiteManage(Integer shoppingWebsiteManage) {
        this.shoppingWebsiteManage = shoppingWebsiteManage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ManageId entity = (ManageId) o;
        return Objects.equals(this.shoppingWebsiteManage, entity.shoppingWebsiteManage) &&
                Objects.equals(this.adminManage, entity.adminManage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingWebsiteManage, adminManage);
    }

}