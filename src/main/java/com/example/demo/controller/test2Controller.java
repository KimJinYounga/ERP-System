package com.example.demo.controller;


import com.example.demo.model.test2;
import com.example.demo.service.test2Service;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;


@Controller
public class test2Controller {

  //  private final Logger logger = (Logger) LoggerFactory.getLogger(test2Controller.class);

    private test2Service test2Service;
    @RequestMapping("/test2")
   // @RequestMapping("method = RequestMethod.GET")
    public String list(Model uiModel) {
        List<test2> test2s = test2Service.findAll();
        uiModel.addAttribute("test2s", test2s);
 //       logger.info("No. of test2 : " );
        return "test2";
    }

    @Autowired
    public void settest2Service(test2Service test2Service) {
        this.test2Service = test2Service;
    }

}
