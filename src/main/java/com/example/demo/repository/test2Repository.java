package com.example.demo.repository;

import com.example.demo.model.test2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface test2Repository extends JpaRepository<test2, String> {
    //test2 findByTestid(String testid);
  //  @SuppressWarnings("unchecked")
  //  public List<Map<String, Object>> selecttest2List(Map<String, Object> map){
   //     return (List<Map<String, Object>>)selectList("selecttest2List", map);
  //  }

}
