package cn.wolfcode.crm.service.impl;

import cn.wolfcode.crm.mapper.CustomerReportMapper;
import cn.wolfcode.crm.query.QueryObject;
import cn.wolfcode.crm.service.ICustomerReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerReportServiceImpl implements ICustomerReportService {

    @Autowired
    private CustomerReportMapper customerReportMapper;

    public PageInfo selectCustomerReport(QueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        List<Map> list = customerReportMapper.selectCustomerReport(qo);
        return new PageInfo(list);
    }

    public List<Map> listAll(QueryObject qo) {
        return customerReportMapper.selectCustomerReport(qo);
    }
}
