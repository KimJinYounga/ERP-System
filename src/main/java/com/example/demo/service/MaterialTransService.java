package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Material;
import com.example.demo.model.MaterialTrans;

import java.time.LocalDate;
import java.util.List;

public interface MaterialTransService {
    List<MaterialTrans> findAll();

    List<MaterialTrans> findByAccount(Account account);
//    String getAccName();
 //   List<Account> findByAccNameContaining(String accName);
    // 날짜 검색 하기
   // List<MaterialTrans> findByTransDateAtBetween(LocalDate startDate, LocalDate finishDate);
     List<MaterialTrans> findByTransDateBetween(LocalDate start, LocalDate end);

 //  List<Account> findByAccNameContaining(String accName);
    List<MaterialTrans> findByTransCode(String transCode);



    List<MaterialTrans> findByMaterial(Material material);
 //   List<MaterialTrans> findByMaterialCode(String materialCode);
}
