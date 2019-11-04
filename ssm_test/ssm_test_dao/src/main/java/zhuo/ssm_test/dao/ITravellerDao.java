package zhuo.ssm_test.dao;

import org.apache.ibatis.annotations.Select;
import zhuo.ssm_test.domain.Traveller;

import java.util.List;

public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{id})")
    public List<Traveller> findById(String id) throws Exception;
}
