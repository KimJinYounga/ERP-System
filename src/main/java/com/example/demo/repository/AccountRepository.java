package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//@Repository
@RepositoryDefinition(domainClass = Account.class, idClass = String.class)
public interface AccountRepository extends JpaRepository<Account, String> {
    public List<Account> findByAccNameContaining(String accName);
  //  public Account findOne(String accCode);
    public List<Account> findAllByAccCode(String accCode);


    Account findByAccName(String accName);
    Account findByAccCode(String accCode);
    Account findByOwnerCode(String ownerCode);
    List<Account> findAllByAccType(String accType);
    List<Account> findAllByOwnerCode(String ownerCode);
    //    @Query("select m from material m")
    List<Account> findAll();

    @Transactional
    void deleteByAccCode(String accCode);

}
