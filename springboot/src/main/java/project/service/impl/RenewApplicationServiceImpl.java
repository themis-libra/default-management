package project.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import project.entity.DefaultApplication;
import project.entity.RenewApplication;
import project.mapper.RenewApplicationMapper;
import project.service.RenewApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import project.vo.PageVO;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
@Service
public class RenewApplicationServiceImpl extends ServiceImpl<RenewApplicationMapper, RenewApplication> implements RenewApplicationService {

    @Autowired
    private RenewApplicationMapper renewApplicationMapper;

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<RenewApplication> renewApplication = new Page<>(page, size);
        Page<RenewApplication> renewApplicationPage = this.renewApplicationMapper.selectPage(renewApplication, null);
        PageVO pageVO = new PageVO();
        pageVO.setData(renewApplicationPage.getRecords());
        pageVO.setTotal(renewApplicationPage.getTotal());
        return pageVO;
    }
    
}
