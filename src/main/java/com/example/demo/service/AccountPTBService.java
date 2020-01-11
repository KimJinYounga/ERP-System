package com.example.demo.service;

import com.example.demo.model.AccountPTB;

public interface AccountPTBService {
    AccountPTB save(AccountPTB accountPTB);
    void deleteByPtbCode(String ptbCode);
//    void updateByAccCode(String no, AccountPTB accountPTB);

}
