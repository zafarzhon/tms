package com.teachmeskills.shop.web;

import com.teachmeskills.shop.dto.ProductDto;
import com.teachmeskills.shop.mapper.ProductMapper;
import com.teachmeskills.shop.service.ProductService;
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
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("product", new ProductDto());
        List<ProductDto> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "home";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute ProductDto productDto) {
        productService.createProduct(productDto);
        return "redirect:/storage";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        ProductDto productDtoById = productService.getProductById(id);
        if (productDtoById != null) {
            model.addAttribute("product", productDtoById);
            return "edit";
        }
        return "error";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute ProductDto productDto) {
        productService.updateProduct(productDto);
        return "redirect:/storage";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        ProductDto productById = productService.getProductById(id);
        productById.setIsRemoved(true);
        productService.updateProduct(productById);
        return "redirect:/storage";
    }

    @GetMapping("/return/{id}")
    public String returnProduct(@PathVariable("id") Integer id) {
        ProductDto productById = productService.getProductById(id);
        productById.setIsRemoved(false);
        productService.updateProduct(productById);
        return "redirect:/storage";
    }
}
