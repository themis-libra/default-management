package project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import project.entity.DefaultReason;
import project.entity.RenewCheck;
import project.mapper.RenewCheckMapper;
import project.service.RenewCheckService;
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
public class RenewCheckServiceImpl extends ServiceImpl<RenewCheckMapper, RenewCheck> implements RenewCheckService {
}
