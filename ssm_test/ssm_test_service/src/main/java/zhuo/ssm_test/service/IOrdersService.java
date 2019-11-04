package zhuo.ssm_test.service;

import zhuo.ssm_test.domain.Orders;

import java.util.List;
public interface IOrdersService {

    public List<Orders> findAll(int page, int size) throws Exception;

    public Orders findById(String id) throws Exception;
}
