package com.onlineshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.hibernate.Session;

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

    @RequestMapping(value = "/Search", method = RequestMethod.GET)
    public String searchPage(){
        return "search";
    }

}
