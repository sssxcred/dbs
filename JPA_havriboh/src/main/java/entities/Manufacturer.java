package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "manufacturer", schema = "public")
public class Manufacturer {
    @Id
    @ColumnDefault("nextval('manufacturer_id_seq'::regclass)")
    @Column(name = "\"manufacturer id\"", nullable = false)
    private Integer id;

    @Column(name = "\"manufacturer name\"", nullable = false, length = 50)
    private String manufacturerName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

}