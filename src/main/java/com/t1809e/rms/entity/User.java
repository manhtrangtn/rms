package com.t1809e.rms.entity;

import com.t1809e.rms.utility.constance.PropertyName;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "uzer")
public class User implements Serializable {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true, length = 50, nullable = false)
    private String id;
    @Column(name = PropertyName.USER_FIRST_NAME, length = 50, nullable = false)
    private String firstName;
    @Column(name = PropertyName.USER_LAST_NAME, length = 50, nullable = false)
    private String lastName;
    @Column(name = PropertyName.USER_BIRTH_DAY, nullable = false)
    private LocalDate birthDay;
    @Column(name = PropertyName.USER_GENDER, length = 7, nullable = false)
    private String gender;
    @Column(name = PropertyName.USER_CREATED_AT)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = PropertyName.USER_UPDATED_AT)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(unique = true, name = PropertyName.USER_USERNAME, length = 50, nullable = false)
    private String username;
    @Column(name = PropertyName.USER_PASSWORD, nullable = false)
    private String password;
    @Column(name = PropertyName.USER_PHONE, length = 15)
    private String phone;
    @Column(name = PropertyName.USER_STATUS, length = 15, nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserRole role;

}
