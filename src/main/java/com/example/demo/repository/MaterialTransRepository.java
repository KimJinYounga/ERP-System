package com.example.demo.repository;

import com.example.demo.model.Account;
import com.example.demo.model.Material;
import com.example.demo.model.MaterialTrans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MaterialTransRepository extends JpaRepository<MaterialTrans, String> {
    public List<MaterialTrans> findByTransCode(String transCode);
    public List<MaterialTrans> findByAccount(Account account);
 //   public List<Account> findByAccNameContaining(String accName);
    public List<MaterialTrans> findByTransDateBetween(LocalDate start, LocalDate end);

//    public List<MaterialTrans> findByMaterialCode(String materialCode);
    public List<MaterialTrans> findByMaterial(Material material);
}
