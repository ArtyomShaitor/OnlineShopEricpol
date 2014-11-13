package com.onlineshop.classes;

/**
 * Created by HOME on 11.11.2014.
 */
public class types {
    private Long id;
    private String title;


    public types() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
}
