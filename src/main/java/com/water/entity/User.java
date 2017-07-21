package com.water.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    private String idUser;
    private String password;
    private String name;
    private String address;
    private String number;
    private Integer isResearcher;
    private Collection<Apply> appliesByIdUser;

    @Id
    @Column(name = "idUser", nullable = false, length = 255)
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "number", nullable = true, length = 45)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "isResearcher", nullable = true)
    public Integer getIsResearcher() {
        return isResearcher;
    }

    public void setIsResearcher(Integer isResearcher) {
        this.isResearcher = isResearcher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != null ? !idUser.equals(user.idUser) : user.idUser != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (number != null ? !number.equals(user.number) : user.number != null) return false;
        if (isResearcher != null ? !isResearcher.equals(user.isResearcher) : user.isResearcher != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser != null ? idUser.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (isResearcher != null ? isResearcher.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "userByIdUser")
//    public Collection<Apply> getAppliesByIdUser() {
//        return appliesByIdUser;
//    }
//
//    public void setAppliesByIdUser(Collection<Apply> appliesByIdUser) {
//        this.appliesByIdUser = appliesByIdUser;
//    }
}
