package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Material;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.MaterialReqository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("AccountService")
public class AccountServicempl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<Account> findAll(){
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(accountRepository.findAll());
    }

    @Override
    public List<Account> findByAccNameContaining(String accName){
        return Lists.newArrayList(accountRepository.findByAccNameContaining(accName));
    }

    @Override
    public List<Account> findAllByAccCode(String accCode){
        return Lists.newArrayList(accountRepository.findAllByAccCode(accCode));
    }

 //   @Override
 //   public Account findOne(String accCode){
 //       return accountRepository.findOne(accCode);
//    }
    @Autowired
    public void setAccountRepository(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        accountRepository.save(account);
        return account;
    }

    @Override
    public void updateByAccCode(String accCode, Account account) {

        Account e = accountRepository.findByAccCode(accCode);

        // 모든 컬럼들을 전부 get으로 가져와서 set해줘야함.
        e.setAccBank(account.getAccBank());
        e.setAccSimple(account.getAccSimple());
        e.setAccCode(account.getAccCode());
        e.setAccName(account.getAccName());
        e.setOwnerCode(account.getOwnerCode());
        e.setAccAddress(account.getAccAddress());
        e.setAccPhone(account.getAccPhone());
        e.setAccEmail(account.getAccEmail());
        e.setAccAccNumber(account.getAccAccNumber());
        e.setAccDate(account.getAccDate());
        e.setAccAccHolder(account.getAccAccHolder());
        e.setAccType(account.getAccType());


        accountService.save(account);

    }

    @Override
    public void deleteByAccCode(String accCode) {
        accountRepository.deleteByAccCode(accCode);
    }
}
