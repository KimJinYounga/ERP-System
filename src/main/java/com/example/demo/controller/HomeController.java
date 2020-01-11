package com.example.demo.controller;

        import com.example.demo.model.test2;
        import com.example.demo.repository.test2Repository;
        import com.example.demo.service.test2Service;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.servlet.ModelAndView;

        import java.util.List;
        import java.util.Map;

@Slf4j
@Controller
public class HomeController {


    @Autowired
    test2Repository test2Repository;

    @RequestMapping("/index")
    public String viewIndexPage() {

        return "index";
    }
    @RequestMapping("/tables")
    public String viewTablesPage() {

        return "tables";
    }

    @RequestMapping("/charts")
    public String viewchartsPage() {

        return "charts";
    }
    @RequestMapping("/search_com")
    public String viewenroll_comPage() {

        return "search_com";
    }
    @RequestMapping("/account_ptd")
    public String viewaccount_ptdPage() {

        return "account_ptd";
    }
    @RequestMapping("/enroll_res")
    public String viewenroll_resPage() {

        return "enroll_res";
    }

    @RequestMapping("/login")
    public String viewloginPage() {

        return "login";
    }

    @RequestMapping("/account")
    public String viewAccountPage() {return "account"; }


}
