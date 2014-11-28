package com.onlineshop.controllers;

import com.onlineshop.DataBase.DataBase;
import com.onlineshop.classes.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Artyom on 10.11.2014.
 */

@Controller
public class MainController{

    final double MAX_PRICE = 1000000;
    final double MIN_PRICE = 0;

    private DataBase db = new DataBase();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(Model model) {
        List<Type> list = db.getTypesList();
        model.addAttribute("itemList", list);
        return "index";
    }

//    @RequestMapping(value = "/Catalog", method = RequestMethod.GET)
//    public String catalogPage(Model model){
//        List<Good> list = db.getGoodsInInterval(0,0);
//        list = db.getGoodsBetweenPrice(list, MIN_PRICE, MAX_PRICE);
//        model.addAttribute("itemList", list);
//        return "catalog";
//    }

    @RequestMapping(value = {"/Catalog/", "/Catalog"}, method = RequestMethod.GET)
    public String catalogParamsPage(
            @RequestParam Map<String, String> allRequestParams,
            Model model
    ){
        String brand = allRequestParams.get("Brand");
        String type = allRequestParams.get("Type");
        double max_price, min_price;

        if (brand == "")
            brand = null;
        if (type == "")
            type = null;

        if ( allRequestParams.get("MAX_PRICE") == null || allRequestParams.get("MAX_PRICE") == "" ) {
            max_price = MAX_PRICE;
            model.addAttribute("maxPrice", "");
        } else {
            max_price = Double.parseDouble( allRequestParams.get("MAX_PRICE") );
            model.addAttribute("maxPrice", allRequestParams.get("MAX_PRICE"));
        }

        if ( allRequestParams.get("MIN_PRICE") == null || allRequestParams.get("MIN_PRICE") == "" ) {
            min_price = MIN_PRICE;
            model.addAttribute("minPrice", "");
        } else {
            min_price = Double.parseDouble( allRequestParams.get("MIN_PRICE") );
            model.addAttribute("minPrice", allRequestParams.get("MIN_PRICE"));
        }

        List<Good> list = db.searchItemsByBrandAndType(brand, type);
        List<Type> listType = db.getTypesList();
        List<Brand> listBrand = db.getBrandsList();

        list = db.getGoodsBetweenPrice(list, min_price, max_price);

        model.addAttribute("listType", listType);
        model.addAttribute("listBrand", listBrand);
        model.addAttribute("mainType", type);
        model.addAttribute("mainBrand", brand);

        model.addAttribute("itemListCount", list.size());
        model.addAttribute("itemList", list);
        return "catalog";
    }

//    @RequestMapping(value = "/Catalog/Brand={brand}&Type={type}", method = RequestMethod.GET)
//    public String brandPage(@PathVariable String brand, @PathVariable String type, Model model){
//        List<Good> list = db.searchItemsByBrandAndType(brand, type);
//        List<Type> listType = db.getTypesList();
//        List<Brand> listBrand = db.getBrandsList();
//
//        list = db.getGoodsBetweenPrice(list, MIN_PRICE, MAX_PRICE);
//
//        model.addAttribute("listType", listType);
//        model.addAttribute("listBrand", listBrand);
//        model.addAttribute("mainType", type);
//        model.addAttribute("mainBrand", brand);
//
//        model.addAttribute("itemListCount", list.size());
//        model.addAttribute("itemList", list);
//        return "catalog";
//    }

//    @RequestParam(value = "Brand") String brand,
//    @RequestParam(value = "Type")  String type,
//    @RequestParam(value = "MAX_PRICE") double max_price,
//    @RequestParam(value = "MIN_PRICE") double min_price,

//    @RequestMapping(value = "/Catalog", method = RequestMethod.GET)
//    public String brandPage(Model model){
//        List<Good> list = db.searchItemsByBrandAndType(brand, type);
//        List<Type> listType = db.getTypesList();
//        List<Brand> listBrand = db.getBrandsList();
//
//        if (min_price == 0) min_price = MIN_PRICE;
//        if (max_price == 0) max_price = MAX_PRICE;
//
//        list = db.getGoodsBetweenPrice(list, min_price, max_price);
//
//        model.addAttribute("listType", listType);
//        model.addAttribute("listBrand", listBrand);
//        model.addAttribute("mainType", type);
//        model.addAttribute("mainBrand", brand);
//
//        model.addAttribute("itemListCount", list.size());
//        model.addAttribute("itemList", list);
//        return "catalog";
//    }

//    @RequestMapping(value = "/Catalog/Max_Price={max_price}", method = RequestMethod.GET)
//    public String maxPricePage(@PathVariable double max_price, Model model){
//        List<Good> list = db.getGoodsInInterval(0,0);
//        list = db.getGoodsBetweenPrice(list, MIN_PRICE, max_price);
//        List<Type> listType = db.getTypesList();
//        List<Brand> listBrand = db.getBrandsList();
//
//        model.addAttribute("listType", listType);
//        model.addAttribute("listBrand", listBrand);
//        model.addAttribute("mainType", "");
//        model.addAttribute("mainBrand", "");
//
//        model.addAttribute("itemListCount", list.size());
//        model.addAttribute("itemList", list);
//        return "catalog";
//    }
//
//    @RequestMapping(value = "/Catalog/Min_Price={min_price}", method = RequestMethod.GET)
//    public String minPricePage(@PathVariable double min_price, Model model){
//        List<Good> list = db.getGoodsInInterval(0,0);
//        list = db.getGoodsBetweenPrice(list, min_price, MAX_PRICE);
//        List<Type> listType = db.getTypesList();
//        List<Brand> listBrand = db.getBrandsList();
//
//        model.addAttribute("listType", listType);
//        model.addAttribute("listBrand", listBrand);
//        model.addAttribute("mainType", "");
//        model.addAttribute("mainBrand", "");
//
//        model.addAttribute("itemListCount", list.size());
//        model.addAttribute("itemList", list);
//        return "catalog";
//    }
//
//    @RequestMapping(value = "/Catalog/Max_Price={max_price}&Min_Price={min_price}", method = RequestMethod.GET)
//    public String minPricePage(@PathVariable double min_price, @PathVariable double max_price, Model model){
//        List<Good> list = db.getGoodsInInterval(0,0);
//        list = db.getGoodsBetweenPrice(list, min_price, max_price);
//        List<Type> listType = db.getTypesList();
//        List<Brand> listBrand = db.getBrandsList();
//
//        model.addAttribute("listType", listType);
//        model.addAttribute("listBrand", listBrand);
//        model.addAttribute("mainType", "");
//        model.addAttribute("mainBrand", "");
//
//        model.addAttribute("itemListCount", list.size());
//        model.addAttribute("itemList", list);
//        return "catalog";
//    }

//    @RequestMapping(value = "/Catalog/Brand={brand}", method = RequestMethod.GET)
//    public String brandPage(@PathVariable String brand, Model model){
//        List<Good> list = db.searchItemsByBrand(brand);
//        List<Type> listType = db.getTypesList();
//        List<Brand> listBrand = db.getBrandsList();
//
//        list = db.getGoodsBetweenPrice(list, MIN_PRICE, MAX_PRICE);
//
//        model.addAttribute("listType", listType);
//        model.addAttribute("listBrand", listBrand);
//        model.addAttribute("mainType", "");
//        model.addAttribute("mainBrand", brand);
//
//        model.addAttribute("itemListCount", list.size());
//        model.addAttribute("itemList", list);
//        return "catalog";
//    }
//
//    @RequestMapping(value = "/Catalog/Type={type}", method = RequestMethod.GET)
//    public String typePage(@PathVariable String type, Model model){
//        List<Good> list = db.searchItemsByType(type);
//        List<Type> listType = db.getTypesList();
//        List<Brand> listBrand = db.getBrandsList();
//
//        list = db.getGoodsBetweenPrice(list, MIN_PRICE, MAX_PRICE);
//
//        model.addAttribute("listType", listType);
//        model.addAttribute("listBrand", listBrand);
//        model.addAttribute("mainType", type);
//        model.addAttribute("mainBrand", "");
//
//        model.addAttribute("itemListCount", list.size());
//        model.addAttribute("itemList", list);
//        return "catalog";
//    }
//
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
