package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.AccountPTBService;
import com.example.demo.service.AccountService;
import com.example.demo.service.MaterialTransService;
import com.example.demo.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@SessionAttributes({"accDetail", "PTBList","accountLists", "accCode"})
@Controller
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MaterialTransRepository materialTransRepository;
    @Autowired
    MaterialTransService materialTransService;
    @Autowired
    MaterialReqository materialRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    AccountPTBRepository accountPTBRepository;

    @Autowired
    AccountPTBService accountPTBService;

    @Autowired
    OwnerService ownerService;

    /**
     * 거래처 담당자 modal창 처리 Controller
     * @return
     */

    // 거래처 담당자 Add버튼 클릭 시
    @RequestMapping("/PTBadd")
    public String PTBaddPage() {
        return "enroll_com_modal";
    }

    // 없애도 됌.
//    @RequestMapping("/enroll_com_modal")
//    public String modalPage() {
//        return "enroll_com_modal";
//    }

    // 거래처담당자 검색 모달창에서 save버튼 누를 때 처리
    @RequestMapping("/PTBAdd/{name}")
    public String PTBaddPage(@PathVariable("name")String name,
                             @ModelAttribute("accCode")String accCode) {
        List<AccountPTB> lists=accountPTBRepository.findAllByPtbName(name);
        AccountPTB a=new AccountPTB();
        for(AccountPTB s : lists)
        {
            a = s;
        }
        if(a.getAccCode()==null) {
            a.setAccCode(accCode);
            accountPTBService.save(a);
        }
        else {
            AccountPTB addPTB=new AccountPTB("p05", accCode, name, a.getPtbPhone(), a.getPtbEmail(), a.getPtbBrand());
            accountPTBService.save(addPTB);
        }


        //log.info("PTBAdd/name ==> "+name);
        // PTB list를 db에 update 하고 session에 저장하자!

        return "redirect:/PTBadd";
    }



    // 거래처 담당자 모달창에서 브랜드, 담당자 이름으로 검색
    @RequestMapping("/PTBsearch/{first}&{second}")
    public String PTBsearchPage(Model model,
                                @PathVariable("first")String name,
                                @PathVariable("second")String brand) {
      //  log.info("PTBsearch call..");
      //  log.info("first=="+name);
      //  log.info("second=="+brand);



        Set<AccountPTB> accountPTBS = new HashSet<AccountPTB>();
        List<AccountPTB> set = new ArrayList<AccountPTB>();
        set=accountPTBRepository.findAllByPtbName(name);
        String findOne="";

        for(AccountPTB s : set) {
            findOne=s.getPtbCode();
            break;
        }
        AccountPTB a=accountPTBRepository.findByPtbCode(findOne);
        if (a!=null)
            accountPTBS.add(a);

        set=accountPTBRepository.findAllByPtbBrand(brand);
        findOne="";


        for(AccountPTB s : set) {
            findOne=s.getPtbCode();
            break;
        }
        a=accountPTBRepository.findByPtbCode(findOne);
        if (a!=null)
            accountPTBS.add(a);


        //log.info("acocuntPTB ==>"+accountPTBS);
        model.addAttribute("accountPTB", accountPTBS);
        return "enroll_com_modal";
    }

    @RequestMapping("/PTBdelete/{code}")
    public String PTBdeletePage(@PathVariable("code")String code,
                                @ModelAttribute("accCode")String accCode) {
        //log.info("PTBdelete clicked..");
        accountPTBService.deleteByPtbCode(code);
        return "redirect:/account/"+accCode;
    }
/*
    @RequestMapping("/Accountdelete/{code}")
    public String AccountdeletePage(@PathVariable("code")String code) {
        //log.info("PTBdelete clicked..");
        accountService.deleteByAccCode(code);
//        accountPTBService.deleteByPtbCode(code);
        return "redirect:/accLists";
    }*/

    @RequestMapping("/Accountdelete/{code}")
    public String AccountdeletePage(@PathVariable("code")String code) {
  //      log.info("PTBdelete clicked..");
        String ow=accountRepository.findByAccCode(code).getOwnerCode();
        accountService.deleteByAccCode(code);
        ownerService.delete(ownerRepository.findByOwnerCode(ow));
        return "redirect:/accLists";
    }

