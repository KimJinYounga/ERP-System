package com.example.demo.service;

import com.example.demo.model.Owner;
import com.example.demo.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepository ownerRepository;


    public void delete(Owner code) {
        ownerRepository.delete(code);

    }
    @Override
    public Owner save(Owner owner) {
        ownerRepository.save(owner);
        return owner;

    }


}
