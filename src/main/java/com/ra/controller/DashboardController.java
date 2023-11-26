package com.ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dashboardController")
public class DashboardController {
    @GetMapping(value = "/product")
    public String showDashboard() {
        return "";
    }
}
