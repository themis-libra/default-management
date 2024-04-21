package project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import project.entity.Customer;
import project.entity.DefaultApplication;
import project.mapper.DefaultApplicationMapper;
import project.service.DefaultApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import project.vo.PageVO;
import project.vo.ResultVO;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
@Service
public class DefaultApplicationServiceImpl extends ServiceImpl<DefaultApplicationMapper, DefaultApplication> implements DefaultApplicationService {

    @Autowired
    private DefaultApplicationMapper defaultApplicationMapper;

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<DefaultApplication> defaultApplication = new Page<>(page, size);
        Page<DefaultApplication> defaultApplicationPage = this.defaultApplicationMapper.selectPage(defaultApplication, null);
        PageVO pageVO = new PageVO();
        pageVO.setData(defaultApplicationPage.getRecords());
        pageVO.setTotal(defaultApplicationPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO listTrue(Integer page, Integer size) {
        QueryWrapper<DefaultApplication> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Dcstatus","认定违约");
        Page<DefaultApplication> defaultApplication = new Page<>(page, size);
        Page<DefaultApplication> defaultApplicationPage = this.defaultApplicationMapper.selectPage(defaultApplication, queryWrapper);
        PageVO pageVO = new PageVO();
        pageVO.setData(defaultApplicationPage.getRecords());
        pageVO.setTotal(defaultApplicationPage.getTotal());
        return pageVO;
    }

    @Override
    public DefaultApplication selectOne(Integer id) {
        QueryWrapper<DefaultApplication> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        DefaultApplication defaultApplication = this.defaultApplicationMapper.selectOne(queryWrapper);
        return defaultApplication;
    }
}
