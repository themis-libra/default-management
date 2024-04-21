package project.service;

import project.entity.DefaultReason;
import com.baomidou.mybatisplus.extension.service.IService;
import project.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
public interface DefaultReasonService extends IService<DefaultReason> {

    public ResultVO Search();
}
