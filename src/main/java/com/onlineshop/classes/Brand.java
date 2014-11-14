package com.onlineshop.classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by HOME on 11.11.2014.
 */
@Entity
@Table(name = "Brand")
public class Brand implements Serializable {
    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "brands")
    public Set brands = new HashSet();

    public Brand(){

    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBrands(Set brands){
        this.brands = brands;
    }

    private Long getId(){
        return id;
    }
    private String getTitle(){
        return title;
    }
    private Set getBrands(){
        return brands;
    }
}
