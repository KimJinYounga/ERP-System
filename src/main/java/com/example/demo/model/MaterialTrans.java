package com.example.demo.model;


//import jdk.vm.ci.meta.Local;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="\"material_trans\"")
@Getter
@Setter
//@Data
//@AllArgsConstructor
@NoArgsConstructor

public class MaterialTrans {

    @Id
    @Column(name = "trans_code")
    private String transCode;

    @ManyToOne
    @JoinColumn(name = "material_code")
//    @Column(name = "material_code")
//    private String materialCode;
    private Material material;

    @ManyToOne
    @JoinColumn(name = "acc_code")
//    @Column(name = "acc_code")
    private Account account;
//    private String accCode;

    @Column(name = "trans_date")
    private LocalDate transDate;

    @Column(name = "trans_num")
    private int transNum;

    @Column(name = "trans_money")
    private int transMoney;

    @Column(name = "trans_inputdate")
    private LocalDateTime transInputdate;

    @Column(name = "trans_inputid")
    private String transInputid;

    @Column(name = "trans_modifyid")
    private String transModifyid;

    @Column(name = "trans_modifydate")
    private LocalDateTime transModifydate;

    public String getTransCode() {
        return transCode;
    }

    public Material getMaterial() {
        return material;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDate getTransDate() {
        return transDate;
    }

    public int getTransNum() {
        return transNum;
    }

    public int getTransMoney() {
        return transMoney;
    }

    public LocalDateTime getTransInputdate() {
        return transInputdate;
    }

    public String getTransInputid() {
        return transInputid;
    }

    public String getTransModifyid() {
        return transModifyid;
    }

    public LocalDateTime getTransModifydate() {
        return transModifydate;
    }


    /*  public MaterialTrans(String transCode, String materialCode, String accCode, LocalDate transDate, int transNum, int transMoney, LocalDateTime transInputdate, String transInputid, String transModifyid, LocalDateTime transModifydate){
       this.transCode = transCode;
       this.materialCode = materialCode;
       this.accCode = accCode;
       this.transDate = transDate;
       this.transNum = transNum;
       this.transMoney = transMoney;
       this.transInputdate = transInputdate;
       this.transInputid = transInputid;
       this.transModifydate = transModifydate;
       this.transModifyid = transModifyid;
    }*/
}
