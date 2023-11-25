package com.ra.serviceImp;

import com.ra.model.Account;
import com.ra.repository.LoginRepository;
import com.ra.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public boolean login(Account account) {
//        Account existingAccount = loginRepository.findByUserNameAndPasswordAndAccountStatusIsTrue
//                (account.getUserName(), account.getPassword(), account.isAccountStatus());
//        if (existingAccount != null) {
//            return true;
//        }
//        return false;
        throw new NotImplementedException();
    }
}
