package com.pingyougou.shopweb.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.common.ConUtils;
import com.pingyougou.common.ReResult;
import com.pingyougou.pojo.TbSeller;
import com.pingyougou.sellergoods.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by tanwen on 2018/11/17.
 */
@Slf4j
@Controller
@RequestMapping("seller")
public class SellerController {

    @Reference
    SellerService sellerService;

    @RequestMapping("add")
    @ResponseBody
    public ReResult register(@RequestBody @Valid TbSeller tbSeller, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            for (ObjectError msg:bindingResult.getAllErrors()) {
                System.out.println(msg.getDefaultMessage());
            }
            return new ReResult(false,ConUtils.ADD_FAIL);
        }
        System.out.println(tbSeller);
        sellerService.addSeller(tbSeller);
        return new ReResult(true,ConUtils.ADD_SUCCESS);
    }

    @RequestMapping("login")
    public String login(String username,String password){
        boolean success = sellerService.login(username,password);
        if (success){
            return "redirect:/index";
        }
        return "shoplogin";
    }
}
