package com.ra.repository;

import com.ra.model.Account;
import com.ra.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("select a from Account a where a.userName like %?1%")
    Page<Account> findByUserName(String userName, Pageable pageable);

    int countByUserNameContains(String userName);

    List<Account> findAll();
    List<Account> findAllByAccountStatusIsTrue();

    @Query("SELECT COUNT(ac) FROM Account ac WHERE ac.accountStatus = true")
    int statisticalAccountActive();

    @Query("select count(ac) from Account ac where ac.accountStatus = false ")
    int statisticalAccountInActive();
}
