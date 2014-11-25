package com.onlineshop.classes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by HOME on 11.11.2014.
 */
@Entity
@Table(name = "Type")
public class Type implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    @NotNull
    private Long id;
    
    @Column(name = "title")
    @NotNull
    private String title;


    public Type() {
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
