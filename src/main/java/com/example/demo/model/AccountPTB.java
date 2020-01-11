package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name="\"account_ptb\"")
@Getter
@Setter
@Data
public class AccountPTB {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="ptb_code")
    private String ptbCode;

    @Column(name="acc_code")
    private String accCode;

    @Column(name="ptb_name")
    private String ptbName;

    @Column(name="ptb_phone")
    private String ptbPhone;

    @Column(name="ptb_email")
    private String ptbEmail;

    @Column(name="ptb_brand")
    private String ptbBrand;

    @Column(name="ptb_inputdate")
    private String ptbInputdate;

    @Column(name="ptb_inputid")
    private String ptbInputid;

    public String getPtbCode() {
        return ptbCode;
    }

    public void setPtbCode(String ptbCode) {
        this.ptbCode = ptbCode;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }

    public String getPtbName() {
        return ptbName;
    }

    public void setPtbName(String ptbName) {
        this.ptbName = ptbName;
    }

    public String getPtbPhone() {
        return ptbPhone;
    }

    public void setPtbPhone(String ptbPhone) {
        this.ptbPhone = ptbPhone;
    }

    public String getPtbEmail() {
        return ptbEmail;
    }

    public void setPtbEmail(String ptbEmail) {
        this.ptbEmail = ptbEmail;
    }

    public String getPtbBrand() {
        return ptbBrand;
    }

    public void setPtbBrand(String ptbBrand) {
        this.ptbBrand = ptbBrand;
    }

    public String getPtbInputdate() {
        return ptbInputdate;
    }

    public void setPtbInputdate(String ptbInputdate) {
        this.ptbInputdate = ptbInputdate;
    }

    public String getPtbInputid() {
        return ptbInputid;
    }

    public void setPtbInputid(String ptbInputid) {
        this.ptbInputid = ptbInputid;
    }

    public AccountPTB(String ptbCode, String accCode, String ptbName, String ptbPhone, String ptbEmail, String ptbBrand) {
        this.ptbCode=ptbCode;
        this.accCode = accCode;
        this.ptbName = ptbName;
        this.ptbPhone = ptbPhone;
        this.ptbEmail = ptbEmail;
        this.ptbBrand = ptbBrand;
//        this.ptbInputdate = ptbInputdate;
//        this.ptbInputid = ptbInputid;
    }
    public AccountPTB() {}
}
