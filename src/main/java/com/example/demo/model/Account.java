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
@Table(name="\"account\"")
@Getter
@Setter
@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class Account {

    @Id
    @Column(name = "acc_code")
    private String accCode;



    @Column(name = "owner_code")
    private String ownerCode;

    @Column(name = "acc_name")
    private String accName;

    @Column(name = "acc_simple")
    private String accSimple;

    @Column(name = "acc_phone")
    private String accPhone;

    @Column(name = "acc_email")
    private String accEmail;

    @Column(name = "acc_accnumber")
    private String accAccNumber;

    @Column(name = "acc_bank")
    private String accBank;

    @Column(name = "acc_accholder")
    private String accAccHolder;

    @Column(name = "acc_type")
    private String accType;

    @Column(name = "acc_date")
    private LocalDate accDate;

    @Column(name = "acc_modifyid")
    private String accModifyid;

    @Column(name = "acc_modifydate")
    private LocalDateTime accModifydate;

    @Column(name = "acc_inputdate")
    private LocalDateTime accInputdate;

    @Column(name = "acc_inputid")
    private String accInputid;

    @Column(name="acc_zipcode")
    private String accZipcode;

    @Column(name="acc_address")
    private String accAddress;

    @Column(name="acc_addressdetail")
    private String accAddressdetail;

    @OneToMany(mappedBy = "account")
    private List<MaterialTrans> materialtrans;
    public String getAccZipcode() {
        return accZipcode;
    }

    public void setAccZipcode(String accZipcode) {
        this.accZipcode = accZipcode;
    }

    public String getAccAddressdetail() {
        return accAddressdetail;
    }

    public void setAccAddressdetail(String accAddressdetail) {
        this.accAddressdetail = accAddressdetail;
    }

    public String getAccPhone() {
        return accPhone;
    }

    public void setAccPhone(String accPhone) {
        this.accPhone = accPhone;
    }

    public String getAccEmail() {
        return accEmail;
    }

    public void setAccEmail(String accEmail) {
        this.accEmail = accEmail;
    }

    public String getAccAccNumber() {
        return accAccNumber;
    }

    public void setAccAccNumber(String accAccnumber) {
        this.accAccNumber = accAccnumber;
    }

    public String getAccBank() {
        return accBank;
    }

    public void setAccBank(String accBank) {
        this.accBank = accBank;
    }

    public String getAccAccHolder() {
        return accAccHolder;
    }

    public void setAccAccHolder(String accAccholder) {
        this.accAccHolder = accAccholder;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public LocalDate getAccDate() {
        return accDate;
    }

    public void setAccDate(LocalDate accDate) {
        this.accDate = accDate;
    }

    public LocalDateTime getAccInputdate() {
        return accInputdate;
    }

    public void setAccInputdate(LocalDateTime accInputdate) {
        this.accInputdate = accInputdate;
    }

    public String getAccInputid() {
        return accInputid;
    }

    public void setAccInputid(String accInputid) {
        this.accInputid = accInputid;
    }

    public String getAccModifyid() {
        return accModifyid;
    }

    public void setAccModifyid(String accModifyid) {
        this.accModifyid = accModifyid;
    }

    public LocalDateTime getAccModifydate() {
        return accModifydate;
    }

    public void setAccModifydate(LocalDateTime accModifydate) {
        this.accModifydate = accModifydate;
    }

    public String getAccAddress() {
        return accAddress;
    }

    public void setAccAddress(String accAddress) {
        this.accAddress = accAddress;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccSimple() {
        return accSimple;
    }

    public void setAccSimple(String accSimple) {
        this.accSimple = accSimple;
    }

    // DB 저장을 위해 임시로 만든 생성자(필요X)
    public Account(String accCode, String ownerCode, String accName, String accSimple) {
        this.accCode = accCode;
        this.ownerCode=ownerCode;
        this.accName=accName;
        this.accSimple=accSimple;
    }
    public Account(String accCode, String accSimple){
        this.accCode=accCode;
        this.accSimple=accSimple;
    }

    public Account() {

    }
    public Account(String accCode, String accName, String ownerCode, String accSimple,  String accAddress,
                   String accPhone, String accEmail, String accAccnumber, LocalDate accDate,
                   String accAccholder, String accType, String accBank, String accAddressdetail, String accZipcode, String accInputid, String accModifyid) {
        this.accCode = accCode;
        this.ownerCode=ownerCode;
        this.accName=accName;
        this.accSimple=accSimple;
        this.accAddress=accAddress;
        this.accPhone=accPhone;
        this.accEmail=accEmail;
        this.accAccNumber=accAccnumber;
        this.accDate=accDate;
        this.accAccHolder=accAccholder;
        this.accType=accType;
        this.accBank=accBank;
        this.accAddressdetail=accAddressdetail;
        this.accZipcode=accZipcode;
        this.accInputid = accInputid;
        this.accModifyid = accModifyid;
    }

}