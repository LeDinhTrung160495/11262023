package com.ra.controller;

import com.ra.model.Categories;
import com.ra.model.Images;
import com.ra.model.Product;
import com.ra.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categoriesController")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;
    private static final int SIZE = 3;
    private static String catalogNameDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "catalogId";
    private static int pageDefault = 1;

    @GetMapping("/findCatalog")
    public ModelAndView displayCatalog(Optional<String> catalogName, Optional<Integer> page, Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("categories");
        catalogNameDefault = catalogName.orElse(catalogNameDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        List<Categories> listCatalog = categoriesService.displayData(catalogNameDefault, pageDefault - 1, SIZE, directionDefault, sortByDefault);
        List<Integer> listPages = categoriesService.getListPage(catalogNameDefault, SIZE);
        mav.addObject("listCatalog", listCatalog);
        mav.addObject("listPages", listPages);
        mav.addObject("catalogName", catalogNameDefault);
        mav.addObject("sortBy", sortByDefault);
        mav.addObject("direction", directionDefault);
        return mav;
    }

    @GetMapping(value = "/initCreate")
    public String initCreateCatalog(ModelMap modelMap) {
        Categories catalog = new Categories();
        modelMap.addAttribute("catalog", catalog);
        return "newCatalog";
    }

    @PostMapping(value = "/create")
    public String createCatalog(Categories catalog) {
        if (categoriesService.save(catalog)) {
            return "redirect:findCatalog";
        } else {
            return "error";
        }
    }
}
