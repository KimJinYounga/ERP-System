package com.example.demo.model;


//import jdk.vm.ci.meta.Local;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="\"material\"")
@Getter
@Setter
//@Data
//@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Material {
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="material_code")
    private String materialCode;

    @Column(name="material_name")
    private String materialName;

    @Column(name="material_money")
    private Integer materialMoney;

    @Column(name="material_inputdate")
    private LocalDateTime materialInputdate;

    @Column(name="material_inputid")
    private String materialInputid;

    @Column(name="material_modifyid")
    private String materialModifyid;

    @Column(name="material_modifydate")
    private LocalDateTime materialModifydate;

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    @OneToMany(mappedBy = "material")
    private List<MaterialTrans> materialtrans;

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public void setMaterialMoney(Integer materialMoney) {
        this.materialMoney = materialMoney;
    }

    public void setMaterialInputdate(LocalDateTime materialInputdate) {
        this.materialInputdate = materialInputdate;
    }

    public void setMaterialInputid(String materialInputid) {
        this.materialInputid = materialInputid;
    }

    public void setMaterialModifyid(String materialModifyid) {
        this.materialModifyid = materialModifyid;
    }

    public void setMaterialModifydate(LocalDateTime materialModifydate) {
        this.materialModifydate = materialModifydate;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public Integer getMaterialMoney() {
        return materialMoney;
    }

    public LocalDateTime getMaterialInputdate() {
        return materialInputdate;
    }

    public String getMaterialInputid() {
        return materialInputid;
    }

    public String getMaterialModifyid() {
        return materialModifyid;
    }

    public LocalDateTime getMaterialModifydate() {
        return materialModifydate;
    }

    public List<MaterialTrans> getMaterialtrans() {
        return materialtrans;
    }

    public Material(String materialCode, String materialName, int materialMoney, LocalDateTime materialInputdate, String materialInputid) {
        this.materialCode = materialCode;
        this.materialName=materialName;
        this.materialMoney=materialMoney;
        this.materialInputdate=materialInputdate;
        this.materialInputid = materialInputid;
    }
     /*  public Material(String materialCode, String materialName, String materialMoney, LocalDateTime materialInputdate, String materialInputid, String materialModifyid, LocalDateTime materialModifydate) {
        this.materialCode = materialCode;
        this.materialName=materialName;
        this.materialMoney=materialMoney;
        this.materialInputdate=materialInputdate;
        this.materialInputid = materialInputid;
        this.materialModifyid = materialModifyid;
        this.materialModifydate = materialModifydate;
    }*/

}
