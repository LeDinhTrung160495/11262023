package com.ra.controller;

import com.ra.model.Account;
import com.ra.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/accountController")
public class AccountController {
    @Autowired
    private AccountService accountService;
    private static final int SIZE = 3;
    private static String userNameDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "userName";
    private static int pageDefault = 1;

    @GetMapping("/findAccount")
    public ModelAndView displayAccount(Optional<String> userName, Optional<Integer> page, Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("account");
        userNameDefault = userName.orElse(userNameDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        List<Account> listAccount = accountService.displayData(userNameDefault, pageDefault - 1, SIZE, directionDefault, sortByDefault);
        List<Integer> listPages = accountService.getListPage(userNameDefault, SIZE);
        mav.addObject("listAccount", listAccount);
        mav.addObject("listPages", listPages);
        mav.addObject("userName", userNameDefault);
        mav.addObject("sortBy", sortByDefault);
        mav.addObject("direction", directionDefault);
        return mav;
    }
}

