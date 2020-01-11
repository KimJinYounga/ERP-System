package com.example.demo.vo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;


//import java.util.logging.Logger;

public class MaterialVO {

    private Logger logger = LoggerFactory.getLogger(MaterialVO.class);

    private String materialCode;
    private String materialName;
    private int materialMoney;
    private LocalDateTime materialInputdate;
    private String materialInputid;
/*
    public String getMaterialCode(){
        logger.info("getMaterialCode 호출됨");
        return materialCode;
    }
    public String getMaterialName(){
        logger.info("getMaterialName 호출됨");
        return materialName;
    }
    public int getMaterialMoney(){
        logger.info("getMaterialMoney 호출됨");
        return materialMoney;
    }
    public LocalDateTime getMaterialInputdate(){
        logger.info("getMaterialInputdate 호출됨");
        return materialInputdate;
    }
    public String getMaterialInputid(){
        logger.info("getMaterialInputid 호출됨");
        return materialInputid;
    }
*/
}
