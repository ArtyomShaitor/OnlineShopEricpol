package com.onlineshop.classes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by HOME on 11.11.2014.
 */
@Entity
@Table(name = "Brand")
public class Brand implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    @NotNull
    private Long id;

    @NotNull
    @Column(name = "tittle")
    private String title;

    @OneToMany(mappedBy = "brand")
    private Set<Good> goods;

    public Brand(){

    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGoods(Set goods){
        this.goods = goods;
    }

    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public Set getGoods(){
        return goods;
    }
}
