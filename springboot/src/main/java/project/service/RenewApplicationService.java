package project.service;

import project.entity.RenewApplication;
import com.baomidou.mybatisplus.extension.service.IService;
import project.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
public interface RenewApplicationService extends IService<RenewApplication> {

    public PageVO list(Integer page, Integer size);

}
