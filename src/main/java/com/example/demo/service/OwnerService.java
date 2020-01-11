package com.example.demo.service;

import com.example.demo.model.Owner;

public interface OwnerService {
    Owner save(Owner owner);
    void delete(Owner code);
}
