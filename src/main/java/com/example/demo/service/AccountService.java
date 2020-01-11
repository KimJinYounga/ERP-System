package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Material;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    List<Account> findByAccNameContaining(String accName);
    List<Account> findAllByAccCode(String accCode);
 //   Account findOne(String accCode);

    Account save(Account account);
    void updateByAccCode(String no, Account account);
    void deleteByAccCode(String accCode);


}
