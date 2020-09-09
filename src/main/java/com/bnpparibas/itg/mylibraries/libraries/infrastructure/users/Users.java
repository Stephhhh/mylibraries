package com.bnpparibas.itg.mylibraries.libraries.infrastructure.users;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class Users {

    @Id
    private String username;

    private String password;

    private boolean active;

    @ElementCollection
    @Column(name = "ROLES")
    private List<String> roles;

    public Users() {
    }

    public Users(String username, String password, boolean active, List<String> roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
