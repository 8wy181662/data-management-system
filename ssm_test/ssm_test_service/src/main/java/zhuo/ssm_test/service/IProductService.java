package zhuo.ssm_test.service;

import zhuo.ssm_test.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll() throws Exception;

    public void save(Product product) throws Exception;
}