//    @RequestMapping("/accountCheck")
//    public String viewAccountCheckPage(Model model,
//                                       @PathVariable("accType")String accType,
//                                       @PathVariable("accName")String accName,
//                                       @PathVariable("ownerCode")String ownerCode,
//                                       @PathVariable("accAccholder")String accAccholder,
//                                       @PathVariable("accBank")String accBank,
//                                       @PathVariable("accAccNumber")String accAccNumber,
//                                       @PathVariable("accCode")String accCode,
//                                       @PathVariable("accSimple")String accSimple,
//                                       @PathVariable("accEmail")String accEmail,
//                                        // 거래게시일은 로컬에서 현재 시간을 받아와서 저장할것.
////                                       @PathVariable("accDate") Local accCode,
//                                       @PathVariable("accAddress")String accAddress,
//                                       @PathVariable("accPhone")String accPhone
//                                       ){
//        return "account";
//    }


    @RequestMapping("/account/{accCode}")
    public String viewAccountDetailPage(Model model,
                                        @PathVariable("accCode")String accCode) {
        System.out.println("accCode 호출");
        Account a=accountRepository.findByAccCode(accCode);
        Set<String> PTBCodeList=new HashSet<String>();

        // account_ptb table : accCode -> ptbCode
        List<AccountPTB> accountPTB=accountPTBRepository.findAllByAccCode(accCode);
        if(accountPTB !=null) {
            for(AccountPTB acc : accountPTB) {
                PTBCodeList.add(acc.getPtbCode());
            }
        }

        List<AccountPTB> PTBList =  new ArrayList<AccountPTB>();
        for(String li : PTBCodeList) {
            PTBList.add(accountPTBRepository.findByPtbCode(li));
        }


      //  log.info("PTBCodeList ==>"+PTBCodeList);
     //   log.info("PTBList -->"+PTBList);
        model.addAttribute("accCode", accCode);
        model.addAttribute("accDetail", a);
        model.addAttribute("PTBList", PTBList);
     //   log.info("a ==> "+a);
        return "enroll_com";
    }


    /**
     * 거래처 목록
     */
    @RequestMapping("/accLists")
    public String viewAccListsPage(Model model) {
        List<Account> account=accountRepository.findAll();
        model.addAttribute("accountLists", account);
        return "enroll_com";
    }

    @RequestMapping("/accDetailCheck/{accCode}")
    public String viewCheckPage(Model model,
                                HttpServletRequest request,
                                @PathVariable("accCode")String accCode,
                                @RequestParam(value = "accName", required = false) String accName,
                                @RequestParam(value="ownerCode", required=false)String ownerCode,
                                @RequestParam(value="accSimple", required=false)String accSimple,
                                @RequestParam(value="accAddress", required=false)String accAddress,
                                @RequestParam(value="accAddressdetail", required=false)String accAddressdetail,
                                @RequestParam(value="accZipcode", required=false)String accZipcode,
                                @RequestParam(value="accPhone", required=false)String accPhone,
                                @RequestParam(value="accEmail", required=false)String accEmail,
                                @RequestParam(value="accAccnumber", required=false)String accAccnumber,
                                @RequestParam(value="accAccholder", required=false)String accAccholder,
                                @RequestParam(value="accType", required=false)String accType
                                ){
        Account get=accountRepository.findByAccCode(accCode);
        HttpSession sess = request.getSession();
        Member a=(Member)sess.getAttribute("loginSuccess");
        String id=a.getMemId();
        String accInputid = get.getAccInputid();
        Account account=new Account(accCode, accName, ownerCode, accSimple, accAddress, accPhone,  accEmail, accAccnumber, get.getAccDate(), accAccholder, accType, get.getAccBank(), accAddressdetail, accZipcode, accInputid, id);
        accountService.updateByAccCode(accCode, account);
        model.addAttribute("accDetail", get);

        return "redirect:/accLists";
    }

    /**
     * 거래처 조회
     */
    @RequestMapping("/acc_code={acc_code}&acc_name={acc_name}&acc_type={acc_type}" +
            "&material_name={material_name}&owner_code={owner_code}&owner_type={owner_type}")
    public String viewAccountPage(Model model,
                                  @PathVariable("acc_name")String acc_name,
                                  @PathVariable("acc_code")String acc_code,
                                  @PathVariable("acc_type")String acc_type,
                                  @PathVariable("material_name")String material_name,
                                  @PathVariable("owner_type")String owner_type,
                                  @PathVariable("owner_code")String owner_code) {

        /**
         * 거래처코드 리스트를 선언하고, 그 리스트에 각각 url에 해당하는 거래처코드를 중복되지 않게 저장하고 마지막에 거래처코드로 한번에 조회해보자!!!!
         */
        Set<String> accList=new HashSet<String>();

        // accName -> accCode
        if(accountRepository.findByAccName(acc_name)!=null) {
            System.out.println("거래처명 add됨!");
            accList.add(accountRepository.findByAccName(acc_name).getAccCode());
        }

        // accCode
        if(!acc_code.equals("")) {
            System.out.println("거래처코드add" + acc_code);
            accList.add(acc_code);
        }

        // accType -> accCode
        List<Account> account=accountRepository.findAllByAccType(acc_type);
        if(account !=null) {
            for(Account acc : account) {
                accList.add(acc.getAccCode());
            }
        }

        // owner_code -> accCode
        List<Account> owns=accountRepository.findAllByOwnerCode(owner_code);
        if(owns!=null) {
            for(Account own : owns) {
                accList.add(own.getAccCode());
            }
        }

        // material_code -> accCode
        Material m = materialRepository.findByMaterialCode(material_name);
        System.out.println("material_name = "+ material_name);
      //  List<MaterialTrans> mats=materialRepository.findByMaterialCode(material_name);   //material_name은 자재 코드
        List<MaterialTrans> materialtrans1 = materialTransService.findByMaterial(m);
//        List<MaterialTrans> mats=materialTransRepository.findByMaterialName(material_name);
        if(materialtrans1!=null) {
            for(MaterialTrans mat : materialtrans1) {
                accList.add(mat.getAccount().getAccCode());
            }
        }


        /**
         * - 사업자유형
         * tb_owner : 사업자유형이름(ownerType)으로 사업자유형 코드(ownerCode)를 검색
         * -> tb_account : 사업자유형 코드(ownerCode)로 거래처 코드(accCode)를 검색.
         */
        // owner_type -> accCode
        Set<String> ownList=new HashSet<String>();
        // 사업자 유형타입(이름)은 한개. 이에 따른 사업자 유형코드는 여러개(리스트여야함.)
        List<Owner> ownerCode=ownerRepository.findAllByOwnerType(owner_type);
//        List<Owner> owntypes = ownerRepository.findByOwnerType(owner_type);
    //    log.info("ownerCode ==> "+ownerCode);
        if (ownerCode!=null) {
            for(Owner own1 : ownerCode) {
                ownList.add(accountRepository.findByOwnerCode(own1.getOwnerCode()).getAccCode());
            }
//            ownList.add(accountRepository.findByOwnerCode(ownerCode).getAccCode());
        }
    //    log.info("ownList ==> "+ownList);

        for(String own :  ownList) {
            accList.add(own);
        }

//        if (!ownerCode.equals("")) {
//            for(Owner owntype : owntypes) {
//                log.info("owntype ==> "+owntype);
//                ownList.add(owntype.getOwnerCode());
//            }
//            if(ownList!=null) {
//                for(String a : ownList) {
//                    // a는 사업자 유형 코드
//                    log.info("ownList의 a ==> "+a);
//                    log.info("byowner code -> accCode "+accountRepository.findByOwnerCode(a).getAccCode());
//                    accList.add(accountRepository.findByOwnerCode(a).getAccCode());
//                }
//            }
//        }


        // 거래처코드를 통한 검색. Account정보를 출력하기 위한 List
        List<Account> accountLists=new ArrayList<Account>();
        /**
         * li는 거래처 코드
         * accountLists는 li에 해당하는 거래처의 모든 정보(Accout 객체)
         */
        for(String li : accList) {
            accountLists.add(accountRepository.findByAccCode(li));
        }
    //    log.info("accountLists == "+ accountLists);
        model.addAttribute("accountLists",accountLists);

        return "enroll_com";
    }

    @RequestMapping("/accountCheck")
    public String accountPage(Model model,
                                HttpServletRequest request,  HttpServletResponse response,
                              @RequestParam(value = "accType", required = false) String accType,
                                @RequestParam(value = "accName", required = false) String accName,
                                @RequestParam(value="accAccholder", required=false)String accAccholder,
                                @RequestParam(value="accBank", required=false)String accBank,
                              @RequestParam(value="accAccnumber", required=false)String accAccnumber,
                                @RequestParam(value="accCode", required=false)String accCode,
                                @RequestParam(value="accSimple", required=false)String accSimple,
                              @RequestParam(value="ownerCode", required=false)String ownerCode,
                              @RequestParam(value="accPhone", required=false)String accPhone,
                                @RequestParam(value="accEmail", required=false)String accEmail,
                              @RequestParam(value="ownerType", required=false)String ownerType

    ) throws IOException {
        Account isnew=accountRepository.findByAccCode(accCode);
        if (isnew!=null) {
            response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<script>alert('이미 등록된 거래처 입니다. '); location.href='account';</script>");

            out.flush();

            return "account";
        }
        else {

            LocalDate d = LocalDate.now();
            Owner o = new Owner(ownerCode, ownerType, d);
         //   log.info("owner ====>>>>" + o);
            ownerService.save(o);
            HttpSession sess = request.getSession();
            Member a=(Member)sess.getAttribute("loginSuccess");
            String id=a.getMemId();

            Account account = new Account(accCode, accName, ownerCode, accSimple, "", accPhone, accEmail, accAccnumber, d, accAccholder, accType, accBank, "", "", id, "");
       //     log.info("account =====>>>>" + account);
            accountService.save(account);
//        accountService.updateByAccCode(accCode, account);

            return "enroll_com";
        }
    }
}
