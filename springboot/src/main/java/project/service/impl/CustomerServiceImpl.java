package project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import project.entity.Customer;
import project.form.RuleForm;
import project.mapper.CustomerMapper;
import project.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public ResultVO Login(RuleForm ruleForm) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Cname",ruleForm.getUsername());
        Customer customer = this.customerMapper.selectOne(queryWrapper);
        ResultVO<Object> resultVO = new ResultVO<>();
        if (customer == null){
            resultVO.setCode(-1);
        }else {
            if (!customer.getPassword().equals(ruleForm.getPassword())) {
                resultVO.setCode(-2);
            }else {
                resultVO.setCode(0);
                resultVO.setData(customer);
            }
        }
        return resultVO;
    }
}
