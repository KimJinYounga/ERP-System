package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="\"owner\"")
@Getter
@Setter
@Data
public class Owner {

//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    @Column(name="owner_code")
    private String ownerCode;

    @Column(name="owner_type")
    private String ownerType;

    @Column(name="owner_inputdate")
    private LocalDate ownerInputdate;

    @Column(name="owner_inputid")
    private String ownerInputid;

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public LocalDate getOwnerInputdate() {
        return ownerInputdate;
    }

    public void setOwnerInputdate(LocalDate ownerInputdate) {
        this.ownerInputdate = ownerInputdate;
    }

    public String getOwnerInputid() {
        return ownerInputid;
    }

    public void setOwnerInputid(String ownerInputid) {
        this.ownerInputid = ownerInputid;
    }

    public Owner(String ownerCode, String ownerType, LocalDate ownerInputdate) {
        this.ownerCode=ownerCode;
        this.ownerType=ownerType;
        this.ownerInputdate=ownerInputdate;
    }
    public Owner() {}
}
