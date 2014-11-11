package com.onlineshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Artyom on 10.11.2014.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(ModelMap model) {

        model.addAttribute("message", "Hello, World!");
        return "index";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String namePage(@PathVariable String name, ModelMap model) {

        model.addAttribute("name", name);
        return "name";
    }
}
