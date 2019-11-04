package zhuo.ssm_test.dao;

import org.apache.ibatis.annotations.Select;
import zhuo.ssm_test.domain.Member;

public interface IMemberDao {

    @Select("select * from member where id = #{id}")
    public Member findById(String id) throws Exception;
}
