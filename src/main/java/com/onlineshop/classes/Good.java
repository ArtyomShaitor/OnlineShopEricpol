package com.onlineshop.classes;

//import java.util.ArrayList;
//import java.util.List;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;


/**
 * Created by HOME on 11.11.2014.
 */
@Entity
@Table(name = "Good")
public class Good implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    @NotNull
    private Long id;

//    @Column(name = "type_id")
//    @NotNull
//    private Long type_id;
//
//    @Column(name = "admin_id")
//    @NotNull
//    private Long admin_id;
//
//    @Column(name = "brand_id")
//    @NotNull
//    private Long brand_id;

    @Column(name = "price")
    @NotNull
    private double price;

    @Column(name = "title")
    @NotNull
    private  String title;

    @Column(name = "description")
    @NotNull
    private  String description;

    @Column(name = "cover_url")
    @NotNull
    private  String cover_url;


    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;


//    @Column(name = "admins")
//    @NotNull
//    private Set<Admin> admins;
//
//    @Column(name = "brands")
//    @NotNull
//    private Set<Brand> brands;
//
//    @Column(name = "types")
//    @NotNull
//    private Set<Type> types;


    public Good(){
    }



    public void setType(){
        this.type = new Type();
    }
    public void setType(Long type_id){
        this.type = new Type();
        this.type.setId(type_id);
    }

    public void setBrand(){
        this.brand = new Brand();
    }
    public void setBrand(Long brand_id){
        this.brand = new Brand();
        this.brand.setId(brand_id);
    }

    public void setAdmin(){
        this.admin = new Admin();
    }
    public void setAdmin(Long admin_id){
        this.admin = new Admin();
        this.admin.setId(admin_id);
    }

    public void setId(Long id){
        this.id = id;
    }
//    public void setType_id(Long id){
//        type.setId(id);
//    }
//    public void setAdmin_id(Long id){
//        this.admin.setId(id);
//    }
//    public void setBrand_id(Long id){
//        this.brand.setId(id);
//    }
    public void setPrice(double price){
        this.price = price;
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
        return type.getId();
    }
    public Long getAdmin_id(){
        return admin.getId();
    }
    public Long getBrand_id(){
        return brand.getId();
    }
    public double getPrice(){
        return price;
    }
//    public Set getAdmins(){
//        return admins;
//    }
//    public Set getBrand(){
//        return brands;
//    }
//    public Set getType(){
//        return types;
//    }
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
