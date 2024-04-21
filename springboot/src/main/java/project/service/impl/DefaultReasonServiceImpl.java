package project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import project.entity.Customer;
import project.entity.DefaultReason;
import project.mapper.DefaultReasonMapper;
import project.service.DefaultReasonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import project.vo.ResultVO;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
@Service
public class DefaultReasonServiceImpl extends ServiceImpl<DefaultReasonMapper, DefaultReason> implements DefaultReasonService {

    @Autowired
    private DefaultReasonMapper defaultReasonMapper;

    @Override
    public ResultVO Search() {
        QueryWrapper<DefaultReason> queryWrapper = new QueryWrapper<>();
        List<DefaultReason> defaultReasons = this.defaultReasonMapper.selectList(queryWrapper);
        ResultVO<Object> resultVO = new ResultVO<>();
        if (defaultReasons == null){
            resultVO.setCode(-1);
        }else {
            resultVO.setCode(0);
            resultVO.setData(defaultReasons);
            }
        return resultVO;
    }
}
