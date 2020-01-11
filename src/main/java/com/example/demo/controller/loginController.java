package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class loginController {

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request) {
        /*
         * index page 코드 홈페이지의 첫 화면은 login 페이지로 이동함. 만약 , 세션이 있다면 /home 으로 전송.
         */
        return "redirect:/enroll_com";
    }
    @RequestMapping(value = "/enroll_com", method = { RequestMethod.GET, RequestMethod.POST })
    public String home(Model model, HttpServletRequest request) {
        /*
         * home page 코드 주요 기능을 가지고 있는 page
         */
        return "enroll_com";
    }

    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public String Adminlogin(Model model, @RequestParam(value = "isLogin", required = false) boolean isLogin,
                             HttpServletRequest request) {
        if (request.getSession().getAttribute("loginSuccess") != null)
            return "redirect:/enroll_com";
        model.addAttribute("isLogin", isLogin);
        return "login";
    }
    @RequestMapping(value = "/loginCheck", method = { RequestMethod.GET, RequestMethod.POST })
    public String loginCheck(Model model, @RequestParam(value = "uid", required = false) String uid,
                             @RequestParam(value = "password", required = false) String password, RedirectAttributes redirectAttributes,
                             HttpServletRequest request) {
        List<Member> adminList = memberRepository.findAll();
        HttpSession sess = request.getSession();

        for (Member admin : adminList) {
          //  log.info("adminId==>"+admin.getMemId());
            if (uid.equals(admin.getMemId()) && password.equals(admin.getMemPw())) {
                sess.setAttribute("loginSuccess", admin);
                return "redirect:/enroll_com";
            }
        }
        redirectAttributes.addAttribute("isLogin", true);
        return "redirect:/login";
    }

    @RequestMapping(value="/logout", method={RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginSuccess");
        return "redirect:/login";
    }
}
