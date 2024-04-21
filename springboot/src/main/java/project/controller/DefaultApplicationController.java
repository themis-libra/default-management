package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.entity.DefaultApplication;
import project.entity.RenewApplication;
import project.service.DefaultApplicationService;

import project.service.RenewApplicationService;
import project.util.ResultVOUtil;
import project.vo.PageVO;
import project.vo.ResultVO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
@RestController
@RequestMapping(value = "/Apply",produces = "application/json;charset=UTF-8")
public class DefaultApplicationController {

    @Autowired
    private DefaultApplicationService defaultApplicationService;

    @Autowired
    private RenewApplicationService renewApplicationService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody DefaultApplication defaultApplication){
        defaultApplication.setDatime(String.valueOf(LocalDate.now()));
        defaultApplication.setDcstatus("认定违约");
        boolean flag = this.defaultApplicationService.save(defaultApplication);
        if (!flag){
            return ResultVOUtil.fail();
        }else {
            return ResultVOUtil.success(null);
        }
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size ){
        PageVO pageVO = this.defaultApplicationService.list(page,size);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/listTrue/{page}/{size}")
    public ResultVO listTrue(@PathVariable("page") Integer page, @PathVariable("size") Integer size ){
        PageVO pageVO = this.defaultApplicationService.listTrue(page,size);
        return ResultVOUtil.success(pageVO);
    }

    @PostMapping("/saveRenew/{id}/{reason}")
    public ResultVO saveRenew(@PathVariable("id") Integer id,@PathVariable("reason") String reason){
        DefaultApplication defaultApplication = this.defaultApplicationService.selectOne(id);
        RenewApplication renewApplication = new RenewApplication();
        renewApplication.setRcname(defaultApplication.getDname());
        renewApplication.setRlevel(defaultApplication.getDlevel());
        renewApplication.setRanote(defaultApplication.getDanote());
        renewApplication.setRano(defaultApplication.getDano());
        renewApplication.setRatime(defaultApplication.getDatime());
        renewApplication.setRname(defaultApplication.getDname());
        renewApplication.setRRgoavity(defaultApplication.getRgoavity());
        renewApplication.setRcstatus(defaultApplication.getDcstatus());
        renewApplication.setRreson(reason);
        boolean flag = this.renewApplicationService.save(renewApplication);
        if (!flag){
            return ResultVOUtil.fail();
        }else {
            boolean remove = this.defaultApplicationService.removeById(id);
            if (!remove){
                return ResultVOUtil.fail();
            }else {
                return ResultVOUtil.success(null);
            }
        }
    }

    @PostMapping("/check/{id}/{flag}/{name}")
    public ResultVO check(@PathVariable("id") Integer id, @PathVariable("flag") String flag, @PathVariable("name") String name){
        DefaultApplication defaultApplication = this.defaultApplicationService.selectOne(id);
        defaultApplication.setDauditor(name);
        defaultApplication.setDctime(String.valueOf(LocalDate.now()));
        if ("true".equals(flag)){
            defaultApplication.setDcstatus("认定违约");
        }else {
            defaultApplication.setDcstatus("认定不违约");
        }
        boolean identity = this.defaultApplicationService.updateById(defaultApplication);
        if (!identity){
            return ResultVOUtil.fail();
        }else {
            return ResultVOUtil.success(null);
        }
    }


}

