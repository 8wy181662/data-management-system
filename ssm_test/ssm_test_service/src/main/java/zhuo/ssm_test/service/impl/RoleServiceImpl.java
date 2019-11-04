package zhuo.ssm_test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhuo.ssm_test.dao.IRoleDao;
import zhuo.ssm_test.domain.Permission;
import zhuo.ssm_test.domain.Role;
import zhuo.ssm_test.service.IRoleService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private IRoleDao roleDao;



    @Override
    public List<Role> findAll() throws Exception {

        List<Role> all = roleDao.findAll();

        return all;
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        Role role = roleDao.findById(id);
        return role;
    }

    @Override
    public List<Permission> findOtherPermission(String id) throws Exception {
        List<Permission> otherPermissions = roleDao.findOtherPermissions(id);
        return otherPermissions;
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) throws Exception {
        for (String permissionId : ids){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
