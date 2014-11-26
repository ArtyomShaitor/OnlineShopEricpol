package com.onlineshop.controllers;

import com.onlineshop.DataBase.DataBase;
import com.onlineshop.classes.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Artyom on 10.11.2014.
 */
@Controller
public class MainController {

    private DataBase db = new DataBase();

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

        return "test";
    }

    @RequestMapping(value = "/Brand/{brand}", method = RequestMethod.GET)
    public String brandPage(@PathVariable String brand, Model model){
        List<Good> list = db.searchItemsByBrand(brand);

        model.addAttribute("itemList", list);
        return "test";
    }

    @RequestMapping(value = "/Search", method = RequestMethod.GET)
    public String searchPage(){
        return "search";
    }

}
