package project.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import project.entity.DefaultApplication;
import project.entity.RenewApplication;
import project.service.RenewApplicationService;
import project.util.ResultVOUtil;
import project.vo.PageVO;
import project.vo.ResultVO;

import java.time.LocalDate;
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
@RequestMapping("/renewApply")
public class RenewApplicationController {

    @Autowired
    private RenewApplicationService renewApplicationService;

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size ){
        PageVO pageVO = this.renewApplicationService.list(page,size);
        return ResultVOUtil.success(pageVO);
    }

    @PostMapping("/check/{id}/{flag}/{name}")
    public ResultVO check(@PathVariable("id") Integer id, @PathVariable("flag") String flag, @PathVariable("name") String name){
        RenewApplication renewApplication = this.renewApplicationService.getById(id);
        renewApplication.setRauditor(name);
        renewApplication.setRctime(String.valueOf(LocalDate.now()));
        if ("true".equals(flag)){
            renewApplication.setRcstatus("认定不违约");
        }
        boolean identity = this.renewApplicationService.updateById(renewApplication);
        if (!identity){
            return ResultVOUtil.fail();
        }else {
            return ResultVOUtil.success(null);
        }
    }


}

