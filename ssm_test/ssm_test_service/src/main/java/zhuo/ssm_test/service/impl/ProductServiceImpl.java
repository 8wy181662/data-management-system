package zhuo.ssm_test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhuo.ssm_test.service.IProductService;
import zhuo.ssm_test.dao.IProductDao;
import zhuo.ssm_test.domain.Product;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao ProductDao;

    @Override
    public List<Product> findAll() throws Exception {

        List<Product> list = ProductDao.findAll();

        return list;
    }

    @Override
    public void save(Product product) throws Exception {
        ProductDao.save(product);
    }
}
