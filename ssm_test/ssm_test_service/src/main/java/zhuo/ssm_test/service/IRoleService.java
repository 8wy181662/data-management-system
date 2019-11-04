package zhuo.ssm_test.service;

import zhuo.ssm_test.domain.Permission;
import zhuo.ssm_test.domain.Role;

import java.util.List;

public interface IRoleService{

    public List<Role> findAll()throws Exception;

    public void save(Role role) throws Exception;

    public Role findById(String id) throws Exception;

    public List<Permission> findOtherPermission(String id) throws Exception;

    public void addPermissionToRole(String roleId,String[] ids) throws Exception;
}
