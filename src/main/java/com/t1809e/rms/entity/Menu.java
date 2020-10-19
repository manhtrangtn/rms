package com.t1809e.rms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.t1809e.rms.utility.constance.PropertyName;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Menu {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true, length = 50, nullable = false)
    private String id;
    @Column(name = PropertyName.MENU_NAME, nullable = false)
    private String name;
    @Column(name = PropertyName.MENU_PATH)
    private String path;
    @CreationTimestamp
    @Column(name = PropertyName.MENU_CREATED_AT)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = PropertyName.MENU_UPDATED_AT)
    private LocalDateTime updatedAt;
    @Column(name = PropertyName.MENU_STATUS, length = 15, nullable = false)
    private String status;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_menu", referencedColumnName = "id", updatable = false, insertable = false)
    private List<Menu> subMenus;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "menu_role",
            joinColumns = { @JoinColumn(name = "menu_id") },
            inverseJoinColumns = {@JoinColumn(name = "role_id") })
    private List<UserRole> roles;

    public Menu() {
    }

    public Menu(String id, String name, String path, LocalDateTime createdAt, LocalDateTime updatedAt, String status, List<Menu> subMenus, List<UserRole> roles) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.subMenus = subMenus;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status='" + status + '\'' +
                ", subMenus=" + subMenus +
                ", roles=" + roles +
                '}';
    }
}
