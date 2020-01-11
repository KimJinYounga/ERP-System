package com.example.demo.service;

import com.example.demo.model.Material;
import com.example.demo.repository.MaterialReqository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service("MaterialService")
public class MaterialServicempl implements MaterialService  {
    private MaterialReqository materialRepository;

    @Override
    public List<Material> findAll(){
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(materialRepository.findAll());
    }
    @Override
    public List<Material> findByMaterialNameContainingAndMaterialCodeContaining(String materialName, String materialCode){
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(materialRepository.findByMaterialNameContainingAndMaterialCodeContaining(materialName, materialCode));
    }

    @Override
    public Material findByMaterialCode(String materialCode){
        return (materialRepository.findByMaterialCode(materialCode));
    }

    @Override
    public Material save(Material material){
      //  Material material = new Material();
        materialRepository.save(material);
        return material;

    }
    @Override
    public void delete(Material material){
        materialRepository.delete(material);
    }
   // @Override
   // public Material findOne(String materialCode){
   //     return materialRepository.findOne(materialCode);
  //  }

   // @Override
   // Material getMaterial(String materialCode){
   //     Material mat =
   // }
 //   @Override
//    public void update(Material material) {
 //       materialRepository.update(material);
//    }
    @Override
     public void updateMaterial(HttpServletRequest request){
        String materialCode = request.getParameter("materialCode");
        String materialName = request.getParameter("materialName");
        String materialMoney = request.getParameter("materialMoney");
     // String materialCode = request.getParameter("materialCode");



    }

    @Autowired
    public void setMaterialRepository(MaterialReqository materialRepository){
        this.materialRepository = materialRepository;
    }
}
