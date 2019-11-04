package zhuo.ssm_test.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhuo.ssm_test.service.IOrdersService;
import zhuo.ssm_test.dao.IOrdersDao;
import zhuo.ssm_test.domain.Orders;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl  implements IOrdersService{

    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception{
        //使用分页插件，需在查询方法前
        PageHelper.startPage(page,size);
        List<Orders> list = iOrdersDao.findAll();
        return list;
    }

    @Override
    public Orders findById(String id) throws Exception {
        Orders orders = iOrdersDao.findById(id);
        return orders;
    }
}
