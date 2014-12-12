package com.onlineshop.classes;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by HOME on 11.11.2014.
 */
@Entity
@Table(name = "Admin")
public class Admin implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id")
    @NotNull
    private Long id;

    @Length(max = 30)
    @Column(name = "login")
    @NotNull
    private String login;

    @Length(max = 30)
    @Column(name = "password")
    @NotNull
    private String password;

    @OneToMany(mappedBy = "admin")
    private Set<Good> goods;

    public Admin(){}

    public void setId(Long id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setGoods(Set goods){
        this.goods = goods;
    }

    public Long getId(){
        return id;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public Set getGoods(){
        return goods;
    }
}
