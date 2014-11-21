package com.onlineshop.classes;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by HOME on 11.11.2014.
 */
@Entity
@Table(name = "Admin")
public class Admin implements Serializable{
//    @Id @GeneratedValue
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "login")
//    private String login;
//
//    @Column(name = "password")
//    private byte password;

//    @Column(name = "goods")
//    private Set goods = new HashSet();
    @Id
    @GeneratedValue
    @Column(name = "id")
    @NotNull
    private Long id;

    @NotNull
    @Length(max = 30)
    @Column(name = "login")
    private String login;

    @NotNull
    @Length(max = 30)
    @Column(name = "password")
    private byte password;

    @OneToMany(mappedBy = "good")
    private Set<Good> goods;
    public Admin(){}

    public void setId(Long id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(byte password) {
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
    public byte getPassword(){
        return password;
    }
    public Set getGoods(){
        return goods;
    }
}
