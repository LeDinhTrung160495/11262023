package com.ra.controller;

import com.ra.model.Product;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    private static final int SIZE = 3;
    private static String productNameDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "productId";
    private static int pageDefault = 1;

    @GetMapping("/findProduct")
    public ModelAndView displayProduct(Optional<String> productName, Optional<Integer> page,
                                       Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("products");
        productNameDefault=productName.orElse(productNameDefault);
        directionDefault=direction.orElse(directionDefault);
        sortByDefault=sortBy.orElse(sortByDefault);
        pageDefault=page.orElse(pageDefault);
        //Lấy dữ liệu hiển thị
        List<Product> listProducts = productService.displayData(productNameDefault,pageDefault-1,SIZE,
                directionDefault,sortByDefault);
        //Lấy ra danh sách các trang theo kết quả tìm kiếm
        List<Integer> listPages = productService.getListPage(productNameDefault,SIZE);
        mav.addObject("listProducts",listProducts);
        mav.addObject("listPages",listPages);
        mav.addObject("productName",productNameDefault);
        mav.addObject("sortBy",sortByDefault);
        mav.addObject("direction",directionDefault);
        return mav;
    }
}
