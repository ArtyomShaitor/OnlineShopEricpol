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
public class MainController{

    private DataBase db = new DataBase();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/Catalog", method = RequestMethod.GET)
    public String catalogPage(Model model){
        List<Good> list = db.getGoodsInInterval(0,0);
        model.addAttribute("itemList", list);
        return "catalog";
    }


    @RequestMapping(value = "/Catalog/Brand/{brand}", method = RequestMethod.GET)
    public String brandPage(@PathVariable String brand, Model model){
        List<Good> list = db.searchItemsByBrand(brand);
        List<Type> listType = db.getTypesList();
        List<Brand> listBrand = db.getBrandsList();

        model.addAttribute("listType", listType);
        model.addAttribute("listBrand", listBrand);
        model.addAttribute("mainType", "");
        model.addAttribute("mainBrand", brand);

        model.addAttribute("itemListCount", list.size());
        model.addAttribute("itemList", list);
        return "catalog";
    }

    @RequestMapping(value = "/Catalog/Type/{type}", method = RequestMethod.GET)
    public String typePage(@PathVariable String type, Model model){
        List<Good> list = db.searchItemsByType(type);
        List<Type> listType = db.getTypesList();
        List<Brand> listBrand = db.getBrandsList();

        model.addAttribute("listType", listType);
        model.addAttribute("listBrand", listBrand);
        model.addAttribute("mainType", type);
        model.addAttribute("mainBrand", "");

        model.addAttribute("itemListCount", list.size());
        model.addAttribute("itemList", list);
        return "catalog";
    }

    @RequestMapping(value = "/Catalog/Product/{id}", method = RequestMethod.GET)
    public String catalogItemPage(@PathVariable Long id, Model model){
        Good good = db.getCatalogItem(id);
        model.addAttribute("item", good);
        return "catalog-item";
    }

    @RequestMapping(value = "/Search/{query}", method = RequestMethod.GET)
    public String searchByQuery(@PathVariable String query, Model model){
        List<Good> list = db.searchItemsByQuery(query);
        List<Type> listType = db.getTypesList();
        List<Brand> listBrand = db.getBrandsList();

        model.addAttribute("listType", listType);
        model.addAttribute("listBrand", listBrand);
        model.addAttribute("mainType", "");
        model.addAttribute("mainBrand", "");

        model.addAttribute("itemListCount", list.size());
        model.addAttribute("queryText", query);
        model.addAttribute("itemList", list);
        return "search";
    }

}
