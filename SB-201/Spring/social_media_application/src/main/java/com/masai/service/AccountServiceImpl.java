package com.masai.service;

import com.masai.component.CurrentUser;
import com.masai.exception.AccountException;
import com.masai.model.Account;
import com.masai.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String createAccount(Account account) {
        if(account == null) throw new AccountException("Invalid account details, please provide a valid details.");
        accountRepository.save(account);
        return "Account create with name: " + account.getName();
    }

    /**
     * Update own account details like name, dob, email, password
     * @param acc
     * @return String message like 'the account is updated'
     * @throws AccountException
     */
    @Override
    public String updateAccount(Account acc) throws AccountException {
        System.out.println("-------- Account is going to update of " + currentUser.getCurrentUserName() + " --------");
        Account account = accountRepository.findByEmail(currentUser.getCurrentUserName()).orElseThrow( () -> new AccountException("Invalid user!"));
        if(acc.getName() != null) account.setName(acc.getName());
        if(acc.getDob() != null) account.setDob(acc.getDob());
        if(acc.getEmail() != null) account.setEmail(acc.getEmail());
        if(acc.getPassword() != null) account.setPassword(passwordEncoder.encode(acc.getPassword()));
        accountRepository.save(account);
        return account.getName() + "'s account is updated.";
    }

    /**
     * View the own account
     * @return Account
     */
    @Override
    public Account viewAccount() {
        Account account = accountRepository.findByEmail(currentUser.getCurrentUserName()).orElseThrow( () -> new AccountException("Invalid user!"));
        return account;
    }

    /**
     * Searching anyone's account with name
     * @param name
     * @return Account
     * @throws AccountException
     */
    @Override
    public Account viewAccountByName(String name) throws AccountException {
        System.out.println("-------- Searching the account of " + name + " --------");
        Account account = accountRepository.findByName(name);
        if(account == null) throw new AccountException("Not found any User with name: " + name);
        return account;
    }
}
