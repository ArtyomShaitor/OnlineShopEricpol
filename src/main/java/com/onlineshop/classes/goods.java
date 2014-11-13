package com.onlineshop.classes;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Set;
import java.util.HashSet;
//import javax.persistence.*;


/**
 * Created by HOME on 11.11.2014.
 */
public class goods {
    private Long id, type_id, admin_id, brand_id;
    private double price;
    private  String title, description, cover_url;
    private Set admin = new HashSet();
    private Set brand = new HashSet();
    private Set type = new HashSet();


    public goods(){
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setType_id(Long id){
        this.type_id = id;
    }
    public void setAdmin_id(Long id){
        this.admin_id = id;
    }
    public void setBrand_id(Long id){
        this.brand_id = id;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setAdmin(Set admin){
        this.admin = admin;
    }
    public void setBrand(Set brand) {
        this.brand = brand;
    }
    public void setType(Set type) {
        this.type = type;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void  setCover_url(String cover_url){
        this.cover_url = cover_url;
    }

    public Long getId(){
        return id;
    }
    public Long getType_id(){
        return type_id;
    }
    public Long getAdmin_id(){
        return admin_id;
    }
    public Long getBrand_id(){
        return brand_id;
    }
    public double getPrice(){
        return price;
    }
    public Set getAdmin(){
        return admin;
    }
    public Set getBrand(){
        return brand;
    }
    public Set getType(){
        return type;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getCover_url(){
        return cover_url;
    }
}
