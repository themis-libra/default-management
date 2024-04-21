package project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import project.form.RuleForm;
import project.service.CustomerService;
import project.vo.ResultVO;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO<Object> resultVO  = this.customerService.Login(ruleForm);
        return resultVO;
    }


}

