package com.masai.service;

import com.masai.exception.AccountException;
import com.masai.model.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    public String createAccount(Account account);
    public Account updateAccount(Account account) throws AccountException;
    public Account viewAccount();
    public Account viewAccountByName(String name) throws AccountException;
}
