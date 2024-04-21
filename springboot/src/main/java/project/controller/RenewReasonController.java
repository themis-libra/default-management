package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import project.entity.RenewReason;
import project.service.RenewCheckService;
import project.service.RenewReasonService;
import project.vo.ResultVO;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
@RestController
@RequestMapping("/renewReason")
public class RenewReasonController {
    @Autowired
    private RenewReasonService renewReasonService;

    @GetMapping("/search")
    public ResultVO reasonList(){
        List<RenewReason> list = this.renewReasonService.list();
        ResultVO<Object> resultVO = new ResultVO<>();
        if (list == null){
            resultVO.setCode(-1);
        }else {
            resultVO.setCode(0);
            resultVO.setData(list);
        }
        return resultVO;
    }
}

