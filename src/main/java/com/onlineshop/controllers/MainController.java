package com.onlineshop.controllers;

import com.onlineshop.DataBase.DataBase;
import com.onlineshop.classes.*;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.io.File;

/**
 * Created by Artyom on 10.11.2014.
 */

@Controller
public class MainController implements ServletContextAware {

    final double MAX_PRICE = 1000000;
    final double MIN_PRICE = 0;

    private DataBase db = new DataBase();

    private List<Type> typeList = db.getTypesList();
    private List<Brand> brandList = db.getBrandsList();

    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(Model model) {
        List<Type> list = db.getTypesList();
        model.addAttribute("itemList", list);
        return "index";
    }

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

    @RequestMapping(value = {"/Admin", "/Admin/"}, method = RequestMethod.GET)
    public String adminPage(){
        return "redirect:/Admin/Panel";
    }

    @RequestMapping(value = {"/Admin/Panel", "/Admin/Panel/"}, method = RequestMethod.GET)
    public String panelPage(Model model){
        List<Good> list = db.getGoodsInInterval(0, 0);

        model.addAttribute("itemList", list);
        return "panel";
    }

    @RequestMapping(value = "/Admin/Panel/Delete/{id}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable Long id){

        db.removeGood(id);
        return "redirect:/Admin/Panel";
    }

    @RequestMapping(value = "/Admin/Panel/Add", method = RequestMethod.GET)
    public String addItem(@RequestParam Map<String, String> params, Model model){

        Good good = new Good();
        good.setType();
        good.setBrand();

        if (params.get("error") == null || params.get("error") == "")
            model.addAttribute("error", "");
        else model.addAttribute("error", "Вы не выбрали изображение");

        model.addAttribute("Title", "Добавить");
        model.addAttribute("submitValue", "Добавить");
        model.addAttribute("typeList", typeList);
        model.addAttribute("brandList", brandList);
        model.addAttribute("mainItem", good);
        model.addAttribute("action", "AddItem");
        return "item";
    }

    @RequestMapping(value = "/Admin/Panel/Edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable Long id, Model model){

        if(id == null || id == 0) return "redirect:/Admin/Panel";

        Good good = db.getCatalogItem(id);

        model.addAttribute("Title", "Изменить");
        model.addAttribute("submitValue", "Сохранить");
        model.addAttribute("typeList", typeList);
        model.addAttribute("brandList", brandList);
        model.addAttribute("mainItem", good);
        model.addAttribute("action", "EditItem");
        return "item";
    }


    @RequestMapping(value = "/EditItem", method = RequestMethod.GET)
    public String editItemScript(@RequestParam Map<String, String> allRequestParams, Model model){

        return "redirect:/Admin/Panel";
    }

    @RequestMapping(value = "/AddItem", method = RequestMethod.POST)
    public String addItemScript(@RequestParam Map<String, String> p,
                                @RequestParam(value = "cover_url", required = false) MultipartFile image,
                                Model model) throws IOException {
        if (image.getSize() == 0) return "redirect:/Admin/Panel/Add?error=true";

        String filename = String.valueOf( Random(100000000,999999999) ) + String.valueOf( Random(100000000,999999999) )+".jpg";

        String title = p.get("title");
        Long type_id = Long.valueOf(p.get("type_id"));
        String description = p.get("description");
        Double price = Double.valueOf(p.get("price"));
        Long admin_id = Long.valueOf(1);
        Long brand_id = Long.valueOf(p.get("brand_id"));

        db.addGood(title, type_id, description, price, admin_id, brand_id, filename);

        saveImage(filename, image);
        return "redirect:/Admin/Panel";
    }



    private void saveImage(String filename, MultipartFile image)
            throws RuntimeException, IOException {
        try {
            File file = new File(servletContext.getRealPath("/res/catalog") + "/"
                    + filename);

            FileUtils.writeByteArrayToFile(file, image.getBytes());
            System.out.println("Go to the location:  " + file.toString()
                    + " on your computer and verify that the image has been stored.");
        } catch (IOException e) {
            throw e;
        }
    }

    private int Random(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }


}
