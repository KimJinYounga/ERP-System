package com.example.demo.service;

import com.example.demo.model.test2;
import com.example.demo.repository.test2Repository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.*;


@Transactional
@Service("test2Service")
public class test2Servicempl implements test2Service{
    private test2Repository test2Repository;

   // @Override
   // public List<Map<String, Object>> selecttest2List(Map<String, Object>map) throws Exception {
   //     return test2Repository.selecttest2List(map);
   // }
    @Override
    public List<test2> findAll(){
     //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(test2Repository.findAll());
    }

 /*   @Override
    public test2 findByTestid(String testid){
        return test2Repository.findByTestid(testid).get();
    }
*/

    @Autowired
    public void setTest2Repository(test2Repository test2Repository){
        this.test2Repository = test2Repository;
    }
}
