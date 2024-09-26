package com.teachmeskills.homework39.controllers;

import com.teachmeskills.homework39.entities.Product;
import com.teachmeskills.homework39.services.DataBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Controller
@RequestMapping("/storage")
@RequiredArgsConstructor
public class MainController {
    private final DataBaseService dataBaseService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("product", new Product());
        List<Product> products = dataBaseService.getProducts();
        model.addAttribute("products", products);
        return "home";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Product product) {
        dataBaseService.addProduct(product);
        return "redirect:/storage";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Product productById = dataBaseService.getProductById(id);
        if (productById != null) {
            model.addAttribute("product", productById);
            return "edit";
        }
        return "error";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Product product) {
        dataBaseService.update(product);
        return "redirect:/storage";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        Product productById = dataBaseService.getProductById(id);
        productById.setIsRemoved(true);
        return "redirect:/storage";
    }

    @GetMapping("/return/{id}")
    public String returnProduct(@PathVariable("id") Integer id) {
        Product productById = dataBaseService.getProductById(id);
        productById.setIsRemoved(false);
        return "redirect:/storage";
    }

//    @GetMapping("/auto")
//    public String autoCreate() {
//
//        Product product = new Product(1, "cola", 2, 2.3, true);
//        Product product1 = new Product(2, "fanta", 2, 2.3, true);
//        Product product2 = new Product(3, "pepsi", 2, 2.3, true);
//        Product product3 = new Product(4, "sprite", 2, 2.3, true);
//        dataBaseService.addProduct(product);
//        dataBaseService.addProduct(product1);
//        dataBaseService.addProduct(product2);
//        dataBaseService.addProduct(product3);
//        return "redirect:/storage";
//    }
}
