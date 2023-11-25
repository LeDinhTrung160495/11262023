package com.ra.repository;

import com.ra.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Account, Integer> {
//    Account findByUserNameAndPasswordAndAccountStatusIsTrue(String userName,String password,boolean status);
}
