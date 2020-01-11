package com.example.demo.repository;

import com.example.demo.model.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MaterialReqository extends JpaRepository<Material, String> {
    //Material findMaterialBy(String materialCode);
   // Material findAllBy();
    public Material save(Material material);
    public void delete(Material material);
 //   public Material findOne(String materialCode);
   public List<Material> findByMaterialNameContainingAndMaterialCodeContaining(String materialName, String materialCode);
   public Material findByMaterialCode(String MaterialCode);
 //  public Material
   // Page<Material> findByMaterialName(String name, Pageable pageable);
  // public void update(Material material);

}
