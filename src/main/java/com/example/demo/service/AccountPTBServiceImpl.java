package com.example.demo.service;

import com.example.demo.model.AccountPTB;
import com.example.demo.repository.AccountPTBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountPTBServiceImpl implements AccountPTBService {
    @Autowired
    AccountPTBRepository accountPTBRepository;

    @Override
    public AccountPTB save(AccountPTB accountPTB) {
        accountPTBRepository.save(accountPTB);
        return accountPTB;
    }

    @Override
    public void deleteByPtbCode(String ptbCode) {
        accountPTBRepository.deleteByPtbCode(ptbCode);
    }
}
