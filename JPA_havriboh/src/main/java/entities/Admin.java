package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "admin", schema = "public", uniqueConstraints = {
        @UniqueConstraint(name = "admin_login_key", columnNames = {"login"})
})
public class Admin {
    @Id
    @ColumnDefault("nextval('admin_id_seq'::regclass)")
    @Column(name = "\"admin id\"", nullable = false)
    private Integer id;

    @Column(name = "login", nullable = false, length = 32)
    private String login;

    @Column(name = "password", nullable = false, length = 32)
    private String password;

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

}