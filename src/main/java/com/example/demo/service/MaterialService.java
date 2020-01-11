package com.example.demo.service;

import com.example.demo.model.Material;
import com.example.demo.model.test2;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MaterialService {
    List<Material> findAll();
    Material save(Material material);
    void delete(Material material);
//    Material findOne(String materialCode);
 //   public void update(Material material);
    void updateMaterial(HttpServletRequest request);
    List<Material> findByMaterialNameContainingAndMaterialCodeContaining(String materialName, String materialCode);
    Material findByMaterialCode(String MaterialCode);
//    Material findOne(String materialCode);
 //   Material getMaterial(String materialCode);
}
