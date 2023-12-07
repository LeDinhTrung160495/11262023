package com.ra.controller;

import com.ra.service.AccountService;
import com.ra.service.BillDetailService;
import com.ra.service.BillService;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/dashboardController")
public class DashboardController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BillService billService;
    @Autowired
    private BillDetailService billDetailService;
    @GetMapping(value = "/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView mav = new ModelAndView("dashboard");
        //Thống kê Account
        int accStatusTrue = accountService.statisticalAccountActive();
        int accStatusFalse=accountService.statisticalAccountInactive();
        int allAccount = accountService.getAllData().size();
        //Thống kê sản phẩm
        int productStatusTrue = productService.statisticalProductActive();
        int productStatusFalse=productService.statisticalProductInactive();
        int allProduct = productService.getAllData().size();
        //Thống kê đơn hàng
        int allBill = billService.getAllBill().size();
        int canceledBill = billService.statisticalCanceledBill();
        int waitingBill = billService.statisticalWaitingBill();
        int approvedBill = billService.statisticalApprovedBill();
        int deliveringBill = billService.statisticalDeliveringBill();
        int receivedBill = billService.statisticalReceivedBill();
        //Doanh thu
        float revenueInDay = billDetailService.revenueInDay();
        float revenueInMonth = billDetailService.revenueInMonth();
        float revenueInYear = billDetailService.revenueInYear();
        //Account
        mav.addObject("accStatusTrue",accStatusTrue);
        mav.addObject("accStatusFalse",accStatusFalse);
        mav.addObject("allAccount",allAccount);
        //Product
        mav.addObject("productStatusTrue",productStatusTrue);
        mav.addObject("productStatusFalse",productStatusFalse);
        mav.addObject("allProduct",allProduct);
        //Bill
        mav.addObject("allBill",allBill);
        mav.addObject("canceledBill",canceledBill);
        mav.addObject("waitingBill",waitingBill);
        mav.addObject("approvedBill",approvedBill);
        mav.addObject("deliveringBill",deliveringBill);
        mav.addObject("receivedBill",receivedBill);
        //Doanh thu
        mav.addObject("revenueInDay",revenueInDay);
        mav.addObject("revenueInMonth",revenueInMonth);
        mav.addObject("revenueInYear",revenueInYear);
        return mav;
    }
}
