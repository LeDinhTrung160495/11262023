package com.ra.service;

import com.ra.model.Account;
import com.ra.model.Categories;

import java.util.List;

public interface AccountService {
    List<Account> displayData(String userName, int page, int size, String direction, String sortBy);

    List<Account> getAllData();

    List<Account> getAllDataByAccStatusTrue();

    Account findById(int accId);

    boolean saveOrUpdate(Account account);

    boolean delete(int accId);

    int statisticalAccountActive();

    int getStatisticalAccountInactive();

    List<Integer> getListPage(String userName, int size);
}
