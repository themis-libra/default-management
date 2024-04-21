package project.service;

import project.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import project.form.RuleForm;
import project.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
public interface CustomerService extends IService<Customer> {
    public ResultVO Login(RuleForm ruleForm);
}
