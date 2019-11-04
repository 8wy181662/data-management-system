package zhuo.ssm_test.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import zhuo.ssm_test.domain.Role;
import zhuo.ssm_test.domain.UserInfo;

import java.util.List;

public interface IUserService extends UserDetailsService {

    public List<UserInfo> findAll() throws Exception;

    public void save(UserInfo userInfo) throws Exception;

    public UserInfo findById(String id) throws Exception;

    public List<Role> findOtherRoles(String userId) throws Exception;

    public void addRoleToUser(String userId, String[] roleIds);



}
