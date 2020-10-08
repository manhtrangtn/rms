package com.t1809e.rms.entity;

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
    private String name;
    private String path;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(length = 15, nullable = false)
    private String status;
    @ManyToMany
    @JoinColumn(name = "sub_menu", referencedColumnName = "id", updatable = false, insertable = false)
    private List<Menu> subMenus;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "menu_role",
            joinColumns = { @JoinColumn(name = "menu_id") },
            inverseJoinColumns = {@JoinColumn(name = "role_id") })
    private List<UserRole> roles;
}
