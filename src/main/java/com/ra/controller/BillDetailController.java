package com.ra.controller;


import com.ra.model.BillDetail;
import com.ra.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("billDetailController")
public class BillDetailController {
    @Autowired
    private BillDetailService billDetailService;
    private static  final int SIZE = 3;
    private static String billIdDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "billDetailId";
    private static int pageDefault = 1;
    @GetMapping("/findBillDetail")
    public ModelAndView displayBillDetail(Optional<String> billId, Optional<Integer>page,
                                          Optional<String>direction, Optional<String>sortBy, Optional<Integer>billId1){
        ModelAndView mav = new ModelAndView("billDetails");
        billIdDefault = billId.orElse(billIdDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        List<BillDetail> billDetailList = billDetailService.displayData(billIdDefault,
                pageDefault-1,SIZE,directionDefault, sortByDefault);
        //Lấy danh sách các trang theo kết quả.
        List<Integer>listPages = billDetailService.getListPage(billIdDefault,SIZE);
        mav.addObject("listBillDetail", billDetailList);
        mav.addObject("listPages", listPages);
        mav.addObject("billId",billIdDefault);
        mav.addObject("sortBy",sortByDefault);
        mav.addObject("direction", directionDefault);
        return  mav;
    }
}
