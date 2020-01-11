package com.example.demo.repository;

import com.example.demo.model.AccountPTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface AccountPTBRepository extends JpaRepository<AccountPTB, String> {
    AccountPTB save(AccountPTB accountPTB);
    List<AccountPTB> findAllByAccCode(String accCode);
    AccountPTB findByPtbCode(String ptbCode);
    AccountPTB findByPtbName(String ptbName);
    List<AccountPTB> findAllByPtbName(String ptbName);
    List<AccountPTB> findAllByPtbCode(String ptbCode);
    AccountPTB findByPtbBrand(String ptbBrand);
    List<AccountPTB> findAllByPtbBrand(String ptbBrand);
//    List<AccountPTB> findAllByPtbNameOrPtbBrand(String name, String brand);
    Set<AccountPTB> findAllByPtbNameOrPtbBrand(String name, String brand);
    @Transactional
    void deleteByPtbCode(String ptbCode);


}
