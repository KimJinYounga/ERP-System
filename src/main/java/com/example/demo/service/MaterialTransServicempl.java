package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Material;
import com.example.demo.model.MaterialTrans;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.MaterialReqository;
import com.example.demo.repository.MaterialTransRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Service("MaterialTransService")
public class MaterialTransServicempl implements MaterialTransService{

    private MaterialTransRepository materialTransRepository;
 //   private AccountRepository accountRepository;

    @Override
    public List<MaterialTrans> findByTransCode(String transCode){
        return Lists.newArrayList(materialTransRepository.findByTransCode(transCode));
    }
 //   @Override
  //  public List<Account> findByAccNameContaining(String accName){
 //       return Lists.newArrayList(accountRepository.findByAccNameContaining(accName));
 //   }
    @Override
    public List<MaterialTrans> findAll(){
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(materialTransRepository.findAll());
    }
    @Override
    public List<MaterialTrans> findByAccount(Account account){
        return Lists.newArrayList(materialTransRepository.findByAccount(account));

    }
    @Override
    public List<MaterialTrans> findByMaterial(Material material){
        return Lists.newArrayList(materialTransRepository.findByMaterial(material));
    }
//    @Override
//    public List<MaterialTrans> findByMaterialCode(String materialCode){
//        return Lists.newArrayList(materialTransRepository.findByMaterialCode(materialCode));
//    }
    @Override
    public List<MaterialTrans> findByTransDateBetween(LocalDate start, LocalDate end) {
        return Lists.newArrayList(materialTransRepository.findByTransDateBetween(start, end));

    }

 //   @Override
//    public List<MaterialTrans> findByAccCodeContaining(String accName){
       // List<Account> accList = accountRepository.findByAccNameContaining(accName);
       // String accname = accList.getAccName();
     //   return Lists.newArrayList(materialTransRepository.findByAccCodeContaining(accList.getAccCode()));
 //       return Lists.newArrayList(materialTransRepository.findAll());
 //   }

    @Autowired
    public void setMaterialTransRepository(MaterialTransRepository materialtransRepository){
        this.materialTransRepository = materialtransRepository;
    }
 //   @Autowired
 //   public void setAccountRepository(AccountRepository accountRepository){
 //       this.accountRepository = accountRepository;
 //   }
}
