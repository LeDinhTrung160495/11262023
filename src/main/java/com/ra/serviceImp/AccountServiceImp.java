package com.ra.serviceImp;

import com.ra.model.Account;
import com.ra.model.Categories;
import com.ra.repository.AccountRepository;
import com.ra.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> displayData(String userName, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        List<Account> listAccount = accountRepository.findByUserName(userName, pageable).getContent();
        return listAccount;
    }

    @Override
    public List<Account> getAllData() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAllDataByAccStatusTrue() {
        return accountRepository.findAllByAccountStatusIsTrue();
    }

    @Override
    public Account findById(int accId) {
        return accountRepository.findById(accId).get();
    }

    @Override
    public boolean saveOrUpdate(Account account) {
        try {
            accountRepository.save(account);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int accId) {
        try {
            accountRepository.delete(findById(accId));
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int statisticalAccountActive() {
        return accountRepository.statisticalAccountActive();
    }

    @Override
    public int getStatisticalAccountInactive() {
        return accountRepository.statisticalAccountInActive();
    }

    @Override
    public List<Integer> getListPage(String userName, int size) {
        int countAccount = accountRepository.countByUserNameContains(userName);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < (int) Math.ceil((double) countAccount / (double) size); i++) {
            listPage.add(i + 1);
        }
        return listPage;
    }
}
