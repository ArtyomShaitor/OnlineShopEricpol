package com.onlineshop.classes;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by HOME on 11.11.2014.
 */
public class admins implements Serializable{
    private Long id;
    private String login;
    private byte password;
    private Set goods = new HashSet();

    public admins(){

    }

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
