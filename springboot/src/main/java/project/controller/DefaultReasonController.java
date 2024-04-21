package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import project.service.DefaultReasonService;
import project.vo.ResultVO;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
@RestController
@RequestMapping("/Reason")
public class DefaultReasonController {

    @Autowired
    private DefaultReasonService defaultReasonService;


    @GetMapping("/search")
    public ResultVO reasonList(){
        ResultVO resultVO = this.defaultReasonService.Search();
        return resultVO;
    }

}

