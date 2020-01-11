package com.example.demo.controller;


import com.example.demo.model.SomeData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Controller
public class Test1Controller {

    @RequestMapping("/test1")
    public String someAction(@ModelAttribute("somedata") SomeData data, Map<String, Object> map,
                             HttpServletRequest request) {

        System.out.println("Name=" + request.getParameter("n") + " age=" + request.getParameter("age"));

        /* do some process and send back the data */
        map.put("n", request.getParameter("n"));
        map.put("age", request.getParameter("age"));

        return "test1";
    }




}