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

    public User() {
    }

    public User(String id, String firstName, String lastName, LocalDate birthDay, String gender, LocalDateTime createdAt, LocalDateTime updatedAt, String username, String password, String phone, String status, UserRole role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", gender='" + gender + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", role=" + role +
                '}';
    }
}
