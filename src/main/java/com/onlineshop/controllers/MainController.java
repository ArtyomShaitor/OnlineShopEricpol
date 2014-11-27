package com.onlineshop.controllers;

import com.onlineshop.classes.DataBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Artyom on 10.11.2014.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/Catalog", method = RequestMethod.GET)
    public String catalogPage(){
        return "catalog";
    }

    @RequestMapping(value = "/Catalog/{title}", method = RequestMethod.GET)
    public String catalogItemPage(@PathVariable String title){
        return "catalog-item";
    }

    @RequestMapping(value = "/Test")
    public String testPage(){
        DataBase db = new DataBase();
        db.addType("Laptop3");
        return "test";
    }

    @RequestMapping(value = "/Search", method = RequestMethod.GET)
    public String searchPage(){
        return "search";
    }

}
