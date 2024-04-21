package project.service;

import project.entity.DefaultApplication;
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
public interface DefaultApplicationService extends IService<DefaultApplication> {

    public PageVO list(Integer page, Integer size);
    public PageVO listTrue(Integer page, Integer size);

    public DefaultApplication selectOne(Integer id);

}
