package com.example.demo.controller;


import com.example.demo.model.Material;
import com.example.demo.model.Member;
import com.example.demo.model.SomeData;
import com.example.demo.model.test2;
import com.example.demo.repository.MaterialReqository;
import com.example.demo.service.MaterialService;
import com.example.demo.service.test2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@Slf4j
@Controller
public class MaterialController {
    private MaterialService materialService;
    private MaterialReqository materialReqository;
    /*
    @RequestMapping("/enroll_res")
    // @PostMapping("/listMaterial")
    public String ListMaterial(Model uiModel) {

        if (request.getParameter("searchName") == null && request.getParameter("searchCode") == null){
            List<Material> materials = materialService.findAll();
        uiModel.addAttribute("materials", materials);

    }

        if(request.getParameter("searchName") != null) {
            List<Material> materials = materialReqository.findByMaterialName(request.getParameter("searchName"));
            uiModel.addAttribute("materials", materials);
            // Account account = accountRepository.findByAccName(4);
        }
        return "enroll_res";
        map.put("searchName", request.getParameter("searchName"));
        map.put("searchCode", request.getParameter("searchCode"));q

    }*/
    /* 2
    @RequestMapping("/searchMaterial")
    public String searchMaterial( @ModelAttribute("material") Material material, Map<String, Object> map,
                           HttpServletRequest request) {
        List<Material> materials1 = materialService.findByMaterialName(request.getParameter("searchName"));

        map.put("searchName", request.getParameter("searchName"));
        map.put("searchCode", request.getParameter("searchCode"));

        return ("enroll_res");
    }*/
    @RequestMapping("/searchMaterial")
    public String searchMaterial( Model uiModel, HttpServletRequest request) {
        List<Material> materials1 = materialService.findByMaterialNameContainingAndMaterialCodeContaining(request.getParameter("searchName"), request.getParameter("searchCode"));

        uiModel.addAttribute("materials1", materials1);
        return "search_res";
    }
 /*   @RequestMapping("/tableClick")
    public String tableClick(Model uiModel, HttpServletRequest request){
        System.out.println("값 넘어옴");
        List<Material> materials2 = materialService.findByMaterialCode(request.getParameter("tableClickcode"));

        uiModel.addAttribute("materials2", materials2);
        return "search_res";
    }*/

  /*  @RequestMapping("/tableClick/updateMaterial")
        public String updateMaterial(Model uiModel, HttpServletRequest request) {
        System.out.println(1);
            //  List<Material> materials = materialService.findAll();
            //     //   uiModel.addAttribute("materials", materials);
            String materialCode = request.getParameter("materialCode");
            String materialName = request.getParameter("materialName");
            String Money = request.getParameter("materialMoney");
            int materialMoney = Integer.parseInt(Money);
         //   LocalDateTime materialInputdate = LocalDateTime.now();
            List<Material>  material = materialReqository.findByMaterialCode(materialCode);
        //    Material material = new Material(materialCode, materialName, materialMoney, materialInputdate);
            Material mat = material.get(0);
        material.get(0).setMaterialName(materialName);
        material.get(0).setMaterialModifydate(LocalDateTime.now());
        material.get(0).setMaterialMoney(materialMoney);
        System.out.println(1);
            System.out.println("mat.materialCode = " + mat.getMaterialCode());


          //  Material material_ = materialReqository.findOne(materialCode);
   //     material_.setMaterialName(materialName);
   //     material_.setMaterialModifydate(LocalDateTime.now());
    //    material_.setMaterialMoney(materialMoney);

        materialReqository.save(material.get(0));
    //        materialReqository.save(material_);
            return "search_res";
        }
*/  String materialCode1;
    @GetMapping("/tableClick/{materialCode}")
    public String updateMaterial(@PathVariable("materialCode") String materialCode, HttpServletRequest request, Model uiModel,Model uiModel1) {
        List<Material> materials = materialService.findAll();
        uiModel1.addAttribute("materials", materials);
        Material materialss = materialService.findByMaterialCode(materialCode);
        uiModel.addAttribute("materials2", materialss);
        materialCode1 = materialCode;
        if(materialCode.equals("updateMaterial")){
            System.out.println("abc");
            materialCode1 = request.getParameter("materialCode");
            String materialName = request.getParameter("materialName");
            String Money = request.getParameter("materialMoney");
            int materialMoney = Integer.parseInt(Money);

            HttpSession sess = request.getSession();
            Member a=(Member)sess.getAttribute("loginSuccess");
            String id=a.getMemId();

            System.out.println("materialCode = " + materialCode);
            System.out.println("materialCode = " + materialCode1);

            Material  material = materialReqository.findByMaterialCode(materialCode1);
            //    Material material = new Material(materialCode, materialName, materialMoney, materialInputdate);
            Material mat = material;
            material.setMaterialName(materialName);
            material.setMaterialModifydate(LocalDateTime.now());
            material.setMaterialMoney(materialMoney);
            material.setMaterialModifyid(id);
            System.out.println(1);
            System.out.println("mat.materialCode = " + mat.getMaterialCode());

        //    mat.setMaterialName(materialName);
        //    mat.setMaterialModifydate(LocalDateTime.now());
        //    mat.setMaterialMoney(materialMoney);

          //  materialReqository.save(mat);
            materialReqository.save(material);
        }
        if(materialCode.equals("deleteMaterial")){
         //   String materialCode1 = request.getParameter("materialCode");
            System.out.println("delete - materialCode = " + materialCode);
         //   List<Material>  material = materialReqository.findByMaterialCode(materialCode1);
        //    Material mat = material.get(0);
        //    materialReqository.delete(mat);
        }

        return "search_res";
    }
    @RequestMapping("/deleteMaterial")
    public String deleteMaterial(Model uiModel, HttpServletRequest request) {


   //     String materialCode = request.getParameter("materialCode");
     //   Material mat = materialReqository.findOne(materialCode1);
     //   List<Material>  material = materialReqository.findByMaterialCode(materialCode);
        System.out.println("delete - materialCode = " + materialCode1);
        Material  material = materialReqository.findByMaterialCode(materialCode1);

        materialReqository.delete(material);
        List<Material> materials = materialService.findAll();
        uiModel.addAttribute("materials", materials);
        return "search_res";
    }

    @RequestMapping("/search_res")
 //   @PostMapping("/search_res/{materialCode}")
    public String updateMaterial(Model uiModel) {
        List<Material> materials = materialService.findAll();
        uiModel.addAttribute("materials", materials);
        return "search_res";
    }
    @RequestMapping("/saveMaterial")
    public String saveMaterial(Model uiModel, HttpServletRequest request) {
      //  List<Material> materials = materialService.findAll();
        //     //   uiModel.addAttribute("materials", materials);
        String materialCode = request.getParameter("materialCode");
        String materialName = request.getParameter("materialName");
        String Money = request.getParameter("materialMoney");
        int materialMoney = Integer.parseInt(Money);
        LocalDateTime materialInputdate = LocalDateTime.now();
        HttpSession sess = request.getSession();
        Member a=(Member)sess.getAttribute("loginSuccess");
        String id=a.getMemId();

        Material material = new Material(materialCode, materialName, materialMoney, materialInputdate, id);
        materialReqository.save(material);


        return "enroll_res";
    }

    @Autowired
    public void setMaterialService(MaterialService materialService){ this.materialService = materialService;}

    @Autowired
    public void setMaterialReqository(MaterialReqository materialReqository){ this.materialReqository = materialReqository;}


}
