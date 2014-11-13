package com.onlineshop.classes;

import java.util.Set;
import java.util.HashSet;
/**
 * Created by HOME on 11.11.2014.
 */
public class brands {
    private Long id;
    private String title;
    public Set brands = new HashSet();

    public brands(){

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
