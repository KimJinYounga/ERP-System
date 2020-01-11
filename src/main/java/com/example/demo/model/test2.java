package com.example.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="\"test2\"")
@Getter
@Setter
@Data
//@AllArgsConstructor
@NoArgsConstructor

public class test2 {

    @Id
    @Column(name="testid")
    private String testid;

    @Column(name="testpw")
    private String testpw;

    public test2(String testid, String testpw) {
        this.testid = testid;
        this.testpw=testpw;
    }
}
