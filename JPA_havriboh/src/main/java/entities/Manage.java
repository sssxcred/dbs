package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "manage", schema = "public", uniqueConstraints = {
        @UniqueConstraint(name = "manage_admin manage_key", columnNames = {"admin manage"}),
        @UniqueConstraint(name = "manage_shopping website manage_key", columnNames = {"shopping website manage"})
})
public class Manage {
    @EmbeddedId
    private ManageId id;

    @MapsId("adminManage")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"admin manage\"", nullable = false)
    private Admin adminManage;

    @MapsId("shoppingWebsiteManage")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"shopping website manage\"", nullable = false)
    private ShoppingWebsite shoppingWebsiteManage;

    public ManageId getId() {
        return id;
    }

    public void setId(ManageId id) {
        this.id = id;
    }

    public Admin getAdminManage() {
        return adminManage;
    }

    public void setAdminManage(Admin adminManage) {
        this.adminManage = adminManage;
    }

    public ShoppingWebsite getShoppingWebsiteManage() {
        return shoppingWebsiteManage;
    }

    public void setShoppingWebsiteManage(ShoppingWebsite shoppingWebsiteManage) {
        this.shoppingWebsiteManage = shoppingWebsiteManage;
    }

}