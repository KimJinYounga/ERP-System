package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Material;
import com.example.demo.model.MaterialTrans;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.MaterialTransRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.MaterialService;
import com.example.demo.service.MaterialTransService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Slf4j
@Controller
public class MaterialTransController {
    private MaterialTransService materialTransService;
    private MaterialTransRepository materialTransRepository;
    private AccountService accountService;
    private AccountRepository accountRepository;

    @RequestMapping("/material_trans")
    public String ListMaterialTrans(Model uiModel) {
        List<MaterialTrans> materialtrans = materialTransService.findAll();
        uiModel.addAttribute("materialtranss", materialtrans);
        return "material_trans";
    }

    @RequestMapping("/searchMaterialTrans")
    public String searchAccName( Model uiModel, @RequestParam("searchAccount") String searchAccount, @RequestParam("searchStartDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate searchStartDate, @RequestParam("searchFinishDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate searchFinishDate){

      //  List<Account> account1 = accountService.findByAccNameContaining(searchAccount);
        if (searchFinishDate!=null && searchStartDate!=null){

            List<MaterialTrans> materialtrans1 = materialTransService.findByTransDateBetween(searchStartDate,searchFinishDate);
            long days = ChronoUnit.DAYS.between(searchStartDate, searchFinishDate);
        //    int q = 0;

            // 검색한 날짜들 순서대로 배열로 받기
            List accdateList = new ArrayList();
            // 날짜를 일일이 넣어준다.
            for(int i=0; i<=days; i++){
                accdateList.add(searchStartDate.plusDays(i));
            }

            // 중복 제거한 거래내역 코드 받기
            List accCodeList = new ArrayList();
            // 검색해서 찾은 거래 내역중에서 중복값을 빼고 저장할 것들.
            List<MaterialTrans> cpMaterialtrans;
            Account accounts;

            // HashSet<MaterialTrans> arr = new HashSet<MaterialTrans>()
            cpMaterialtrans = materialtrans1;
            List<Account> account = new ArrayList<>();
            if(cpMaterialtrans != null){
                for(MaterialTrans cpmat : cpMaterialtrans){
                    accCodeList.add(cpmat.getAccount().getAccCode());  // 현재는 중복이 제거되지 않은 상태
                    accounts = cpmat.getAccount();
                    account.add(accounts);
                }
            }

            // 중복 제거한 거래 코드 구하기
            HashSet<String> accCode = new HashSet<String>(accCodeList);
            accCodeList = new ArrayList<String>(accCode);

            HashSet<Account> acco = new HashSet<Account>(account);
            account = new ArrayList<Account>(acco);

            String[][] mlist = new String[accCode.size()][(int) days];

            List mList = new ArrayList();
            int dateindex, codeindex;
            for(MaterialTrans mat : materialtrans1){

                // 중복 제거한 거래코드 리스트에서 특정한 코드의 인덱스 찾기
               codeindex = accCodeList.indexOf( mat.getAccount().getAccCode());
               dateindex = accdateList.indexOf(mat.getTransDate());
               // mlist 2차원 배열에 금액 삽입
               mlist[codeindex][dateindex] =Integer.toString(mat.getTransMoney()) ;

            }


            ArrayList<ArrayList<String>> secondM = new ArrayList<ArrayList<String>>();
            ArrayList<Integer> Tsum = new ArrayList<Integer>();
            int sum;

            for(int i=0; i<accCode.size(); i++){
                ArrayList<String> firstM = new ArrayList<String>();
                sum = 0;
                for(int j=0; j<(int) days; j++){

                    firstM.add(mlist[i][j]);
                    if(mlist[i][j] != null) {
                        sum += Integer.parseInt(mlist[i][j]);
                    }

                }
                Tsum.add(sum);
                System.out.println("Tsum = " + Tsum);
                System.out.println("firstM = " + firstM);
                secondM.add(firstM);
                System.out.println("secondM1 = " + secondM);
            //    firstM.clear();

            }

            System.out.println("secondM = " + secondM);
            for(int j = 0; j<accCode.size(); j++){
                for(int k = 0; k < (int) days; k++){
                    System.out.println(mlist[j][k]);

                }
           //     System.out.println("accCode = " + accCode[j]);
            }
            String a = String.valueOf(accCodeList.get(0));
            System.out.println("accCode = " + a);
            System.out.println("transCode.size() = " + accCode.size());

          //  HashSet<MaterialTrans> distinctData = new HashSet<MaterialTrans>(cpMaterialtrans);
          //  cpMaterialtrans = new ArrayList<MaterialTrans>(distinctData);


            //     for(MaterialTrans m : days) {
        //        accdate.add(m.getTransDate());
//
  //          }
    //        accdate.add(searchStartDate);
          //  for(int i=0; i<(searchFinishDate -searchStartDate ))


      //      for(int i=0; i<accCodeList.size(); i++){
      //          String acccode = String.valueOf(accCodeList.get(0));
      //          account = (accountService.findByAccCode(acccode));
//
       //         accounts = cpmat.getAccount();
      //          account.add(accounts);

        //    }
        //    String[] acc = new String[accCodeList.size()];
        //    int a = 0;

        //    for(MaterialTrans cpmat : cpMaterialtrans) {
        //        acc[a] = cpmat.getAccount().getAccCode();  // 현재는 중복이 제거되지 않은 상태
         //       account.add(accountService.findByAccCode(acc[a]));
         //       a++;
        //        }
        //    }



       //     uiModel.addAttribute("materialtrans1", cpMaterialtrans);
            uiModel.addAttribute("account1", account);
            uiModel.addAttribute("mlist", secondM);
            uiModel.addAttribute("countDate", (int) days);
            uiModel.addAttribute("sum", Tsum);
      //      uiModel.addAttribute("cpmaterialtrans1", cpMaterialtrans);
            uiModel.addAttribute("colDate", accdateList);
        }
        else if(searchAccount !=null){
            List<Account> account1 = accountService.findByAccNameContaining(searchAccount);
            for (Account a : account1){
                List<MaterialTrans> materialtrans1 = materialTransService.findByAccount(a);
                uiModel.addAttribute("materialtrans1", materialtrans1);
            }
        }



        return "material_trans";
    }


    @Autowired
    public void setMaterialTransService(MaterialTransService materialTransService){ this.materialTransService = materialTransService;}
    @Autowired
    public void setMaterialTransRepository(MaterialTransRepository materialTransRepository){ this.materialTransRepository = materialTransRepository;}

    @Autowired
    public void setAccountService(AccountService accountService){ this.accountService = accountService;}

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository){ this.accountRepository = accountRepository;}

}
