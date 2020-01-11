package com.example.demo.repository;

import com.example.demo.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {
    List<Owner> findAllByOwnerType(String ownerType);
    Owner findByOwnerType(String ownerType);
    Owner save(Owner owner);
    Owner findByOwnerCode(String code);
}
