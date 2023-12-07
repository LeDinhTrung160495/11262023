package com.ra.controller;

import com.ra.model.Bill;
import com.ra.model.Categories;
import com.ra.model.Images;
import com.ra.model.Product;
import com.ra.service.BillService;
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
@RequestMapping("/billController")
public class BillController {
    @Autowired
    private BillService billService;
    private static final int SIZE = 3;
    private static String billIdDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "billId";
    private static int pageDefault = 1;

    @GetMapping("/findBill")
    public ModelAndView displayBill(Optional<String> billId, Optional<Integer> page, Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("bills");
        billIdDefault = billId.orElse(billIdDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        List<Bill> listBill = billService.displayData(billIdDefault, pageDefault - 1, SIZE, directionDefault, sortByDefault);
        List<Integer> listPages = billService.getListPage(billIdDefault, SIZE);
        mav.addObject("listBill", listBill);
        mav.addObject("listPages", listPages);
        mav.addObject("billId", billIdDefault);
        mav.addObject("sortBy", sortByDefault);
        mav.addObject("direction", directionDefault);
        return mav;
    }

    @GetMapping(value = "/cancelBill")
    public String cancelBill(String billId) {
        if (billService.cancelBill(billId)) {
            return "redirect:findBill";
        } else {
            return "error";
        }
    }
}

